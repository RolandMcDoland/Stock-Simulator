/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import ProjektPO.Spolka;
import ProjektPO.Inwestor;
import ProjektPO.Fundusz;
import ProjektPO.Waluta;
import ProjektPO.Surowiec;
import ProjektPO.Gielda;
import ProjektPO.Akcja;
import ProjektPO.Indeks;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import ProjektPO.ListyObiektow;
import java.util.List;
import java.util.Random;
import java.io.*;
import ProjektPO.ListyWatkow;
import ProjektPO.WatekFunduszu;
import ProjektPO.WatekInwestora;
import ProjektPO.WatekSpolki;
/**
 *
 * @author Licealista
 */
public class GUI extends Application{
    //deklaracja zmiennych
    Stage stage;
    Scene scene,szczegolySpolkiScene,dodajScene,szczegolyInwestoraScene,szczegolyFunduszuScene,szczegolySurowcaScene,szczegolyWalutyScene,szczegolyAkcjiScene;
    Button dodaj,usunAktywo,szczegolyAktywa,dodajElement,wroc,usunSpolke,usunUczestnika,szczegolySpolki,szczegolyUczestnika,zapisz,wczytaj,wrocSzczegolySpolki,wrocSzczegolyInwestora,wrocSzczegolyFunduszu,wrocSzczegolySurowca,wrocSzczegolyWaluty,wrocSzczegolyAkcji,wykupAkcjeButton;
    Label aktywo,spolka,uczestnik,wolumen,nazwa,data1Wyceny,zysk,przychod,obroty,liczbaAkcji,kursOtw,kursAkt,kursMax,kursMin,imie,nazwisko,PESEL,nazwaFunduszu,imieWlasciciela,nazwiskoWlasciciela,nazwaSurowca,wartosc,jednostka,waluta,wartoscMin,wartoscMax,nazwaWaluty,cenaKupna,cenaSprzedazy,listaKrajow,iloscAkcji,nazwaAkcji;
    ListView<String>listaAktyw,listaUczestnikow,listaSpolek;
    ObservableList<String>lista;
    ChoiceBox<String>wyborElementu;
    TextField podajWartosc;
    LineChart wykresSurowca,wykresWaluty;
    CategoryAxis x;
    NumberAxis y;
    ListyObiektow listaObiektow;
    ListyWatkow listaWatkow;
    Exception Exception;
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args){
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        //utworzenie zmiennych
        Exception=new Exception();
        stage=primaryStage;
        aktywo=new Label("Aktywa");
        spolka=new Label("Spółki");
        uczestnik=new Label("Uczestnicy");
        dodaj=new Button("Dodaj");
        usunAktywo=new Button("Usuń");
        usunSpolke=new Button("Usuń");
        usunUczestnika=new Button("Usuń");
        szczegolyAktywa=new Button("Szczegóły");
        szczegolySpolki=new Button("Szczegóły");
        szczegolyUczestnika=new Button("Szczegóły");
        zapisz=new Button("Zapisz");
        wczytaj=new Button("Wczytaj");
        listaAktyw=new ListView<>();
        listaSpolek=new ListView<>();
        listaUczestnikow=new ListView<>();
        listaObiektow=new ListyObiektow();
        listaWatkow=new ListyWatkow();
        //tworzenie layoutu okna startowego
        HBox aktywaButtons=new HBox(10);
        aktywaButtons.setPadding(new Insets(20,0,20,0));
        aktywaButtons.getChildren().addAll(usunAktywo,szczegolyAktywa);
        VBox aktywa=new VBox(10);
        aktywa.setPadding(new Insets(0,20,20,20));
        aktywa.getChildren().addAll(aktywo,listaAktyw,aktywaButtons);
        HBox spolkiButtons=new HBox(10);
        spolkiButtons.setPadding(new Insets(20,0,20,0));
        spolkiButtons.getChildren().addAll(usunSpolke,szczegolySpolki);
        VBox spolki=new VBox(10);
        spolki.setPadding(new Insets(0,20,20,20));
        spolki.getChildren().addAll(spolka,listaSpolek,spolkiButtons);
        HBox uczestnicyButtons=new HBox(10);
        uczestnicyButtons.setPadding(new Insets(20,0,20,0));
        uczestnicyButtons.getChildren().addAll(usunUczestnika,szczegolyUczestnika);
        VBox uczestnicy=new VBox(10);
        uczestnicy.setPadding(new Insets(0,20,20,20));
        uczestnicy.getChildren().addAll(uczestnik,listaUczestnikow,uczestnicyButtons);
        HBox lists=new HBox(10);
        lists.setPadding(new Insets(0,0,0,0));
        lists.getChildren().addAll(aktywa,spolki,uczestnicy);
        HBox buttons=new HBox(30);
        buttons.setPadding(new Insets(0,0,0,250));
        buttons.getChildren().addAll(dodaj);
        HBox serializeButtons=new HBox(30);
        serializeButtons.setPadding(new Insets(20,20,20,200));
        serializeButtons.getChildren().addAll(wczytaj,zapisz);
        VBox layout=new VBox();
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(lists,buttons,serializeButtons);
        scene = new Scene(layout,600,500);
        //tworzenie przycisków do powrotu do okna startowego
        wrocSzczegolySpolki=new Button("Wroc");
        wrocSzczegolyInwestora=new Button("Wroc");
        wrocSzczegolyFunduszu=new Button("Wroc");
        wrocSzczegolySurowca=new Button("Wroc");
        wrocSzczegolyWaluty=new Button("Wroc");
        wrocSzczegolyAkcji=new Button("Wroc");
        //przycisk do wykupowania akcji przez spółkę
        wykupAkcjeButton=new Button("Wykup Akcję");
        //tworzenie layoutu okna w którym dodawane są obiekty
        wroc=new Button("Wróć");
        dodajElement=new Button("Dodaj");
        wyborElementu=new ChoiceBox<>();
        wyborElementu.getItems().addAll("Giełda","Indeks","Waluta","Surowiec","Spółka","Inwestor","Fundusz");
        wyborElementu.setValue("Giełda");
        VBox dodajLayout=new VBox(10);
        dodajLayout.setPadding(new Insets(20,20,20,60));
        dodajLayout.getChildren().addAll(wyborElementu,dodajElement,wroc);
        dodajScene=new Scene(dodajLayout,200,150);
        //deklaracja funkcjonalności przycisków
        szczegolyAktywa.setOnAction(e->szczegolyAktywaClicked());
        szczegolySpolki.setOnAction(e->szczegolySpolkiClicked());
        szczegolyUczestnika.setOnAction(e->szczegolyUczestnikaClicked());
        dodaj.setOnAction(e->stage.setScene(dodajScene));
        wrocSzczegolySpolki.setOnAction(e->stage.setScene(scene));
        wrocSzczegolyInwestora.setOnAction(e->stage.setScene(scene));
        wrocSzczegolyFunduszu.setOnAction(e->stage.setScene(scene));
        wrocSzczegolySurowca.setOnAction(e->stage.setScene(scene));
        wrocSzczegolyWaluty.setOnAction(e->stage.setScene(scene));
        wrocSzczegolyAkcji.setOnAction(e->stage.setScene(scene));
        wroc.setOnAction(e->stage.setScene(scene));
        dodajElement.setOnAction(e->dodajClicked(wyborElementu));
        usunAktywo.setOnAction(e->usunAktywoClicked(listaAktyw));
        usunSpolke.setOnAction(e->usunSpolkaClicked(listaSpolek));
        usunUczestnika.setOnAction(e->usunUczestnikClicked(listaUczestnikow));
        zapisz.setOnAction(e->zapisz());
        wczytaj.setOnAction(e->wczytaj());
        stage.setScene(scene);
        stage.setTitle("Panel sterowania");
        stage.show();
        stage.setOnCloseRequest(e->shutdown());
    }
    //tworzenie odpowiedniego obiektu (i jeśli to konieczne odpalanie jego wątku) po wybraniu klasy elementu i kliknięciu przycisku dodaj
    private void dodajClicked(ChoiceBox<String> wybor){
        String typ=wybor.getValue();
        switch(typ){
            case "Spółka":
                try{
                Spolka spolka;
                spolka=new Spolka(listaObiektow);
                listaSpolek.getItems().add(spolka.getNazwa());
                int index=listaObiektow.getListaAkcji().size()-1;
                List <Akcja> tymczasowaListaAkcji=listaObiektow.getListaAkcji();
                Akcja akcjaDoDodania=tymczasowaListaAkcji.get(index);
                listaAktyw.getItems().add(akcjaDoDodania.getNazwa()+" (Akcje)");
                listaObiektow.addListaSpolek(spolka);
                WatekSpolki watekSpolki=new WatekSpolki(spolka,listaObiektow);
                listaWatkow.addWatkiSpolek(watekSpolki);
                new Thread(watekSpolki).start();
                Random generator=new Random();
                int liczba=generator.nextInt(3)+1;
                for(int i=0;i<liczba;i++){
                    int choice=generator.nextInt(2);
                    if(choice==0){
                        Inwestor inwestor2;
                        inwestor2=new Inwestor();
                        listaUczestnikow.getItems().add(inwestor2.getImie()+" "+inwestor2.getNazwisko()+" (Inwestor)");
                        listaObiektow.addListaInwestorow(inwestor2);
                        WatekInwestora watekInwestora=new WatekInwestora(inwestor2,listaObiektow);
                        listaWatkow.addWatkiInwestorow(watekInwestora);
                        new Thread(watekInwestora).start();
                    }
                    else{       

                        if(listaObiektow.getListaInwestorow().size()==0){
                            Inwestor inwestorDod;
                            inwestorDod=new Inwestor();
                            listaUczestnikow.getItems().add(inwestorDod.getImie()+" "+inwestorDod.getNazwisko()+" (Inwestor)");
                            listaObiektow.addListaInwestorow(inwestorDod);
                        }
                        Fundusz fundusz;
                        fundusz=new Fundusz(listaObiektow);
                        listaUczestnikow.getItems().add(fundusz.getNazwa()+" (Fundusz)");
                        listaObiektow.addListaFunduszy(fundusz);
                        WatekFunduszu watekFunduszu=new WatekFunduszu(fundusz,listaObiektow);
                        listaWatkow.addWatkiFunduszy(watekFunduszu);
                        new Thread(watekFunduszu).start();
                    }
                }
                }catch(Exception e){
                    System.out.println("Najpierw utwórz giełdę!");
                }
                break;
            case "Inwestor":
                Inwestor inwestor;
                inwestor=new Inwestor();
                 listaUczestnikow.getItems().add(inwestor.getImie()+" "+inwestor.getNazwisko()+" (Inwestor)");
                 listaObiektow.addListaInwestorow(inwestor);
                 WatekInwestora watekInwestora=new WatekInwestora(inwestor,listaObiektow);
                listaWatkow.addWatkiInwestorow(watekInwestora);
                new Thread(watekInwestora).start();
                 break;
            case "Fundusz":
                if(listaObiektow.getListaInwestorow().size()==0){
                    Inwestor inwestorDod;
                    inwestorDod=new Inwestor();
                    listaUczestnikow.getItems().add(inwestorDod.getImie()+" "+inwestorDod.getNazwisko()+" (Inwestor)");
                    listaObiektow.addListaInwestorow(inwestorDod);
                    WatekInwestora watekInwestora1=new WatekInwestora(inwestorDod,listaObiektow);
                    listaWatkow.addWatkiInwestorow(watekInwestora1);
                    new Thread(watekInwestora1).start();
                }
                Fundusz fundusz;
                fundusz=new Fundusz(listaObiektow);
                 listaUczestnikow.getItems().add(fundusz.getNazwa()+" (Fundusz)");
                 listaObiektow.addListaFunduszy(fundusz);
                 WatekFunduszu watekFunduszu1=new WatekFunduszu(fundusz,listaObiektow);
                 listaWatkow.addWatkiFunduszy(watekFunduszu1);
                 new Thread(watekFunduszu1).start();
                 break;
            case "Surowiec":
                Surowiec surowiec;
                surowiec=new Surowiec();
                listaAktyw.getItems().add(surowiec.getNazwa()+" (Surowiec)");
                listaObiektow.addListaSurowcow(surowiec);
                break;
            case "Waluta":
                Waluta waluta;
                waluta=new Waluta();
                listaAktyw.getItems().add(waluta.getNazwa()+(" (Waluta)"));
                listaObiektow.addListaWalut(waluta);
                break;
            case "Giełda":
                Gielda gielda;
                gielda=new Gielda(listaObiektow);
                listaObiektow.addListaGield(gielda);
                break;
            case "Indeks":
                Indeks indeks;
                indeks=new Indeks();
                listaObiektow.addListaIndeksow(indeks);
                break;
        }
    }
    //usuwanie spółki po wybraniu z listy i naciśnięciu przycisku usuń
    private void usunSpolkaClicked(ListView<String> lista){
        try{
        int doUsuniecia;
        doUsuniecia=lista.getSelectionModel().getSelectedIndex();
        List<Spolka>listaDoPrzeszukania=listaObiektow.getListaSpolek();
        listaDoPrzeszukania.remove(doUsuniecia);
        lista.getItems().remove(doUsuniecia);
        }catch(Exception e){
            
        }
    }
    //usuwanie uczestnika po wybraniu z listy i naciśnięciu przycisku usuń
    private void usunUczestnikClicked(ListView<String> lista){
        try{
        int doUsuniecia;
        String nazwaWybranegoUczestnika=new String();
        doUsuniecia=lista.getSelectionModel().getSelectedIndex();
        lista.getItems().remove(doUsuniecia);
        nazwaWybranegoUczestnika=lista.getSelectionModel().getSelectedItem();
        if(nazwaWybranegoUczestnika.endsWith("(Inwestor)")){
            List<Inwestor>listaDoPrzeszukania=listaObiektow.getListaInwestorow();
            for(int i=0;i<listaDoPrzeszukania.size();i++){
                if(nazwaWybranegoUczestnika.equals(listaDoPrzeszukania.get(i).getImie()+" "+listaDoPrzeszukania.get(i).getNazwisko()+" (Inwestor)")){
                    listaDoPrzeszukania.remove(i);
                    break;
                }
            }
        }
        else if(nazwaWybranegoUczestnika.endsWith("(Fundusz)")){
            List<Fundusz>listaDoPrzeszukania=listaObiektow.getListaFunduszy();
            for(int i=0;i<listaDoPrzeszukania.size();i++){
                if(nazwaWybranegoUczestnika.equals(listaDoPrzeszukania.get(i).getNazwa()+" (Fundusz)")){
                    listaDoPrzeszukania.remove(i);
                    break;
                }
            }
        }
        }catch(Exception e){
            
        }
    }
    //usuwanie aktywa po wybraniu z listy i naciśnięciu przycisku usuń
    private void usunAktywoClicked(ListView<String> lista){
        try{
        int doUsuniecia;
        String nazwaWybranegoAktywa=new String();
        nazwaWybranegoAktywa=lista.getSelectionModel().getSelectedItem();
        if(nazwaWybranegoAktywa.endsWith("(Surowiec)")){
            doUsuniecia=lista.getSelectionModel().getSelectedIndex();
            lista.getItems().remove(doUsuniecia);
            List<Surowiec>listaDoPrzeszukania=listaObiektow.getListaSurowcow();
            for(int i=0;i<listaDoPrzeszukania.size();i++){
                if(nazwaWybranegoAktywa.equals(listaDoPrzeszukania.get(i).getNazwa()+" (Surowiec)")){
                    listaDoPrzeszukania.remove(i);
                    break;
                }
            }
        }
        else if(nazwaWybranegoAktywa.endsWith("(Waluta)")){
            doUsuniecia=lista.getSelectionModel().getSelectedIndex();
            lista.getItems().remove(doUsuniecia);
            List<Waluta>listaDoPrzeszukania=listaObiektow.getListaWalut();
            for(int i=0;i<listaDoPrzeszukania.size();i++){
                if(nazwaWybranegoAktywa.equals(listaDoPrzeszukania.get(i).getNazwa()+" (Waluta)")){
                    listaDoPrzeszukania.remove(i);
                    break;
                }
            }
        }
        else if(nazwaWybranegoAktywa.endsWith("(Akcje)")){
            System.out.println("Akcje usuwa się tylko ze spółką!");
        }
        }catch(Exception e){
            
        }
    }
    //wyświetlanie szczegółów spółki
    private void szczegolySpolkiClicked(){
        Spolka wybranaSpolka=new Spolka(listaObiektow);
        String nazwaWybranejSpolki;
        nazwaWybranejSpolki=listaSpolek.getSelectionModel().getSelectedItem();
        List<Spolka>listaDoPrzeszukania=listaObiektow.getListaSpolek();
        for(int i=0;i<listaDoPrzeszukania.size();i++){
            if(nazwaWybranejSpolki==listaDoPrzeszukania.get(i).getNazwa()){
                wybranaSpolka=listaDoPrzeszukania.get(i);
                break;
            }
        }
        wolumen=new Label("Wolumen: "+Integer.toString(wybranaSpolka.getWolumen()));
        nazwa=new Label("Nazwa: "+ wybranaSpolka.getNazwa());
        data1Wyceny=new Label("Data 1 wyceny: "+wybranaSpolka.getData1Wyceny());
        kursOtw=new Label("Kurs otwarcia: "+Double.toString(wybranaSpolka.getKursOtw()));
        kursAkt=new Label("Aktualny kurs: "+Double.toString(wybranaSpolka.getKursAkt()));
        kursMin=new Label("Minimalny kurs: "+Double.toString(wybranaSpolka.getKursMin()));
        kursMax=new Label("Maksymalny kurs: "+Double.toString(wybranaSpolka.getKursMax()));
        liczbaAkcji=new Label("Liczba akcji: "+Integer.toString(wybranaSpolka.getLiczbaAkcji()));
        zysk=new Label("Zysk: "+Double.toString(wybranaSpolka.getZysk()));
        przychod=new Label("Przychod: "+Double.toString(wybranaSpolka.getPrzychod()));
        obroty=new Label("Obroty: "+Double.toString(wybranaSpolka.getObroty()));
        VBox szczegolySpolkiLayout=new VBox(10);
        szczegolySpolkiLayout.setPadding(new Insets(20,20,20,20));
        szczegolySpolkiLayout.getChildren().addAll(nazwa,wolumen,data1Wyceny,kursOtw,kursAkt,kursMin,kursMax,liczbaAkcji,zysk,przychod,obroty,wrocSzczegolySpolki);
        szczegolySpolkiScene=new Scene(szczegolySpolkiLayout,300,500);
        stage.setScene(szczegolySpolkiScene);
    }
    //wyświetlanie szczegółów aktywa
    private void szczegolyAktywaClicked(){
        String nazwaWybranegoAktywa=new String();
        nazwaWybranegoAktywa=listaAktyw.getSelectionModel().getSelectedItem();
        if(nazwaWybranegoAktywa.endsWith("(Surowiec)")){
            Surowiec wybranySurowiec=new Surowiec();
            List<Surowiec>listaDoPrzeszukania=listaObiektow.getListaSurowcow();
            for(int i=0;i<listaDoPrzeszukania.size();i++){
                if(nazwaWybranegoAktywa.equals(listaDoPrzeszukania.get(i).getNazwa()+" (Surowiec)")){
                    wybranySurowiec=listaDoPrzeszukania.get(i);
                    break;
                }
            }
            jednostka=new Label("Jednostka: "+wybranySurowiec.getJednostka());
            waluta=new Label("Waluta: "+ wybranySurowiec.getWaluta());
            nazwaSurowca=new Label("Nazwa: "+wybranySurowiec.getNazwa());
            wartosc=new Label("Wartość: "+Double.toString(wybranySurowiec.getWartosc()));
            wartoscMin=new Label("Wartość minimalna: "+Double.toString(wybranySurowiec.getWartoscMin()));
            wartoscMax=new Label("Wartość maksymalna: "+Double.toString(wybranySurowiec.getWartoscMax()));
            //wykresSurowca=new LineChart(x,y);
            VBox szczegolySurowcaLayout=new VBox(10);
            szczegolySurowcaLayout.setPadding(new Insets(20,20,20,20));
            szczegolySurowcaLayout.getChildren().addAll(nazwaSurowca,jednostka,waluta,wartosc,wartoscMin,wartoscMax,/*wykresSurowca,*/wrocSzczegolySurowca);
            szczegolySurowcaScene=new Scene(szczegolySurowcaLayout,300,250);
            stage.setScene(szczegolySurowcaScene);
        }
        else if(nazwaWybranegoAktywa.endsWith("(Waluta)")){
            Waluta wybranaWaluta=new Waluta();
            List<Waluta>listaDoPrzeszukania=listaObiektow.getListaWalut();
            for(int i=0;i<listaDoPrzeszukania.size();i++){
                if(nazwaWybranegoAktywa.equals(listaDoPrzeszukania.get(i).getNazwa()+" (Waluta)")){
                    wybranaWaluta=listaDoPrzeszukania.get(i);
                    break;
                }
            }
            nazwaWaluty=new Label("Nazwa: "+wybranaWaluta.getNazwa());
            cenaKupna=new Label("Cena kupna: "+Double.toString(wybranaWaluta.getCenaKupna()));
            cenaSprzedazy=new Label("Cena sprzedaży: "+Double.toString(wybranaWaluta.getCenaSprzedazy()));
            listaKrajow=new Label("Lista krajów: "+wybranaWaluta.getListaKrajow());
            VBox szczegolyWalutyLayout=new VBox(10);
            szczegolyWalutyLayout.setPadding(new Insets(20,20,20,20));
            szczegolyWalutyLayout.getChildren().addAll(nazwaWaluty,cenaKupna,cenaSprzedazy,listaKrajow,wrocSzczegolyWaluty);
            szczegolyWalutyScene=new Scene(szczegolyWalutyLayout,300,250);
            stage.setScene(szczegolyWalutyScene);
        }
        else if(nazwaWybranegoAktywa.endsWith("(Akcje)")){
            Akcja wybranaAkcja=new Akcja();
            List<Akcja>listaDoPrzeszukania=listaObiektow.getListaAkcji();
            for(int i=0;i<listaDoPrzeszukania.size();i++){
                if(nazwaWybranegoAktywa.equals(listaDoPrzeszukania.get(i).getNazwa()+" (Akcje)")){
                    wybranaAkcja=listaDoPrzeszukania.get(i);
                    break;
                }
            }
            nazwaAkcji=new Label("Nazwa: "+wybranaAkcja.getNazwa());
            wartosc=new Label("Wartość: "+Double.toString(wybranaAkcja.getWartosc()));
            iloscAkcji=new Label("Ilość akcji: "+Integer.toString(wybranaAkcja.getIloscAkcji()));
            podajWartosc=new TextField("Podaj cenę wykupu");
            final Akcja akcjaDoWykupu=wybranaAkcja;
            wykupAkcjeButton.setOnAction(e->wykupAkcjeClicked(podajWartosc,akcjaDoWykupu));
            VBox szczegolyAkcjiLayout=new VBox(10);
            szczegolyAkcjiLayout.setPadding(new Insets(20,20,20,20));
            szczegolyAkcjiLayout.getChildren().addAll(nazwaAkcji,wartosc,iloscAkcji,podajWartosc,wykupAkcjeButton,wrocSzczegolyAkcji);
            szczegolyAkcjiScene=new Scene(szczegolyAkcjiLayout,300,250);
            stage.setScene(szczegolyAkcjiScene);
        }
    }
    //wyświetlanie szczegółów uczestnika
    private void szczegolyUczestnikaClicked(){
        String nazwaWybranegoUczestnika=new String();
        nazwaWybranegoUczestnika=listaUczestnikow.getSelectionModel().getSelectedItem();
        if(nazwaWybranegoUczestnika.endsWith("(Inwestor)")){
            Inwestor wybranyInwestor=new Inwestor();
            List<Inwestor>listaDoPrzeszukania=listaObiektow.getListaInwestorow();
            for(int i=0;i<listaDoPrzeszukania.size();i++){
                if(nazwaWybranegoUczestnika.equals(listaDoPrzeszukania.get(i).getImie()+" "+listaDoPrzeszukania.get(i).getNazwisko()+" (Inwestor)")){
                    wybranyInwestor=listaDoPrzeszukania.get(i);
                    break;
                }
            }
            imie=new Label("Imie: "+wybranyInwestor.getImie());
            nazwisko=new Label("Nazwisko: "+ wybranyInwestor.getNazwisko());
            PESEL=new Label("PESEL: "+wybranyInwestor.getPESEL());
            VBox szczegolyInwestoraLayout=new VBox(10);
            szczegolyInwestoraLayout.setPadding(new Insets(20,20,20,20));
            szczegolyInwestoraLayout.getChildren().addAll(imie,nazwisko,PESEL,wrocSzczegolyInwestora);
            szczegolyInwestoraScene=new Scene(szczegolyInwestoraLayout,300,200);
            stage.setScene(szczegolyInwestoraScene);
        }
        else if(nazwaWybranegoUczestnika.endsWith("(Fundusz)")){
            Fundusz wybranyFundusz=new Fundusz(listaObiektow);
            List<Fundusz>listaDoPrzeszukania=listaObiektow.getListaFunduszy();
            for(int i=0;i<listaDoPrzeszukania.size();i++){
                if(nazwaWybranegoUczestnika.equals(listaDoPrzeszukania.get(i).getNazwa()+" (Fundusz)")){
                    wybranyFundusz=listaDoPrzeszukania.get(i);
                    break;
                }
            }
            imieWlasciciela=new Label("Imie włściciela: "+wybranyFundusz.getImie());
            nazwiskoWlasciciela=new Label("Nazwisko właściciela: "+ wybranyFundusz.getNazwisko());
            nazwaFunduszu=new Label("Nazwa: "+wybranyFundusz.getNazwa());
            VBox szczegolyFunduszuLayout=new VBox(10);
            szczegolyFunduszuLayout.setPadding(new Insets(20,20,20,20));
            szczegolyFunduszuLayout.getChildren().addAll(nazwaFunduszu,imieWlasciciela,nazwiskoWlasciciela,wrocSzczegolyFunduszu);
            szczegolyFunduszuScene=new Scene(szczegolyFunduszuLayout,300,200);
            stage.setScene(szczegolyFunduszuScene);
        }
    }
    //wykupowanie akcji przez spółkę
    private void wykupAkcjeClicked(TextField podaj,Akcja akcjaDoWykupu){
        String slowoCena=podaj.getText();
        akcjaDoWykupu.wykup(slowoCena);
    }
    //serializacja-zapisywanie
    private void zapisz(){
        String nazwaPliku = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\ProjektPO\\gielda.ser";
        try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nazwaPliku)))){
            out.writeObject(listaObiektow);
            out.close();
        }catch(Exception e){
            System.out.println("Błąd zapisu!");
        }
    }
    //serializacja-wczytywanie i przywracanie ListView oraz wątków
    private void wczytaj(){
        String nazwaPliku = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\ProjektPO\\gielda.ser";
        try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nazwaPliku)))){
            listaObiektow = (ListyObiektow) in.readObject();
            in.close();
            List <Spolka> lista=listaObiektow.getListaSpolek();
            for(int i=0;i<lista.size();i++){
                Spolka spolka=lista.get(i);
                listaSpolek.getItems().add(spolka.getNazwa());
                WatekSpolki watekSpolki=new WatekSpolki(spolka,listaObiektow);
                listaWatkow.addWatkiSpolek(watekSpolki);
                new Thread(watekSpolki).start();
            }
            List <Inwestor> lista1=listaObiektow.getListaInwestorow();
            for(int i=0;i<lista1.size();i++){
                Inwestor inwestor=lista1.get(i);
                listaUczestnikow.getItems().add(inwestor.getImie()+" "+inwestor.getNazwisko()+" (Inwestor)");
                WatekInwestora watekInwestora=new WatekInwestora(inwestor,listaObiektow);
                listaWatkow.addWatkiInwestorow(watekInwestora);
                new Thread(watekInwestora).start();
            }
            List <Fundusz> lista2=listaObiektow.getListaFunduszy();
            for(int i=0;i<lista2.size();i++){
                Fundusz fundusz=lista2.get(i);
                listaUczestnikow.getItems().add(fundusz.getNazwa()+" (Fundusz)");
                WatekFunduszu watekFunduszu=new WatekFunduszu(fundusz,listaObiektow);
                listaWatkow.addWatkiFunduszy(watekFunduszu);
                new Thread(watekFunduszu).start();
            }
            List <Waluta> lista3=listaObiektow.getListaWalut();
            for(int i=0;i<lista3.size();i++){
                Waluta waluta=lista3.get(i);
                listaAktyw.getItems().add(waluta.getNazwa()+" (Waluta)");
            }
            List <Surowiec> lista4=listaObiektow.getListaSurowcow();
            for(int i=0;i<lista4.size();i++){
                Surowiec surowiec=lista4.get(i);
                listaAktyw.getItems().add(surowiec.getNazwa()+" (Surowiec)");
            }
            List <Akcja> lista5=listaObiektow.getListaAkcji();
            for(int i=0;i<lista5.size();i++){
                Akcja akcja=lista5.get(i);
                listaAktyw.getItems().add(akcja.getNazwa()+" (Akcje)");
            }
        }catch(Exception e){
            System.out.println("Błąd wczytywania!");
        }
    }
    //zamykanie wszystkich wątków przy zamknięciu okna
    private void shutdown(){
        System.exit(0);
    }
}
