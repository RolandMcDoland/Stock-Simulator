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
public class WatekFunduszu implements Runnable{
    private Fundusz fundusz;
    private ListyObiektow listaObiektow;
    public WatekFunduszu(Fundusz var, ListyObiektow var1){
        fundusz=var;
        listaObiektow=var1;
    }
    @Override
    public void run(){
        Random generator=new Random();
        int choice;
        while(true){
            choice=generator.nextInt(1000000001);
            if(choice<25){
                fundusz.kup(listaObiektow);
            }
            else if(choice<50){
                fundusz.sprzedaj(listaObiektow);
            }
        }
    }
}
