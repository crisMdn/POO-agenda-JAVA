import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        int opcion;
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Verificar si un contacto existe");
            System.out.println("3. Listar todos los contactos");
            System.out.println("4. Buscar contacto por nombre");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Verificar si la agenda está llena");
            System.out.println("7. Ver espacio disponible en la agenda");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del contacto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el teléfono del contacto: ");
                    String telefono = scanner.nextLine();
                    Contacto nuevoContacto = new Contacto(nombre, telefono);
                    agenda.addContacto(nuevoContacto);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del contacto a verificar: ");
                    nombre = scanner.nextLine();
                    Contacto contactoExistente = new Contacto(nombre, "");
                    if (agenda.existeContacto(contactoExistente)) {
                        System.out.println("El contacto existe en la agenda.");
                    } else {
                        System.out.println("El contacto no existe en la agenda.");
                    }
                    break;
                case 3:
                    agenda.listarContactos();
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del contacto a buscar: ");
                    nombre = scanner.nextLine();
                    String resultado = agenda.buscarContacto(nombre);
                    System.out.println("Resultado: " + resultado);
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del contacto a eliminar: ");
                    nombre = scanner.nextLine();
                    Contacto contactoAEliminar = new Contacto(nombre, "");
                    agenda.eliminarContacto(contactoAEliminar);
                    break;
                case 6:
                    if (agenda.estaLlena()) {
                        System.out.println("La agenda está llena.");
                    } else {
                        System.out.println("La agenda no está llena.");
                    }
                    break;
                case 7:
                    int espacio = agenda.espacioDisponible();
                    System.out.println("Espacio disponible en la agenda: " + espacio);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
