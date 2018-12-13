/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjektPO;

import java.util.*;
import ProjektPO.GeneratorNazw;
import java.io.*;
/**
 *
 * @author Admin
 */
public class Waluta extends Aktywa implements Serializable{
    private double cenaKupna;
    private double cenaSprzedazy;
    private List <String> listaKrajow;
    public Waluta(){
        Random generator=new Random();
        GeneratorNazw generatorNazw=new GeneratorNazw();
        cenaKupna=generator.nextDouble()*3+2;
        cenaSprzedazy=generator.nextDouble()*3+1;
        listaKrajow=new ArrayList<>();
        listaKrajow.addAll(generatorNazw.generujListeKrajow());
        this.setNazwa(generatorNazw.generujNazweWaluty());
    }
    public void setCenaKupna(double var){
        cenaKupna=var;
    }
    public void setCenaSprzedazy(double var){
        cenaSprzedazy=var;
    }
    public void addListaKrajow(String var){
        listaKrajow.add(var);
    }
    public double getCenaKupna(){
        return cenaKupna;
    }
    public double getCenaSprzedazy(){
        return cenaSprzedazy;
    }
    public List getListaKrajow(){
        return listaKrajow;
    }
    @Override
    public synchronized void kup(Uczestnik uczestnik){
        if(uczestnik.getBudzet()>=cenaKupna){
            uczestnik.setBudzet(uczestnik.getBudzet()-cenaKupna);
            uczestnik.addPosiadaneWaluty(this);
            Random generator=new Random();
            double wzrost=generator.nextDouble();
            cenaKupna=cenaKupna+wzrost;
            cenaSprzedazy=cenaSprzedazy+wzrost;
        }
    }
    public synchronized void sprzedaj(Uczestnik uczestnik,RynekWalut rynek){
        uczestnik.setBudzet(uczestnik.getBudzet()+cenaSprzedazy-rynek.getMarza()*cenaSprzedazy);
        rynek.addListaWalut(this);
        Random generator=new Random();
        double spadek=generator.nextDouble()*10;
        if(cenaKupna-spadek>0 && cenaSprzedazy-spadek>0){
            cenaKupna=cenaKupna-spadek;
            cenaSprzedazy=cenaSprzedazy-spadek;
        }
    }
}
