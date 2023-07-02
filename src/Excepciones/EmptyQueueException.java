package Excepciones;

/**
 * Exception EmptyQueueException
 * Clase de error cuando la cola se encuentra vac�a
 * @author Maslein Martin
 * @author Borromei Nicolas
 * Departamento de Cs. e Ing. de la Computaci�n, UNS
 */
public class EmptyQueueException extends Exception {
	
	/**
	 * Lanza el mensaje correspondiente
	 * @param msg mensaje a mostrar
	 */
	public EmptyQueueException(String msg) {
		super(msg);
	}
}
