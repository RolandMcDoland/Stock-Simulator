/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjektPO;

import java.util.Random;
/**
 *
 * @author Admin
 */
public class WatekInwestora implements Runnable{
    private Inwestor inwestor;
    private ListyObiektow listaObiektow;
    public WatekInwestora(Inwestor var, ListyObiektow var1){
        inwestor=var;
        listaObiektow=var1;
    }
    @Override
    public void run(){
        Random generator=new Random();
        int choice;
        double wzrost;
        while(true){
            choice=generator.nextInt(1000000001);
            if(choice<25){
                inwestor.kup(listaObiektow);
            }
            else if(choice<50){
                inwestor.sprzedaj(listaObiektow);
            }
            else if(choice<70){
                inwestor.sprzedajJFunduszy(listaObiektow);
            }
            else if(choice<85){
                wzrost=generator.nextDouble()*1000;
                inwestor.setBudzet(inwestor.getBudzet()+wzrost);
            }
        }
    }
}
