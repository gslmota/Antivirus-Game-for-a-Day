package semana12;

public class Monitor {
    private String nome;
    private String matricula;
    private int codDisciplina;

    public Monitor(String nome, String matricula, int codDisciplina) {
        this.nome = nome;
        this.matricula = matricula;
        this.codDisciplina = codDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(int codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    
}
