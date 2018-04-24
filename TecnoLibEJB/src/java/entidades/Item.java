/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;


public class Item {
    private int idproducto;
    private String titulo;
    private String autor;
    private String isbn;
    private float precio;
    private Integer unidades;
    private double total;
    private boolean err_stock;

    public Item() {
    }
    public Item(int idproducto) {
        this.idproducto = idproducto;
    }

    public Item(int idproducto, String titulo, String autor, String isbn, float precio, Integer unidades, boolean err_stock) {
        this.idproducto = idproducto;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.precio = precio;
        this.unidades = unidades;
        this.total = this.precio;
        this.err_stock = err_stock;
    }

    
    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        if(unidades==null){
            unidades = 1;
        }
        this.total = this.precio*unidades;
        this.total = Math.round( this.total * 100.0 ) / 100.0;
        this.unidades = unidades;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean getErr_stock() {
        return err_stock;
    }

    public void setErr_stock(boolean err_stock) {
        this.err_stock = err_stock;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.idproducto;
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
        final Item other = (Item) obj;
        if (this.idproducto != other.idproducto) {
            return false;
        }
        return true;
    }
    
    
}
