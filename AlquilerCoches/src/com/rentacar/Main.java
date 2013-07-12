package com.rentacar;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
/*
 * Implement a  Rent a Car control system. This system must have a menu:
 * Ingreso de Vehículos(add  a car) + Matricula del Vehículo(reg. number) +
 * Nombre de la Persona que Alquila(person  name) + Km actual del vehículo(INTEGER)
 * Buscar(search) + Los vehículos cuyo KM sea mayor a 20 y menor a 100(cars with 100km > KM > 20km)
 * Listar(list) +Todo los vehículos Ingresados(all the cars)
 * 
 * NOTA: Trabajar con un ingreso de 10 Vehículos, Los reportes de Buscar y
 * Listar deben ser en columnas, Ej.:
 * Matricula  KM  Persona
 * GHJ456     12  Julio Pérez
 */



/*
 * Main class is used to run application 
 * GUI is implemented with Swing
 */
public class Main extends JFrame {

	private static final long serialVersionUID = -8580747949672239286L;
	private JPanel contentPane;
	private JTextField matricula;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField km;
	private JTextField txtDesdeKm;
	private JTextField txtHastaKm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setResizable(false);
		setTitle("RENT A CAR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);

		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatricula.setBounds(0, 12, 79, 14);
		layeredPane.add(lblMatricula);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(83, 12, 115, 14);
		layeredPane.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellidos");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellido.setBounds(198, 12, 115, 14);
		layeredPane.add(lblApellido);

		JLabel lblKm = new JLabel("KM");
		lblKm.setHorizontalAlignment(SwingConstants.CENTER);
		lblKm.setBounds(320, 12, 54, 14);
		layeredPane.add(lblKm);

		matricula = new JTextField();
		matricula.setBounds(0, 31, 79, 18);
		layeredPane.add(matricula);
		matricula.setColumns(10);

		nombre = new JTextField();
		nombre.setBounds(83, 31, 115, 18);
		layeredPane.add(nombre);
		nombre.setColumns(10);

		apellido = new JTextField();
		apellido.setBounds(198, 31, 115, 18);
		layeredPane.add(apellido);
		apellido.setColumns(10);

		km = new JTextField();
		km.setBounds(320, 31, 54, 18);
		layeredPane.add(km);
		km.setColumns(10);

		// we add the car here clicking the button and
		// after being added we clean all the input fields 
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Coche(matricula.getText(), km.getText(), nombre.getText(),
						apellido.getText());
				matricula.setText("");
				km.setText("");
				nombre.setText("");
				apellido.setText("");
			}
		});
		btnIngresar.setBounds(378, 28, 104, 24);
		layeredPane.add(btnIngresar);

		JLabel lblBusquedaPorKm = new JLabel("Busqueda por km");
		lblBusquedaPorKm.setHorizontalAlignment(SwingConstants.CENTER);
		lblBusquedaPorKm.setBounds(0, 61, 148, 14);
		layeredPane.add(lblBusquedaPorKm);

		txtDesdeKm = new JTextField();
		txtDesdeKm.setBounds(0, 87, 68, 18);
		layeredPane.add(txtDesdeKm);
		txtDesdeKm.setColumns(10);

		txtHastaKm = new JTextField();
		txtHastaKm.setBounds(80, 87, 68, 18);
		layeredPane.add(txtHastaKm);
		txtHastaKm.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 117, 482, 146);
		layeredPane.add(scrollPane);

		final JTextArea textAreaBuscar = new JTextArea();
		textAreaBuscar.setEditable(false);
		scrollPane.setViewportView(textAreaBuscar);

		// we search the car according to the search parameters in input fields 
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaBuscar.setText("");
				textAreaBuscar.setText(Vehiculo.buscar(txtDesdeKm.getText(),
						txtHastaKm.getText()));
				txtDesdeKm.setText("");
				txtHastaKm.setText("");

			}
		});
		btnBuscar.setBounds(154, 84, 96, 24);
		layeredPane.add(btnBuscar);
        
		// we list all the cars that have been added to the list 
		JButton btnListarTodo = new JButton("Listar todo");
		btnListarTodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaBuscar.setText("");
				textAreaBuscar.setText(Vehiculo.listarTodo());
			}
		});
		btnListarTodo.setBounds(262, 84, 220, 24);
		layeredPane.add(btnListarTodo);

		JLabel lblDesdekm = new JLabel("desde");
		lblDesdekm.setBounds(12, 104, 55, 14);
		layeredPane.add(lblDesdekm);

		JLabel lblHasta = new JLabel("hasta");
		lblHasta.setBounds(100, 104, 55, 14);
		layeredPane.add(lblHasta);

	}
}
