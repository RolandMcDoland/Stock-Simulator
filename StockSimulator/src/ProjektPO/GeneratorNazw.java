/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjektPO;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Admin
 */
public class GeneratorNazw {
    private String nazwa;
    private Random generator;
    private List <String> lista;
    private List <String> listaNazw;
    private int index;
    public GeneratorNazw(){
        generator=new Random();
        lista=new ArrayList<>();
        listaNazw=new ArrayList<>();
    }
    public String generujImie(){
        lista.addAll(Arrays.asList("Michael","Donna","Fez","Eric","Steven","Jackie","Geralt","Bruce","Wade","Drax","Ragnar","Corvo","Arlen","Han","Gandalf"));
        index=generator.nextInt(15);
        nazwa=lista.get(index);
        lista.clear();
        return nazwa;
    }
    public String generujNazwisko(){
        lista.addAll(Arrays.asList("Kelso","Pinciotti","z Junikowa","Forman","Hyde","Burckhart","z Rivii","Wayne","Wilson","the Destroyer","Lothbrok","Attano","Bales","Solo","the Grey"));
        index=generator.nextInt(15);
        nazwa=lista.get(index);
        lista.clear();
        return nazwa;
    }
    public String generujNazweWaluty(){
        lista.addAll(Arrays.asList("PLN","USD","GBP","Oreny","Korony","Kredyty","Naboje","Kapsle","Galeony","Złote smoki"));
        index=generator.nextInt(10);
        nazwa=lista.get(index);
        lista.clear();
        return nazwa;
    }
    public List generujListeKrajow(){
        lista.addAll(Arrays.asList("Westeros","Stany Zjednoczone","Wielka Bryatnia","Novigrad","Hanza","Imperium Galaktyczne","Rivendell","Republika Nowej Kalifornii","Polis","Temeria","Nilfgaard","Xandar","Karnaka","Krasja","Gondor"));
        int ilosc=generator.nextInt(2)+1;
        for(int i=0;i<ilosc;i++){
            index=generator.nextInt(15);
            listaNazw.add(lista.get(index));
        }
        lista.clear();
        return listaNazw;
    }
    public String generujNazweSurowca(){
        lista.addAll(Arrays.asList("Złoto","Srebro","Gaz Tibbana","Cortosis","Smocze szkło","Valyriańska stal","Brąz","Platyna","Miedź","Żelazo","Vibranium"));
        index=generator.nextInt(11);
        nazwa=lista.get(index);
        lista.clear();
        return nazwa;
    }
    public String generujJednostke(){
        lista.addAll(Arrays.asList("Uncje","Kilogramy","Metry sześcienne","Litry","Funty"));
        index=generator.nextInt(5);
        nazwa=lista.get(index);
        lista.clear();
        return nazwa;
    }
    public String generujKraj(){
        lista.addAll(Arrays.asList("Westeros","Stany Zjednoczone","Wielka Bryatnia","Novigrad","Hanza","Imperium Galaktyczne","Rivendell","Republika Nowej Kalifornii","Polis","Temeria","Nilfgaard","Xandar","Karnaka","Krasja","Gondor"));
        index=generator.nextInt(15);
        nazwa=lista.get(index);
        lista.clear();
        return nazwa;
    }
    public String generujMiasto(){
        lista.addAll(Arrays.asList("Flotsam","Mos Eisley","Blaviken","Zakątek Drwali","Mahakam","Hogsmeade","Shire","Anchorhead","Gotham City","Cyatdela","Central City","Nowy Jork","Londyn","Kattegat","Warszawa"));
        index=generator.nextInt(15);
        nazwa=lista.get(index);
        lista.clear();
        return nazwa;
    }
    public String generujAdres(){
        lista.addAll(Arrays.asList("Os.","Ul.","Al."));
        index=generator.nextInt(3);
        nazwa=lista.get(index);
        lista.clear();
        lista.addAll(Arrays.asList("Wall Street","Tall Street","Call Street","Mall Street","Ball Street"));
        index=generator.nextInt(5);
        nazwa=nazwa+" "+lista.get(index);
        index=generator.nextInt(200);
        nazwa=nazwa+" "+Integer.toString(index);
        lista.clear();
        return nazwa;
    }
    public String generujNazweGieldy(){
        lista.addAll(Arrays.asList("Wall","HDAG","VATS","Shaghai","Haiku"));
        index=generator.nextInt(5);
        nazwa=lista.get(index);
        lista.clear();
        lista.addAll(Arrays.asList("Composite","Market","Share"));
        index=generator.nextInt(3);
        nazwa=nazwa+" "+lista.get(index);
        lista.clear();
        return nazwa;
    }
    public String generujNazweSpolki(){
        lista.addAll(Arrays.asList("CD Projekt","Józek","Mlek","Gringott","Vivaldi","Ship","FED","Media","House","Uni"));
        index=generator.nextInt(10);
        nazwa=lista.get(index);
        lista.clear();
        lista.addAll(Arrays.asList("Pol","Markt","Kart"," sp. z. o. o."," RED"," & Partnerzy"," & Syn"));
        index=generator.nextInt(7);
        nazwa=nazwa+lista.get(index);
        lista.clear();
        return nazwa;
    }
    public String generujNazweFunduszu(){
        lista.addAll(Arrays.asList("Noble","Optimum","Uni","Global","Vivaldi","Parsek","Arka","LANL","Uno","Dos"));
        index=generator.nextInt(10);
        nazwa=lista.get(index);
        lista.clear();
        lista.addAll(Arrays.asList(" Fundusze","Fund"," Investors","Invest"," Subfundusz"));
        index=generator.nextInt(5);
        nazwa=nazwa+lista.get(index);
        lista.clear();
        return nazwa;
    }
    public String generujNazweIndeksu(){
        lista.addAll(Arrays.asList("Najlepszy","Najgorszy","Taki sobie","Może być","Ujdzie"));
        index=generator.nextInt(5);
        nazwa=lista.get(index)+" indeks";
        lista.clear();
        return nazwa;
    }
}
