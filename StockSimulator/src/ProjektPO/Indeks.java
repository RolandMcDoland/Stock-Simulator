/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjektPO;

import java.io.*;
import java.util.*;
/**
 *
 * @author Admin
 */
public class Indeks implements Serializable{
    private String nazwa;
    private List <Spolka> spolki;//= new ArrayList <>();
    public Indeks(){
        GeneratorNazw generatorNazw=new GeneratorNazw();
        spolki=new ArrayList<>();
        nazwa=generatorNazw.generujNazweIndeksu();
    }
    public void setNazwa(String var){
        nazwa=var;
    }
    public void addSpolki(Spolka var){
        spolki.add(var);
    }
    public String getNazwa(){
        return nazwa;
    }
    public List getSpolki(){
        return spolki;
    }
}
