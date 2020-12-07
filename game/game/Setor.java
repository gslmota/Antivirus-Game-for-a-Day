package game;
public class Setor {
    public String parede = "|";
    //String [] vetorSetor = {"|", " ", parede, " ", parede, " ", parede, " ", parede, " ", "|"};
    public String [] vetorSetor = {"|", " ", " ", " ",parede, " ", " ", " ",parede, " ", " ", " ",parede, " ", " ", " ",parede, " ", " ", " ","|"};
    public int posSetor1[] = new int[2];
    public int posSetor2[] = new int[2];
    
    public Setor() {
        this.posSetor1[0] = 3;
        this.posSetor1[1] = 3;
        this.posSetor2[0] = 3;
        this.posSetor2[1] = 3;
    }

    public String getParede() {
        return parede;
    }

    public void setParede(String parede) {
        this.parede = parede;
    }

    public String[] getVetorSetor() {
        return vetorSetor;
    }

    public void setVetorSetor(String[] vetorSetor) {
        this.vetorSetor = vetorSetor;
    }

    public int[] getPosSetor1() {
        return posSetor1;
    }

    public void setPosSetor1(int[] posSetor1) {
        this.posSetor1 = posSetor1;
    }

    public int[] getPosSetor2() {
        return posSetor2;
    }

    public void setPosSetor2(int[] posSetor2) {
        this.posSetor2 = posSetor2;
    }

    
}
