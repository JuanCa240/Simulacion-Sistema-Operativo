package AparatosElectronicos;


public class Dispositivo {
    protected String tipoDispositivo;
    protected String mensaje;

    public Dispositivo(String tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }

    public String getTipoDispositivo() {
        return tipoDispositivo;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    
    
}
