/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sebas
 */
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.text.DecimalFormat;

import java.io.Serializable;

@Named("KalkulatorKredytowyKlasa")
@RequestScoped
public class KalkulatorKredytowyKlasa implements Serializable {

    private double kwotaKredytu;
    private double stopaKredytu;
    private int okresKredytu;
    private double obliczonyKredyt;

    // Gettery i settery
    public double getKwotaKredytu() {
        return kwotaKredytu;
    }

    public void setKwotaKredytu(double kwotaKredytu) {
        this.kwotaKredytu = kwotaKredytu;
    }

    public double getStopaKredytu() {
        return stopaKredytu;
    }

    public void setStopaKredytu(double stopaKredytu) {
        this.stopaKredytu = stopaKredytu;
    }

    public int getOkresKredytu() {
        return okresKredytu;
    }

    public void setOkresKredytu(int okresKredytu) {
        this.okresKredytu = okresKredytu;
    }

    public double getObliczonyKredyt() {
        return obliczonyKredyt;
    }

    // Metoda obliczająca całkowity koszt kredytu
   public void obliczKredyt() {
        double miesiecznaStopa = stopaKredytu / 100 / 12;
        int liczbaRat = okresKredytu * 12;

        if (miesiecznaStopa > 0) {
            double rataMiesieczna = kwotaKredytu * miesiecznaStopa /
                                    (1 - Math.pow(1 + miesiecznaStopa, -liczbaRat));
            obliczonyKredyt = Math.round(rataMiesieczna * liczbaRat * 100.0) / 100.0;
        } else {
            obliczonyKredyt = Math.round(kwotaKredytu * 100.0) / 100.0; // Bez oprocentowania
        }

   
}
}
