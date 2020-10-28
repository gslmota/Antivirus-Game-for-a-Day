package game;

import java.util.Arrays;

public class placadecarro {
    private String nomepa;
    private String[] letras = new String[5];

    public String getNomepa() {
        return nomepa;
    }

    public void setNomepa(String nomepa) {
        this.nomepa = nomepa;
    }

    public String[] getLetras() {
        return letras;
    }

    public void setLetras(String[] letras) {
        this.letras = letras;
    }

    public placadecarro(String nomepa, String[] letras) {
        this.nomepa = nomepa;
        this.letras = letras;
    }

    public placadecarro(placadecarro placa) {
        this.(placa.nomepa, placa[].letras);
    }

    public placadecarro() {

    }

    

}
