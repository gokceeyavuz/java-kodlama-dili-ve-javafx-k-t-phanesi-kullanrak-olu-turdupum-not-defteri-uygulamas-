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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class notDEF extends Application {
    private ListView<String> notListesi;
    private TextField yeniNotAlanı;
    private TextField duzenleNotAlanı;
    private Button ekleButton;
    private Button silButton;
    private Button kaydetButton;

    @Override
    public void start(Stage primaryStage) {
        // Bileşenleri oluştur
        notListesi = new ListView<>();
        yeniNotAlanı = new TextField();
        duzenleNotAlanı = new TextField();
        ekleButton = new Button("Ekle");
        silButton = new Button("Sil");
        kaydetButton = new Button("Kaydet");

        // Yeni not ekleme işlemi
        ekleButton.setOnAction(e -> {
            String yeniNot = yeniNotAlanı.getText();
            if (!yeniNot.isEmpty()) {
                notListesi.getItems().add(yeniNot);
                yeniNotAlanı.clear();
                // notlariKaydet();  // Notları kaydetmek için metodu çağırabilirsiniz
            }
        });

        // Not silme işlemi
        silButton.setOnAction(e -> {
            int selectedIndex = notListesi.getSelectionModel().getSelectedIndex();
            if (selectedIndex != -1) {
                notListesi.getItems().remove(selectedIndex);
                duzenleNotAlanı.clear();
                // notlariKaydet();  // Notları kaydetmek için metodu çağırabilirsiniz
            }
        });

        // Not düzenleme işlemi
        notListesi.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    duzenleNotAlanı.setText(newValue);
                }
            }
        });

        kaydetButton.setOnAction(e -> {
            int selectedIndex = notListesi.getSelectionModel().getSelectedIndex();
            if (selectedIndex != -1) {
                String duzenlenmisNot = duzenleNotAlanı.getText();
                if (!duzenlenmisNot.isEmpty()) {
                    notListesi.getItems().set(selectedIndex, duzenlenmisNot);
                    // notlariKaydet();  // Notları kaydetmek için metodu çağırabilirsiniz
                }
            }
        });

        // VBox düzeni
        VBox anaDüzen = new VBox();
        anaDüzen.setPadding(new Insets(10));
        anaDüzen.setSpacing(10);
        anaDüzen.getChildren().addAll(notListesi, yeniNotAlanı, ekleButton, silButton, duzenleNotAlanı, kaydetButton);

        // ListView boyutlarını ayarlama
        notListesi.setMinHeight(300);
        notListesi.setPrefHeight(300);
        notListesi.setMaxHeight(400);
        notListesi.setMinWidth(400);
        notListesi.setPrefWidth(700);
        notListesi.setMaxWidth(900);
        VBox.setVgrow(notListesi, Priority.ALWAYS);

        Scene scene = new Scene(anaDüzen, 700,800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Not Defteri Uygulaması");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    private void notKaydet(){
        
    }
    private void notYukle(){
        
    }
}
