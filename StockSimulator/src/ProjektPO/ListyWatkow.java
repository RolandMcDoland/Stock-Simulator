/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjektPO;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class ListyWatkow {
    List<WatekInwestora> watkiInwestorow;
    List<WatekFunduszu> watkiFunduszy;
    List<WatekSpolki> watkiSpolek;
    public ListyWatkow(){
        watkiInwestorow=new ArrayList<>();
        watkiFunduszy=new ArrayList<>();
        watkiSpolek=new ArrayList<>();
    }
    public void addWatkiInwestorow(WatekInwestora var){
        watkiInwestorow.add(var);
    }
    public void addWatkiFunduszy(WatekFunduszu var){
        watkiFunduszy.add(var);
    }
    public void addWatkiSpolek(WatekSpolki var){
        watkiSpolek.add(var);
    }
}
