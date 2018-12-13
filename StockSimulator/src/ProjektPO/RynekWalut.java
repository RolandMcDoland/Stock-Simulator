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
public class RynekWalut extends Rynek implements Serializable{
    private List <Waluta> listaWalut;
    public RynekWalut(){
        listaWalut=new ArrayList<>();
        Random generator=new Random();
        this.setMarza(generator.nextDouble()*0.5);
    }
    public void addListaWalut(Waluta var){
        listaWalut.add(var);
    }
    public List getListaWalut(){
        return listaWalut;
    }
    public void removeListaWalut(int i){
        listaWalut.remove(i);
    }
}
