/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjektPO;

import java.util.Random;
import ProjektPO.GeneratorNazw;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class Inwestor extends Uczestnik implements Serializable{
    private String PESEL;
    private List<Fundusz> posiadaneFundusze;
    public Inwestor(){
        posiadaneFundusze=new ArrayList<>();
        Random generator=new Random();
        String PESELPom=new String();
        GeneratorNazw generatorNazw=new GeneratorNazw();
        for(int i=0;i<11;i++){
            PESELPom=PESELPom+Integer.toString(generator.nextInt(10));
        }
        PESEL=PESELPom;
        this.setImie(generatorNazw.generujImie());
        this.setNazwisko(generatorNazw.generujNazwisko());
        this.setBudzet(generator.nextDouble()*5000+20000);
    }
    public synchronized void sprzedajJFunduszy(ListyObiektow listaObiektow){
        Random generator=new Random();
        if(posiadaneFundusze.size()!=0){
            int index=generator.nextInt(posiadaneFundusze.size());
            Fundusz fundusz=posiadaneFundusze.get(index);
            List <Inwestor> lista=listaObiektow.getListaInwestorow();
            int index1=generator.nextInt(lista.size());
            Inwestor inwestor=lista.get(index1);
            if(PESEL!=inwestor.getPESEL()){
                fundusz.setImie(inwestor.getImie());
                fundusz.setNazwisko(inwestor.getNazwisko());
                fundusz.setBudzet(inwestor.getBudzet());
                fundusz.setWlasciciel(inwestor);
                posiadaneFundusze.remove(index);
            }
        }
    }
    public void setPESEL(String var){
        PESEL=var;
    }
    public void addPosidaneFundusze(Fundusz var){
        posiadaneFundusze.add(var);
    }
    public String getPESEL(){
        return PESEL;
    }
    public List getPosiadaneFundusze(){
        return posiadaneFundusze;
    }
}
