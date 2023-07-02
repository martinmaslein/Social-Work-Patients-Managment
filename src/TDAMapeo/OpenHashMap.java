package TDAMapeo;

import java.util.Iterator;

import TDALista.*;
import Excepciones.*;

/**
 * Clase OpenHashMap genera un mapeo con tabla de dispersion abierta, con entradas que contienen clave y valor de tipo generico K y V.
 * @author Maslein Martín.
 * @author Borromei Nicolás.
 * Departamento de Cs. e Ing. de la Computación, UNS.
 */

public class OpenHashMap<K, V> implements Map<K, V> {

   /**
	 * Arreglo con listas que contienen entradas de clave y valor de tipo K y V genericos.
	 */
	protected PositionList<Entrada<K, V>>[] A;
	
   /**
	 * Tamaño del arreglo.
	 */
	protected int N;
	
   /**
	 * Cantidad de entradas en todo el mapeo
	 */
	protected int n;
	
   /**
	 * Atributo que controla el factor de carga
	 */
	private static double fc = 0.9;

   /**
	 * Constructor del mapeo con tamaño del arreglo 8 y todas las listas inicializadas en cada bucket del areglo
	 */
	public OpenHashMap() {
		N = 8;
		n = 0;
		A = new PositionList[N];
		for (int i = 0; i < N; i++)
			A[i] = new DoubleLinkedList<Entrada<K,V>>();
	}
	
   /**
	 * Consulta el número de entradas del mapeo
	 * @return int número de entradas del mapeo
	 */
	public int size() {
		return n;
	}

   /**
	 * Consulta si el mapeo está vacío
	 * @return boolean verdadero si el mapeo está vacío, falso en caso contrario
	 */
	public boolean isEmpty() {
		return (n == 0);
	}

   /**
	 * Busca una entrada con clave igual a una clave dada y devuelve el valor asociado, si no existe retorna nulo
	 * @param key clave a buscar
	 * @return V valor de la entrada encontrada
	 * @throws InvalidKeyException si la clave pasada por parámetro es inválida
	 */
	public V get(K key) throws InvalidKeyException {
		checkKey(key);
		V toReturn = null;
		int clave = hash(key);
		Iterator<Position<Entrada<K, V>>> it = A[clave].positions().iterator();
		Position<Entrada<K,V>> pos = it.hasNext() ? it.next() : null;
		boolean found = false;
		while (!found && pos != null) {
			if (pos.element().getKey().equals(key)) {
				toReturn = pos.element().getValue();
				found = true;
			} else
				pos = it.hasNext() ? it.next() : null;
		}
		return toReturn;
	}

   /**
	 * Si el mapeo no tiene una entrada con clave key, inserta una entrada con clave key y valor value en el mapeo y devuelve null. 
	 * Si el mapeo ya tiene una entrada con clave key, entonces remplaza su valor y retorna el viejo valor.
	 * @param key Clave de la entrada a crear.
	 * @param value Valor de la entrada a crear. 
	 * @return Valor de la vieja entrada.
	 * @throws InvalidKeyException si la clave pasada por parámetro es inválida.
	 */
	public V put(K key, V value) throws InvalidKeyException {
		checkKey(key);
		V toReturn = null;
		int k = hash(key);
		Iterator<Entrada<K,V>> it = A[k].iterator();
		Entrada<K,V> e = it.hasNext() ? it.next() : null;
		boolean found = false;
		while (!found && e != null) {
			if (key.equals(e.getKey())) {
				found = true;
				toReturn = e.getValue();
				e.setValue(value);
			} else 
				e = it.hasNext() ? it.next() : null;
		}
		if (!found) {
			A[k].addLast(new Entrada<K,V>(key, value));
			n++;
		}
		if (n / N > fc)
			rehash();
		return toReturn;

	}

   /**
	 * Remueve la entrada con la clave dada en el mapeo y devuelve su valor, o nulo si no fue encontrada.
	 * @param key Clave de la entrada a remover.
	 * @return Valor de la entrada removida.
	 * @throws InvalidKeyException si la clave pasada por parámetro es inválida
	 */
	public V remove(K key) throws InvalidKeyException {
		checkKey(key);
		V toReturn = null;
		int k = hash(key);
		Iterator<Position<Entrada<K,V>>> it = A[k].positions().iterator();
		Position<Entrada<K,V>> pos = it.hasNext() ? it.next() : null;
		boolean found = false;

		try {
			while (!found && pos != null) {
				if (pos.element().getKey().equals(key)) {
					toReturn = pos.element().getValue();
					found = true;
					A[k].remove(pos);
					n--;
				} else {
					pos = it.hasNext() ? it.next() : null;
				}
			}
		} catch (InvalidPositionException e) {
			System.out.println(e.getMessage());
		}
		return toReturn;
	}

   /**
	 * Retorna una colección iterable con todas las claves del mapeo
	 * @return colección iterable con todas las claves del mapeo
	 */
	public Iterable<K> keys() {
		PositionList<K> L = new DoubleLinkedList<K>();
		for (int i = 0; i<N; i++) {
			for (Position<Entrada<K,V>> pos : A[i].positions()) {
				L.addLast(pos.element().getKey());
			}
		}
		return L;
	}

   /**
	 * Retorna una colección iterable con todas los valores del mapeo
	 * @return colección iterable con todas los valores del mapeo
	 */
	public Iterable<V> values() {
		PositionList<V> L = new DoubleLinkedList<V>();
		for (int i = 0; i<N; i++) {
			for (Position<Entrada<K,V>> pos : A[i].positions()) {
				L.addLast(pos.element().getValue());
			}
		}
		return L;

	}

   /**
	 * Retorna una colección iterable con todas las entradas del mapeo
	 * @return colección iterable con todas las entradas del mapeo
	 */
	public Iterable<Entry<K,V>> entries() {
		PositionList<Entry<K,V>> L = new DoubleLinkedList<Entry<K,V>>();
		for (int i = 0; i < N; i++) {
			for (Position<Entrada<K,V>> pos : A[i].positions()) {
				L.addLast(pos.element());
			}
		}
		return L;
	}

   /**
	 * Crea un mapeo nuevo con el doble de tamaño y copia todos los elementos que ya tenia anteriormente
	 */
	private void rehash() {
		N = nextPrime(N * 2);
		PositionList<Entrada<K,V>>[] T;
		T = new DoubleLinkedList[N];
		for (int i = 0; i < N; i++)
			T[i] = new DoubleLinkedList<Entrada<K, V>>();
		for (int i = 0; i < A.length; i++)
			for (Entrada<K,V> e : A[i]) {
				int p = hash(e.getKey());
				T[p].addLast(e);
			}
		A=T;
	}
	
   /**
	 * Retorna una colección iterable con todas las entradas del mapeo
	 * @param key clave a aplicarse el hashCode
	 * @return int codigo hash, posicion del arreglo donde se insertara la entrada con clave key
	 */
	private int hash(K key) {
		int i = Math.abs(key.hashCode());
		return (i % N);
	}

   /**
	 * Retorna una colección iterable con todas las entradas del mapeo
	 * @param key clave a evaluar si es una clave invalida
	 */
	private void checkKey(K key) throws InvalidKeyException {
		if (key == null) {
			throw new InvalidKeyException("Clave invalida");
		}
	}

   /**
	 * Retorna una colección iterable con todas las entradas del mapeo
	 * @param n numero a buscar el siguiente primo
	 * @return int siguiente primo a n
	 */
	private int nextPrime(int n) {
		boolean found = false;
		n++;
		while (!found) {
			if (isPrime(n))
				found = true;
			else
				n++;
		}
		return n;
	}

   /**
	 * Retorna una colección iterable con todas las entradas del mapeo
	 * @param n numero a evaluar si es primo
	 * @return boolean retorna verdadero si n es primo, falso caso contrario
	 */
	private boolean isPrime(int n) {
		boolean found = false;
		int divider = 2;
		while (divider < n && !found) {
			if (n % divider == 0)
				found = true;
			else
				divider++;
		}
		return found;
	}
}