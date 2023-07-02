package TDAMapeo;

/**
 * Interface Entry con par clave y valor genericos.
 * @author Maslein Martin.
 * @author Borromei Nicolas.
 * Departamento de Cs. e Ing. de la Computación, UNS.
*/
public interface Entry<K,V> {
	
	/**
	 * @return clave de tipo K.
	 */
	public K getKey();
	
	/**
	 * @return valor de tipo V.
	 */
	public V getValue();
}