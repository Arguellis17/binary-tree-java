package binario;

public class ClienteTree {

    public static void main2(String[] args) {

        // Creacion del arbol
        Tree ab = new Tree();

        // Conectando al arbol
        Node n1 = ab.crearArbol(3, null, null);
        Node n4 = ab.crearArbol(7, null, null);

        Node n2 = ab.crearArbol(5, n4, null);
        Node n3 = ab.crearArbol(1, n2, n1); // Raiz

        //ab.imprimir(n3);
        ab.imprimir(n3);
    }

    public static void main(String[] args) {

        Tree ab = new Tree();

        System.out.println("Arbol");
        ab.add(8);
        ab.add(3);
        ab.add(10);
        ab.add(1);
        ab.add(6);
        ab.add(14);
        ab.add(4);
        ab.add(7);
        ab.add(13);

        ab.imprimir(ab.Tree());
        
        // Tipos de impresiones
        //ab.preorden(ab.Tree());
        //ab.inorden(ab.Tree());
        //ab.postorden(ab.Tree());
        
        System.out.println("\n\nAltura del arbol " + ab.alturaArbol(ab.Tree()));
        System.out.println("Numero de nodos " + ab.contarNodos(ab.Tree()));
        System.out.println("Hijos " + ab.contarHojas(ab.Tree()));
        System.out.println("Suma valores " + ab.sumaValores(ab.Tree()));
        System.out.println(ab.caminoMasLargo(ab.Tree()));
        System.out.println("Profundidad del nodo " + ab.profundidadNodo(ab.Tree(), 4, 1));
        
        //ab.crearEspejo(ab.Tree());
        //ab.invertirArbol(ab.Tree());
        System.out.println("");
        ab.imprimir(ab.Tree());
        System.out.println("");
        ab.imprimirEnReverso(ab.Tree());
        System.out.println("");
        //System.out.println(ab.buscarNodo(ab.Tree(), 1));
        //ab.removeRecursive(ab.Tree(), 10);
        //ab.buscarNodo(4);
        
        //System.out.println("Maximo " + ab.verMaximo(ab.Tree()));
        Tree ab2 = new Tree();

        ab2.add(6);
        ab2.add(5);
        ab2.add(8);
        ab2.add(4);
        ab2.add(7);

        //ab2.imprimir(ab2.Tree());

        //System.out.println("");
        //System.out.println("Hijos " + ab2.contarHojas(ab2.Tree()));
    }
}
