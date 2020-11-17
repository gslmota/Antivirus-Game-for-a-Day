package game;
public class Setor {
    String parede = "|";
    //String [] vetorSetor = {"|", " ", parede, " ", parede, " ", parede, " ", parede, " ", "|"};
    String [] vetorSetor = {"|", " ", " ", " ",parede, " ", " ", " ",parede, " ", " ", " ",parede, " ", " ", " ",parede, " ", " ", " ","|"};
    int posSetor1[] = new int[2];
    int posSetor2[] = new int[2];

    public Setor() {
        this.posSetor1[0] = 3;
        this.posSetor1[1] = 3;
        this.posSetor2[0] = 3;
        this.posSetor2[1] = 3;
    }

    
}
