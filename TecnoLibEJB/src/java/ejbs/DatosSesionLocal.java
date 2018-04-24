/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import entidades.Item;
import entidades.SinStock;
import java.util.ArrayList;
import javax.ejb.Local;


@Local
public interface DatosSesionLocal {

    public String getLanguage();

    public void setLanguage(String language);

    public boolean getStyle_stock();

    public void setStyle_stock(boolean style_stock);

    public double getTotal();

    public void setTotal(double total);

    public int getTotalItems();

    public void setTotalItems(int totalItems);

    public String getUsuario();

    public void setUsuario(String usuario);

    public boolean isEdtcomp();

    public void setEdtcomp(boolean edtcomp);

    public int getSeccion();

    public void setSeccion(int seccion);

    public ArrayList<Item> getItems();

    public void setItems(ArrayList<Item> items);

    public ArrayList<SinStock> getProd_erroneos();

    public void setProd_erroneos(ArrayList<SinStock> prod_erroneos);

    public boolean getErr_stock();

    public void setErr_stock(boolean err_stock);

    public boolean getModoregistro();

    public void setModoregistro(boolean modoregistro);

    public void cierreSesion();

    public void destruirSesion();

    public Integer getDescripcion();

    public void setDescripcion(Integer descripcion);

    public boolean isPasoporLogin();

    public void setPasoporLogin(boolean pasoporLogin);

    public boolean isPasoporIdioma();

    public void setPasoporIdioma(boolean pasoporIdioma);

    public boolean getModopago();

    public void setModopago(boolean modopago);

    public int getRecibo();

    public void setRecibo(int recibo);

    public String getTabActivo();

    public void setTabActivo(String tabActivo);

    public boolean isBaja();

    public void setBaja(boolean baja);

    public String getFdia();

    public void setFdia(String fdia);

    public String getFmes();

    public void setFmes(String fmes);

    public String getFaño();

    public void setFaño(String faño);


}