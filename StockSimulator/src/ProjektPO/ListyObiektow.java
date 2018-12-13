/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjektPO;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.ListView;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
/**
 *
 * @author Admin
 */
public class ListyObiektow implements Serializable{
    private List<Spolka> listaSpolek;
    private List<Surowiec> listaSurowcow;
    private List<Waluta> listaWalut;
    private List<Inwestor> listaInwestorow;
    private List<Fundusz> listaFunduszy;
    private List<Gielda> listaGield;
    private List<Akcja> listaAkcji;
    private List<Indeks> listaIndeksow;
    private RynekWalut rynekWalut;
    private RynekSurowcow rynekSurowcow;
    public ListyObiektow(){
        listaSpolek=new ArrayList<>();//FXCollections.observableArrayList();
        listaSurowcow=new ArrayList<>();//FXCollections.observableArrayList();
        listaWalut=new ArrayList<>();//FXCollections.observableArrayList();
        listaFunduszy=new ArrayList<>();//FXCollections.observableArrayList();
        listaInwestorow=new ArrayList<>();//FXCollections.observableArrayList();
        listaGield=new ArrayList<>();//FXCollections.observableArrayList();
        listaAkcji=new ArrayList<>();//FXCollections.observableArrayList();
        listaIndeksow=new ArrayList<>();//FXCollections.observableArrayList();
        rynekWalut=new RynekWalut();
        rynekSurowcow=new RynekSurowcow();
    }
    public void addListaSpolek(Spolka val){
        listaSpolek.add(val);
    }
    public void addListaSurowcow(Surowiec val){
        listaSurowcow.add(val);
        rynekSurowcow.addListaSurowcow(val);
    }
    public void addListaWalut(Waluta val){
        listaWalut.add(val);
        rynekWalut.addListaWalut(val);
    }
    public void addListaInwestorow(Inwestor val){
        listaInwestorow.add(val);
    }
    public void addListaFunduszy(Fundusz val){
        listaFunduszy.add(val);
    }
    public void addListaGield(Gielda val){
        listaGield.add(val);
    }
    public void addListaAkcji(Akcja val){
        listaAkcji.add(val);
    }
    public void addListaIndeksow(Indeks val){
        listaIndeksow.add(val);
    }
    public List getListaSurowcow(){
        return listaSurowcow;
    }
    public List getListaSpolek(){
        return listaSpolek;
    }
    public List getListaWalut(){
        return listaWalut;
    }
    public List getListaInwestorow(){
        return listaInwestorow;
    }
    public List getListaFunduszy(){
        return listaFunduszy;
    }
    public List getListaGield(){
        return listaGield;
    }
    public List getListaAkcji(){
        return listaAkcji;
    }
    public List getListaIndeksow(){
        return listaIndeksow;
    }
    public RynekWalut getRynekWalut(){
        return rynekWalut;
    }
    public RynekSurowcow getRynekSurowcow(){
        return rynekSurowcow;
    }
    }
