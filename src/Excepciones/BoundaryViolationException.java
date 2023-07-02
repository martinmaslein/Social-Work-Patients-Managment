package Excepciones;

/**
 * Exception BoundaryViolationException
 * Clase de error cuando se exceden los limites de la lista
 * @author Maslein Martin
 * @author Borromei Nicolas
 * Departamento de Cs. e Ing. de la Computación, UNS
 */
public class BoundaryViolationException extends Exception {
	
	/**
	 * Lanza el mensaje correspondiente
	 * @param msg mensaje a mostrar
	 */
	public BoundaryViolationException (String msg) {
		super(msg);
	}
}
