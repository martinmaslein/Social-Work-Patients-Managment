package TDAColaCP;

/**
 * Comparador de elementos
 * @author Maslein Martin.
 * @author Borromei Nicolas.
 * Departamento de Ciencias e Ingenieria de la Computación, UNS.
 * @param <E> elemento generico
 */

public class DefaultComparator<E> implements java.util.Comparator<E>{
	
	/**
	 * Compara sus dos argumentos por orden.
	 * @param a El primer objeto a comparar.
	 * @param b El segundo objeto a comparar.
	 * @return int un entero negativo , cero o un entero positivo como primer argumento es menor que , igual o mayor que el segundo.
	 * @throws ClassCastException si los tipos de argumentos impiden que sean comparados por este comparador.
	 */
		public int compare(E a, E b) throws ClassCastException {
			return ((Comparable<E>)a).compareTo(b);	
		}
}