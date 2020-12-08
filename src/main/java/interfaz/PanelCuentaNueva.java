package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import acceso.UsuarioDAOimpl;
import excepciones.UsuarioExistenteException;
import logica.GestorUsuario;
import logica.ProvinciaDTO;
import logica.Usuario;

public class PanelCuentaNueva extends PanelGenerico {
		
		JLabel labelNombre;
		JLabel labelApellido;
		JLabel labelCorreo;
		JLabel labelContrase�a;
		JLabel labelProvincia;
		JLabel labelLocalidad;
		JTextField campoNombre;
		JTextField campoApellido;
		JTextField campoCorreo;
		JPasswordField campoContrase�a;
		JComboBox<String> comboProvincia;
		JComboBox<String> comboLocalidad;
		JButton buttonCancelar;
		JButton buttonAceptar;
		ArrayList<ProvinciaDTO> dtosProvincia;
		public PanelCuentaNueva() {
			super();
			inicializarComponentes();
			armarPanel();
			}
		

		private void inicializarComponentes() {
			//Inicializo provincias
			dtosProvincia = GestorUsuario.obtenerProvincias();
			for(ProvinciaDTO pDto : dtosProvincia) {
				if(pDto.getNombre().equals( "Ciudad Aut�noma de Buenos Aires"))
					pDto.setNombre("CABA");
				if(pDto.getNombre().equals( "Tierra del Fuego, Ant�rtida e Islas del Atl�ntico Sur"))
					pDto.setNombre("Tierra del Fuego");
			}
			for(ProvinciaDTO pDto : dtosProvincia) {
				if(pDto.getNombre().equals( "Entre R�os"))
					System.out.println("LOL "+pDto.getLocalidades()[0]);
			}
			
			
			//Labels
			labelNombre= new JLabel("<HTML><B>Nombre:</B></HTML>");
			labelApellido= new JLabel("<HTML><B>Apellido:</B></HTML>");
			labelCorreo= new JLabel("<HTML><B>Correo <br> Electr�nico:</B></HTML>");
			labelContrase�a= new JLabel("<HTML><B>Contrase�a:</B></HTML>");
			labelProvincia= new JLabel("<HTML><B>Provincia:</B></HTML>");
			labelLocalidad= new JLabel("<HTML><B>Localidad</B></HTML>");
			
			//Buttons
			buttonCancelar = new JButton("Cancelar");
			buttonAceptar = new JButton("Aceptar");
			buttonCancelar.setPreferredSize(new Dimension(100,30));
			buttonAceptar.setPreferredSize(new Dimension(120,30));
			
			//Color buttons
			buttonCancelar.setBackground(colorFondoBoton);
			buttonCancelar.setForeground(colorTextoBoton);
			buttonAceptar.setBackground(colorFondoBoton);
			buttonAceptar.setForeground(colorTextoBoton);
			
			//Campos
			campoNombre = new JTextField(10);
			//campoNombre.setPreferredSize(new Dimension(175,30));
			campoApellido = new JTextField(10);
			//campoApellido.setPreferredSize(new Dimension(175,30));
			campoCorreo = new JTextField(10);
			//campoCorreo.setPreferredSize(new Dimension(175,30));
			campoContrase�a = new JPasswordField(10);
			//campoContrase�a.setsize(new Dimension(175,30));
			
			//Combos
			final ModeloComboModalidad modelo = new ModeloComboModalidad();
			modelo.insertElementAt("<Ninguna>",0);
			comboProvincia = new JComboBox<String>();
			comboLocalidad = new JComboBox<String>(modelo);

			comboProvincia.setPreferredSize(new Dimension(125,30));
			comboProvincia.addItem("<Ninguna>");
			for(ProvinciaDTO pDto : dtosProvincia) {
				comboProvincia.addItem(pDto.getNombre());
			}
			comboLocalidad.setPreferredSize(new Dimension(125,30));
			comboProvincia.setSelectedIndex(0);
			comboLocalidad.setSelectedIndex(0);
			
			//Listeners
			ActionListener cancelarListener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame ventana = ((JFrame) SwingUtilities.getWindowAncestor(((JButton) e.getSource()).getParent()));
					ventana.setContentPane(new PanelPrincipal());
					ventana.setSize(PanelGenerico.tamPrincipal);
					ventana.setLocationRelativeTo(null);
					ventana.revalidate();
					ventana.repaint();
				}
			}; 
			buttonCancelar.addActionListener(cancelarListener);
			ActionListener cuentaNuevaListener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame ventana = ((JFrame) SwingUtilities.getWindowAncestor(((JButton) e.getSource()).getParent()));
					String respuesta = "";
					respuesta=GestorUsuario.registrarUsuario(comboProvincia.getSelectedItem().toString(),comboLocalidad.getSelectedItem().toString()
							,campoNombre.getText(),campoApellido.getText(),campoCorreo.getText(),String.valueOf(campoContrase�a.getPassword()));
					JOptionPane.showMessageDialog(ventana,respuesta);
					
				}
			};
			buttonAceptar.addActionListener(cuentaNuevaListener);
			
			ActionListener localidadListener = new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	modelo.removeAllElements();
	                String mod = (String) comboLocalidad.getSelectedItem();
	                if (mod=="<Ninguna>") {
	                	modelo.removeAllElements();
	                	modelo.insertElementAt("<Ninguna>",0);
	                	comboLocalidad.setSelectedIndex(0);
	                }
	                else {
	                	modelo.insertElementAt("<Ninguna>",0);
	                	for(ProvinciaDTO pDto : dtosProvincia) {
	                		if(pDto.getNombre().equals(comboProvincia.getSelectedItem())) {
	                			for(int i=1;i<pDto.getLocalidades().length;i++) {
	                				modelo.insertElementAt(pDto.getLocalidades()[i],i);
	                			}
	                		}
	                	}
	                	comboLocalidad.setSelectedIndex(0);
	                	}
	                }
	            
	        };
	        comboProvincia.addActionListener(localidadListener);
		}
		
		private void armarPanel() {
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.anchor= GridBagConstraints.WEST;
			gbc.fill=GridBagConstraints.VERTICAL;
			gbc.insets= new Insets(0,10,10,0);
			this.setLayout(new GridBagLayout());
			gbc.gridx=0;
			gbc.gridy=0;
			gbc.weightx=0.5;
			this.add(labelNombre,gbc);
			gbc.gridy++;
			this.add(labelApellido,gbc);
			gbc.gridy++;
			this.add(labelCorreo,gbc);
			gbc.gridy++;
			this.add(labelContrase�a,gbc);
			gbc.gridy++;
			this.add(labelProvincia,gbc);
			gbc.gridy++;
			this.add(labelLocalidad,gbc);
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
			this.add(comboProvincia,gbc);
			gbc.gridy++;
			this.add(comboLocalidad,gbc);
			gbc.anchor= GridBagConstraints.LINE_END;
			gbc.fill=GridBagConstraints.NONE;
			gbc.insets= new Insets(0,0,10,0);
			gbc.gridy++;
			gbc.gridx--;
			this.add(buttonCancelar,gbc);
			gbc.anchor= GridBagConstraints.CENTER;
			gbc.gridx++;
			this.add(buttonAceptar,gbc);
		}
		
		
}
