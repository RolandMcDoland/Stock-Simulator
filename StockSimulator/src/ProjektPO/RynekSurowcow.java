/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjektPO;

import java.util.Random;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class RynekSurowcow extends Rynek implements Serializable{
    private List<Surowiec> listaSurowcow;
     public RynekSurowcow(){
         listaSurowcow=new ArrayList<>();
        Random generator=new Random();
        this.setMarza(generator.nextDouble()*0.5);
    }
    public void addListaSurowcow(Surowiec var){
        listaSurowcow.add(var);
    }
    public List getListaSurowcow(){
        return listaSurowcow;
    }
    public void removeListaSurowcow(int i){
        listaSurowcow.remove(i);
    }
}
