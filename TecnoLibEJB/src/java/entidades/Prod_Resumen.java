

package entidades;

public class Prod_Resumen {
    private Integer idproducto; 
    private String titulo; 
    private String autor; 
    private String editorial; 
    private String isbn; 
    private String resumen; 
    private float precio; 
    private int stock;
    private byte[] imagen;

    public Prod_Resumen(Integer idproducto, String titulo, String autor, String editorial, String isbn, String resumen, float precio, int stock, byte[] imagen) {
        this.idproducto = idproducto;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.isbn = isbn;
        this.resumen = resumen;
        this.precio = precio;
        this.stock = stock;
        this.imagen = imagen;
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

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
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

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.idproducto != null ? this.idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prod_Resumen other = (Prod_Resumen) obj;
        if (this.idproducto != other.idproducto && (this.idproducto == null || !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prod_Resumen{" + "idproducto=" + idproducto + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", isbn=" + isbn + ", resumen=" + resumen + ", precio=" + precio + ", stock=" + stock + '}';
    }
    
}
