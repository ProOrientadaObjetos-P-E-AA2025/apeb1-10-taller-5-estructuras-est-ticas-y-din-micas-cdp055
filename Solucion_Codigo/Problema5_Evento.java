import java.time.LocalDate;

public class Problema5_Evento {
    private String nombre;
    private LocalDate fecha;
    private String ubicacion;
    private String descripcion;
    private String tipo;
    private String paisInvolucrado;
    private double porcentajeBajas;
    private boolean usoNuclear;

    public Problema5_Evento(String nombre, LocalDate fecha, String ubicacion, String tipo,
                            String descripcion, String paisInvolucrado, double porcentajeBajas, boolean usoNuclear) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.paisInvolucrado = paisInvolucrado;
        this.porcentajeBajas = porcentajeBajas;
        this.usoNuclear = usoNuclear;
    }

    // Getters
    public String getNombre() { return nombre; }
    public LocalDate getFecha() { return fecha; }
    public String getUbicacion() { return ubicacion; }
    public String getTipo() { return tipo; }
    public String getDescripcion() { return descripcion; }
    public String getPaisInvolucrado() { return paisInvolucrado; }
    public double getPorcentajeBajas() { return porcentajeBajas; }
    public boolean isUsoNuclear() { return usoNuclear; }

    // Setters (para permitir actualización de datos)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPaisInvolucrado(String paisInvolucrado) {
        this.paisInvolucrado = paisInvolucrado;
    }

    public void setPorcentajeBajas(double porcentajeBajas) {
        this.porcentajeBajas = porcentajeBajas;
    }

    public void setUsoNuclear(boolean usoNuclear) {
        this.usoNuclear = usoNuclear;
    }

    @Override
    public String toString() {
        return "Evento: " + nombre + ", Tipo: " + tipo + ", País: " + paisInvolucrado +
                ", Fecha: " + fecha + ", Ubicación: " + ubicacion + ", Bajas: " + porcentajeBajas +
                "%, Nuclear: " + usoNuclear + "\nDescripción: " + descripcion;
    }
}

