package sentencias;

import sentencias.clasePadre.Sentencia;

public class Use extends Sentencia {
    String consulta;
    String[] consultaSeparada;

    public Use(String consulta, String[] consultaSeparada) {
        this.consulta = consulta;
        this.consultaSeparada = consultaSeparada;
    }

    public void comprobarSintaxis() {
        System.out.println("POR FAVOR FUNCIONA");
        System.out.println(consulta);
    }
}
