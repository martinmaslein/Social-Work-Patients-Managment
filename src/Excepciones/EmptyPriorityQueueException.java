package Excepciones;

/**
 * Exception EmptyPriorityQueueExceptionException
 * Clase de error cuando la cola con prioridad se encuentra vacía
 * @author Maslein Martin
 * @author Nicolas Borromei
 * Departamento de Cs. e Ing. de la Computación, UNS
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
