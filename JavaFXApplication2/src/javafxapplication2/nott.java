/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javafxapplication2;

/**
 *
 * @author gokce
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Priority;

public class nott extends Application {

    private ArrayList<String> notlar = new ArrayList<>();
    private ListView<String> notListesi;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Not Defteri");

        // Not Listesi
        notListesi = new ListView<>();
        notListesi.setPrefHeight(300);
       
        // Yeni Not Ekleme Alanı
        TextField yeniNotAlanı = new TextField();
        yeniNotAlanı.setPromptText("Buraya yeni bir not ekleyin");

        // Butonlar
        Button ekleButton = new Button("Not Ekle");
        Button silButton = new Button("Not Sil");
        Button notduzenButton=new Button("Not düzenle");
        Button kaydetButton = new Button("Kaydet");
        // Buton Eylemleri
        ekleButton.setOnAction(e -> {
            String yeniNot = yeniNotAlanı.getText();
            if (!yeniNot.isEmpty()) {
                notlar.add(yeniNot);
                yeniNotAlanı.clear();
                notListesi.getItems().add(yeniNot);
                notlariKaydet();
            }
        });

        silButton.setOnAction(e -> {
            int secilenIndex = notListesi.getSelectionModel().getSelectedIndex();
            if (secilenIndex >= 0) {
                notlar.remove(secilenIndex);
                notListesi.getItems().remove(secilenIndex);
                notlariKaydet();
            }
        });
       notListesi.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                notduzenButton.setText(newValue);
            }
             kaydetButton.setOnAction(e -> {
            int selectedIndex = notListesi.getSelectionModel().getSelectedIndex();
            if (selectedIndex != -1) {
                String duzenlenmisNot = notduzenButton.getText();
                if (!duzenlenmisNot.isEmpty()) {
                    notListesi.getItems().set(selectedIndex, duzenlenmisNot);
                    
                }
            }
        });
        
        notListesi.setMinHeight(350);
        notListesi.setPrefHeight(300);
        notListesi.setMaxHeight(450);
        notListesi.setMinWidth(400);
        notListesi.setPrefWidth(300);
        notListesi.setMaxWidth(900);

      
        VBox.setVgrow(notListesi, Priority.ALWAYS);
        
        // Ana Düzen
        VBox anaDüzen = new VBox();
        anaDüzen.setPadding(new Insets(10));
        anaDüzen.setSpacing(10);
        anaDüzen.getChildren().addAll(notListesi, yeniNotAlanı, ekleButton, silButton);

      
        Scene sahne = new Scene(anaDüzen, 700, 500);
        primaryStage.setScene(sahne);
        primaryStage.show();

        
     