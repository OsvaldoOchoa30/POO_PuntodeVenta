import java.util.Scanner; //Importar Scanner.

import models.Caja;
import models.Producto;
import models.Inventario;

public class Main { //Nombre de la Clase.
    public static void main(String[] args) { //Linea de codigo que le da "Vida" al programa.
        Scanner scanner = new Scanner(System.in); //Creacion de Scanner, en este caso le colocamos scanner
        Caja caja = new Caja(0);
        Inventario inventario = new Inventario();

        boolean programaActivo = true; //creacion de boolean.
        while (programaActivo) { //Con el boolean anterior entramos a un ciclo, mientras este sea true se repetira.

            System.out.println(" ");
            System.out.println("MENU");
            System.out.println(" ");
            System.out.println("Opciones para Administrador: ");
            System.out.println("1) Apertura de Caja.");
            System.out.println("2) Arqueo de Caja.");
            System.out.println(" ");
            System.out.println("Opciones para Empleado: ");
            System.out.println("3) Registrar Venta.");
            System.out.println("4) Alta de Producto.");
            System.out.println("5) Ver Inventario.");
            System.out.println(" ");
            System.out.println("Concluir Programa.");
            System.out.println("6) Cerrar Programa.");
            System.out.print("Elige la Opción que Deseas Realizar: "); // de las lineas 16 - 29 solo creamos un menu con ayuda de sout.

            String opcion = scanner.next(); //creacion de una variable.
            switch (opcion) {// con la variable anterior elegimos que opcion realizaremos en el Swithc.
                case "1"://Los cases son las opciones que podemos elegir por medio del teclado, en este programa solo esta permitido del 1 - 6, dependiendo que opcion desees elegir.
                    System.out.println("Esta area es exclusivamente para del Administrador.");
                    System.out.println("Eres el Administrador? ");
                    System.out.println("1) Si / 2) No");
                    System.out.print("Elige una opcion: ");// De las lineas 34 - 37 se establecen unos texto para una verificacion de rol.
                    int d1 = scanner.nextInt();// creamos una variable.
                    if (d1 == 1){//con la variable anterior podremos entrar a un if, solo si tecleamos el numero 1 permitira realizar la accion deseada.
                        System.out.print("Ingrese el monto inicial de la caja: $");
                        double montoInicial = scanner.nextDouble();
                        caja.abrir(montoInicial);
                        System.out.println("Caja abierta con un saldo de: $" + caja.getSaldo());
                    }else {
                        System.out.println("Regresando al Menu...");
                    }
                    break; //los break se usan para romper y pausar.
                case "2":
                    System.out.println("Esta area es exclusivamente para del Administrador.");
                    System.out.println("Eres el Administrador? ");
                    System.out.println("1) Si / 2) No");
                    System.out.print("Elige una opcion: ");
                    int d2 = scanner.nextInt();
                    if (d2 == 1) {
                        System.out.println("Arqueo de Caja");
                        System.out.println("Saldo actual en caja: $" + caja.getSaldo());
                        caja.cerrar();
                        System.out.println("Caja cerrada. Saldo reiniciado a $0.");
                    } else {
                        System.out.println("Regresando al Menu...");
                    }
                    break;
                case "3":
                    System.out.println("Esta area es exclusivamente para el Empleado.");
                    System.out.println("Eres Empleado? ");
                    System.out.println("1) Si / 2) No");
                    System.out.print("Elige una opcion: ");
                    int d3 = scanner.nextInt();
                    if (d3 == 1) {
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombreProducto = scanner.next();
                        Producto productoVendido = inventario.buscarProducto(nombreProducto);
                        if (productoVendido != null) {
                            System.out.print("Ingrese la cantidad vendida: ");
                            int cantidadVendida = scanner.nextInt();
                            caja.registrarVenta(productoVendido, cantidadVendida);
                        } else {
                            System.out.println("Producto no encontrado en el inventario.");
                            break;
                        }
                    } else
                        System.out.println("Regresando al menu...");{
                    break;
                    }

                case "4":
                    System.out.println("Esta area es exclusivamente para el Empleado.");
                    System.out.println("Eres Empleado? ");
                    System.out.println("1) Si / 2) No");
                    System.out.print("Elige una opcion: ");
                    int d4 = scanner.nextInt();
                    if (d4 == 1) {
                        System.out.print("Ingrese el nombre del nuevo producto: ");
                        String nuevoNombre = scanner.next();
                        System.out.print("Ingrese el precio del nuevo producto: $");
                        double nuevoPrecio = scanner.nextDouble();
                        System.out.print("Ingrese la cantidad inicial disponible: ");
                        int nuevaCantidad = scanner.nextInt();

                        Producto nuevoProducto = new Producto(nuevoNombre, nuevoPrecio, nuevaCantidad);
                        inventario.agregarProducto(nuevoProducto);

                        System.out.println("Producto agregado al inventario.");
                    } else {
                        System.out.println("Regresando al Menu...");
                    }
                    break;
                case "5":  System.out.println("Esta area es exclusivamente para el Empleado.");
                    System.out.println("Eres Empleado? ");
                    System.out.println("1) Si / 2) No");
                    System.out.print("Elige una opcion: ");
                    int d5 = scanner.nextInt();
                    if (d5 == 1) {
                        inventario.mostrarInventario();
                    }else {
                        System.out.println("Regresando al Menu...");
                    }
                    break;
                case "6": //Al elegir este caso se concluye el programa.
                    System.out.println("Cerrando Programa...");
                    programaActivo = false; //Aqui nuesra variable se convierte en falsa, como el ciclo esta esperando que sea verdadadera y regresa de manera falsa, concluira el programa.
                    break;
                default: //Al ingresar datos que no estan establecidos, regresara y pedira nuevamente que elijas una opcion.
                    System.out.println("Opción inválida. Por favor, elige una opción válida.");
                    break;
            }
        }
    }
}