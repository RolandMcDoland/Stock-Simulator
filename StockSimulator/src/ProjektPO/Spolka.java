package ProjektPO;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import ProjektPO.GeneratorNazw;
import javafx.collections.ObservableList;
import java.io.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Spolka implements Serializable{
    private String nazwa;
    private String data1Wyceny;
    private double kursOtw;
    private double kursAkt;
    private double kursMin;
    private double kursMax;
    private int liczbaAkcji;
    private double zysk;
    private double przychod;
    private double kapWlasny;
    private double kapZakladowy;
    private int wolumen;
    private double obroty;
    private Gielda gielda;
    private Akcja akcjeSpolki;
    public Spolka(ListyObiektow listaObiektow){
        Random generator=new Random();
        GeneratorNazw generatorNazw=new GeneratorNazw();
        wolumen=0;
        nazwa=generatorNazw.generujNazweSpolki();
        data1Wyceny=Integer.toString(generator.nextInt(30)+1)+"."+Integer.toString(generator.nextInt(12)+1)+"."+Integer.toString(generator.nextInt(16)+2000);
        kursOtw=generator.nextDouble()*200+50;
        kursAkt=kursOtw;
        kursMin=kursOtw;
        kursMax=kursOtw;
        liczbaAkcji=generator.nextInt(21)+5;
        akcjeSpolki=new Akcja(kursAkt,nazwa,liczbaAkcji,this);
        listaObiektow.addListaAkcji(akcjeSpolki);
        zysk=0;
        przychod=0;
        obroty=0;
        int index;
        gielda=new Gielda();
        List<Gielda>listaDoLosowania=listaObiektow.getListaGield();
        index=generator.nextInt(listaDoLosowania.size());
        gielda=listaDoLosowania.get(index);
        int liczba;
        List <Indeks> listaDoWylosowania=new ArrayList<>();
        listaDoWylosowania=gielda.getListaIndeksow();
        liczba=generator.nextInt(listaDoWylosowania.size());
        Indeks indeks=listaDoWylosowania.get(liczba);
        indeks.addSpolki(this);
        gielda.addListaAkcji(akcjeSpolki);
    }
    public double generujWartosc(){
        return liczbaAkcji*kursAkt;
    }
    public void setNazwa(String var){
        nazwa=var;
    }
    public void setData1Wyceny(String var){
        data1Wyceny=var;
    }
    public void setKursOtw(double var){
        kursOtw=var;
    }
    public void setKursAkt(double var){
        if(var<kursMin)kursMin=var;
        else if(var>kursMax)kursMax=var;
        kursAkt=var;
        akcjeSpolki.setWartosc(var);
    }
    public void setKursMin(double var){
        kursMin=var;
    }
    public void setKursMax(double var){
        kursMax=var;
    }
    public void setLiczbaAkcji(int var){
        liczbaAkcji=var;
        akcjeSpolki.setIloscAkcji(var);
    }
    public void setZysk(double var){
        zysk=var;
    }
    public void setPrzychod(double var){
        przychod=var;
    }
    public void setKapWlasny(double var){
        kapWlasny=var;
    }
    public void setKapZakladowy(double var){
        kapZakladowy=var;
    }
    public void setWolumen(int var){
        wolumen=var;
    }
    public void setObroty(double var){
        obroty=var;
    }
    public String getNazwa(){
        return nazwa;
    }
    public String getData1Wyceny(){
        return data1Wyceny;
    }
    public double getKursOtw(){
        return kursOtw;
    }
    public double getKursAkt(){
        return kursAkt;
    }
    public double getKursMin(){
        return kursMin;
    }
    public double getKursMax(){
        return kursMax;
    }
    public int getLiczbaAkcji(){
        return liczbaAkcji;
    }
    public double getZysk(){
        return zysk;
    }
    public double getPrzychod(){
        return przychod;
    }
    public double getKapWlasny(){
        return kapWlasny;
    }
    public double getKapZakladowy(){
        return kapZakladowy;
    }
    public int getWolumen(){
        return wolumen;
    }
    public double getObroty(){
        return obroty;
    }
    public Gielda getGielda(){
        return gielda;
    }
}
