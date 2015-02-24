package com.programandoando.hamp.controller;


import com.programandoando.hamp.entities.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServletEjercicio1", urlPatterns = {"/ServletEjercicio1"})
public class ServletEjercicio1 extends HttpServlet {
   
    private ArrayList<Persona> personas=new ArrayList<>();
    
    @Override
    public void init(){
        System.out.println("init");
    }
    
    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println("process");
        
        
        //Captura de datos de una peticion
        String nombre=request.getParameter("nombre");
        String apellido=request.getParameter("apellido");
        String edad=request.getParameter("edad");
        //Proceso ---> ACCCIONES DEL CONTROLADOR
        if(!nombre.equals("") && !apellido.equals("") && !edad.equals("")){
            Persona persona=new Persona(nombre,apellido,edad);
            personas.add(persona);
        }        
        
       
            out.println("<table>");
            out.println("<tr>");
                out.println("<td>NOMBRE</td>");
                out.println("<td>APELLIDO</td>");
                out.println("<td>EDAD</td>");
            out.println("</tr>");
            for (int i = 0; i < personas.size(); i++) {
               Persona persona=personas.get(i);
                out.println("<tr>");
                out.println("<td>"+persona.getNombre()+"</td>");
                out.println("<td>"+persona.getApellido()+"</td>");
                out.println("<td>"+persona.getEdad()+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
