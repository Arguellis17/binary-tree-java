package binario;

public class Tree<E> {

    // Raiz del arbol
    private Node raiz;
    private boolean flag = false;
    private int count = 0;
    private int min = 0;
    private int max = 0;

    // Creacion de la raiz (Se puede obtener) | Constructor
    public Node Tree() {

        return raiz;
    }

    /**
     * Agrega un nodo al arbol
     *
     * @param valor: Data del nodo
     */
    public void add(int valor) {

        // Si la raiz es nula, significa que no se ha creado el arbol
        if (raiz == null) {
            // Se crea el nuevo nodo
            Node nuevo = new Node(valor);
            // La raiz sera el nuevo nodo
            raiz = nuevo;
        } else {
            // Se hace llamado al metodo recursivo
            addRecursive(raiz, valor);
        }

    }

    // Complemento de agregar nodo
    private void addRecursive(Node nodoActual, int valor) {

        // Se comparan los datos, si el nodo a agregar es menor
        if (valor < nodoActual.getData()) {
            if (nodoActual.getLeft() == null) {

                Node nuevo = new Node(valor); // Crea el nodo
                nodoActual.setLeft(nuevo); // Asigna el nodo
            } else {
                // Se mueve el puntero en la izquierda hasta encontrar un null
                addRecursive(nodoActual.getLeft(), valor);
            }

        } // Insertar del lado derecho
        else if (valor > nodoActual.getData()) {
            if (nodoActual.getRight() == null) {

                Node nuevo = new Node(valor);
                nodoActual.setRight(nuevo);
            } else {
                addRecursive(nodoActual.getRight(), valor);
            }

        }
    }

    /**
     * Remueve el nodo de un arbol de
     *
     * @param nodoActual: Puntero
     * @param valor: Valor a eliminar
     *
     * @return devuelve el nodo eliminado
     */
    public Node removeRecursive(Node nodoActual, int valor) {
        if (nodoActual == null) {
            // El nodo no existe en el árbol
            return null;
        }
        // Identificar el movimiento de nuestras ramas

        // Si el valor a eliminar es menor al nodo actual (Rama izquierda)
        if (valor < nodoActual.getData()) {
            // Usando el set y la llamada recursiva con el get de acuerdo a la posicion de la rama
            // garantizamos que se este moviendo correctamente
            nodoActual.setLeft(removeRecursive(nodoActual.getLeft(), valor));
        } // Si el valor a eliminar es mayor al nodo (Rama derecha)
        else if (valor > nodoActual.getData()) {
            nodoActual.setRight(removeRecursive(nodoActual.getRight(), valor));
        } // Una vez que se ha encontrado el nodo, comienza la evaluación de los casos
        else {

            // Caso 1: Sin hijo izquierdo o sin hijos
            if (nodoActual.getLeft() == null) {

                return nodoActual.getRight();

            } // Caso 2: Sin hijo derecho
            else if (nodoActual.getRight() == null) {

                return nodoActual.getLeft();

            } // Caso 3: Dos hijos, encontrar sucesor inmediato
            else {

                nodoActual.setData(findMinValue(nodoActual.getRight()));
                // Eliminar el sucesor inmediato en el subárbol derecho
                nodoActual.setRight(removeRecursive(nodoActual.getRight(), nodoActual.getData()));
            }
        }

        return nodoActual;
    }

    // Encontrar el valor más pequeño en el subárbol
    private int findMinValue(Node nodo) {

        while (nodo.getLeft() != null) {
            nodo = nodo.getLeft();
        }
        return nodo.getData();
    }

    /**
     * Crea un arbol paso a paso
     *
     * @param data: Dato del nodo
     * @param left: Puntero izquierdo
     * @param right: Puntero derecho
     *
     * @return devuelve el nodo creado
     */
    public Node crearArbol(int data, Node left, Node right) {

        Node nuevo = new Node(data);

        nuevo.setLeft(left);
        nuevo.setRight(right);

        return nuevo;
    }

    /**
     * Imprime el arbol junto a su rama izquierda y derecha
     *
     * @param raiz: Raiz del arbol a imprimir
     */
    public void imprimir(Node raiz) {

        if (raiz != null) {
            System.out.print(raiz.getData() + ",");
            imprimir(raiz.getLeft());
            imprimir(raiz.getRight());
        }

    }

    /**
     * Imprime la rama izquierda de un arbol
     *
     * @param nodoActual : Puntero
     */
    public void imprimirRamaIzquierda(Node nodoActual) {
        if (nodoActual != null) {
            System.out.println(nodoActual.getData());
            imprimirRamaIzquierda(nodoActual.getLeft());
        }
    }

    /**
     * Imprime la rama derecha de un arbol
     *
     * @param nodoActual: Puntero
     */
    public void imprimirRamaDerecha(Node nodoActual) {

        if (raiz.getRight() != null) {
            System.out.println(raiz.getData());
            imprimirRamaDerecha(raiz.getRight());
        }

    }

    /**
     * Indica si el arbol tiene nodos
     *
     * @return
     */
    public boolean isEmpty() {

        return raiz == null;
    }

    /**
     * Indica si un nodo pertenece a un arbol
     *
     * @param nodoActual: Puntero
     * @param valor: Valor a buscar
     *
     * @return valor booleano
     */
    public boolean pertenece(Node nodoActual, int valor) {

        // Si el nodo a buscar no existe en el arbol
        if (nodoActual == null) {
            return flag;
        }
        if (valor < nodoActual.getData()) {

            pertenece(nodoActual.getLeft(), valor);
        } else if (valor > nodoActual.getData()) {

            pertenece(nodoActual.getRight(), valor);

        } else {

            flag = true;
            return flag;

        }
        return flag;
    }

    /**
     * Determina la altura del arbol
     *
     * @param nodoActual
     *
     * @return regresa la altura del arbol
     */
    public int alturaArbol(Node nodoActual) {

        if (nodoActual == null) {
            return 0;
        } else {
            int alturaIzquierda = alturaArbol(nodoActual.getLeft());
            int alturaDerecha = alturaArbol(nodoActual.getRight());

            // La altura del árbol es 1 más el máximo de las alturas izquierda y derecha
            return 1 + Math.max(alturaIzquierda, alturaDerecha);

        }
    }

    /**
     * Determina el numero de nodos de un arbol
     *
     * @param nodoActual
     *
     * @return
     */
    public int numeroElementos(Node nodoActual) {

        if (nodoActual == null) {

            return 0;
        } else {

            int elementoIzquierdo = numeroElementos(nodoActual.getLeft());
            int elementoDerecho = numeroElementos(nodoActual.getRight());

            // Se incluye el +1 para contar tambien al nodo actual en la llamada recursiva
            return elementoDerecho + elementoIzquierdo + 1;
        }

    }

    public int contarHojas(Node nodoActual) {

        // Recorre los izquierdos
        if (nodoActual.getLeft() != null) {

            contarHojas(nodoActual.getLeft());

            // Si llego a un punto, en que los izquierdos es vacio comience con los derechos
            if (nodoActual.getRight() != null) {

                contarHojas(nodoActual.getRight());
            }

        } // Cuando ambos son nulos, se encuentra una hoja, asi que se lleva el conteo
        else {

            count++;
        }

        return count;
    }

    private Node encontrarMaximo(Node nodoActual) {
        if (nodoActual == null) {
            return null;  // Si el nodo es nulo, no hay máximo
        }

        Node maximo = nodoActual;  // Inicializar el máximo con el nodo actual

        if (nodoActual.getLeft() != null) {
            Node maxIzquierdo = encontrarMaximo(nodoActual.getLeft());
            if (maxIzquierdo.getData() > maximo.getData()) {
                maximo = maxIzquierdo;
            }
        }

        if (nodoActual.getRight() != null) {
            Node maxDerecho = encontrarMaximo(nodoActual.getRight());
            if (maxDerecho.getData() > maximo.getData()) {
                maximo = maxDerecho;
            }
        }

        return maximo;

    }

    public int verMaximo(Node nodoActual) {

        Node maximo = encontrarMaximo(nodoActual);

        return maximo.getData();

    }

    public void buscarNodo(int valor) {

        try {
            Node encontrado = buscarNodo(raiz, valor);
            System.out.println("Buscaste al nodo " + encontrado.getData());
        } catch (Exception e) {

        }

    }

    private Node buscarNodo(Node nodoActual, int valor) {
        // Si el nodo a buscar no existe en el árbol
        if (nodoActual == null) {

            return null;
        }
        // Si el valor es menor al valor del nodo actual, irse a la rama izquierda
        if (valor < nodoActual.getData()) {
            // Desplazarse en rama izquierda
            return buscarNodo(nodoActual.getLeft(), valor);
            //Si el valor es mayor al nodo actual, irse a la rama derecha
        } else if (valor > nodoActual.getData()) {
            // Desplazarse en rama derecha
            return buscarNodo(nodoActual.getRight(), valor);
            // Entra a este else cuando el valor coincide, lo que significa que se encontro el nodo
        } else {
            // Nodo encontrado
            return nodoActual;
        }
    }

    /**
     * Devuelve la raiz de un arbol
     *
     * @return
     */
    public Node getRaiz() {

        return raiz;
    }

    // Preguntar de que manera se puede hacer recursivo 
    public void compararArboles(Tree arbolOne, Tree arbolTwo) {

        Node n = arbolOne.getRaiz();
        Node m = arbolTwo.getRaiz();

        Node p = n;
        Node q = m;

        int alturaOne = arbolOne.alturaArbol(n);
        int alturaTwo = arbolTwo.alturaArbol(m);
        if (alturaOne != alturaTwo) {
            System.err.println("No son iguales");
        } else {

            // Obtener los resultados de las ramas izquierdas
            int takeOneLeft = 0;
            int takeTwoLeft = 0;

            while (p != null && q != null) {
                takeOneLeft += p.getData();
                takeTwoLeft += q.getData();
                p = p.getLeft();
                q = q.getLeft();

            }

            // Reiniciar los apuntadores
            p = n;
            q = m;

            // Obtener los resultados de las ramas derechas
            int takeOneRight = 0;
            int takeTwoRight = 0;

            while (p != null && q != null) {
                takeOneRight += p.getData();
                takeTwoRight += q.getData();
                p = p.getRight();
                q = q.getRight();

            }

            if (takeOneLeft == takeTwoLeft && takeOneRight == takeTwoRight) {

                System.out.println("Los arboles son iguales");
            } else {
                System.out.println("Los arboles no son iguales");
            }
        }
    }

    public void preorden(Node nodoActual) {
        if (nodoActual != null) {
            // Visitar la raíz
            System.out.print(nodoActual.getData() + " ");

            // Recorrer el subárbol izquierdo
            preorden(nodoActual.getLeft());

            // Recorrer el subárbol derecho
            preorden(nodoActual.getRight());
        }
    }

    public void inorden(Node nodoActual) {
        if (nodoActual != null) {
            // Recorrer el subárbol izquierdo
            inorden(nodoActual.getLeft());

            // Visitar la raíz
            System.out.print(nodoActual.getData() + " ");

            // Recorrer el subárbol derecho
            inorden(nodoActual.getRight());
        }
    }

    public void postorden(Node nodoActual) {
        if (nodoActual != null) {
            // Recorrer el subárbol izquierdo
            postorden(nodoActual.getLeft());

            // Recorrer el subárbol derecho
            postorden(nodoActual.getRight());

            // Visitar la raíz
            System.out.print(nodoActual.getData() + " ");
        }
    }

    public int contarNodos(Node nodoActual) {
        if (nodoActual == null) {
            return 0; // La cantidad de nodos en un árbol vacío es 0
        } else {
            // Contar los nodos en los subárboles izquierdo y derecho
            int nodosIzquierda = contarNodos(nodoActual.getLeft());
            int nodosDerecha = contarNodos(nodoActual.getRight());

            // La cantidad total de nodos es la suma de los nodos en los subárboles más la raíz
            return nodosIzquierda + nodosDerecha + 1;
        }
    }

    public int sumaValores(Node nodoActual) {
        if (nodoActual == null) {
            return 0; // La suma de valores en un árbol vacío es 0
        } else {
            // Sumar los valores en los subárboles izquierdo y derecho, y sumar la raíz
            int sumaIzquierda = sumaValores(nodoActual.getLeft());
            int sumaDerecha = sumaValores(nodoActual.getRight());

            return sumaIzquierda + sumaDerecha + nodoActual.getData();
        }
    }

    public Node crearEspejo(Node nodoActual) {
        if (nodoActual == null) {
            return null; // El espejo de un árbol vacío es vacío
        } else {
            // Intercambiar los subárboles izquierdo y derecho
            Node temp = nodoActual.getLeft();
            nodoActual.setLeft(crearEspejo(nodoActual.getRight()));
            nodoActual.setRight(crearEspejo(temp));

            return nodoActual;
        }
    }

    public int caminoMasLargo(Node nodoActual) {
        if (nodoActual == null) {
            return 0; // Altura de un árbol vacío es 0
        }

        // Calcular la altura de los subárboles izquierdo y derecho
        int alturaIzquierda = alturaArbol(nodoActual.getLeft());
        int alturaDerecha = alturaArbol(nodoActual.getRight());

        // Calcular la longitud del camino más largo
        int caminoActual = alturaIzquierda + alturaDerecha;

        // Comparar con las longitudes de camino más largo en los subárboles
        int caminoIzquierda = caminoMasLargo(nodoActual.getLeft());
        int caminoDerecha = caminoMasLargo(nodoActual.getRight());

        return Math.max(caminoActual, Math.max(caminoIzquierda, caminoDerecha));
    }

    public int profundidadNodo(Node raiz, int nodoBuscado, int profundidadActual) {
        if (raiz == null) {
            return -1; // Nodo no encontrado
        }

        if (raiz.getData() == nodoBuscado) {
            return profundidadActual;
        }

        int profundidadIzquierda = profundidadNodo(raiz.getLeft(), nodoBuscado, profundidadActual + 1);
        int profundidadDerecha = profundidadNodo(raiz.getRight(), nodoBuscado, profundidadActual + 1);

        return Math.max(profundidadIzquierda, profundidadDerecha);
    }

    public Node ancestroComunMasBajo(Node raiz, Node nodo1, Node nodo2) {
        if (raiz == null || raiz == nodo1 || raiz == nodo2) {
            return raiz;
        }

        Node izquierda = ancestroComunMasBajo(raiz.getLeft(), nodo1, nodo2);
        Node derecha = ancestroComunMasBajo(raiz.getRight(), nodo1, nodo2);

        if (izquierda != null && derecha != null) {
            return raiz;
        }

        return (izquierda != null) ? izquierda : derecha;
    }

    public Node invertirArbol(Node raiz) {
        if (raiz == null) {
            return null;
        }

        Node temp = raiz.getLeft();
        raiz.setLeft(invertirArbol(raiz.getRight()));
        raiz.setRight(invertirArbol(temp));

        return raiz;
    }
public void imprimirEnReverso(Node raiz) {
        if (raiz != null) {
            imprimirEnReverso(raiz.getRight()); // Recorre el subárbol derecho
            System.out.print(raiz.getData() + " "); // Imprime el nodo actual
            imprimirEnReverso(raiz.getLeft()); // Recorre el subárbol izquierdo
        }
    }

public boolean sonIguales(Node raiz1, Node raiz2) {
    if (raiz1 == null && raiz2 == null) {
        return true;
    }

    if (raiz1 != null && raiz2 != null) {
        return (raiz1.getData() == raiz2.getData()) &&
               sonIguales(raiz1.getLeft(), raiz2.getLeft()) &&
               sonIguales(raiz1.getRight(), raiz2.getRight());
    }

    return false;
}

}
