/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjektPO;
import java.io.*;
/**
 *
 * @author Admin
 */
public class Rynek implements Serializable{
    private double marza;
    public void setMarza(double var){
        marza=var;
    }
    public double getMarza(){
        return marza;
    }
}
