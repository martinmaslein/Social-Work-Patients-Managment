package TDAMapeo;

/**
* Clase Entrada con un par generico K clave y V valor.
* @author Maslein Martin.
* @author Borromei Nicolas.
* Departamento de Cs. e Ing. de la Computación, UNS.
*/

public class Entrada<K,V> implements Entry<K,V> {

	/**
	 * key de tipo K.
	 */
	protected K key;
	
	/**
	 * value de tipo V.
	 */
	protected V value;
	
	
	/**
	 * Constructor que crea una entrada con clave y valor pasados por parametro.
	 * @param k clave de tipo K.
	 * @param v valor de tipo V.
	 */
	public Entrada(K k, V v) {
		key = k;
		value = v;
	}
	
	/**
	 * Consturctor que crea una entrada vacia.
	 */
	public Entrada() {
		key = null;
		value = null;
	}
	
	/**
	 * Setea en la entrada la clave k.
	 * @param k clave de tipo K.
	 */
	public void setKey(K k) {
		key = k;
	}
	
	/**
	 * Setea en la entrada el valor v.
	 * @param v valor de tipo V.
	 */
	public void setValue(V v) {
		value = v;
	}

	/**
	 * Obtiene la clave de la entrada.
	 * @return K clave de la entrada de tipo K.
	 */
	public K getKey() {
		return key;
	}

	/**
	 * Obtiene el valor de la entrada.
	 * @return V valor de la entrada de tipo V.
	 */
	public V getValue() {
		return value;
	}	
}