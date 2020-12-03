package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PanelCuentaNueva extends PanelGenerico {
		
		JLabel labelNombre;
		JLabel labelApellido;
		JLabel labelCorreo;
		JLabel labelContrase�a;
		JLabel labelPais;
		JLabel labelProvincia;
		JLabel labelLocalidad;
		JTextField campoNombre;
		JTextField campoApellido;
		JTextField campoCorreo;
		JPasswordField campoContrase�a;
		JComboBox<String> comboPais;
		JComboBox<String> comboProvincia;
		JComboBox<String> comboLocalidad;
		JButton buttonCancelar;
		JButton buttonAceptar;
		
		public PanelCuentaNueva() {
			super();
			inicializarComponentes();
			armarPanel();
			}
		
		

		private void inicializarComponentes() {
			//Labels
			labelNombre= new JLabel("<HTML><B>Nombre:</B></HTML>");
			labelApellido= new JLabel("<HTML><B>Apellido:</B></HTML>");
			labelCorreo= new JLabel("<HTML><B>Correo <br> Electr�nico:</B></HTML>");
			labelContrase�a= new JLabel("<HTML><B>Contrase�a:</B></HTML>");
			labelPais= new JLabel("<HTML><B>Pais:</B></HTML>");
			labelProvincia= new JLabel("<HTML><B>Provincia:</B></HTML>");
			labelLocalidad= new JLabel("<HTML><B>Localidad</B></HTML>");
			//Buttons
			buttonCancelar = new JButton("Cancelar");
			buttonAceptar = new JButton("Aceptar");
			buttonCancelar.setPreferredSize(new Dimension(100,30));
			buttonAceptar.setPreferredSize(new Dimension(120,30));
			//Color buttons
			buttonCancelar.setBackground(Color.decode("#112349"));
			buttonCancelar.setForeground(Color.white);
			buttonAceptar.setBackground(Color.decode("#112349"));
			buttonAceptar.setForeground(Color.white);
			//Campos
			campoNombre = new JTextField(10);
			campoApellido = new JTextField(10);
			campoCorreo = new JTextField(10);
			campoContrase�a = new JPasswordField(10);
			//Combos
			comboPais = new JComboBox<String>();
			comboProvincia = new JComboBox<String>();
			comboLocalidad = new JComboBox<String>();
			comboPais.addItem("<Ninguno>");
			comboProvincia.addItem("<Ninguna>");
			comboLocalidad.addItem("<Ninguna>");
		}



		private void armarPanel() {
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.anchor= GridBagConstraints.WEST;
			gbc.fill=GridBagConstraints.BOTH;
			gbc.insets= new Insets(0,10,10,0);
			this.setLayout(new GridBagLayout());
			gbc.gridx=0;
			gbc.gridy=0;
			this.add(labelNombre,gbc);
			gbc.gridy++;
			this.add(labelApellido,gbc);
			gbc.gridy++;
			this.add(labelCorreo,gbc);
			gbc.gridy++;
			this.add(labelContrase�a,gbc);
			gbc.gridy++;
			this.add(labelPais,gbc);
			gbc.gridy++;
			this.add(labelProvincia,gbc);
			gbc.gridy++;
			this.add(labelLocalidad,gbc);
			gbc.gridy++;
			this.add(buttonCancelar,gbc);
			gbc.gridx=1;
			gbc.gridy=0;
			this.add(campoNombre,gbc);
			gbc.gridy++;
			this.add(campoApellido,gbc);
			gbc.gridy++;
			this.add(campoCorreo,gbc);
			gbc.gridy++;
			this.add(campoContrase�a,gbc);
			gbc.gridy++;
			this.add(comboPais,gbc);
			gbc.gridy++;
			this.add(comboProvincia,gbc);
			gbc.gridy++;
			this.add(comboLocalidad,gbc);	
			gbc.gridy++;
			this.add(buttonAceptar,gbc);
		}
		
		
}
