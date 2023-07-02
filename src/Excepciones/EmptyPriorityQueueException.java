package Excepciones;

/**
 * Exception EmptyPriorityQueueExceptionException
 * Clase de error cuando la cola con prioridad se encuentra vac�a
 * @author Maslein Martin
 * @author Nicolas Borromei
 * Departamento de Cs. e Ing. de la Computaci�n, UNS
 */
public class EmptyPriorityQueueException extends Exception {
	
	/**
	 * Lanza el mensaje correspondiente
	 * @param msg mensaje a mostrar
	 */
	public EmptyPriorityQueueException(String msg){
		super (msg);
	}
}
