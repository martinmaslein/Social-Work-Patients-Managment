package Excepciones;

/**
 * Exception EmptyQueueException
 * Clase de error cuando la cola se encuentra vacía
 * @author Maslein Martin
 * @author Borromei Nicolas
 * Departamento de Cs. e Ing. de la Computación, UNS
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
