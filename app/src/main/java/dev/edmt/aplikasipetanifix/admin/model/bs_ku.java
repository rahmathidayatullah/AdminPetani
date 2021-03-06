package dev.edmt.aplikasipetanifix.admin.model;

import android.widget.EditText;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

/**
 * Created by Herdi_WORK on 18.06.17.
 */

@IgnoreExtraProperties
public class bs_ku implements Serializable {


    private String key,alamat,email,jenisbang,name,nik,nohp,norek,saldo,slotdibeli,totalbayar,totaltarik;

    public bs_ku(){

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String gettotaltarik() {
        return totaltarik;
    }

    public void settotaltarik(String totaltarik) {
        this.totaltarik = totaltarik;
    }

    public String getalamat() {
        return alamat;
    }

    public void setalamat(String alamat) {
        this.alamat = alamat;
    }

    public String getjenisbang() {
        return jenisbang;
    }

    public void setjenisbang(String jenisbang) {
        this.jenisbang = jenisbang;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getnik() {
        return nik;
    }

    public void setnik(String nik) {
        this.nik = nik;
    }

    public String getnohp() {
        return nohp;
    }

    public void setnohp(String nohp) {
        this.nohp = nohp;
    }

    public String getnorek() {
        return norek;
    }

    public void setnorek(String norek) {
        this.norek = norek;
    }

    public String getsaldo() {
        return saldo;
    }

    public void setsaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getslotdibeli() {
        return slotdibeli;
    }

    public void setslotdibeli(String slotdibeli) {
        this.slotdibeli = slotdibeli;
    }

    public String gettotalbayar() {
        return totalbayar;
    }

    public void settotalbayar(String totalbayar) {
        this.totalbayar = totalbayar;
    }



    @Override
    public String toString() {
        return " "+email+"\n" +
                " "+alamat+"\n" +
                " "+jenisbang+"\n" +
                " "+name+"\n" +
                " "+nik+"\n" +
                " "+nohp+"\n" +
                " "+norek+"\n" +
                " "+saldo+"\n" +
                " "+totaltarik+"\n" +
                " "+slotdibeli+"\n" +
                " "+totalbayar;

    }
    public bs_ku(String a, String b, String c, String e, String f, String g, String h, String i, String j, String k, String l){
            email=a;
            totaltarik = b;
            alamat= c;
            slotdibeli=e;
            jenisbang= f;
            name= g;
            nik= h;
            nohp= i;
            norek= j;
            saldo= k;
            totalbayar= l;
    }
}
