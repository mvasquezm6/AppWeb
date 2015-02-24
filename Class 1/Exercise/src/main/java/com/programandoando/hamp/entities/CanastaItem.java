package com.programandoando.hamp.entities;

public class CanastaItem {
    
    private String articulo;
    private Double precio;
    private Integer cantidad;
    private Double subtotal;

    
    private void calcularSubtotal()
    {
        Double st;
        try {
            st=getPrecio()*getCantidad();
        } catch (Exception e) {
            st=0.0;
        }
        setSubtotal(st); 
    }
    
    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
        calcularSubtotal();
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        calcularSubtotal();
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
    
    
}
