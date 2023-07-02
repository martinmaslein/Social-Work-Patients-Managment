package Logica;

import java.time.LocalDate;

/**
 * Clase Paciente representa un paciente que va a ingresar al sistema, con un DNI, obra social, habitacion que ocupar� y fecha de nacimiento, que tambi�n posee un nivel de urgencia
 * @author Maslein Martin
 * @author Borromei Nicolas
 * Departamento de Cs. e Ing. de la Computaci�n, UNS
 */
public class Paciente {
	
	/**
	 * DNI del paciente
	 */
	protected int DNI;
	
	/**
	 * obra social del paciente
	 */
	protected String obraSocial;
	
	/**
	 * habitaci�n del paciente
	 */
	protected char habitacion;
	
	/**
	 * fecha de nacimiento del paciente
	 */
	protected LocalDate fechaNacimiento;

	/**
	 * Constructor Paciente que crea un paciente con dni, obra social, fecha de nacimiento y habitaci�n
	 * @param d dni
	 * @param os obra social
	 * @param dia dia de nacimiento
	 * @param mes mes de nacimiento
	 * @param a�o a�o de nacimiento
	 * @param h habitacion
	 */
	public Paciente(int d, String os, int dia, int mes, int a�o, char h) {
		DNI = d;
		obraSocial = os;
		fechaNacimiento = LocalDate.of(a�o,mes,dia);
		habitacion = h;
	}
	
	/**
	 * obtiene DNI del paciente
	 * @return int dni del paciente
	 */
	public int getDNI() {
		return DNI;
	}

	/**
	 * obtiene obra social del paciente
	 * @return String obra social del paciente
	 */
	public String getObraSocial() {
		return obraSocial;
	}

	/**
	 * obtiene habitacion del paciente
	 * @return char habitaci�n del paciente
	 */
	public char getHabitacion() {
		return habitacion;
	}

	/**
	 * obtiene fecha de nacimiento del paciente
	 * @return LocalDate fecha de nacimiento del paciente
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * setea dni del paciente
	 * @param d del paciente
	 */
	public void setDNI(int d) {
		DNI = d;
	}

	/**
	 * setea obra social del paciente
	 * @param os obra social del paciente
	 */
	public void setObraSocial(String os) {
		obraSocial = os;
	}

	/**
	 * setea habitaci�n del paciente
	 * @param h habitaci�n del paciente
	 */
	public void setHabitacion(char h) {
		habitacion = h;
	}

	/**
	 * setea fecha de nacimiento del paciente
	 * @param fn fecha de nacimiento del paciente
	 */
	public void setFechaNacimiento(LocalDate fn) {
		fechaNacimiento = fn;
	}
}