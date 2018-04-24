/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;


public class SinStock {
    private int idproducto;
    private String isbn;
    private String titulo;
    private int stock_actual;
    

    public SinStock() {
    }

    public SinStock(int idproducto, String isbn, String titulo, int stock_actual) {
        this.idproducto = idproducto;
        this.isbn = isbn;
        this.titulo = titulo;
        this.stock_actual = stock_actual;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getStock_actual() {
        return stock_actual;
    }

    public void setStock_actual(int stock_actual) {
        this.stock_actual = stock_actual;
    }

    @Override
    public String toString() {
        return "SinStock{" + "idproducto=" + idproducto + ", isbn=" + isbn + ", titulo=" + titulo + ", stock_actual=" + stock_actual + '}';
    }
    
    
}
