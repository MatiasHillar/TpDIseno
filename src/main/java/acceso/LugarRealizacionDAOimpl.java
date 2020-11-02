package acceso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import logica.Competencia;
import logica.Deporte;
import logica.LugarRealizacion;
import logica.Usuario;

public class LugarRealizacionDAOimpl implements LugarRealizacionDAO {

	private static final String INSERT_LUGAR = "INSERT INTO pruebacomp.lugar_realizacion NOMBRE, "
			+ "USUARIO_DUENO VALUES(?, ?)";
	private static final String UPDATE_LUGAR = "UPDATE pruebacomp.lugar_realizacion SET "
			+ "NOMBRE = ?, USUARIO_DUENO = ? "
			+ "WHERE ID_LUGAR = ?"; 
	private static final String DELETE_LUGAR = "DELETE FROM pruebacomp.lugar_realizacion WHERE "
			+ "ID_LUGAR = ?";
	private static final String SELECT_LUGAR = "SELECT * FROM pruebacomp.lugar_realizacion WHERE"
			+ " ID_LUGAR = ?";
	
	public LugarRealizacion saveOrUpdate(LugarRealizacion l) {
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		try {
			if(l.getIdLugar() == null) {
				pstmt = conn.prepareStatement(INSERT_LUGAR);
				//setear parametros
			}
			else {
				pstmt = conn.prepareStatement(UPDATE_LUGAR);
			
			//setear parametros
			}
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return l;
	}

	public void delete(int id) {
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(DELETE_LUGAR);
			pstmt.setInt(1, id);
			pstmt.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public List<LugarRealizacion> buscarTodos() {
		List<LugarRealizacion> lista = null;
		// TODO Auto-generated method stub
		return lista;
	}

	public LugarRealizacion buscarPorId(Integer id) {
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LugarRealizacion l = null;
		try {
			pstmt = conn.prepareStatement(SELECT_LUGAR,ResultSet.TYPE_SCROLL_INSENSITIVE,	ResultSet.CONCUR_UPDATABLE);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(!rs.first()) System.out.println("no existe");;
			l = new LugarRealizacion();
		//setear valores
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt!=null) pstmt.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return l;
	}

	public static ArrayList buscarLugaresPorDeporte(String deporte, String usuario) {
		Connection conn = DB.getConexion();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<LugarRealizacion> lista = new ArrayList<LugarRealizacion>();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM (SELECT * FROM pruebacomp.lugar_realizacion as L RIGHT JOIN " + 
					"(SELECT id_lugar FROM pruebacomp.se_puede_realizar WHERE id_deporte=?) as D on D.id_lugar=L.id_lugar) as F WHERE usuario_dueno=?");
			pstmt.setString(1, deporte);
			pstmt.setInt(2,Integer.parseInt(usuario));
			rs = pstmt.executeQuery();
			if(!rs.next()) {
				return lista;
			}
			else {
				
				do {
					LugarRealizacion l = new LugarRealizacion();
					l.setNombre(rs.getString(2));
					l.setIdLugar(Integer.valueOf(rs.getInt(1)));
					l.setUsuario(new Usuario(rs.getInt(3)));
					l.addDeporte(new Deporte(deporte));
					lista.add(l);
					
				} while (rs.next());
			}
			
		//setear valores
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt!=null) pstmt.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
		
}
