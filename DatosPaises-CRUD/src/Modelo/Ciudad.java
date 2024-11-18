package Modelo;

public class Ciudad {
    private String codigoC;
    private String nombreC;
    private int poblacionC;
    private int IDC;

    public Ciudad() {
    }

    public Ciudad(int idc,String nombrec, int poblacionc, String codigoc) {
        this.nombreC = nombrec;
        this.poblacionC = poblacionc;
        this.codigoC = codigoc;
        this.IDC = idc; 
        
    }

    public String getCodigoC() {
        return codigoC;
    }

    public void setCodigoC(String codigoC) {
        this.codigoC = codigoC;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public int getPoblacionC() {
        return poblacionC;
    }

    public void setPoblacionC(int poblacionC) {
        this.poblacionC = poblacionC;
    }

    public int getIDC() {
        return IDC;
    }

    public void setIDC(int IDC) {
        this.IDC = IDC;
    }

    
}

