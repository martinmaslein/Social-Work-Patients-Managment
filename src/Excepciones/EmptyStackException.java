package Excepciones;

/**
 * Exception EmptyStackException
 * Clase de error cuando la pila se encuentra vac�a
 * @author Maslein Martin
 * @author Borromei Nicolas
 * Departamento de Cs. e Ing. de la Computaci�n, UNS
 */
public class EmptyStackException extends Exception{
	
	/**
	 * Lanza el mensaje correspondiente
	 * @param msg mensaje a mostrar
	 */
	public EmptyStackException(String msg) {
		super(msg);
	}
}
