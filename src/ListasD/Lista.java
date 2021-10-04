package ListasD;

import java.util.Scanner;

public class Lista {

    private Nodo cabeza;
    private int longitud = 0;

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public Lista() {
        cabeza = null;
    }

    Nodo insercionInicioD(informacion x) {
        Nodo aux;
        if (this.cabeza == null) {
            this.cabeza = new Nodo(x);
            this.longitud++;
        } else {
            aux = new Nodo(x);
            aux.sigte = this.cabeza;
            this.cabeza.prev = aux;
            this.cabeza = aux;
            this.longitud++;
        }
        return cabeza;
    }

    Nodo insercionFinalD(informacion x) {
        if (this.cabeza == null) {
            this.cabeza = new Nodo(x);
            this.longitud++;
        } else {
            Nodo aux;
            aux = this.cabeza;

            while (aux.sigte != null) {
                aux = aux.sigte;
            }
            aux.sigte = new Nodo(x);
            aux.sigte.prev = aux;
            this.longitud++;
        }
        return cabeza;
    }

    Nodo insercionMedia(informacion x) {
        if (this.cabeza == null) {
            this.cabeza = new Nodo(x);
            this.longitud++;
        }
        /*if (this.cabeza.sigte == this.cabeza.prev) {
            Nodo aux1;
            aux1 = this.cabeza;
        }*/ else {
            Nodo aux;
            aux = this.cabeza;

            while (aux.sigte != null) {
                aux = aux.sigte;
            }
            aux.sigte = new Nodo(x);
            aux.sigte.prev = aux;
            this.longitud++;
        }
        return cabeza;
    }

    void imprime(Nodo cabeza) {
        if (cabeza != null) {
            Nodo aux;
            Nodo aux2;
            aux = cabeza;
            aux2 = cabeza;
            while (aux != null) {
                System.out.print("|" + aux.elem.getX() + "|" + "<->");
                aux = aux.sigte;
            }
            System.out.println("//");
        } else {
            System.out.println("Lista Vacia");
        }
    }

    void elimNodoInicioD() {
        Nodo aux = this.cabeza;
        if (this.cabeza == null) {
            this.cabeza = null;
        } else if (this.cabeza.sigte == null) {
            this.cabeza.sigte = null;
        } else {
            cabeza = aux.sigte;
            aux = null;
            this.cabeza.prev = null;
        }
    }

    void borrarNodoFinalD() {
        Nodo aux = this.cabeza;
        Nodo aux2;
        if (this.cabeza == null) {
            this.cabeza = null;
        } else if (this.cabeza.sigte == null) {
            this.cabeza = null;
        } else {
            while (aux.sigte.sigte != null) {
                aux = aux.sigte;
            }
            //aux.sigte=null;
            aux2 = aux.sigte;
            aux.sigte = null;
            aux2.prev = null;
            aux2 = null;
        }
    }

    int buscaNodo(Nodo cabeza, informacion elemento) {
        int contador, posicion;
        contador = 0;
        posicion = -1;
        Nodo aux;
        aux = cabeza;
        while ((aux != null) && (aux.elem.getInformacion() != elemento.getInformacion())) {
            aux = aux.sigte;
            contador++;
        }
        if (aux != null) {
            if (aux.elem.getInformacion() == elemento.getInformacion()) {
                contador++;
                posicion = contador++;
            }
        }
        System.out.println("La posicion es: " + posicion);
        return posicion;
    }

    void elimNodoPos(informacion elem) {
        Nodo aux = cabeza, aux2;
        int posicion;
        posicion = this.buscaNodo(cabeza, elem);
        if (posicion == 1) {
            this.elimNodoInicioD();
            this.longitud--;
        } else if (posicion == this.longitud) {

            this.borrarNodoFinalD();
            this.longitud--;
        } else {
            while (aux.sigte.elem.getInformacion() != elem.getInformacion()) {

                aux = aux.sigte;
            }
            aux2 = aux.sigte;
            aux.sigte = aux2.sigte;
            aux2 = null;
            this.longitud--;
        }
    }

    void modifcaElemento(informacion elemento) {
        Scanner entrada = new Scanner(System.in);
        int posicion;
        posicion = this.buscaNodo(cabeza, elemento);
        Nodo aux = cabeza, aux2;
        if ((posicion == 1)) {
            System.out.println("Digite el nuevo elemento: ");
            informacion elem2 = new informacion(entrada.nextInt());
            elemento = elem2;
            Nodo aux3 = new Nodo(elemento);
            aux2 = aux.sigte;
            aux.elem = aux3.elem;
        } else if (posicion == this.longitud) {
            while (aux.sigte.sigte != null) {
                aux = aux.sigte;
            }
            System.out.println("Digite el nuevo elemento: ");
            informacion elem2 = new informacion(entrada.nextInt());
            elemento = elem2;
            Nodo aux3 = new Nodo(elemento);
            aux2 = aux.sigte;
            aux.sigte = aux3;
        } else {
            while (aux.sigte.elem.getInformacion() != elemento.getInformacion()) {
                aux = aux.sigte;
            }
        }
        System.out.println("Digite el nuevo elemento: ");
        informacion elem2 = new informacion(entrada.nextInt());
        elemento = elem2;
        Nodo aux3 = new Nodo(elemento);
        aux2 = aux.sigte;
        aux.sigte.elem = aux3.elem;
    }
}
