/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.seba_paw_us.kalkulator_kredytowy1;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;


/**
 *
 * @author sebas
 */
public class KredytowyKalkulatorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {      
            /* TODO output your page here. You may use following sample code. */
            
            String kwotaKredytuStr = request.getParameter("kwotakredytu");
            String stopaKredytuStr = request.getParameter("stopakredytu");
            String okresKredytuStr = request.getParameter("okreskredytu");
            
            if (kwotaKredytuStr == null || kwotaKredytuStr.isEmpty() ||
                    stopaKredytuStr == null || stopaKredytuStr.isEmpty() ||
                    okresKredytuStr == null || okresKredytuStr.isEmpty()) {
                request.setAttribute("error", "Wszystkie pola muszą być wypełnione!");
            }
            else{
                try{
                    // Pobranie danych z formularza
                    double kwotaKredytu = Float.parseFloat(request.getParameter("kwotakredytu"));
                    double stopaKredytu = Float.parseFloat(request.getParameter("stopakredytu"));
                    int okresKredytu = Integer.parseInt(request.getParameter("okreskredytu"));

                    //Obliczenie kwoty kredytu

                    double obliczonyKredyt = kwotaKredytu * Math.pow(1+(stopaKredytu/100), okresKredytu);
                    
                    //zaokrąglenie wyniku do dwóch miejsc po przecinku
                    DecimalFormat df = new DecimalFormat("#.##");
                     String zaokraglonyKredyt = df.format(obliczonyKredyt);
                    // wyświetl wynik przekazując go do index.jsp
                    request.setAttribute("obliczonyKredyt", zaokraglonyKredyt);
                }
                catch (NumberFormatException e){ // jeśli użykownik wpisał złe dane
                  request.setAttribute("error", "Wprowadzone dane muszą być liczbami!");
                }
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
