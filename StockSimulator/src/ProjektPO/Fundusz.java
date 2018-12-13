/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjektPO;

import ProjektPO.GeneratorNazw;
import java.io.Serializable;
import java.util.Random;
import java.util.List;
import javafx.collections.ObservableList;
/**
 *
 * @author Admin
 */
public class Fundusz extends Uczestnik implements Serializable{
    private String nazwa;
    private Inwestor wlasciciel;
    public Fundusz(ListyObiektow listaObiektow){
        Random generator=new Random();
        int index;
        wlasciciel=new Inwestor();
        List<Inwestor>listaDoLosowania=listaObiektow.getListaInwestorow();
        GeneratorNazw generatorNazw=new GeneratorNazw();
        nazwa=generatorNazw.generujNazweFunduszu();
        index=generator.nextInt(listaDoLosowania.size());
        wlasciciel=listaDoLosowania.get(index);
        this.setImie(wlasciciel.getImie());
        this.setNazwisko(wlasciciel.getNazwisko());
        this.setBudzet(wlasciciel.getBudzet());
        wlasciciel.addPosidaneFundusze(this);
    }
    public void setNazwa(String var){
        nazwa=var;
    }
    public void setWlasciciel(Inwestor var){
        wlasciciel=var;
    }
    public String getNazwa(){
        return nazwa;
    }
}
