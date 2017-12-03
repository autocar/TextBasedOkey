/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package okeyText;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import okeyText.Tas.Renk;
/**
 *
 * @author Fatih Zeynel
 */
public class Masa {
    
    private final List<Tas> taslar;
    private Tas acikTas;
    
    public static Random random = new Random(System.currentTimeMillis());

    public Masa() {
        
    // Masa Nesnesi Oluşturuken 106 elemanlı bir dizi oluştur...
        taslar = new ArrayList<>(106);
        for (int i = 0; i <= 3; i++) {
            for (int j = 1; j <= 13; j++) {
                taslar.add(new Tas(j, Renk.values()[i]));
                taslar.add(new Tas(j, Renk.values()[i]));
            }
        }
        taslar.add(new Tas(true));
        taslar.add(new Tas(true));
    
    //taşları random karıştır...    
        int index1, index2;
        int size = taslar.size() - 1 ;
        Tas temp;
        
        for (int a = 0; a <= 300; a++) {
            index1 = random.nextInt(size);
            index2 = random.nextInt(size);
            temp = (Tas) taslar.get(index2);
            taslar.set(index2, taslar.get(index1));
            taslar.set(index1, temp);
        }
    }
    
    public Tas acikTasiBelirle(){
        int renk = random.nextInt(4);
        int sayi = random.nextInt(13) + 1;
        return new Tas(sayi, Renk.values()[renk]);
    }
    
    public Tas masadanCek(){
        return taslar.remove(taslar.size() - 1);
    }
    public List<Tas> getTumtaslar(){
        return taslar;
    }
}
