package Modelo;

public class Idioma {
    private int IdIdio;
    private String nombre;
    private String CodigoP;
    private int oficial;

    public Idioma() {
    }

    public Idioma(int id, String nombre, int oficial , String codigoP ) {
        this.IdIdio = id;
        this.nombre = nombre;
        this.CodigoP = codigoP;
        this.oficial = oficial;
    }

    public int getIdIdio() {
        return IdIdio;
    }

    public void setIdIdio(int IdIdio) {
        this.IdIdio = IdIdio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoP() {
        return CodigoP;
    }

    public void setCodigoP(String CodigoP) {
        this.CodigoP = CodigoP;
    }

    public int getOficial() {
        return oficial;
    }

    public void setOficial(int oficial) {
        this.oficial = oficial;
    }
}
