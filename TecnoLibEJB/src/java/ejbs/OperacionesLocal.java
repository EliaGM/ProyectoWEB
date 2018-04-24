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
import entidades.Producto;
import entidades.Recibo;
import entidades.Seccion;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

@Local
public interface OperacionesLocal {

    public String Validar(String user, String password);

    public int insertarUsuario(Usuario us);

    public void eliminarUsuario(String user);

    public List<Ciudad> getCiudades();

    public List<Seccion> getSecciones();

    public List<Producto> getProductos(int seccion);

   // public List<Producto> getProductos(ArrayList<Integer> productos, Integer desc_producto);

    public Integer getStock(int producto);

    public Usuario getUsuario(String user);

    public int modificarStock(List<Item> items);

    public Prod_Extendido getProd_Extendido(int producto);

    public List<Recibo> getRecibos(String usuario);

    public List<Detalle> getDetalles(int idrecibo);

    public Integer nuevoReciboCliente(String usuario, ArrayList<Item> items,double total);

    public Imagen getImagen(int producto);

    public List<Detalle> getVentas();


    public List<Detalle> getDetalles(Date fecha);
    
}
