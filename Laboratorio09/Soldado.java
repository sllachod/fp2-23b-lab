public class Soldado {
    private String nombre;
    private int nivelAtaque;
    private int nivelDefensa;
    private int nivelVida;
    private int vidaActual;
    private int velocidad;
    private int fila;
    private int columna;
    private String actitud;
    private boolean vive;

    public Soldado(String nombre, int nivelAtaque, int nivelDefensa, int nivelVida, int velocidad,int columna, int fila, String actitud) {
        this.nombre = nombre;
        this.nivelAtaque = nivelAtaque;
        this.nivelDefensa = nivelDefensa;
        this.nivelVida = nivelVida;
        this.vidaActual = nivelVida;
        this.velocidad = velocidad;
        this.actitud = actitud;
        this.columna = columna;
        this.vive = true;
    }
    public Soldado(String nombre, int nivelAtaque, int nivelDefensa, int nivelVida, int velocidad, String actitud, boolean vive) {
        this(nombre, nivelAtaque, nivelDefensa, nivelVida, velocidad, velocidad, actitud, vive);
        this.vive = vive;
    }
    public Soldado(String nombre2, int nivelAtaque2, int nivelDefensa2, int nivelVida2, int vidaActual2, int velocidad2,String actitud2, boolean vive2) {

    }

    public String getNombre() {
		return nombre;
	}
    
    public String getActitud() {
        return actitud;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getNivelAtaque() {
        return nivelAtaque;
    }

    public void setNivelAtaque(int nivelAtaque) {
        this.nivelAtaque = nivelAtaque;
    }

    public int getNivelDefensa() {
        return nivelDefensa;
    }

    public void setNivelDefensa(int nivelDefensa) {
        this.nivelDefensa = nivelDefensa;
    }

    public int getNivelVida() {
        return nivelVida;
    }

    public void setNivelVida(int random) {
        this.nivelVida = random;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setActitud(String actitud) {
        this.actitud = actitud;
    }

    public boolean isVive() {
        return vive;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }
    @Override
    public String toString() {
        return "Soldado [nombre=" + nombre + ", nivelAtaque=" + nivelAtaque + ", nivelDefensa=" + nivelDefensa
                + ", nivelVida=" + nivelVida + ", vidaActual=" + vidaActual + ", velocidad=" + velocidad + ", fila="
                + fila + ", columna=" + columna + ", actitud=" + actitud + ", vive=" + vive + "]";
    }
}