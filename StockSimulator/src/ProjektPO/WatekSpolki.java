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
public class WatekSpolki implements Runnable{
    private Spolka spolka;
    private ListyObiektow listaObiektow;
    public WatekSpolki(Spolka var, ListyObiektow var1){
        spolka=var;
        listaObiektow=var1;
    }
    @Override
    public void run(){
        Random generator=new Random();
        double roznica;
        int choice;
        while(true){
            choice=generator.nextInt(1000000001);
            if(choice<3){
                roznica=generator.nextDouble()*10000;
                spolka.setPrzychod(spolka.getPrzychod()+roznica);
                roznica=generator.nextDouble()*15000;
                spolka.setZysk(spolka.getPrzychod()-roznica);
            }
            else if(choice<5){
                spolka.setLiczbaAkcji(spolka.getLiczbaAkcji()+1);
            }
        }
    }
}
