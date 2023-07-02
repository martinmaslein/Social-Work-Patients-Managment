package TDAPila;
import Excepciones.EmptyStackException;

/**
 * Pila Enlazada con referencia a su primer elemento y a su longitud
 * @author Maslein Martín
 * @author Borromei Nicolás
 * Departamento de Cs. e Ing. de la Computación, UNS
 * @param <E> Tipo genérico E
 */
public class LinkedStack<E> implements Stack<E> {
	
	/**
	 * Entero size referenciado la longitud de la pila
	 */
	protected int size;
	/**
	 * Referencia al primer elemento 
	 */
	protected Node<E> head;
	
	/**
	 * Constrcutor crea la pila sin ningun elemento
	 */
	public LinkedStack() {
		head = new Node<E>(null,null);
		size = 0;
	}
	
	/**
	 * Consulta la cantidad de elementos de la pila.
	 * @return Cantidad de elementos de la pila.
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Consulta si la pila está vacía.
	 * @return Verdadero si la pila está vacía, falso en caso contrario.
	 */
	public boolean isEmpty() {
		return (size == 0);
	}
	
	/**
	 * Inserta un elemento en el tope de la pila.
	 * @param e Elemento a insertar.
	 */
	public void push(E e) {
		Node<E> n = new Node<E>(e,head);
		head = n;
		size++;
	}
	
	/**
	 * Examina el elemento que se encuentra en el tope de la pila.
	 * @return Elemento que se encuentra en el tope de la pila.
	 * @throws EmptyStackException si la pila está vacía. 
	 */
	public E top() throws EmptyStackException {
		if(isEmpty())
			throw new EmptyStackException("Estructura vacia.");
		return head.getElement();
	}
	
	/**
	 * Remueve el elemento que se encuentra en el tope de la pila.
	 * @return Elemento removido.
	 * @throws EmptyStackException si la pila está vacía. 
	 */
	public E pop() throws EmptyStackException {
		if(isEmpty())
			throw new EmptyStackException("Estructura vacia.");
		E toReturn = head.getElement();
		head = head.getNext();
		size--;
		return toReturn;
	}
}