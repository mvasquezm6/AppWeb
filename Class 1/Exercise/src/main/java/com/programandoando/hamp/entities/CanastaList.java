package com.programandoando.hamp.entities;

import java.util.ArrayList;

public class CanastaList {
    
    private ArrayList<CanastaItem> lista=new ArrayList<CanastaItem>();    
    public void addItem(CanastaItem item){
        lista.add(item);
    }    
    public ArrayList<CanastaItem> getLista(){
        return lista;
    }    
    public int size(){
        return lista.size();
    }
}
