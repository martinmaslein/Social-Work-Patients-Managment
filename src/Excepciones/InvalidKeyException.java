package Excepciones;

/**
* Exception InvalidKeyException
* Clase de error cuando la clave pasada es inválida
* @author Maslein Martin
* @author Nicolas Borromei
* Departamento de Cs. e Ing. de la Computación, UNS
*/
public class InvalidKeyException extends Exception {

	/**
	 * Lanza el mensaje correspondiente
	 * @param msg mensaje pasado por parámetro
	 */
	public InvalidKeyException(String msg) {
		super(msg);
	}
}