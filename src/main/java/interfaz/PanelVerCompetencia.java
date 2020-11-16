package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.plaf.basic.BasicArrowButton;



public class PanelVerCompetencia extends JFrame {
	//Componentes Swing
	JLabel labelDatosComp;
	JLabel labelNombreC;
	JLabel campoNombre;
	JLabel labelMod;
	JLabel campoMod;
	JLabel labelDeporte;
	JLabel campoDeporte;
	JLabel labelEstado;
	JLabel campoEstado;
	JLabel labelProxEnc;
	JLabel labelParticipantes;
	JLabel labelPaginador;
	JButton botonModComp;
	JButton botonElimComp;
	JButton botonMostrarFixture;
	JButton botonMostrarTabla;
	JButton botonGenFixture;
	JButton botonVerPartic;
	JButton botonCancelar;
	BasicArrowButton botonPagIzq;
	BasicArrowButton botonPagDer;
	JPanel panel;
	JPanel panelIzq;
	JPanel panelDer;
	JTable tablaEncuentros;
	JTable tablaParticipantes;
	JSplitPane splitHorizontal;
	JScrollPane scrollPaneParticipantes;
	//Variables
	ArrayList<String> columnasTablaEncuentros;
	Integer paginaSeleccionada;
	public PanelVerCompetencia(boolean modal) {
		super();
		inicializarComponentes();
		armarPanel();
		this.setContentPane(panel);
		this.setSize(1024,720);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
	}
	private void inicializarComponentes() {
		//VARIABLES
		paginaSeleccionada = 1;
		//LABELS
		labelDatosComp = new JLabel("<HTML><B><U>Datos de la competencia: </U></B></HTML>");
		labelNombreC = new JLabel("<HTML><B><U>Nombre: </U></B></HTML> ");
		labelMod = new JLabel("<HTML><B><U>Modalidad: </U></B></HTML>");
		labelDeporte = new JLabel("<HTML><B><U>Deporte: </U></B></HTML>");
		labelEstado = new JLabel("<HTML><B><U>Estado de la <br> Competencia: </U></B></HTML>");
		labelProxEnc = new JLabel("<HTML><B><U>Proximos encuentros: </U></B></HTML> ");
		labelParticipantes = new JLabel("<HTML><B><U>Participantes: </U></B></HTML> ");
		campoNombre = new JLabel("NOMBRE COMPE");
		campoMod = new JLabel("LA MODALIDAD");
		campoDeporte =  new JLabel("EL DEPORTE");
		campoEstado = new JLabel("EL ESTADO");
		labelPaginador = new JLabel("<HTML> <B> PAGINA "+ (paginaSeleccionada)+"</B> </HTML>");
		//BUTTONS
		 botonModComp = new JButton("Modificar Competencia");
		 botonElimComp = new JButton("Eliminar Competencia");
		 botonMostrarFixture = new JButton("Mostrar Fixture");
		 botonMostrarTabla = new JButton("Mostrar Tabla de Posiciones");
		 botonGenFixture = new JButton("Generar Fixture");
		 botonVerPartic = new JButton("Ver Participantes");
		 botonCancelar = new JButton("Cancelar");
		 botonModComp.setPreferredSize(new Dimension(300,30));
		 botonElimComp.setPreferredSize(new Dimension(300,30));
		 botonMostrarFixture.setPreferredSize(new Dimension(300,30));
		 botonMostrarTabla.setPreferredSize(new Dimension(300,30));
		 botonGenFixture.setPreferredSize(new Dimension(300,30));
		 botonVerPartic.setPreferredSize(new Dimension(300,30));
		 botonCancelar.setPreferredSize(new Dimension(150,50));
		 botonPagIzq = new BasicArrowButton(BasicArrowButton.WEST);
		 botonPagDer = new BasicArrowButton(BasicArrowButton.EAST);
		 //TABLAS
		 tablaEncuentros = new JTable(3,3);
		 tablaEncuentros.setPreferredSize(new Dimension(270,210));
		 tablaParticipantes = new JTable(3,3);
		 tablaParticipantes.setSize(70,140);
		 scrollPaneParticipantes = new JScrollPane(tablaParticipantes);
		 scrollPaneParticipantes.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  
		 scrollPaneParticipantes.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		 scrollPaneParticipantes.setPreferredSize(new Dimension(300,200));
		 //SPLITS
		 splitHorizontal= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		 splitHorizontal.setLeftComponent(panelIzq);
		 splitHorizontal.setRightComponent(panelDer);
		 splitHorizontal.setPreferredSize(new Dimension(1000,600));
		 splitHorizontal.setOneTouchExpandable(false);
		 splitHorizontal.setResizeWeight(0.2);      
		 splitHorizontal.setEnabled(false);
		 
		 //ACTION LISTENERS
		 ActionListener pagDerListener = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					paginaSeleccionada++;
					labelPaginador.setText("<HTML> <B> PAGINA "+ (paginaSeleccionada)+"</B> </HTML>");
					System.out.println("Pagina es "+paginaSeleccionada);
				}
			};
			botonPagDer.addActionListener(pagDerListener);
			
		 ActionListener pagIzqListener = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(paginaSeleccionada!=1) {
					paginaSeleccionada--;
					labelPaginador.setText("<HTML> <B> PAGINA "+ (paginaSeleccionada)+"</B> </HTML>");}
					else {
						//Ver si ponemos una excepcion o JDialog
						System.out.println("LO ESTAS ROMPIENDO");
					}
				}
			};
			botonPagIzq.addActionListener(pagIzqListener);
			 construirTablaEncuentros(setearColumnasEncuentros(),obtenerMatrizDatosEncuentros());
	}
	private void armarPanel() {
		panel = new JPanel();
		this.add(panel,BorderLayout.CENTER);
		SpringLayout layout = new SpringLayout();
		panel.setLayout(layout);
		panel.add(splitHorizontal);
		layout.putConstraint(SpringLayout.WEST,splitHorizontal,5,SpringLayout.WEST,panel);
		layout.putConstraint(SpringLayout.NORTH,splitHorizontal,10,SpringLayout.NORTH,panel);
		panelIzq = new JPanel();
		panelDer = new JPanel();
		splitHorizontal.setLeftComponent(panelIzq);
		splitHorizontal.setRightComponent(panelDer);
		panelIzq.setPreferredSize(new Dimension(580,290));
		panelDer.setPreferredSize(new Dimension(380,290));
		
		armarPanelIzq();
		armarPanelDer();
		
	}
	private void armarPanelIzq() {
		SpringLayout sLayout = new SpringLayout();
		panelIzq.setLayout(sLayout);
		panelIzq.add(labelDatosComp);
		sLayout.putConstraint(SpringLayout.WEST,labelDatosComp,25,SpringLayout.WEST,panelIzq);
		sLayout.putConstraint(SpringLayout.NORTH,labelDatosComp,30,SpringLayout.NORTH,panelIzq);
		panelIzq.add(labelNombreC);
		sLayout.putConstraint(SpringLayout.WEST,labelNombreC,25,SpringLayout.WEST,panelIzq);
		sLayout.putConstraint(SpringLayout.NORTH,labelNombreC,40,SpringLayout.NORTH,labelDatosComp);
		panelIzq.add(campoNombre);
		sLayout.putConstraint(SpringLayout.WEST,campoNombre,15,SpringLayout.EAST,labelNombreC);
		sLayout.putConstraint(SpringLayout.NORTH,campoNombre,40,SpringLayout.NORTH,labelDatosComp);
		panelIzq.add(labelMod);
		sLayout.putConstraint(SpringLayout.WEST,labelMod,25,SpringLayout.WEST,panelIzq);
		sLayout.putConstraint(SpringLayout.NORTH,labelMod,40,SpringLayout.NORTH,labelNombreC);
		panelIzq.add(campoMod);
		sLayout.putConstraint(SpringLayout.WEST,campoMod,15,SpringLayout.EAST,labelMod);
		sLayout.putConstraint(SpringLayout.NORTH,campoMod,40,SpringLayout.NORTH,labelNombreC);
		panelIzq.add(labelDeporte);
		sLayout.putConstraint(SpringLayout.WEST,labelDeporte,25,SpringLayout.WEST,panelIzq);
		sLayout.putConstraint(SpringLayout.NORTH,labelDeporte,40,SpringLayout.NORTH,labelMod);
		panelIzq.add(campoDeporte);
		sLayout.putConstraint(SpringLayout.WEST,campoDeporte,15,SpringLayout.EAST,labelDeporte);
		sLayout.putConstraint(SpringLayout.NORTH,campoDeporte,40,SpringLayout.NORTH,labelMod);
		panelIzq.add(labelEstado);
		sLayout.putConstraint(SpringLayout.WEST,labelEstado,25,SpringLayout.WEST,panelIzq);
		sLayout.putConstraint(SpringLayout.NORTH,labelEstado,40,SpringLayout.NORTH,labelDeporte);
		panelIzq.add(campoEstado);
		sLayout.putConstraint(SpringLayout.WEST,campoEstado,15,SpringLayout.EAST,labelEstado);
		sLayout.putConstraint(SpringLayout.NORTH,campoEstado,55,SpringLayout.NORTH,labelDeporte);
        panelIzq.add(labelProxEnc);
        sLayout.putConstraint(SpringLayout.WEST,labelProxEnc,25,SpringLayout.WEST,panelIzq);
		sLayout.putConstraint(SpringLayout.NORTH,labelProxEnc,90,SpringLayout.SOUTH,labelEstado);
		panelIzq.add(tablaEncuentros);
		sLayout.putConstraint(SpringLayout.WEST,tablaEncuentros,155,SpringLayout.WEST,panelIzq);
		sLayout.putConstraint(SpringLayout.NORTH,tablaEncuentros,30,SpringLayout.SOUTH,labelProxEnc);
		
		panelIzq.add(labelPaginador);
		sLayout.putConstraint(SpringLayout.WEST,labelPaginador,100,SpringLayout.WEST,tablaEncuentros);
		sLayout.putConstraint(SpringLayout.NORTH,labelPaginador,10,SpringLayout.SOUTH,tablaEncuentros);
		panelIzq.add(botonPagIzq);
		sLayout.putConstraint(SpringLayout.EAST,botonPagIzq,-20,SpringLayout.WEST,labelPaginador);
		sLayout.putConstraint(SpringLayout.NORTH,botonPagIzq,10,SpringLayout.SOUTH,tablaEncuentros);
		panelIzq.add(botonPagDer);
		sLayout.putConstraint(SpringLayout.WEST,botonPagDer,20,SpringLayout.EAST,labelPaginador);
		sLayout.putConstraint(SpringLayout.NORTH,botonPagDer,10,SpringLayout.SOUTH,tablaEncuentros);
	}
	private void armarPanelDer() {
		SpringLayout sLayout = new SpringLayout();
		panelDer.setLayout(sLayout);
		panelDer.add(labelParticipantes);
		panelDer.add(scrollPaneParticipantes);
		sLayout.putConstraint(SpringLayout.WEST,labelParticipantes,25,SpringLayout.WEST,panelDer);
		sLayout.putConstraint(SpringLayout.NORTH,labelParticipantes,15,SpringLayout.NORTH,panelDer);
		sLayout.putConstraint(SpringLayout.WEST,scrollPaneParticipantes,45,SpringLayout.WEST,panelDer);
		sLayout.putConstraint(SpringLayout.NORTH,scrollPaneParticipantes,15,SpringLayout.SOUTH,labelParticipantes);

		panelDer.add(botonModComp);
		sLayout.putConstraint(SpringLayout.WEST,botonModComp,45,SpringLayout.WEST,panelDer);
		sLayout.putConstraint(SpringLayout.NORTH,botonModComp,35,SpringLayout.SOUTH,scrollPaneParticipantes);

		panelDer.add(botonElimComp);
		sLayout.putConstraint(SpringLayout.WEST,botonElimComp,45,SpringLayout.WEST,panelDer);
		sLayout.putConstraint(SpringLayout.NORTH,botonElimComp,35,SpringLayout.NORTH,botonModComp);

		panelDer.add(botonMostrarFixture);
		sLayout.putConstraint(SpringLayout.WEST,botonMostrarFixture,45,SpringLayout.WEST,panelDer);
		sLayout.putConstraint(SpringLayout.NORTH,botonMostrarFixture,35,SpringLayout.NORTH,botonElimComp);

		panelDer.add(botonMostrarTabla);
		sLayout.putConstraint(SpringLayout.WEST,botonMostrarTabla,45,SpringLayout.WEST,panelDer);
		sLayout.putConstraint(SpringLayout.NORTH,botonMostrarTabla,35,SpringLayout.NORTH,botonMostrarFixture);

		panelDer.add(botonGenFixture);
		sLayout.putConstraint(SpringLayout.WEST,botonGenFixture,45,SpringLayout.WEST,panelDer);
		sLayout.putConstraint(SpringLayout.NORTH,botonGenFixture,35,SpringLayout.NORTH,botonMostrarTabla);
		
		panelDer.add(botonVerPartic);
		sLayout.putConstraint(SpringLayout.WEST,botonVerPartic,45,SpringLayout.WEST,panelDer);
		sLayout.putConstraint(SpringLayout.NORTH,botonVerPartic,35,SpringLayout.NORTH,botonGenFixture);
		
		panelDer.add(botonCancelar);
		sLayout.putConstraint(SpringLayout.WEST,botonCancelar,75,SpringLayout.WEST,botonVerPartic);
		sLayout.putConstraint(SpringLayout.NORTH,botonCancelar,35,SpringLayout.SOUTH,botonVerPartic);
	}
	public void construirTablaEncuentros(String[] columnas,Object[][] data) {
		 ModeloTablaGen model = new ModeloTablaGen(data,columnas);
		 tablaEncuentros.setModel(model);
		
		
		 tablaEncuentros.getColumnModel().getColumn(0).setCellRenderer(new GestionCeldasGen("texto"));
		 tablaEncuentros.getColumnModel().getColumn(1).setCellRenderer(new GestionCeldasGen("texto"));
		 tablaEncuentros.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldasGen("texto"));
		 
		 tablaEncuentros.getTableHeader().setReorderingAllowed(false);
		 tablaEncuentros.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		 tablaEncuentros.setRowHeight(35);
		 tablaEncuentros.setGridColor(Color.BLACK);

		 tablaEncuentros.getColumnModel().getColumn(0).setPreferredWidth(10);
		 tablaEncuentros.getColumnModel().getColumn(1).setPreferredWidth(15);
		 
	}
	
	private String[] setearColumnasEncuentros() {
		columnasTablaEncuentros = new ArrayList<String>();
		columnasTablaEncuentros.add("Participante 1");
		columnasTablaEncuentros.add("Participante 2");
		columnasTablaEncuentros.add("Lugar");
		String[] columnas = new String[columnasTablaEncuentros.size()];
		for(int i=0; i<columnas.length; i++) {
			columnas[i] = columnasTablaEncuentros.get(i);
		}
		return columnas;
		
	}
	private Object[][] obtenerMatrizDatosEncuentros() {
		/*String informacion[][] = new String[.size()][columnasTabla.size()];
		int i=0;
		System.out.println(lugaresElegidos.entrySet());
		for(Map.Entry<LugarRealizacion,Integer> lugar : lugaresElegidos.entrySet()) {
			informacion[i][0] = lugar.getKey().getNombre();
			informacion[i][1] = String.valueOf(lugar.getValue());
			System.out.println(lugar.getKey().getNombre());
			System.out.println(String.valueOf(lugar.getValue()));
			i++;
		}
		return informacion;
		*/
		return null;
	}
	
}