package Controladores;

import java.sql.Connection;
import java.util.ArrayList;

import Entidades.LibroDto;
import Servicios.ConexionPostgresqlImplementacion;
import Servicios.ConexionPostgresqlInterfaz;
import Servicios.ConsultasPostgresqlImplementacion;
import Servicios.ConsultasPostgresqlInterfaz;

/*
 * Clase principal de la aplicacion
 * 19102023 -> irm*/
public class Inicio {
	/*
	 * Metodo principal para el acceso a la aplicacion por consola
	 * 1912023 -> irm
	 */
	public static void main(String[] args) {
		ConexionPostgresqlInterfaz cpi = new ConexionPostgresqlImplementacion();
		ConsultasPostgresqlInterfaz consultaspi = new ConsultasPostgresqlImplementacion();
		ArrayList<LibroDto> listaLibros = new ArrayList<>();
		
		try {
			Connection conexion = cpi.generaConexion();
			
			if(conexion != null) {
				listaLibros = consultaspi.seleccionaTodosLibros(conexion);
				for(int i=0;i<listaLibros.size();i++) {
					System.out.println(listaLibros.get(i).toString());
				}
			}	
			
		} catch (Exception e) {
			System.err.println("[ERROR-Main] Se ha producido un error al ejecutar la aplicación: " + e);
		}

	}

}
