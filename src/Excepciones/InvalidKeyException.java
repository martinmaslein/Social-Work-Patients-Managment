package Excepciones;

/**
* Exception InvalidKeyException
* Clase de error cuando la clave pasada es inv�lida
* @author Maslein Martin
* @author Nicolas Borromei
* Departamento de Cs. e Ing. de la Computaci�n, UNS
*/
public class InvalidKeyException extends Exception {

	/**
	 * Lanza el mensaje correspondiente
	 * @param msg mensaje pasado por par�metro
	 */
	public InvalidKeyException(String msg) {
		super(msg);
	}
}