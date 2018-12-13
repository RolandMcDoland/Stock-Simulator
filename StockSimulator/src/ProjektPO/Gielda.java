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
public class Gielda extends Rynek implements Serializable{
    private String nazwa;
    private String kraj;
    private String waluta;
    private String miasto;
    private String adres;
    private List <Indeks> listaIndeksow;
    private List <Akcja> listaAkcji;
    public Gielda(ListyObiektow listaObiektow){
        int liczba;
        Random generator=new Random();
        GeneratorNazw generatorNazw=new GeneratorNazw();
        nazwa=generatorNazw.generujNazweGieldy();
        kraj=generatorNazw.generujKraj();
        waluta=generatorNazw.generujNazweWaluty();
        miasto=generatorNazw.generujMiasto();
        adres=generatorNazw.generujAdres();
        listaIndeksow=new ArrayList<>();
        liczba=generator.nextInt(5)+1;
        for(int i=0;i<liczba;i++){
            Indeks indeks=new Indeks();
            listaObiektow.addListaIndeksow(indeks);
            listaIndeksow.add(indeks);
        }
        this.setMarza(generator.nextDouble()*0.5);
        listaAkcji=new ArrayList<>();
    }
    public Gielda(){
        
    }
    public void setNazwa(String var){
        nazwa=var;
    }
    public void setKraj(String var){
        kraj=var;
    }
    public void setWaluta(String var){
        waluta=var;
    }
    public void setMiasto(String var){
        miasto=var;
    }
    public void setAdres(String var){
        adres=var;
    }
    public void addListaIndeksow(Indeks var){
        listaIndeksow.add(var);
    }
    public void addListaAkcji(Akcja var){
        listaAkcji.add(var);
    }
    public String getNazwa(){
        return nazwa;
    }
    public String getKraj(){
        return kraj;
    }
    public String getWaluta(){
        return waluta;
    }
    public String getMiasto(){
        return miasto;
    }
    public String getAdres(){
        return adres;
    }
    public List getListaIndeksow(){
        return listaIndeksow;
    }
    public List getListaAkcji(){
        return listaAkcji;
    }
}
