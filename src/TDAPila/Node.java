package TDAPila;

/**
 * Clase Node (nodo) que guarda un elemento y una referencia a un nodo posterior
 * @author Maslein Martín
 * @author Borromei Nicolás
 * Departamento de Cs. e Ing. de la Computación, UNS
 * @param <E> tipo genérico del nodo
 */
public class Node<E> {
	
	/**
	 * Elemento a guardar del tipo generico E
	 */
	E elem;
	
	/**
	 * Referencia a un nodo next (siguiente) 
	 */
	Node <E> next;
	
	/**
	 * Constructor del nodo, recibe el elemento y el nodo siguiente al que hara referencia "next"
	 * @param e elemento a guardar en el nodo
	 * @param n	nodo siguiente a guardar como referencia
	 */
	public Node(E e, Node <E> n) {
		this.elem = e;
		this.next = n;
	}
	
	/**
	 * Inserta un elemento en el nodo, si el nodo ya tenia elemento lo reemplaza
	 * @param element elemento a insertar
	 */
	public void setElement(E element) {
		this.elem = element;
	}
	
	/**
	 * Guarda una referencia (next) al nodo pasado por parametro, si ya tenia una referencia asignada esta se reemplaza
	 * @param n El nodo que se guarda como referencia de siguiente
	 */
	public void setNext(Node <E> n) {
		this.next = n;
	}
	
	/**
	 * Retorna el elemento de tipo generico del nodo
	 * @return elemento del nodo
	 */
	public E getElement() {
		return elem;
	}
	
	/**
	 * Retorna el nodo siguiente mediante la referencia guardada
	 * @return el nodo que le sigue
	 */
	public Node <E> getNext() {
		return next;
	}
}