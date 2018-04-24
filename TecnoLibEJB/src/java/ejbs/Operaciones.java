/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entidades.Ciudad;
import entidades.Detalle;
import entidades.Imagen;
import entidades.Item;
import entidades.Prod_Extendido;
import entidades.Prod_Resumen;
import entidades.Producto;
import entidades.Recibo;
import entidades.Seccion;
import entidades.Usuario;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

@Stateless
public class Operaciones implements OperacionesLocal {

    @PersistenceContext(unitName = "PUTecnoLib")
    private EntityManager em;

    @Override
    public String Validar(String user, String password) {
        String result = null;
        try {
            TypedQuery<Object> query = em.createNamedQuery("validarUsuario", Object.class);
            query.setParameter("user", user);
            query.setParameter("password", password);
            result = (String) query.getSingleResult();
        } catch (Exception ex) {
            System.out.println("DEVOLVIO NULL");
        }

        return result;
    }

    @Override
    public int insertarUsuario(Usuario us) {
        int devuelve = 0;
        try {
            Query query = em.createNamedQuery("comprobarExiste");
            query.setParameter("user", us.getUsuario());
            query.setParameter("telf", us.getTelefono());
            query.getSingleResult();
            System.out.println("El usuario ya existe");
        } catch (Exception ex) {
            em.persist(us);
            devuelve = 1;
        } finally {
            return devuelve;
        }

    }

    @Override
    public void eliminarUsuario(String user) {
        Usuario us = em.find(Usuario.class, user);
        if (us != null) {
            em.remove(us);
        }
    }

    @Override
    public List<Ciudad> getCiudades() {
        Query query = em.createNamedQuery("getCiudades");
        return (List) query.getResultList();
    }

    @Override
    public List<Seccion> getSecciones() {
        Query query = em.createNamedQuery("getSecciones");
        return query.getResultList();
    }

    @Override
    public List<Producto> getProductos(int seccion) {
        List<Producto> productos = new ArrayList<Producto>();
        TypedQuery<Prod_Resumen> query = null;
        String sql = "";
        sql = "SELECT NEW entidades.Prod_Resumen(p.idproducto,p.titulo,p.autor,p.editorial,p.isbn,p.resumen,p.precio,p.stock,p.imagen) FROM Producto p JOIN p.seccion s WHERE s.idseccion = :seccion AND p.descatalogado=0";
        query = em.createQuery(sql, Prod_Resumen.class);
        query.setParameter("seccion", seccion);
        List<Prod_Resumen> lista = query.getResultList();
        for (Prod_Resumen l : lista) {
            productos.add(new Producto(l));
        }

        return productos;
    }

    @Override
    public Integer getStock(int producto) {
        TypedQuery<Object> query = null;
        Integer devolver = null;
        try {
            query = em.createNamedQuery("getStock", Object.class);
            query.setParameter("producto", producto);
            devolver = (Integer) query.getSingleResult();
        } catch (Exception ex) {
            System.out.println("Devuleve NULL getStock");
        } finally {
            return devolver;
        }
    }

    @Override
    public Imagen getImagen(int producto) {
        String sql = "SELECT NEW entidades.Imagen(p.idproducto,p.titulo,p.imagen) FROM Producto p WHERE p.idproducto = :producto AND p.descatalogado=0";

        TypedQuery<Imagen> query = em.createQuery(sql, Imagen.class);
        query.setParameter("producto", producto);
        return query.getSingleResult();
    }

    @Override
    public Prod_Extendido getProd_Extendido(int producto) {
        String sql = "SELECT NEW entidades.Prod_Extendido(p.año,p.paginas,p.descripcion,p.lengua) FROM Producto p WHERE p.idproducto = :producto AND p.descatalogado=0";

        TypedQuery<Prod_Extendido> query = em.createQuery(sql, Prod_Extendido.class);
        query.setParameter("producto", producto);
        return query.getSingleResult();
    }

    @Override
    public Usuario getUsuario(String user) {
        Usuario u = em.find(Usuario.class, user);
        return u;
    }

    @Override
    public int modificarStock(List<Item> items) {
        System.out.println("MODIFICAR STOCK");
        int recibo = 0;
        String update = "UPDATE Producto p SET p.stock = p.stock -";
        try {
            for (Item item : items) {
                String sql = update + item.getUnidades() + " WHERE p.idproducto = " + item.getIdproducto();
                Query query = em.createQuery(sql);
                query.executeUpdate();
                System.out.println("UPDATE = " + item.getIdproducto());
            }

        } catch (Exception ex) {
            System.out.println("Error en Operaciones metodo modificarStock");
            System.out.println(ex.getMessage());
        } finally {
            return recibo;
        }

    }

    @Override
    public List<Recibo> getRecibos(String usuario) {
        Query query = em.createNamedQuery("getRecibos");
        query.setParameter("usuario", usuario);
        return (List<Recibo>) query.getResultList();
    }

    @Override
    public List<Detalle> getDetalles(int idrecibo) {
        Query query = em.createNamedQuery("getDetalles");
        query.setParameter("idrecibo", idrecibo);
        return (List<Detalle>) query.getResultList();
    }

    @Override
    public Integer nuevoReciboCliente(String usuario, ArrayList<Item> items, double total) {
        int idrecibo;
        System.out.println("nuevoReciboCliente");
        try {

            Usuario cliente = em.find(Usuario.class, usuario);
            DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            Date today = Calendar.getInstance().getTime();
            String reportDate = df.format(today);
            System.out.println("Report Date: " + reportDate);
            Recibo recibo = new Recibo(today, total, cliente);
            em.persist(recibo);
            em.flush();
            System.out.println("getFecha " + recibo.getFecha());
            System.out.println("getTotal " + recibo.getTotal());
            idrecibo = recibo.getIdrecibo();
            System.out.println("idrecibo " + idrecibo);
            System.out.println("DETALLES");
            for (Item it : items) {
                Detalle detalle = new Detalle();
                Producto p = em.find(Producto.class, it.getIdproducto());
                detalle.setProducto(p);
                System.out.println("producto: " + p.getIdproducto());
                detalle.setRecibo(recibo);
                System.out.println("recibo: " + recibo.getIdrecibo());
                detalle.setUnidades(it.getUnidades());
                em.persist(detalle);
            }
        } catch (Exception ex) {
            idrecibo = 0;
            System.out.println(ex.getMessage());
        }
        return idrecibo;
    }

    @Override
    public List<Detalle> getVentas() {
        Query query = em.createNamedQuery("getVentas");
        return query.getResultList();
    }

    @Override
    public List<Detalle> getDetalles(Date fecha) {
        String sql = "SELECT d FROM Detalle d JOIN d.recibo r WHERE r.fecha like :fecha";
        Query query = em.createQuery(sql);
        query.setParameter("fecha", fecha, TemporalType.DATE);
        return query.getResultList();
    }
}
