package TDAColaCP;

import java.util.Comparator;

import Excepciones.EmptyPriorityQueueException;
import Excepciones.InvalidKeyException;

/**
 * Clase HeapPQueue.
 * @author Maslein Martin.
 * @author Borromei Nicolas.
 * Departamento de Cs. e Ing. de la Computación, UNS.
 */
public class HeapPQueue<K, V> implements PriorityQueue<K, V> {

	/**
	 * T arreglo de entradas clave-valor
	 */
	private Entrada<K, V>[] T;
	
	/**
	 * comparador DefaultComparator de tipo generico K
	 */
	private DefaultComparator<K> comp;
	
	/**
	 * cantidad de elementos en la cola
	 */
	private int size;

	/**
	 * Crea un nuevo Heap con Comparador y cantidad de entradas dados.
	 * @param c   Comparador
	 * @param max Cantidad de entradas.
	 */
	public HeapPQueue(DefaultComparator<K> c, int max) {
		T = new Entrada[max];
		comp = c;
		size = 0;
	}

	/**
	 * Crea un nuevo Heap vacío.
	 */
	public HeapPQueue() {
		this(new DefaultComparator<K>(), 100);
	}

	/**
	 * Crea un nuevo Heap con Comparador dado y 100 entradas.
	 * @param c Comparador
	 */
	public HeapPQueue(DefaultComparator<K> c) {
		this(c, 100);
	}

	/**
	 * Crea un nuevo Heap con una cantidad de entradas dadas.
	 * @param max Cantidad de entradas
	 */
	public HeapPQueue(int max) {
		this(new DefaultComparator<K>(), max);
	}

	/**
	 * obtiene la cantidad de entradas en la cola
	 * @return int cantidad de entradas
	 */
	public int size() {
		return size;
	}

	/**
	 * Consulta si la cola está vacía.
	 * @return boolean Verdadero si la cola está vacía, falso en caso contrario.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Devuelve la entrada con menor prioridad de la cola.
	 * @return Entrada con menor prioridad.
	 * @throws EmptyPriorityQueueException si la cola está vacía.
	 */
	public Entry<K, V> min() throws EmptyPriorityQueueException {
		if (size == 0)
			throw new EmptyPriorityQueueException("error: CP vacia");
		return T[1];
	}

	/**
	 * Inserta un par clave-valor y devuelve la entrada creada.
	 * @param key Clave de la entrada a insertar.
	 * @param value Valor de la entrada a insertar.
	 * @return Entrada creada.
	 * @throws InvalidKeyException si la clave es inválida.
	 */
	public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
		if (size == T.length - 1) {
			Entrada<K, V>[] A = (Entrada<K, V>[]) new Entrada[T.length * 3];
			for (int i = 1; i < T.length; i++)
				A[i] = T[i];
			T = A;
		}

		Entrada<K, V> e = new Entrada<K, V>(checkKey(key), value);
		size++;
		T[size] = e;

		int i = size;
		boolean seguir = true;
		while (i > 1 && seguir) {
			Entrada<K, V> hijo = T[i];
			Entrada<K, V> padre = T[i / 2];
			if (comp.compare(padre.getKey(), hijo.getKey()) > 0) {
				Entrada<K, V> aux = T[i];
				T[i] = T[i / 2];
				T[i / 2] = aux;
				i /= 2;
			} else
				seguir = false;
		}
		return e;
	}

	/**
	 * checkea si la clave key es invalida
	 * @param key clave a checkear
	 * @return K clave checkeada
	 * @throws InvalidKeyException si la clave es invalida
	 */
	private K checkKey(K key) throws InvalidKeyException {
		try {
			comp.compare(key, key);
		} catch (ClassCastException | NullPointerException e) {
			throw new InvalidKeyException("error: la clave no es comparable");
		}
		return key;
	}

	/**
	 * Remueve y devuelve la entrada con menor prioridad de la cola.
	 * @return Entrada con menor prioridad.
	 * @throws EmptyPriorityQueueException si la cola está vacía.
	 */
	public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
		if (size == 0)
			throw new EmptyPriorityQueueException("error al eliminar: cola vacia");
		Entrada<K, V> aux = T[1];
		T[1] = T[size];
		T[size] = null;
		size--;
		int i = 1;
		boolean seguir = true;
		while (seguir) {
			int hi = i * 2;
			int hd = (i * 2) + 1;
			boolean hasLeft = hi <= size;
			boolean hasRight = hd <= size;
			if (!hasLeft)
				seguir = false;
			else {
				int menor = hi;
				if (hasRight) {
					if (comp.compare(T[hi].getKey(), T[hd].getKey()) > 0)
						menor = hd;
				}
				if (comp.compare(T[menor].getKey(), T[i].getKey()) < 0) {
					Entrada<K, V> aux1 = T[i];
					T[i] = T[menor];
					T[menor] = aux1;
					i = menor;
				} else
					seguir = false;
			}
		}
		return aux;
	}
}