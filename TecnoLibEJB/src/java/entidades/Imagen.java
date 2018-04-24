/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

public class Imagen {
    private String id;
    private String nombre;
    private byte[] contenido;
    private String tipocontenido;

    public Imagen(int id, String nombre, byte[] contenido) {
        this.id = String.valueOf(id);
        this.nombre = nombre;
        this.contenido = contenido;
        this.tipocontenido = "image/jpg";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    public String getTipocontenido() {
        return tipocontenido;
    }

    public void setTipocontenido(String tipocontenido) {
        this.tipocontenido = tipocontenido;
    }

    
    
}
