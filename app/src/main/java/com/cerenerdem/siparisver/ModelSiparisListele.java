package com.cerenerdem.siparisver;

public class ModelSiparisListele {

    private String kullaniciemail;
    private String secilenurun;

    public ModelSiparisListele(){}
    public ModelSiparisListele(String kullaniciemail, String secilenurun){

        this.kullaniciemail = kullaniciemail;
        this.secilenurun = secilenurun;

    }

    public String getKullaniciemail() {
        return kullaniciemail;
    }

    public void setKullaniciemail(String kullaniciemail){

        this.kullaniciemail = kullaniciemail;

    }

    public String getSecilenurun() {
        return secilenurun;
    }

    public void setSecilenurun(String secilenurun) {
        this.secilenurun = secilenurun;
    }
}

