package ListasD;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Lista L;
        L = new Lista();
        informacion elem;
        int opc, posicion;
        do {
            System.out.println("---------------------------------");
            System.out.println("Ingresa la opcion");
            System.out.println("1.- Inserta nodo");
            System.out.println("2.- Imprimir");
            System.out.println("3.- Modifica elemento nodo");
            System.out.println("4.- Longitud");
            System.out.println("5.- Busqueda Nodo");
            System.out.println("6.- Elimina elemento del nodo");
            System.out.println("7.- Salir");
            opc = entrada.nextInt();
            switch (opc) {
                case 1:
                    elem = new informacion((int) (Math.random() * 100 + 1));
                    L.insercionMedia(elem);
                    break;
                case 2:
                    L.imprime(L.getCabeza());
                    break;
                case 3:
                    System.out.println("Elija el elemento a modificar");
                    informacion elem3 = new informacion(entrada.nextInt());
                    L.modifcaElemento(elem3);
                    break;
                case 4:
                    System.out.println("La longitud es: "+L.getLongitud());
                    break;      
                case 5:
                    System.out.println("Inserte la posicion a buscar: ");
                    elem = new informacion(entrada.nextInt());
                    L.buscaNodo(L.getCabeza(), elem);
                    break;
                case 6:
                    /*System.out.println("Ingrese la posicion a eliminar");
                    informacion elem1 = new informacion(entrada.nextInt());*/
                    L.borrarNodoFinalD();
                    break;
            }
        } while (opc != 7);
    }
}
