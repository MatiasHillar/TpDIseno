package logica;
// default package
// Generated 7 oct. 2020 00:43:56 by Hibernate Tools 5.4.18.Final

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Competencia generated by hbm2java
 */
public class Competencia implements java.io.Serializable {

	private Integer idCompetencia;
	private Deporte deporte;
	private FormaPuntuacion formaPuntuacion;
	private Usuario usuario;
	private String nombre;
	private Boolean permiteEmpate;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaBaja;
	private String estado;
	private String reglamento;
	private ArrayList<Participante> participantes;
	private Fixture fixture;
	private Set fixtures = new HashSet(0);
	private Set<DisponiblePara> disponibleParas = new HashSet<DisponiblePara>(0);
	public Competencia() {
	}

	public Fixture getFixture() {
		return fixture;
	}

	public void setFixture(Fixture fixture) {
		this.fixture = fixture;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}

	public Competencia(int idCompetencia) {
		this.idCompetencia = idCompetencia;
	}

	public Competencia(int idCompetencia, Deporte deporte, FormaPuntuacion formaPuntuacion, Usuario usuario,
			String nombre, Boolean permiteEmpate, Date fechaInicio, Date fechaFin, Date fechaBaja, String estado,
			Set fixtures, Set disponibleParas) {
		this.idCompetencia = idCompetencia;
		this.deporte = deporte;
		this.formaPuntuacion = formaPuntuacion;
		this.usuario = usuario;
		this.nombre = nombre;
		this.permiteEmpate = permiteEmpate;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaBaja = fechaBaja;
		this.estado = estado;
		this.fixtures = fixtures;
		this.disponibleParas = disponibleParas;
	}
	
	
	
	public Competencia(Integer idCompetencia, Deporte deporte, FormaPuntuacion formaPuntuacion, Usuario usuario,
			String nombre, Boolean permiteEmpate, Date fechaInicio, Date fechaFin, Date fechaBaja, String estado,
			String reglamento, ArrayList<Participante> participantes, Set fixtures,
			Set<DisponiblePara> disponibleParas) {
		super();
		this.idCompetencia = idCompetencia;
		this.deporte = deporte;
		this.formaPuntuacion = formaPuntuacion;
		this.usuario = usuario;
		this.nombre = nombre;
		this.permiteEmpate = permiteEmpate;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaBaja = fechaBaja;
		this.estado = estado;
		this.reglamento = reglamento;
		this.participantes = participantes;
		this.fixtures = fixtures;
		this.disponibleParas = disponibleParas;
	}

	public Competencia(String nombre, boolean permite_empate, Usuario usuario, Deporte deporte,
			FormaPuntuacion forma, Set<DisponiblePara> disponibilidades) {
		this.nombre = nombre;
		this.permiteEmpate = permite_empate;
		this.usuario = usuario;
		this.deporte = deporte;
		this.formaPuntuacion = forma;
		this.disponibleParas = disponibilidades;
	}

	public Competencia(Deporte deporte, FormaPuntuacion forma, Usuario usuario, String nombre, boolean permite_empate,
			String estado) {
		// TODO Auto-generated constructor stub
		this.deporte = deporte;
		this.formaPuntuacion = forma;
		this.usuario = usuario;
		this.nombre = nombre;
		this.permiteEmpate = permite_empate;
		this.estado = estado;
	}

	

	public Competencia(Deporte deporte, String nombre, String estado) {
		this.deporte = deporte;
		this.nombre = nombre;
		this.estado = estado;
	}

	public Integer getIdCompetencia() {
		return this.idCompetencia;
	}

	public void setIdCompetencia(Integer idCompetencia) {
		this.idCompetencia = idCompetencia;
	}

	public Deporte getDeporte() {
		return this.deporte;
	}

	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}

	public FormaPuntuacion getFormaPuntuacion() {
		return this.formaPuntuacion;
	}

	public void setFormaPuntuacion(FormaPuntuacion formaPuntuacion) {
		this.formaPuntuacion = formaPuntuacion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getPermiteEmpate() {
		return this.permiteEmpate;
	}

	public void setPermiteEmpate(Boolean permiteEmpate) {
		this.permiteEmpate = permiteEmpate;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Set getFixtures() {
		return this.fixtures;
	}

	public void setFixtures(Set fixtures) {
		this.fixtures = fixtures;
	}


	public Set<DisponiblePara> getDisponibleParas() {
		return this.disponibleParas;
	}
	
	public void setDisponibleParas(ArrayList<DisponiblePara> disponibleParas) {
		this.disponibleParas = new HashSet<DisponiblePara>(disponibleParas);
	}

	public void setDisponibleParas(Set disponibleParas) {
		this.disponibleParas = disponibleParas;
	}

	public String getReglamento() {
		// TODO Auto-generated method stub
		return this.reglamento;
	}
	
	public void setReglamento(String reglamento) {
		this.reglamento = reglamento;
	}

	public ArrayList<Participante> getParticipantes() {
		// TODO Auto-generated method stub
		return this.participantes;
	}
}
