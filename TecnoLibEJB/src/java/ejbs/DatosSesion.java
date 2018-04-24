/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entidades.Item;
import entidades.SinStock;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

@Stateful
@StatefulTimeout(unit = TimeUnit.MINUTES, value = -1)
public class DatosSesion implements DatosSesionLocal {

    private String language;
    private boolean style_stock;
    private double total;
    private int totalItems;
    private String usuario;
    private boolean edtcomp;
    private int seccion;
    private boolean err_stock;
    private boolean modoregistro;
    private boolean modopago;
    private Integer descripcion;
    private ArrayList<SinStock> prod_erroneos;
    private ArrayList<Item> todositems;
    private ArrayList<String> todosIdioma;
    private boolean pasoporLogin;
    private boolean pasoporIdioma;
    private int recibo;
    private String tabActivo;
    private boolean baja;
    private String fdia;
    private String fmes;
    private String faño;
    @PostConstruct
    public void init() {
        prod_erroneos = new ArrayList<SinStock>();
        todositems = new ArrayList<Item>();
        descripcion = null;
        todosIdioma = null;
        pasoporLogin=false;
        todosIdioma = new ArrayList<String>();
        todosIdioma.add("es");
        todosIdioma.add("en");
        this.language = "es";
        fdia = "10";
        fmes = "12";
        faño = "2014";
    }

    @Override
    public String getLanguage() {
        return this.language;
    }

    @Override
    public void setLanguage(String language) {
        this.language = language;
    }


    @Override
    public boolean getStyle_stock() {
        return style_stock;
    }

    @Override
    public void setStyle_stock(boolean style_stock) {
        this.style_stock = style_stock;
    }

    @Override
    public double getTotal() {
        total = 0;
        for (Item it : getItems()) {
            total += it.getTotal();
        }
        return total;
    }

    @Override
    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public int getTotalItems() {
        totalItems = 0;
        for (Item it : getItems()) {
            totalItems += it.getUnidades();
        }
        return totalItems;
    }

    @Override
    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }
   
    @Override
    public String getUsuario() {
        return usuario;
    }

    @Override
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean isEdtcomp() {
        return edtcomp;
    }

    @Override
    public void setEdtcomp(boolean edtcomp) {
        this.edtcomp = edtcomp;
    }

    @Override
    public int getSeccion() {
        return seccion;
    }

    @Override
    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }

    @Override
    public ArrayList<Item> getItems() {
        return todositems;

    }

    @Override
    public void setItems(ArrayList<Item> items) {
        todositems = items;

    }

    @Override
    public ArrayList<SinStock> getProd_erroneos() {
        return prod_erroneos;
    }

    @Override
    public void setProd_erroneos(ArrayList<SinStock> prod_erroneos) {
        this.prod_erroneos = prod_erroneos;
    }

    @Override
    public boolean getErr_stock() {
        return err_stock;
    }

    @Override
    public void setErr_stock(boolean err_stock) {
        this.err_stock = err_stock;
    }

    @Override
    public boolean getModoregistro() {
        return modoregistro;
    }

    @Override
    public void setModoregistro(boolean modoregistro) {
        this.modoregistro = modoregistro;
    }
    @Override
    public Integer getDescripcion() {
        return descripcion;
    }

    @Override
    public void setDescripcion(Integer descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean isPasoporLogin() {
        return pasoporLogin;
    }

    @Override
    public void setPasoporLogin(boolean pasoporLogin) {
        this.pasoporLogin = pasoporLogin;
    }

    @Override
    public boolean isPasoporIdioma() {
        return pasoporIdioma;
    }

    @Override
    public void setPasoporIdioma(boolean pasoporIdioma) {
        this.pasoporIdioma = pasoporIdioma;
    }

    @Override
    public boolean getModopago() {
        return modopago;
    }

    @Override
    public void setModopago(boolean modopago) {
        this.modopago = modopago;
    }

    @Override
    public int getRecibo() {
        return recibo;
    }

    @Override
    public void setRecibo(int recibo) {
        this.recibo = recibo;
    }

    @Override
    public String getTabActivo() {
        return tabActivo;
    }

    @Override
    public void setTabActivo(String tabActivo) {
        this.tabActivo = tabActivo;
    }

    @Override
    public boolean isBaja() {
        return baja;
    }

    @Override
    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    @Override
    public String getFdia() {
        return fdia;
    }

    @Override
    public void setFdia(String fdia) {
        this.fdia = fdia;
    }

    @Override
    public String getFmes() {
        return fmes;
    }

    @Override
    public void setFmes(String fmes) {
        this.fmes = fmes;
    }

    @Override
    public String getFaño() {
        return faño;
    }
    @Override
    public void setFaño(String faño) {
        this.faño = faño;
    }

    

    
   

    @Remove
    @Override
    public void cierreSesion() {
        language = null;
        style_stock = false;
        total = 0;
        totalItems = 0;
        usuario = null;
        seccion = 0;
        err_stock = false;
        modoregistro = false;
        prod_erroneos = null;
        todositems = null;
        todosIdioma = null;
        modopago = false;
        tabActivo = null;
        recibo = 0;
        baja = false;
    }
    @PreDestroy
    @Override
    public void destruirSesion(){
        System.out.println("PRE DESTROY EJB");
        
    }

    
    
}
