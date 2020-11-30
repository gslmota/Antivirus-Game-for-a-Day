package semana12;

import java.util.Iterator;
import java.util.TreeSet;

public class PrincipalMonitor {
    public static void main(String[] args) {
        
        Monitor monitor1 = new Monitor("Joao", "4444", 141);
        Monitor monitor2 = new Monitor("Pedro", "3224", 110);
        Monitor monitor3 = new Monitor("Augusto", "4324", 141);
        TreeSet <Monitor> listaMonitores = new TreeSet <Monitor>();
        listaMonitores.add(monitor1);
        listaMonitores.add(monitor2);
        listaMonitores.add(monitor3);
        Iterator monitor = listaMonitores.iterator();
        while (monitor.hasNext()) {
            Monitor m = (Monitor) monitor.next();
            System.out.println("Nome : " + m.getNome() + "Matricula : " + m.getMatricula() + "Codigo da Disciplina : " + m.getCodDisciplina());
        }

    }
}
