package Logica;

import TDAColaCP.*;
import TDAMapeo.*;
import TDAPila.*;
import TDALista.*;

import java.util.Iterator;

import Excepciones.*;

/**
 * Clase Logica que contiene los mensajes y servicios que tiene el sistema
 * @author Maslein Martin
 * @author Borromei Nicolas
 * Departamento de Cs. e Ing. de la Computación, UNS
 */

public class Logica {

	/** M mapeo que contiene entradas con dni-paciente */
	protected Map<Integer, Paciente> M;
	
	/**
	 * C cola con prioridad que contiene entradas dni-nivel de urgencia
	 */
	protected PriorityQueue<Integer, Integer> C;

	/**
	 * Constructor Logica que inicializa el mapeo y la cola con prioridad
	 */
	public Logica() {
		M = new OpenHashMap<Integer, Paciente>();
		C = new HeapPQueue<Integer, Integer>();
	}
	
	/**
	 * Asignar Habitación: dado un paciente se le asigna una habitación
	 * @param dni Dni de un paciente a asginar en una habitacion
	 * @param obraSocial Obra Social de un paciente a asginar en una habitacion
	 * @param dia Dia de la fecha de nacimiento de un paciente a asginar en una habitación
	 * @param mes Mes de la fecha de nacimiento de un paciente a asginar en una habitación
	 * @param año Año de la fecha de nacimiento de un paciente a asginar en una habitación
	 * @param h Habitacion donde se asignara el paciente
	 * 
	 */
	public void asignarHabitacion(String dni, String obraSocial, String dia, String mes, String año, char h) {
		Paciente p = new Paciente(Integer.valueOf(dni), obraSocial, Integer.valueOf(dia), Integer.valueOf(mes), Integer.valueOf(año), h);	
		try {	
			M.put(p.getDNI(), p);
		} catch (InvalidKeyException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Consultar datos de un paciente: muestra fecha de nacimiento, obra social y habitacion asignada.
	 * @param dni de la persona para consultar datos.
	 * @return String que lleva los datos a mostrar.
	 */
	public String consultaPaciente(int dni) {
		String salida = " ";
		Paciente p = null;
		try {
			p = M.get(dni);
			salida = "DNI: " +dni +" - Fecha de nacimiento: "+p.getFechaNacimiento().toString()+" - Obra social: "+p.getObraSocial()+" - Habitacion: "+p.getHabitacion()+"";
		} catch (InvalidKeyException e) {
			System.out.println(e.getMessage());
		}
		return salida;
	}	
	
	/**
	 * Desasignar Habitación: dado un paciente, se lo elimina de la habitación
	 * @param dni dni del paciente al que se le va a dar el alta
	 * @return Paciente paciente al que se le dio el alta
	 */
	public Paciente desasignarHabitacion(int dni) {
		Paciente toRet = null;
		try {
			toRet = M.remove(dni);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return toRet;
	}
	
	/**
	 * Listar habitaciones vacias: lista todas las habitaciones que no tienen ningun paciente dentro.
	 * @return listado de habitaciones vacias.
	 */
	public String habitacionesVacias() {
		Iterable<Paciente> it = M.values();
		String salida = "";
		for (char i ='A'; i < 'K'; i++) {
			if (!esta(i, it))
				salida += " "+i;
		}
		return salida;
	}
	
	/**
	 * esta controla si se encuentra la habitacion c en la lista de pacientes it2.
	 * @param c habitacion a buscar.
	 * @param it2 lista de pacientes.
	 * @return verdadero si la habitacion esta ocupada, falso si la habitacion esta libre.
	 */
	private boolean esta(Character c, Iterable<Paciente> it2) {
		boolean salida = false;
		Iterator<Paciente> it = it2.iterator();
		Paciente p = it.hasNext() ? it.next() : null;
		while(!salida && p != null) {
			if(p.getHabitacion() == c) {
				salida = true;
			}
			else
				p = it.hasNext()? it.next() : null;
		}
		return salida;
	}
	
	/**
	 * Cantidad De Pacientes en Habitación: dada una habitacion retorna la cantidad de pacientes en dicha habitacion
	 * @param h Una habitacion de la a...
	 * @return La cantidad de pacientes en la habitación pasada por parámetro
	 */
	public int cantidadPacientesHabitacion(char h) {
		int toRet = 0;
		for (TDAMapeo.Entry<Integer, Paciente> e : M.entries()) {
			if (e.getValue().getHabitacion() == h)
				toRet++;
		}
		return toRet;
	}
	

	/**
	 * Ingresar paciente: ingresa un paciente en el sistema de urgencias
	 * @param d dni del paciente a ingresar en el sistema de urgencias
	 * @param u nivel de urgencia del paciente a ingresar en el sistema de urgencias
	 */
	public void ingresarPaciente(int d, int u) {
		try {
			C.insert(d,u);
		} catch (InvalidKeyException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Atender paciente: atiende un paciente del sistema de urgencias y lo retira del sistema
	 * @return int DNI del paciente atendido
	 */
	public int atenderPaciente() {
		int salida = -1;
		try {
			salida =  C.removeMin().getKey();
		} catch (EmptyPriorityQueueException e) {
			System.out.println(e.getMessage());
		}
		return salida;
	}
	
	/**
	 * Cantidad pacientes urgencias: consulta la cantidad de pacientes que esperan ser atendidos.
	 * @return cantidad de pacientes a ser atendidos.
	 */
	public int cantidadPacientesUrgencias() {
		return C.size();
	}
	
	
	/**
	 * Validar contraseña: valida que la contraseña del sistema cumpla el siguiente formato AXA'A', siendo A un String, X un caracter x (asumimos que no es parte del String A), A' es A invertido
	 * @param cadena contraseña a verificar
	 * @return boolean verdadero si es valida, caso contrario falso.
	 */
	public boolean validarContraseña(String cadena) {
		boolean cumple=true;
		boolean encontreX=false;
		int indice=0;
		Stack<Character> p1=new LinkedStack<Character>();
		Stack<Character> p2=new LinkedStack<Character>();
		if(cadena.length()!=0) {
			while(cumple && !encontreX && indice<cadena.length()) {
				if(cadena.charAt(indice)=='x') {
					if(indice == 0) {
						cumple=false;
					}
					else { 
						indice++;
						encontreX=true;
					}
				}else {
					if(cadena.charAt(indice)==' ') 	{
						cumple=false;
					}else {
						p1.push(cadena.charAt(indice));
						p2.push(cadena.charAt(indice));
						indice++;
					}
				}
			}
			try {
				while(cumple && indice<cadena.length() && !p1.isEmpty()) {
					cumple=cadena.charAt(indice) == p1.pop();
					indice++;
				}
				cumple=cumple && p1.isEmpty();
				while(cumple && indice<cadena.length() && !p2.isEmpty()) {
					cumple=cadena.charAt(indice) == p2.pop();
					indice++;
				}
				cumple=cumple && p2.isEmpty();
			}catch(EmptyStackException e) {e.printStackTrace();}
			if(indice<cadena.length())
				cumple=false;
		}else
			cumple=false;
		return cumple;
	}
}