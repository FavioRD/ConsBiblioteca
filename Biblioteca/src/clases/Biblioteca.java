package clases;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Prestamo> prestamos;

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public void agregarLibro(String titulo, String autor) {
        libros.add(new Libro(titulo, autor));
        System.out.println("Libro agregado: " + titulo);
    }

    public void registrarUsuario(String nombre, String dni) {
        usuarios.add(new Usuario(nombre, dni));
        System.out.println("Usuario registrado: " + nombre);
    }

    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            System.out.println("Libros disponibles:");
            for (Libro libro : libros) {
                System.out.println(libro); 
            }
        }
    }

    public void prestarLibro(String tituloLibro, String nombreUsuario) {
        // Buscar si el libro existe
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(tituloLibro)) {
                // Verificar si el libro ya está prestado
                if (libro.isPrestado()) {
                    System.out.println("El libro ya está prestado.");
                    return;
                }
                for (Usuario usuario : usuarios) {
                    if (usuario.getNombre().equalsIgnoreCase(nombreUsuario)) {
                        Prestamo prestamo = new Prestamo(usuario, libro);
                        prestamos.add(prestamo);

                        libro.setPrestado(true);
                        
                        System.out.println("Préstamo realizado con éxito.");
                        return;
                    }
                }
                System.out.println("Usuario no encontrado.");
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }

    public void devolverLibro(String titulo) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getLibro().getTitulo().equalsIgnoreCase(titulo) && prestamo.getLibro().isPrestado()) {
                prestamo.getLibro().devolver();
                System.out.println("Libro devuelto: " + titulo);
                prestamos.remove(prestamo);
                return;
            }
        }
        System.out.println("No se encontró el préstamo.");
    }

    public void mostrarHistorial() {
        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
        } else {
            System.out.println("Historial de préstamos:");
            for (Prestamo prestamo : prestamos) {
                System.out.println(prestamo);
            }
        }
    }

    private Usuario buscarUsuario(String dni) {
        for (Usuario usuario : usuarios) {
            if (usuario.getDni().equals(dni)) {
                return usuario;
            }
        }
        return null;
    }

    private Libro buscarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }
}