/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjektPO;

import java.io.Serializable;
import java.util.*;
/**
 *
 * @author Admin
 */
public class Uczestnik implements Serializable{
    private String imie;
    private String nazwisko;
    private double budzet;
    private List <Akcja> posiadaneAkcje;
    private List <Waluta> posiadaneWaluty;
    private List <Surowiec> posiadaneSurowce;
    public Uczestnik(){
        posiadaneAkcje=new ArrayList<>();
        posiadaneWaluty=new ArrayList<>();
        posiadaneSurowce=new ArrayList<>();
    }
    public synchronized void kup(ListyObiektow listaObiektow){
        Random generator=new Random();
        int choice=generator.nextInt(3);
        switch(choice){
            case 0:
                List <Gielda> lista2=listaObiektow.getListaGield();
                if(lista2.size()!=0){
                    int index1=generator.nextInt(lista2.size());
                    Gielda gielda=lista2.get(index1);
                    List <Akcja> lista3=gielda.getListaAkcji();
                    if(lista3.size()!=0){
                        int index2=generator.nextInt(lista3.size());
                        Akcja akcja=lista3.get(index2);
                        akcja.kup(this);
                    }
                }
                break;
            case 1:
                RynekSurowcow rynekSurowcow=listaObiektow.getRynekSurowcow();
                List <Surowiec> lista=rynekSurowcow.getListaSurowcow();
                if(lista.size()!=0){
                    int index=generator.nextInt(lista.size());
                    Surowiec surowiec=lista.get(index);
                    surowiec.kup(this);
                    rynekSurowcow.removeListaSurowcow(index);
                }
                break;
            case 2:
                RynekWalut rynekWalut=listaObiektow.getRynekWalut();
                List <Waluta> lista1=rynekWalut.getListaWalut();
                if(lista1.size()!=0){
                    int index3=generator.nextInt(lista1.size());
                    Waluta waluta=lista1.get(index3);
                    waluta.kup(this);
                    rynekWalut.removeListaWalut(index3);
                }
                break;
        }
    }
    public synchronized void sprzedaj(ListyObiektow listaObiektow){
        Random generator=new Random();
        int choice1=generator.nextInt(3);
        switch(choice1){
            case 0:
                if(posiadaneAkcje.size()!=0){
                    int index1=generator.nextInt(posiadaneAkcje.size());
                    Akcja akcja=posiadaneAkcje.get(index1);
                    Spolka spolka=akcja.getSpolkaWlasciciel();
                    Gielda gielda=spolka.getGielda();
                    akcja.sprzedaj(this,gielda);
                    posiadaneAkcje.remove(index1);
                }
                break;
            case 1:
                RynekSurowcow rynekSurowcow=listaObiektow.getRynekSurowcow();
                if(posiadaneSurowce.size()!=0){
                    int index=generator.nextInt(posiadaneSurowce.size());
                    Surowiec surowiec=posiadaneSurowce.get(index);
                    surowiec.sprzedaj(this,rynekSurowcow);
                    posiadaneSurowce.remove(index);
                }
                break;
            case 2:
                RynekWalut rynekWalut=listaObiektow.getRynekWalut();
                if(posiadaneWaluty.size()!=0){
                    int index3=generator.nextInt(posiadaneWaluty.size());
                    Waluta waluta=posiadaneWaluty.get(index3);
                    waluta.sprzedaj(this,rynekWalut);
                    posiadaneWaluty.remove(index3);
                }
                break;
        }
    }
    public void setImie(String var){
        imie=var;
    }
    public void setNazwisko(String var){
        nazwisko=var;
    }
    public void setBudzet(double var){
        budzet=var;
    }
    public void addPosiadaneAkcje(Akcja var){
        posiadaneAkcje.add(var);
    }
    public void addPosiadaneWaluty(Waluta var){
        posiadaneWaluty.add(var);
    }
    public void addPosiadaneSurowce(Surowiec var){
        posiadaneSurowce.add(var);
    }
    public String getImie(){
        return imie;
    }
    public String getNazwisko(){
        return nazwisko;
    }
    public double getBudzet(){
        return budzet;
    }
}
