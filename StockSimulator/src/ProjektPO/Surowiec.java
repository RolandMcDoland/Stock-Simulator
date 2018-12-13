/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjektPO;

import java.util.Random;
import ProjektPO.GeneratorNazw;
import java.io.*;
/**
 *
 * @author Admin
 */
public class Surowiec extends Aktywa implements Serializable{
    private String jednostka;
    private String waluta;
    private double wartosc;
    private double wartoscMin;
    private double wartoscMax;
    public Surowiec(){
        Random generator=new Random();
        GeneratorNazw generatorNazw=new GeneratorNazw();
        jednostka=generatorNazw.generujJednostke();
        waluta=generatorNazw.generujNazweWaluty();
        wartosc=generator.nextDouble()*100+100;
        wartoscMin=wartosc;
        wartoscMax=wartosc;
        this.setNazwa(generatorNazw.generujNazweSurowca());
    }
    public void setJednostka(String var){
        jednostka=var;
    }
    public void setWaluta(String var){
        waluta=var;
    }
    public void setWartosc(double var){
        if(var<wartoscMin) wartoscMin=var;
        else if(var>wartoscMax) wartoscMax=var;
        wartosc=var;
    }
    public void setWartoscMin(double var){
        wartoscMin=var;
    }
    public void setWartoscMax(double var){
        wartoscMax=var;
    }
    public String getJednostka(){
        return jednostka;
    }
    public String getWaluta(){
        return waluta;
    }
    public double getWartosc(){
        return wartosc;
    }
    public double getWartoscMin(){
        return wartoscMin;
    }
    public double getWartoscMax(){
        return wartoscMax;
    }
    @Override
    public synchronized void kup(Uczestnik uczestnik){
        if(uczestnik.getBudzet()>=wartosc){
            uczestnik.setBudzet(uczestnik.getBudzet()-wartosc);
            uczestnik.addPosiadaneSurowce(this);
            Random generator=new Random();
            double wzrost=generator.nextDouble()*10;
            this.setWartosc(wartosc+wzrost);
        }
    }
    public synchronized void sprzedaj(Uczestnik uczestnik,RynekSurowcow rynek){
        uczestnik.setBudzet(uczestnik.getBudzet()+wartosc-rynek.getMarza()*wartosc);
        rynek.addListaSurowcow(this);
        Random generator=new Random();
        double spadek=generator.nextDouble()*10;
        if(wartosc-spadek>0){
            this.setWartosc(wartosc-spadek);
        }
    }
}
