package clases;

public class Usuario {
    private String nombre;
    private String dni;

    public Usuario(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "Usuario: " + nombre + " (DNI: " + dni + ")";
    }
}
