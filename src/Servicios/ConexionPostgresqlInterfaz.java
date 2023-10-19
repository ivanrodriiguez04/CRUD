package Servicios;

import java.sql.Connection;

/*
 * Interfaz que realiza la conexion a la base de datos de PostgreSQL
 * 19102023 -> irm
 */
public interface ConexionPostgresqlInterfaz {
	/**
	 * Método que genera la conexión a partir de la configuración guardada en 
	 * .properties
	 * 10192023 -> irm
	 * @return Conexión a postgresql abierta
	 */
	public Connection generaConexion();
}
