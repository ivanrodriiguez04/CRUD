package Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.LibroDto;
/*
 * Clase de utilidad que contiene los metodos de paso a DTO
 * 10102023 -> irm
 */
public class ADto {
	/**
	 * Método que pasa un resultSet con libros a lista de LibroDto
	 * @param resultadoConsulta
	 * 19102023 -> irm
	 * @return lista de libros
	 */
	public ArrayList<LibroDto> resultsALibrosDto(ResultSet resultadoConsulta){
		
		ArrayList<LibroDto> listaLibros = new ArrayList<>();
		
		//Leemos el resultado de la consulta hasta que no queden filas
		try {
			while (resultadoConsulta.next()) {
				
				listaLibros.add(new LibroDto(resultadoConsulta.getLong("id_libro"),
						resultadoConsulta.getString("titulo"),
						resultadoConsulta.getString("autor"),
						resultadoConsulta.getString("isbn"),
						resultadoConsulta.getInt("edicion"))
						);
			}
			
			int i = listaLibros.size();
			System.out.println("[INFORMACIÓN-ADto-resultsALibrosDto] Número libros: "+i);
			
		} catch (SQLException e) {
			System.err.println("[ERROR-ADto-resultsALibrosDto] Error al pasar el result set a lista de LibroDto" + e);
		}
		
		return listaLibros;
		
	}
}
