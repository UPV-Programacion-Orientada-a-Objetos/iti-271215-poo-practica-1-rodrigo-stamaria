package sentencias;
import sentencias.clasePadre.Sentencia;
import java.io.*;

public class Use extends Sentencia {
    File ruta;
    File rutaAbuscar = new File(consultaSeparada[1]);

    public Use(String[] consultaSeparada) { super(consultaSeparada); }

    public void comprobarSintaxis() throws FileNotFoundException {
        if (!rutaAbuscar.exists()) {
            throw new FileNotFoundException();
        }
    }

    public void accionSentencia() {
        ruta = rutaAbuscar;
        //Una vez definida la ruta, se parsean las tablas para meterlas al codigo y poder menearlas aqui dentro
    }

    public File getRuta() {
        return ruta;
    }
}
