/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package okeyText;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import okeyText.Tas;

/**
 *
 * @author Fatih Zeynel
 */
public class El {

    private final List<Tas> tumtaslar;
    private final List<List<Tas>> oyuncuTaslari;
    private final Tas acikTas;

    public El(Masa masa) {

        this.acikTas = masa.acikTasiBelirle();

        oyuncuTaslari = new ArrayList<>(4);

        for (int oyuncu = 0; oyuncu < 4; oyuncu++) {
            oyuncuTaslari.add(new LinkedList<>());
        }
        for (int i = 0; i < 14; i++) {
            for (int oyuncu = 0; oyuncu < 4; oyuncu++) {
                oyuncuTaslari.get(oyuncu).add(masa.masadanCek());
            }
        }
        this.tumtaslar = masa.getTumtaslar();
    }

    void goster() {
        
        for (int i = 0; i < 4; i++) {
            System.out.println("Oyuncu:" + i + oyuncuTaslari.get(i));
        }
    }

    void gosterHepsi() {

        System.out.println("Tüm Taşlar : [" );
        tumtaslar.forEach((tas) -> {
            System.out.print(tas.tasYazdir() + ",");
        });
        System.out.println("]");
    }

}
