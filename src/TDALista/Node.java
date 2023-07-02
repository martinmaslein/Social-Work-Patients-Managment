package TDALista;

/**
 * Clase Node, implementa Position, almacena un elemento y una referencia a su siguiente
 * @author Maslein Martin
 * @author Borromei Nicolas
 * Departamento de Cs. e Ing. de la Computación, UNS
 * @param <E> elemento generico
 */
public class Node<E> implements Position<E> {

	/**
	 * E elemento generico
	 */
	private E element;
	
	/**
	 * referencia siguiente
	 */
	private Node<E> next;
	
	/**
	 * Constructor Node, crea un nodo con elemento e y nodo n como siguiente
	 * @param e elemento del nodo
	 * @param n nodo siguiente al creado
	 */
	public Node(E e, Node<E> n) {
		element = e;
		next = n;
	}
	
	/**
	 * obtiene el elemento del nodo
	 * @return E elemento del nodo
	 */
	public E element() {
		return element;
	}
	
	/**
	 * setea el elemento e al nodo
	 * @param e elemento a setear
	 */
	public void setElement(E e) {
		element = e;
	}
	
	/**
	 * obtiene el nodo siguiente
	 * @return nodo siguiente
	 */
	public Node<E> getNext() {
		return next;
	}
	
	/**
	 * setea n como nodo siguiente
	 * @param n nodo a setear
	 */
	public void setNext(Node<E> n) {
		next = n;
	}
}