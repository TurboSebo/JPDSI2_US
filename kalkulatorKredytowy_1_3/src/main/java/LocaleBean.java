/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.context.FacesContext;
import java.util.Locale;
/**
 *
 * @author sebas
 */
@ManagedBean
public class LocaleBean {

    public void changeLanguage(String language) {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
    }
}