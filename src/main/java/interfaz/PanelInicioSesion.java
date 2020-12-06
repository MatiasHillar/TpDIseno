package interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import acceso.UsuarioDAOimpl;
import logica.GestorUsuario;


public class PanelInicioSesion extends PanelGenerico{
	JLabel labelTitulo;
	JLabel labelEmail;
	JLabel labelContrase�a;
	ButtonGenerico buttonCancelar;
	ButtonGenerico buttonIniciar;
	JTextField campoEmail;
	JPasswordField campoContrase�a;
	
	public PanelInicioSesion() {
		super();
		inicializarComponentes();
		armarPanel();
	}

	private void inicializarComponentes() {
		//Labels
		labelTitulo = new JLabel("<HTML><B> <font color='white'> <font size = 3> INICIO DE SESI�N</B></HTML>");
		labelEmail = new JLabel("<HTML><B>Correo <br> Electr�nico:</B></HTML>");
		labelContrase�a = new JLabel("<HTML><B>Contrase�a:</B></HTML> ");
		//Buttons
		buttonCancelar = new ButtonGenerico("Cancelar");
		buttonIniciar = new ButtonGenerico("Iniciar Sesi�n");
		buttonCancelar.setPreferredSize(new Dimension(120,30));
		buttonIniciar.setPreferredSize(new Dimension(120,30));
		
		//Color Buttons
		buttonCancelar.setBackground(colorFondoBoton);
		buttonCancelar.setForeground(colorTextoBoton);
		buttonIniciar.setBackground(colorFondoBoton);
		buttonIniciar.setForeground(colorTextoBoton);
		
		//Campos
		campoEmail = new JTextField(10);
		campoContrase�a = new JPasswordField(10);
		//Listeners
		ActionListener iniciarSesionListener = new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	JFrame ventana = ((JFrame) SwingUtilities.getWindowAncestor(((JButton) e.getSource()).getParent()));
		            	String resultado;
		            	resultado = GestorUsuario.autenticarUsuario(campoEmail.getText().trim(),String.valueOf(campoContrase�a.getPassword()));
		        		JOptionPane pane =new JOptionPane(resultado, 
		                JOptionPane.PLAIN_MESSAGE ,JOptionPane.DEFAULT_OPTION);
		        		JDialog dialogInicio;
		        		 getComponents(pane);
		                 pane.setBackground(Color.decode("#2148bc"));
		                 dialogInicio = pane.createDialog(ventana, "Autenticaci�n de Login");
		                 pane.setForeground(Color.white);
		                 dialogInicio.setVisible(true);
		            	if(resultado.equals("Inicio de sesion exitoso")) {
		            		ventana.setContentPane(new PanelPrincipal());
		            		ventana.setSize(tamPrincipal);
		            		ventana.setLocationRelativeTo(null);
		            		ventana.revalidate();
		            		ventana.repaint();}
		            	}
		        };
		 buttonIniciar.addActionListener(iniciarSesionListener);
		 ActionListener cancelarListener = new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	JFrame ventana = ((JFrame) SwingUtilities.getWindowAncestor(((JButton) e.getSource()).getParent()));
						ventana.setContentPane(new PanelPrincipal());
						ventana.setSize(tamPrincipal);
						ventana.setLocationRelativeTo(null);
						ventana.revalidate();
						ventana.repaint();
		            	}
		        };
		 buttonCancelar.addActionListener(cancelarListener);
	}

	private void armarPanel() {
		SpringLayout sLayout = new SpringLayout();
		this.setLayout(sLayout);
		this.add(labelTitulo);
		sLayout.putConstraint(SpringLayout.WEST,labelTitulo,95,SpringLayout.WEST,this);
		sLayout.putConstraint(SpringLayout.NORTH,labelTitulo,30,SpringLayout.NORTH,this);
		this.add(labelEmail);
		sLayout.putConstraint(SpringLayout.WEST,labelEmail,20,SpringLayout.WEST,this);
		sLayout.putConstraint(SpringLayout.NORTH,labelEmail,80,SpringLayout.NORTH,this);
		this.add(labelContrase�a);
		sLayout.putConstraint(SpringLayout.WEST,labelContrase�a,20,SpringLayout.WEST,this);
		sLayout.putConstraint(SpringLayout.NORTH,labelContrase�a,40,SpringLayout.SOUTH,labelEmail);
		this.add(campoEmail);
		sLayout.putConstraint(SpringLayout.WEST,campoEmail,40,SpringLayout.EAST,labelEmail);
		sLayout.putConstraint(SpringLayout.NORTH,campoEmail,90,SpringLayout.NORTH,this);
		this.add(campoContrase�a);
		sLayout.putConstraint(SpringLayout.WEST,campoContrase�a,0,SpringLayout.WEST,campoEmail);
		sLayout.putConstraint(SpringLayout.NORTH,campoContrase�a,30,SpringLayout.SOUTH,campoEmail);
		this.add(buttonCancelar);
		sLayout.putConstraint(SpringLayout.WEST,buttonCancelar,10,SpringLayout.WEST,this);
		sLayout.putConstraint(SpringLayout.NORTH,buttonCancelar,25,SpringLayout.SOUTH,campoContrase�a);
		this.add(buttonIniciar);
		sLayout.putConstraint(SpringLayout.EAST,buttonIniciar,-10,SpringLayout.EAST,this);
		sLayout.putConstraint(SpringLayout.NORTH,buttonIniciar,25,SpringLayout.SOUTH,campoContrase�a);
		
	}
	
}
