package TDACola;

import Excepciones.EmptyQueueException;

/**
 * Clase ColaConArregloCircular
 * @author Maslein Martín
 * @author Borromei Nicolás
 * Departamento de Ciencias e Ingenieria de la Computación, UNS.
 */

public class ColaConArregloCircular<E> implements Queue<E> {
	
	/**
	 * f la posición a remover en un dequeue (primero)
	 */
	protected int f; 
	
	/**
	 * r la posición a agregar en un enqueue (ultimo+1)
	 */
	protected int r; 
	/**
	 * q el arreglo de tipo generico E
	 */
	protected E[] q;

	/**
	 * Constructor
	 * @param max longitud del arreglo
	 */
	public ColaConArregloCircular(int max) {
		f = 0;
		r = 0;
		q = (E[]) new Object[max];
	}

	/**
	 * Constructor sin parametros llama al constructor con un entero 10 como parametro, es decir, crea la cola con longitud 10
	 */
	public ColaConArregloCircular() {
		this(10);
	}

	/**
	 * Size retorna la cantidad de elementos en la cola
	 * @return int cantidad de elementos en la cola
	 */
	public int size() {
		int n = q.length;
		return (n - f + r) % n;
	}

	/**
	 * isEmpty retorna true o false si la cola esta vacia
	 * @return boolean true si la cola esta vacia
	 */
	public boolean isEmpty() {
		return f == r;
	}

	/**
	 * front retorna el primer elemento de la cola, lanza excepcion si la cola esta vacia
	 * @return E el primer elemento de la cola
	 * @throws EmptyQueueException cuando la cola esta vacía
	 */
	public E front() throws EmptyQueueException {
		if (f == r)
			throw new EmptyQueueException("Can't front: Empty Queue");
		return q[f];
	}

	/**
	 * Enqueue inserta el elemento pasado por parametro al final de la cola
	 * @param elem el elemento a insertar en la cola
	 */
	public void enqueue(E elem) {
		if (size() == q.length - 1)
			resize();
		q[r] = elem;
		r = (r + 1) % q.length;
	}

	/**
	 * Dequeue elimina el primer elemento de la cola y lo devuelve, lanza excepcion si la cola esta vacia
	 * @return  E retorna el elemento a desencolar
	 * @throws EmptyQueueException cuando la cola esta vacía
	 */
	public E dequeue() throws EmptyQueueException {
		if (f == r)
			throw new EmptyQueueException("Can't dequeue: Empty Queue");
		E aux = q[f];
		q[f] = null;
		f = (f + 1) % q.length;
		return aux;
	}

	/**
	 * resize agranda el arreglo cuando este se llena 
	 */
	private void resize() {
		E[] newArray = (E[]) new Object[2 * q.length];
		int fAux = f;
		for (int i = 0; i < size(); i++) {
			newArray[i] = q[fAux];
			fAux = (fAux + 1) % q.length;
		}
		r = size();
		f = 0;
		q = newArray;
	}
}