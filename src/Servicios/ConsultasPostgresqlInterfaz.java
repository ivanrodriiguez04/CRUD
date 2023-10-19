package Servicios;

import java.sql.Connection;
import java.util.ArrayList;

import Entidades.LibroDto;

/*
 * Interfaz con todos los metodos de consulta a PostgrSQL
 * 1912023 -> irm
 */
public interface ConsultasPostgresqlInterfaz {
	/**
	 * Método que realiza un select all sobre el catálogo de libros
	 * 19102023 -> irm
	 * @param conexionGenerada
	 * @return lista de libros
	 */
	public ArrayList<LibroDto> seleccionaTodosLibros(Connection conexionGenerada);
	
}
