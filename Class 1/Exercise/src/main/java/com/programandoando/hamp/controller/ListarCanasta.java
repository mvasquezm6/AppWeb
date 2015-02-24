package com.programandoando.hamp.controller;


import com.programandoando.hamp.entities.CanastaItem;
import com.programandoando.hamp.entities.CanastaList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ListarCanasta", urlPatterns = {"/ListarCanasta"})
public class ListarCanasta extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();       
        HttpSession sesion=request.getSession(true);
        if(sesion.getAttribute("canasta")==null){
            out.println("No se aperturo session");
            return;
        }        
        CanastaList canasta=(CanastaList)sesion.getAttribute("canasta");
        if(canasta.size()==0){
            out.println("Canasta esta vacia");
            return;
        }        
        out.println("Ticket:"+sesion.getAttribute("Ticket"));        
        Double total=0.0;
        for (CanastaItem item :canasta.getLista()) {
            total+=item.getSubtotal();
            out.println("<tr>"+
                "<td>"+item.getArticulo()+"</td>"+
                "<td>"+item.getPrecio()+"</td>"+
                "<td>"+item.getCantidad()+"</td>"+
                "<td>"+item.getSubtotal()+"</td>"+             
            "</tr>");
        }
        
        out.println("<h2>Total:"+total+"</h2>");        
        out.println("<a href='CerrarSesion'> Nueva Venta</a>");   
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
