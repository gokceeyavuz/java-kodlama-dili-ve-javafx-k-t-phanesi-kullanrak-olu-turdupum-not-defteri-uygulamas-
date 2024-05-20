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
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class notdefteri extends Application {

    private TextArea metinAlani;

    @Override
    public void start(Stage anaSahne) {
        anaSahne.setTitle("Not Defteri");

        // Menü Bar oluşturma
        MenuBar menuCubugu = new MenuBar();
        Menu dosyaMenusu = new Menu("Dosya");
        MenuItem acMenuOgasi = new MenuItem("Aç");
        MenuItem kaydetMenuOgasi = new MenuItem("Kaydet");
        MenuItem cikisMenuOgasi = new MenuItem("Çıkış");

        dosyaMenusu.getItems().addAll(acMenuOgasi, kaydetMenuOgasi, cikisMenuOgasi);
        menuCubugu.getMenus().add(dosyaMenusu);

        // TextArea oluşturma
        metinAlani = new TextArea();

        // BorderPane oluşturma ve bileşenleri ekleme
        BorderPane anaPanel = new BorderPane();
        anaPanel.setTop(menuCubugu);
        anaPanel.setCenter(metinAlani);

        // Aç menü öğesi için olay işleyicisi
        acMenuOgasi.setOnAction(e -> dosyaAc(anaSahne));

        // Kaydet menü öğesi için olay işleyicisi
        kaydetMenuOgasi.setOnAction(e -> dosyaKaydet(anaSahne));

        // Çıkış menü öğesi için olay işleyicisi
        cikisMenuOgasi.setOnAction(e -> anaSahne.close());

        // Sahne oluşturma
        Scene sahne = new Scene(anaPanel, 800, 600);
        anaSahne.setScene(sahne);
        anaSahne.show();
    }

    private void dosyaAc(Stage sahne) {
        FileChooser dosyaSecici = new FileChooser();
        File dosya = dosyaSecici.showOpenDialog(sahne);
        if (dosya != null) {
            try (FileReader dosyaOkuyucu = new FileReader(dosya)) {
                metinAlani.clear();
                int karakter;
                while ((karakter = dosyaOkuyucu.read()) != -1) {
                    metinAlani.appendText(String.valueOf((char) karakter));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void dosyaKaydet(Stage sahne) {
        FileChooser dosyaSecici = new FileChooser();
        File dosya = dosyaSecici.showSaveDialog(sahne);
        if (dosya != null) {
            try (FileWriter dosyaYazici = new FileWriter(dosya)) {
                dosyaYazici.write(metinAlani.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
