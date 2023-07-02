package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Logica.Logica;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI {

	
	private Logica logic = new Logica();
	private JFrame frmProyecto;
	private JPasswordField psw_passwordField;

	// Botones
	private JButton btnAsignarHabitacion;
	private JButton btnConsultarPaciente;
	private JButton btnDesasignarHabitacion;

	private JButton btnListarHabitacionesVacas;
	private JButton btnCantidadDePacientes;
	private JButton btnIngresarPaciente;

	private JButton btnAtenderPaciente;
	private JButton btnCantidaDePacientes;
	private JLabel aH_lblDni;
	private JLabel aH_aH_lblObraSocial;
	private JLabel aH_lblFechaDeNacimiento;
	private JTextField aH_textFieldDNI;
	private JTextField aH_textFieldObraSocial;
	private JLabel aH_lblHabitacin;
	private JTextField aH_txtDia;
	private JTextField aH_txtMes;
	private JTextField aH_txtAo;
	private JPanel DesasignarHabitacion;
	private JLabel DH_lblDNI;
	private JTextField DH_txtFieldDNI;
	private JPanel CantPacEnHab;
	private JLabel PacEnHab_labelHabitacion;
	private JTextField cp_txtDNI;
	private JPanel ingresarPaciente;
	private JLabel iP_lblDNI;
	private JTextField iP_txtDNI;
	private JButton iP_btnIngresar;

	/**
	 * Iniciar la aplicación
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmProyecto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea la aplicacíon
	 */
	public GUI() {
		initialize();
		disableButtons();
	}

	/**
	 * Inicializa el contenido del frame
	 */
	private void initialize() {
		frmProyecto = new JFrame();
		frmProyecto.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmProyecto.setResizable(false);
		frmProyecto.setTitle("Proyecto ED");
		frmProyecto.setBounds(100, 100, 914, 698);
		frmProyecto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel generalPanel = new JPanel();
		generalPanel.setBounds(10, 11, 697, 640);
		generalPanel.setBorder(new LineBorder(new Color(64, 64, 64), 2, true));
		CardLayout cards = new CardLayout(0, 0);
		generalPanel.setLayout(cards);

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBounds(717, 11, 171, 640);
		buttonsPanel.setBackground(Color.LIGHT_GRAY);
		buttonsPanel.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		buttonsPanel.setLayout(new GridLayout(0, 1, 0, 10));

		btnAsignarHabitacion = new JButton("<html> <p> Asignar Habitaci\u00F3n </p> </html>");
		btnAsignarHabitacion.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAsignarHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cards.show(generalPanel, "name_600919357555800");
			}
		});
		buttonsPanel.add(btnAsignarHabitacion);

		btnConsultarPaciente = new JButton("<html><p> Consultar Datos de un Paciente</p></html>");
		btnConsultarPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cards.show(generalPanel, "name_600927386110000");
			}
		});
		
				btnDesasignarHabitacion = new JButton("<html> <p> Desasignar Habitaci\u00F3n</html> </p> ");
				btnDesasignarHabitacion.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnDesasignarHabitacion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cards.show(generalPanel, "name_74609805959000");
					}
				});
				buttonsPanel.add(btnDesasignarHabitacion);
		buttonsPanel.add(btnConsultarPaciente);
		
				btnCantidadDePacientes = new JButton("<html> <p> Cantidad de Pacientes en Habitaci\u00F3n</html> </p> ");
				btnCantidadDePacientes.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cards.show(generalPanel, "name_84307667011500");
					}
				});
				btnCantidadDePacientes.setToolTipText("");
				btnCantidadDePacientes.setFont(new Font("Tahoma", Font.BOLD, 11));
				buttonsPanel.add(btnCantidadDePacientes);
		frmProyecto.getContentPane().setLayout(null);
		frmProyecto.getContentPane().add(generalPanel);

		JPanel password = new JPanel();
		generalPanel.add(password, "name_601039540173200");
		password.setLayout(null);

		JLabel psw_lblpass = new JLabel("Ingresar Contrase\u00F1a");
		psw_lblpass.setFont(new Font("Tahoma", Font.BOLD, 14));
		psw_lblpass.setBounds(260, 71, 149, 30);
		password.add(psw_lblpass);

		JLabel psw_lblesCorrecta = new JLabel("Contrase\u00F1a Incorrecta!");
		psw_lblesCorrecta.setForeground(Color.RED);
		psw_lblesCorrecta.setHorizontalAlignment(SwingConstants.CENTER);
		psw_lblesCorrecta.setFont(new Font("Tahoma", Font.BOLD, 14));
		psw_lblesCorrecta.setBounds(260, 164, 162, 30);
		psw_lblesCorrecta.setVisible(false);
		password.add(psw_lblesCorrecta);

		psw_passwordField = new JPasswordField();

		psw_passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ps = e.getActionCommand();
				if (logic.validarContraseña(ps)) {
					enableButtons();
					psw_lblesCorrecta.setText("Contraseña Correcta!");
					psw_lblesCorrecta.setForeground(Color.GREEN);
					psw_lblesCorrecta.setVisible(true);
				} else {
					psw_lblesCorrecta.setText("Contraseña Inorrecta!");
					psw_lblesCorrecta.setForeground(Color.RED);
					psw_lblesCorrecta.setVisible(true);
					psw_passwordField.setText("");
					disableButtons();
				}
			}
		});
		psw_passwordField.setBounds(234, 112, 212, 30);
		password.add(psw_passwordField);

		JPanel asignarHabitacion = new JPanel();
		generalPanel.add(asignarHabitacion, "name_600919357555800");
		asignarHabitacion.setLayout(null);

		aH_lblDni = new JLabel("DNI");
		aH_lblDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		aH_lblDni.setBounds(97, 103, 35, 17);
		asignarHabitacion.add(aH_lblDni);

		aH_aH_lblObraSocial = new JLabel("Obra Social");
		aH_aH_lblObraSocial.setFont(new Font("Tahoma", Font.BOLD, 14));
		aH_aH_lblObraSocial.setBounds(97, 131, 86, 24);
		asignarHabitacion.add(aH_aH_lblObraSocial);

		aH_lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		aH_lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.BOLD, 14));
		aH_lblFechaDeNacimiento.setBounds(97, 166, 153, 24);
		asignarHabitacion.add(aH_lblFechaDeNacimiento);

		aH_textFieldDNI = new JTextField();
		
		/**
		 * Inicializa y guarda variable del oyente porque se usará en otros paneles
		 */
		KeyAdapter oyenteSoloDigitos = null;
		aH_textFieldDNI.addKeyListener(oyenteSoloDigitos = new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					e.consume();
				}
			}
		});
		aH_textFieldDNI.setBounds(255, 103, 170, 20);
		asignarHabitacion.add(aH_textFieldDNI);
		aH_textFieldDNI.setColumns(10);

		aH_textFieldObraSocial = new JTextField();
		aH_textFieldObraSocial.setColumns(10);
		aH_textFieldObraSocial.setBounds(255, 135, 170, 20);
		asignarHabitacion.add(aH_textFieldObraSocial);

		aH_lblHabitacin = new JLabel("Habitaci\u00F3n");
		aH_lblHabitacin.setFont(new Font("Tahoma", Font.BOLD, 14));
		aH_lblHabitacin.setBounds(97, 231, 86, 24);
		asignarHabitacion.add(aH_lblHabitacin);

		JComboBox aH_comboBoxHabitacion = new JComboBox();
		aH_comboBoxHabitacion.setBounds(265, 234, 50, 22);
		aH_comboBoxHabitacion.addItem('A');
		aH_comboBoxHabitacion.addItem('B');
		aH_comboBoxHabitacion.addItem('C');
		aH_comboBoxHabitacion.addItem('D');
		aH_comboBoxHabitacion.addItem('E');
		aH_comboBoxHabitacion.addItem('F');
		aH_comboBoxHabitacion.addItem('G');
		aH_comboBoxHabitacion.addItem('H');
		aH_comboBoxHabitacion.addItem('I');
		aH_comboBoxHabitacion.addItem('J');

		asignarHabitacion.add(aH_comboBoxHabitacion);

		JButton aH_btnIngresar = new JButton("Ingresar");
		
		/**
		 * Al clickear "Ingresar" primero se verifica que todos los campos esten
		 * correctos Luego se llama al metodo asignarHabitacion de la clase logica este
		 * metodo puede lanzar una excepcion (DateTimeException) al crear un paciente
		 * con una fecha incorrecta. Desde la GUI capturo esa excepcion y envio una
		 * alertqa de que la fecha ha sido mal ingresada Luego de ingresar al paciente,
		 * borro los elemetos de los textFields -------------------------------------
		 * CHECKEAR ------------------------------------- Que pasa cuando ingresan un
		 * paciente y ya existe un paciente con ese dni?
		 * 
		 */
		aH_btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (aH_textFieldDNI.getText().isEmpty() || aH_textFieldObraSocial.getText().isEmpty()
						|| aH_txtDia.getText().isEmpty() || aH_txtMes.getText().isEmpty()
						|| aH_txtAo.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Algun campo es incorrecto");
				else {
					try {
						logic.asignarHabitacion(aH_textFieldDNI.getText(), aH_textFieldObraSocial.getText(),
								aH_txtDia.getText(), aH_txtMes.getText(), aH_txtAo.getText(),
								aH_comboBoxHabitacion.getSelectedItem().toString().charAt(0));
						JOptionPane.showMessageDialog(null,
								logic.consultaPaciente(Integer.valueOf(aH_textFieldDNI.getText())));
					} catch (java.time.DateTimeException argument) {
						JOptionPane.showMessageDialog(null, "Fecha mal ingresada. Reintentar.");
					}
					aH_textFieldDNI.setText("");
					aH_textFieldObraSocial.setText("");
					aH_txtDia.setText("");
					aH_txtMes.setText("");
					aH_txtAo.setText("");
					aH_comboBoxHabitacion.setSelectedIndex(0);
				}
			}
		});
		aH_btnIngresar.setBounds(252, 416, 145, 24);
		asignarHabitacion.add(aH_btnIngresar);

		aH_txtDia = new JTextField();
		aH_txtDia.setColumns(10);
		aH_txtDia.setBounds(255, 170, 50, 20);
		asignarHabitacion.add(aH_txtDia);

		aH_txtMes = new JTextField();
		aH_txtMes.setColumns(10);
		aH_txtMes.setBounds(315, 170, 50, 20);
		asignarHabitacion.add(aH_txtMes);

		aH_txtAo = new JTextField();
		aH_txtAo.setColumns(10);
		aH_txtAo.setBounds(375, 170, 50, 20);
		asignarHabitacion.add(aH_txtAo);

		JLabel aH_lbldaMesAo = new JLabel("(D\u00EDa, Mes, A\u00F1o)");
		aH_lbldaMesAo.setForeground(Color.GRAY);
		aH_lbldaMesAo.setFont(new Font("Tahoma", Font.BOLD, 12));
		aH_lbldaMesAo.setBounds(97, 192, 153, 17);
		asignarHabitacion.add(aH_lbldaMesAo);

		/**
		 * Setea oyente anteriormente creado (aH_textFieldDNI)
		 */
		aH_txtDia.addKeyListener(oyenteSoloDigitos);

		aH_txtMes.addKeyListener(oyenteSoloDigitos);

		aH_txtAo.addKeyListener(oyenteSoloDigitos);

		JPanel consultarPaciente = new JPanel();
		generalPanel.add(consultarPaciente, "name_600927386110000");
		consultarPaciente.setLayout(null);

		JLabel label = new JLabel("DNI");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(97, 103, 35, 17);
		consultarPaciente.add(label);

		cp_txtDNI = new JTextField();
		cp_txtDNI.addKeyListener(oyenteSoloDigitos);
		cp_txtDNI.setColumns(10);
		cp_txtDNI.setBounds(255, 103, 170, 20);
		consultarPaciente.add(cp_txtDNI);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cp_txtDNI.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Introduzca un DNI");
				else {
					try {
						String data = logic.consultaPaciente(Integer.valueOf(cp_txtDNI.getText()));
						JOptionPane.showMessageDialog(null, "Paciente: " + data);
					} catch (NullPointerException argument0) {
						JOptionPane.showMessageDialog(null, "No se ha encontrado paciente con dni " + cp_txtDNI.getText());
					}
					cp_txtDNI.setText("");
				}
			}
		});
		btnConsultar.setBounds(255, 157, 89, 23);
		consultarPaciente.add(btnConsultar);

		DesasignarHabitacion = new JPanel();
		generalPanel.add(DesasignarHabitacion, "name_74609805959000");
		DesasignarHabitacion.setLayout(null);

		DH_lblDNI = new JLabel("DNI");
		DH_lblDNI.setBounds(97, 103, 35, 17);
		DH_lblDNI.setFont(new Font("Tahoma", Font.BOLD, 14));
		DesasignarHabitacion.add(DH_lblDNI);

		DH_txtFieldDNI = new JTextField();
		DH_txtFieldDNI.setColumns(10);
		DH_txtFieldDNI.setBounds(255, 103, 170, 20);
		
		/**
		 * Seteo de oyente al creado anteriormente (aH_textFieldDNI)
		 */
		DH_txtFieldDNI.addKeyListener(oyenteSoloDigitos);
		DesasignarHabitacion.add(DH_txtFieldDNI);

		JButton DH_btnAlta = new JButton("Alta");
		DH_btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (DH_txtFieldDNI.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Introduzca un DNI");
				else {
					try {
						String data = logic.consultaPaciente(Integer.valueOf(DH_txtFieldDNI.getText()));
						logic.desasignarHabitacion(Integer.valueOf(DH_txtFieldDNI.getText()));
						JOptionPane.showMessageDialog(null, "Paciente dado de Alta: " + data);
					} catch (NullPointerException argument0) {
						JOptionPane.showMessageDialog(null, "No se ha encontrado paciente con dni " + cp_txtDNI.getText());
					}
					DH_txtFieldDNI.setText("");
				}
			}
		});
		DH_btnAlta.setBounds(255, 157, 145, 24);
		DesasignarHabitacion.add(DH_btnAlta);

		CantPacEnHab = new JPanel();
		generalPanel.add(CantPacEnHab, "name_84307667011500");
		CantPacEnHab.setLayout(null);

		PacEnHab_labelHabitacion = new JLabel("Seleccionar habitaci\u00F3n");
		PacEnHab_labelHabitacion.setBounds(97, 103, 180, 17);
		PacEnHab_labelHabitacion.setFont(new Font("Tahoma", Font.BOLD, 14));
		CantPacEnHab.add(PacEnHab_labelHabitacion);

		JComboBox PacEnHab_comboBoxHabitaciones = new JComboBox();
		PacEnHab_comboBoxHabitaciones.setBounds(310, 102, 50, 22);
		PacEnHab_comboBoxHabitaciones.addItem('A');
		PacEnHab_comboBoxHabitaciones.addItem('B');
		PacEnHab_comboBoxHabitaciones.addItem('C');
		PacEnHab_comboBoxHabitaciones.addItem('D');
		PacEnHab_comboBoxHabitaciones.addItem('E');
		PacEnHab_comboBoxHabitaciones.addItem('F');
		PacEnHab_comboBoxHabitaciones.addItem('G');
		PacEnHab_comboBoxHabitaciones.addItem('H');
		PacEnHab_comboBoxHabitaciones.addItem('I');
		PacEnHab_comboBoxHabitaciones.addItem('J');

		CantPacEnHab.add(PacEnHab_comboBoxHabitaciones);

		JButton PacEnHab_btnConsultar = new JButton("Consultar");
		PacEnHab_btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Cantidad de pacientes en habitación " + PacEnHab_comboBoxHabitaciones.getSelectedItem() + ": "
								+ logic.cantidadPacientesHabitacion(
										PacEnHab_comboBoxHabitaciones.getSelectedItem().toString().charAt(0)));

				PacEnHab_comboBoxHabitaciones.setSelectedIndex(0);
			}
		});
		PacEnHab_btnConsultar.setBounds(255, 157, 145, 24);
		CantPacEnHab.add(PacEnHab_btnConsultar);
		
		ingresarPaciente = new JPanel();
		generalPanel.add(ingresarPaciente, "name_167634319964600");
		ingresarPaciente.setLayout(null);
		
		iP_lblDNI = new JLabel("DNI");
		iP_lblDNI.setBounds(97, 103, 35, 17);
		iP_lblDNI.setFont(new Font("Tahoma", Font.BOLD, 14));
		ingresarPaciente.add(iP_lblDNI);
		
		iP_txtDNI = new JTextField();
		iP_txtDNI.addKeyListener(oyenteSoloDigitos);
		iP_txtDNI.setColumns(10);
		iP_txtDNI.setBounds(255, 103, 170, 20);
		ingresarPaciente.add(iP_txtDNI);
		
		JComboBox iP_comboBoxNivel = new JComboBox();
		iP_comboBoxNivel.setBounds(255, 178, 35, 20);
		iP_comboBoxNivel.addItem(1);
		iP_comboBoxNivel.addItem(2);
		iP_comboBoxNivel.addItem(3);
		iP_comboBoxNivel.addItem(4);
		iP_comboBoxNivel.addItem(5);
		ingresarPaciente.add(iP_comboBoxNivel);
		
		JLabel iP_lblNivel = new JLabel("Nivel de urgencia");
		iP_lblNivel.setFont(new Font("Tahoma", Font.BOLD, 14));
		iP_lblNivel.setBounds(97, 178, 127, 17);
		ingresarPaciente.add(iP_lblNivel);
		
		iP_btnIngresar = new JButton("Ingresar");
		iP_btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(iP_txtDNI.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Ingrese un DNI");
				else {
					logic.ingresarPaciente(Integer.valueOf(iP_txtDNI.getText()), Integer.valueOf(iP_comboBoxNivel.getSelectedItem().toString()));
					JOptionPane.showMessageDialog(null, "Paciente ingresado correctamente");
				}
				iP_txtDNI.setText("");
			}
		});
		iP_btnIngresar.setBounds(255, 292, 145, 24);
		ingresarPaciente.add(iP_btnIngresar);
		frmProyecto.getContentPane().add(buttonsPanel);

		btnIngresarPaciente = new JButton("<html> <p> Ingresar Paciente</html> </p> ");
		btnIngresarPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIngresarPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			cards.show(generalPanel, "name_167634319964600");
			}
		});
		buttonsPanel.add(btnIngresarPaciente);
		
				btnListarHabitacionesVacas = new JButton("<html> <p> Listar Habitaciones Vac\u00EDas</html> </p> ");
				btnListarHabitacionesVacas.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnListarHabitacionesVacas.addActionListener(new ActionListener() {
					/**
					 * 
					 */
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Habitaciones vacias: "+logic.habitacionesVacias());
					}
				});
				
						btnAtenderPaciente = new JButton("<html> <p> Atender Paciente</html> </p> ");
						btnAtenderPaciente.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								int aux = logic.atenderPaciente();
								if(aux == -1)
									JOptionPane.showMessageDialog(null, "No hay pacientes para atender");
								else {
									JOptionPane.showMessageDialog(null, "Paciente con dni "+aux+" ha sido atendido con éxito");
								}
							}
						});
						btnAtenderPaciente.setFont(new Font("Tahoma", Font.BOLD, 11));
						buttonsPanel.add(btnAtenderPaciente);
				buttonsPanel.add(btnListarHabitacionesVacas);

		btnCantidaDePacientes = new JButton("<html> <p> Cantidad de Pacientes en Urgencias</html> </p> ");
		btnCantidaDePacientes.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCantidaDePacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Cantidad de pacientes en Urgencias: "+logic.cantidadPacientesUrgencias());
			}
			
		});
		buttonsPanel.add(btnCantidaDePacientes);

	}

	public void disableButtons() {
		btnAsignarHabitacion.setEnabled(false);
		btnConsultarPaciente.setEnabled(false);
		btnDesasignarHabitacion.setEnabled(false);
		btnListarHabitacionesVacas.setEnabled(false);
		btnCantidadDePacientes.setEnabled(false);
		btnIngresarPaciente.setEnabled(false);
		btnAtenderPaciente.setEnabled(false);
		btnCantidaDePacientes.setEnabled(false);
	}

	public void enableButtons() {
		btnAsignarHabitacion.setEnabled(true);
		btnConsultarPaciente.setEnabled(true);
		btnDesasignarHabitacion.setEnabled(true);
		btnListarHabitacionesVacas.setEnabled(true);
		btnCantidadDePacientes.setEnabled(true);
		btnIngresarPaciente.setEnabled(true);
		btnAtenderPaciente.setEnabled(true);
		btnCantidaDePacientes.setEnabled(true);
	}
}