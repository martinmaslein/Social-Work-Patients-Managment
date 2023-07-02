package TDACola;

import Excepciones.EmptyQueueException;

/**
 * Interface Queue (Pila)
 * @author Maslein Martín
 * @author Borromei Nicolás
 * Departamento de Ciencias e Ingenieria de la Computación, UNS.
 */

public interface Queue <E> {
	
	/**
	 * Devuelve la cantidad de elementos en la cola.
	 * @return Cantidad de elementos en la cola.
	 */
	public int size();
	
	/**
	 * Consulta si la cola está vacía.
	 * @return boolean Verdadero si la cola está vacía, falso en caso contrario.
	 */
	public boolean isEmpty();
	
	/**
	 * Inspecciona el elemento que se encuentra en el frente de la cola.
	 * @return E Elemento que se encuentra en el frente de la cola.
	 * @throws EmptyQueueException si la cola está vacía.
	 */
	public E front() throws EmptyQueueException;
	
	/**
	 * Inserta un elemento en el fondo de la cola.
	 * @param element Nuevo elemento a insertar.
	 */
	public void enqueue(E element);
	
	/**
	 * Remueve el elemento en el frente de la cola.
	 * @return E Elemento removido.
	 * @throws EmptyQueueException si la cola está vacía.
	 */
	public E dequeue() throws EmptyQueueException;
}
