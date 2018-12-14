/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjektPO;

import java.util.Random;
import java.io.*;
/**
 *
 * @author Admin
 */
public class Akcja extends Aktywa implements Serializable{
    private double wartosc;
    private Spolka spolkaWlasciciel;
    private int iloscAkcji;
    private int iloscAkcjiNaGieldzie;
    public Akcja(double kurs,String val,int val1,Spolka val2){
        wartosc=kurs;
        iloscAkcji=val1;
        this.setNazwa(val);
        spolkaWlasciciel=val2;
        iloscAkcjiNaGieldzie=iloscAkcji;
    }
    public Akcja(){
        
    }
    public void setWartosc(double var){
        wartosc=var;
    }
    public void setSpolkaWlasciciel(Spolka var){
        spolkaWlasciciel=var;
    }
    public void setIloscAkcji(int var){
        iloscAkcji=var;
        iloscAkcjiNaGieldzie=iloscAkcjiNaGieldzie+1;
    }
    public double getWartosc(){
        return wartosc;
    }
    public Spolka getSpolkaWlasciciel(){
        return spolkaWlasciciel;
    }
    public int getIloscAkcji(){
        return iloscAkcji;
    }
    @Override
    public synchronized void kup(Uczestnik uczestnik){
        if(uczestnik.getBudzet()>=wartosc && iloscAkcjiNaGieldzie>0){
            Gielda gielda=spolkaWlasciciel.getGielda();
            uczestnik.setBudzet(uczestnik.getBudzet()-wartosc);
            uczestnik.addPosiadaneAkcje(this);
            spolkaWlasciciel.setWolumen(spolkaWlasciciel.getWolumen()+1);
            spolkaWlasciciel.setObroty(spolkaWlasciciel.getObroty()+wartosc);
            spolkaWlasciciel.setPrzychod(spolkaWlasciciel.getPrzychod()+wartosc-gielda.getMarza());
            spolkaWlasciciel.setZysk(spolkaWlasciciel.getZysk()+wartosc-gielda.getMarza()*wartosc);
            Random generator=new Random();
            double wzrost=generator.nextDouble()*10;
            spolkaWlasciciel.setKursAkt(spolkaWlasciciel.getKursAkt()+wzrost);
            iloscAkcjiNaGieldzie=iloscAkcjiNaGieldzie-1;
        }
    }
    public synchronized void sprzedaj(Uczestnik uczestnik,Gielda rynek){
        uczestnik.setBudzet(uczestnik.getBudzet()+wartosc-rynek.getMarza()*wartosc);
        Gielda gielda=spolkaWlasciciel.getGielda();
        spolkaWlasciciel.setWolumen(spolkaWlasciciel.getWolumen()+1);
        spolkaWlasciciel.setObroty(spolkaWlasciciel.getObroty()+wartosc);
        spolkaWlasciciel.setZysk(spolkaWlasciciel.getZysk()-wartosc);
        Random generator=new Random();
        double spadek=generator.nextDouble()*10;
        if(spolkaWlasciciel.getKursAkt()-spadek>0){
            spolkaWlasciciel.setKursAkt(spolkaWlasciciel.getKursAkt()-spadek);
        }
        iloscAkcjiNaGieldzie=iloscAkcjiNaGieldzie+1;
    }
    public synchronized void wykup(String text){
        int cena;
        cena=Integer.parseInt(text);
        iloscAkcji=iloscAkcji-1;
        spolkaWlasciciel.setZysk(spolkaWlasciciel.getZysk()-cena);
    }
}
