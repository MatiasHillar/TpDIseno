package logica;
// default package
// Generated 7 oct. 2020 00:43:56 by Hibernate Tools 5.4.18.Final

/**
 * Liga generated by hbm2java
 */
public class Liga extends Competencia implements java.io.Serializable {

	private Integer puntosPartidoGanado;
	private Integer puntosPartidoEmpatado;

	public Liga() {
		super();
	}
	
	public Liga(Integer puntosPartidoGanado, Integer puntosPartidoEmpatado) {
		super();
		this.puntosPartidoGanado = puntosPartidoGanado;
		this.puntosPartidoEmpatado = puntosPartidoEmpatado;
	}


	public Liga(Deporte deporte, FormaPuntuacion forma, Usuario usuario, String nombre, boolean permite_empate, String estado,
			Integer puntos_pg, Integer puntos_pe) {
		super(deporte, forma, usuario, nombre, permite_empate, estado);
		this.puntosPartidoGanado = puntos_pg;
		this.puntosPartidoEmpatado = puntos_pe;
	}

	public Integer getPuntosPartidoGanado() {
		return this.puntosPartidoGanado;
	}

	public void setPuntosPartidoGanado(Integer puntosPartidoGanado) {
		this.puntosPartidoGanado = puntosPartidoGanado;
	}

	public Integer getPuntosPartidoEmpatado() {
		return this.puntosPartidoEmpatado;
	}

	public void setPuntosPartidoEmpatado(Integer puntosPartidoEmpatado) {
		this.puntosPartidoEmpatado = puntosPartidoEmpatado;
	}

}
