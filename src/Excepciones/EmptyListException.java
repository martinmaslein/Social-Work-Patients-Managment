package Excepciones;

/**
 * Exception EmptyListException
 * Clase de error cuando la lista se encuentra vacia
 * @author Maslein Martin
 * @author Borromei Nicolas
 * Departamento de Cs. e Ing. de la Computación, UNS
 */
public class EmptyListException extends Exception {
	
	/**
	 * Lanza el mensaje correspondiente
	 * @param msg mensaje a mostrar
	 */
	public EmptyListException (String msg) {
		super(msg);
	}
}