
package entidades;


public class Prod_Extendido {
    private String año;
    private Integer paginas;
    private String descripcion;
    private Idioma lengua;

    public Prod_Extendido(String año, Integer paginas, String descripcion, Idioma lengua) {
        this.año = año;
        this.paginas = paginas;
        this.descripcion = descripcion;
        this.lengua = lengua;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Idioma getLengua() {
        return lengua;
    }

    public void setLengua(Idioma lengua) {
        this.lengua = lengua;
    }

    @Override
    public String toString() {
        return "Prod_Extendido{" + "a\u00f1o=" + año + ", paginas=" + paginas + ", descripcion=" + descripcion + ", lengua=" + lengua + '}';
    }

    
}
