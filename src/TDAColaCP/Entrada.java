package TDAColaCP;

/**
 * Clase Entrada con un par generico K clave y V valor.
 * @author Maslein Martin.
 * @author Borromei Nicolas.
 * Departamento de Cs. e Ing. de la Computación, UNS.
 */
public class Entrada<K, V> implements Entry<K, V> {
	
	/**
	 * clave de tipo K.
	 */
	private K clave;
	
	/**
	 * valor de tipo V.
	 */
	private V valor;

	/**
	 * Constructor que crea una entrada con clave y valor pasados por parametro.
	 * @param k clave de tipo K.
	 * @param v valor de tipo V.
	 */
	public Entrada(K k, V v) {
		clave = k;
		valor = v;
	}

	/**
	 * Obtiene la clave de la entrada.
	 * @return K clave de la entrada de tipo K.
	 */
	public K getKey() {
		return clave;
	}

	/**
	 * Obtiene el valor de la entrada.
	 * @return V valor de la entrada de tipo V.
	 */
	public V getValue() {
		return valor;
	}

	/**
	 * Setea en la entrada la clave k.
	 * @param k clave de tipo K.
	 */
	public void setKey(K k) {
		clave = k;
	}

	/**
	 * Setea en la entrada el valor v.
	 * @param v valor de tipo V.
	 */
	public void setValue(V v) {
		valor = v;
	}

	/**
	 * Obtiene el valor de la entrada.
	 * @return String que contiene la clave y el valor de la entrada que recibe el mensaje.
	 */
	public String toString() {
		return "(" + getKey() + "," + getValue() + ")" ;
	}
}