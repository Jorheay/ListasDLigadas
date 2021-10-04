package ListasD;


public class Nodo {

    informacion elem;
    Nodo sigte;
    Nodo prev;

    public Nodo(informacion elem) {
        this.elem = elem;
        this.sigte = null;
        this.prev = null;
    }
}
