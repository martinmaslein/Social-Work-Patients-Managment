package Excepciones;

/**
 * Exception InvalidPositionException
 * Clase de error cuando la posicion pasada es inv�lida
 * @author Maslein Martin
 * @author Borromei Nicolas
 * Departamento de Cs. e Ing. de la Computaci�n, UNS
 */
public class InvalidPositionException extends Exception {
	
	/**
	 * Lanza el mensaje correspondiente
	 * @param msg mensaje a mostrar
	 */
	public InvalidPositionException (String msg) {
		super(msg);
	}
}
