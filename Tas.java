/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package okeyText;

public class Tas {
    
    private Renk renk;
    public static enum Renk {
        Sari, Mavi, Siyah, Kirmizi
    }
    private boolean sahteOkey;
    private boolean okey;
    private int sayi;
    
    public Tas(int sayi, Renk renk) {
        this.sayi = sayi;
        this.renk = renk;
        this.okey = false;
        this.sahteOkey = false;
    }
    public Tas(boolean sahteOkey) {
        this.sahteOkey = true;
    }
    public Renk getRenk() {
        return renk;
    }
    public int getSayi (){
        return sayi;
    }
    public boolean okeyMi() {
        return this.okey;
    }
    public boolean sahteOkeyMi() {
        return this.sahteOkey;
    }
  
    public Tas SahteOkey(int sayi, Renk rek) {
       Tas tas = new Tas(sayi, renk);
       tas.sahteOkey = true;
       tas.okey = false;
       return tas;
    }    
   
    /**
     *
     * @param sayi
     * @param rek
     * @return
     */
    public Tas Okey(int sayi, Renk rek) {
       Tas tas = new Tas(sayi, renk);
       tas.sahteOkey = false;
       tas.okey = true;
       return tas;
    }
   
    public Tas OkeyTasi(Tas acikTas){
        Renk renk = acikTas.getRenk();
        int sayi = acikTas.getSayi() + 1;
        if (sayi > 13){
            sayi = 1;
        }  
        return Okey(sayi, renk);
    }
   
    public Tas SahteOkeyTasi(Tas acikTas){
        Renk renk = acikTas.getRenk();
        int sayi = acikTas.getSayi() + 1;
        if (sayi > 13){
            sayi = 1;
        }  
        return SahteOkey(sayi, renk);
    }
    
    public String tasYazdir() {
       String ek = "";
       if (this.okeyMi()) {
           ek = "(Okey)" ;
       } else if (this.sahteOkeyMi()) {
           ek = "(Sahte Okey)" ;
       }
       switch(this.renk) {
           case Sari:
               return "Sari-" + this.sayi + ek;
            case Mavi:
                return  "Mavi-" + this.sayi + ek;
            case Kirmizi:
               return "Kirmizi-" + this.sayi + ek;
            case Siyah:
               return "Siyah-" + this.sayi + ek;
            default:
                return "Böyle Bişey Yok";
       }
   }
}
