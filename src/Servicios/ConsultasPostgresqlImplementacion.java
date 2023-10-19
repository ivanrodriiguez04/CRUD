package Servicios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entidades.LibroDto;
import Utils.ADto;

public class ConsultasPostgresqlImplementacion implements ConsultasPostgresqlInterfaz {

	@Override
	public ArrayList<LibroDto> seleccionaTodosLibros(Connection conexionGenerada) {
		Statement declaracionSQL = null;
		ResultSet resultadoConsulta = null;
		ArrayList<LibroDto> listaLibros = new ArrayList<>();
		ADto adto = new ADto();
		try {

			// Se abre una declaración
			declaracionSQL = conexionGenerada.createStatement();
			// Se define la consulta de la declaración y se ejecuta
			resultadoConsulta = declaracionSQL.executeQuery("SELECT * FROM \"gbp_almacen\".\"gbp_alm_cat_libros\"");

			// Llamada a la conversión a dtoAlumno
			listaLibros = adto.resultsALibrosDto(resultadoConsulta);
			int i = listaLibros.size();
			System.out.println(
					"[INFORMACIÓN-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Número libros: " + i);

			System.out.println(
					"[INFORMACIÓN-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Cierre conexión, declaración y resultado");
			resultadoConsulta.close();
			declaracionSQL.close();
			conexionGenerada.close();

		} catch (SQLException e) {

			System.err.println(
					"[ERROR-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Error generando o ejecutando la declaracionSQL: "
							+ e);

		}
		return listaLibros;
	}

}
