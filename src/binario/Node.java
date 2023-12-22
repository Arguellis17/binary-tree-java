package binario;

 public class Node<E> {

    // Dato del nodo
    private int data;
    // Lado izquierdo
    private Node<E> left;
    // Lado derecho
    private Node<E> right;

    // Creacion del nodo
    public Node(int data) {
        this.data = data;
    }

    // Obtener el data
    public int getData() {
        return data;
    }

    // Asignar la data
    public void setData(int data) {
        this.data = data;
    }

    // Obtener izquierdo
    public Node getLeft() {
        return left;
    }

    // Asignar izquierdo
    public void setLeft(Node left) {
        this.left = left;
    }

    // Obtener derecho
    public Node getRight() {
        return right;
    }

    // Asignar derecho
    public void setRight(Node right) {
        this.right = right;
    }

}
