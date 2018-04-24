/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Akari
 */
@Entity
@Table(name = "producto")
@NamedQueries({
    @NamedQuery(name = "getStock", query = "SELECT p.stock FROM Producto p WHERE p.idproducto = :producto AND p.descatalogado=0")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproducto")
    private Integer idproducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "autor")
    private String autor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "editorial")
    private String editorial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "isbn")
    private String isbn;
    @Size(max = 4)
    @Column(name = "a\u00f1o")
    private String año;
    @Column(name = "paginas")
    private Integer paginas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "resumen")
    private String resumen;
    @Size(max = 600)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private float precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private int stock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descatalogado")
    private int descatalogado;
    @Lob
    @Column(name = "imagen")
    private byte[] imagen;
    @JoinColumn(name = "seccion", referencedColumnName = "idseccion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Seccion seccion;
    @JoinColumn(name = "lengua", referencedColumnName = "ididioma")
    @ManyToOne(fetch = FetchType.LAZY)
    private Idioma lengua;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<Detalle> detalleList;

    public Producto() {
    }

    public Producto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Producto(Prod_Resumen res) {
        this.idproducto = res.getIdproducto();
        this.titulo = res.getTitulo();
        this.autor = res.getAutor();
        this.editorial = res.getEditorial();
        this.isbn = res.getIsbn();
        this.resumen = res.getResumen();
        this.precio = res.getPrecio();
        this.stock = res.getStock();
    }

    public Producto(Integer idproducto, String titulo, String autor, String editorial, String isbn, String año, Integer paginas, String resumen, String descripcion, float precio, int stock, int descatalogado, byte[] imagen, Seccion seccion, Idioma lengua) {
        this.idproducto = idproducto;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.isbn = isbn;
        this.año = año;
        this.paginas = paginas;
        this.resumen = resumen;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.descatalogado = descatalogado;
        this.imagen = imagen;
        this.seccion = seccion;
        this.lengua = lengua;
    }
    
    

    public Producto(Integer idproducto, String titulo, String autor, String editorial, String isbn, String resumen, float precio, int stock, int descatalogado) {
        this.idproducto = idproducto;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.isbn = isbn;
        this.resumen = resumen;
        this.precio = precio;
        this.stock = stock;
        this.descatalogado = descatalogado;
    }
    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getDescatalogado() {
        return descatalogado;
    }

    public void setDescatalogado(int descatalogado) {
        this.descatalogado = descatalogado;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Idioma getLengua() {
        return lengua;
    }

    public void setLengua(Idioma lengua) {
        this.lengua = lengua;
    }

    public List<Detalle> getDetalleList() {
        return detalleList;
    }

    public void setDetalleList(List<Detalle> detalleList) {
        this.detalleList = detalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Producto[ idproducto=" + idproducto + " ]";
    }
    
}
