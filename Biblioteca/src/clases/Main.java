package clases;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        
        /*Datos de Prueba*/
        biblioteca.agregarLibro("El Quijote", "Miguel de Cervantes");
        biblioteca.agregarLibro("Cien años de soledad", "Gabriel García Márquez");
        biblioteca.agregarLibro("El principito", "Antoine de Saint-Exupéry");
        biblioteca.listarLibros();

        while (true) {
            System.out.println("\n--- BIBLIOTECA ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Listar libros");
            System.out.println("4. Prestar libro");
            System.out.println("5. Devolver libro");
            System.out.println("6. Mostrar historial de préstamos");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  

            switch (opcion) {
                case 1:
                    System.out.print("Título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor del libro: ");
                    String autor = scanner.nextLine();
                    biblioteca.agregarLibro(titulo, autor);
                    break;
                case 2:
                    System.out.print("Nombre del usuario: ");
                    String nombre = scanner.nextLine();
                    System.out.print("DNI: ");
                    String dni = scanner.nextLine();
                    biblioteca.registrarUsuario(nombre, dni);
                    break;
                case 3:
                    System.out.println("Listando libros...");
                    biblioteca.listarLibros();
                    break;
                case 4:
                	 System.out.println("Introduce el título del libro:");
                	    scanner.nextLine();
                	    String tituloLibro = scanner.nextLine();

                	    System.out.println("Introduce el nombre del usuario:");
                	    String nombreUsuario = scanner.nextLine();

                	    biblioteca.prestarLibro(tituloLibro, nombreUsuario);
                	    break;
                case 5:
                    System.out.print("Título del libro a devolver: ");
                    String tituloDevolucion = scanner.nextLine();
                    biblioteca.devolverLibro(tituloDevolucion);
                    break;
                case 6:
                    biblioteca.mostrarHistorial();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}