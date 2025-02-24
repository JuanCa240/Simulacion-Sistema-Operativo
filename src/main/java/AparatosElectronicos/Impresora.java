package AparatosElectronicos;

import SO.Proceso;

public class Impresora extends Dispositivo {
    public Impresora() {
        super("Impresora");
    }

    public void imprimirTexto(String texto, Proceso proceso) {
        procesarTexto(texto, proceso);
        System.out.println("Imprimiendo... " + texto);
    }
}