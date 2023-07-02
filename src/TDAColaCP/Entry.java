package TDAColaCP;

/**
 * Interfaz Entry.
 * @author Maslein Martin.
 * @author Borromei Nicolas.
 * Departamento de Cs. e Ing. de la Computación, UNS.
 */
public interface Entry<K,V> {
	
	/**
	 * Obtiene la clave de la entrada.
	 * @return K clave.
	 */
	public K getKey();
	
	/**
	 * Obtiene el valor de la entrada.
	 * @return V valor.
	 */
	public V getValue();
	
	/**
	 * Setea la clave recibida por parametro en la entrada que recibe el mensaje.
	 * @param key clave a setear
	 */
	public void setKey(K key);
	
	/**
	 * Setea el valor recibido por parametro en la entrada que recibe el mensaje.
	 * @param value valor a setear.
	 */
	public void setValue(V value);

}