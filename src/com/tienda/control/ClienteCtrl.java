package com.tienda.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.tienda.entity.Cliente;

public class ClienteCtrl implements Control<Cliente>{  // implementa los metodos de control para cliente a interfase insert search delete update
	
	private Conexion conexion; // unico atributo
	
	public ClienteCtrl (Conexion conexion) { //constructor de la clase conexion se ocupa de conectar java con la base de datos y es una interfase de datos 
		this.conexion = conexion;             
	}

	/*
	 * *****************************************************************************
	 * List
	 ******************************************************************************/
	public ArrayList<Cliente> list() throws Throwable { //arraylist es una estructura de tipo arreglo con tama�o indefinido es una estructura dinamica
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();//devolver una lista cliente
		ResultSet rs; //donde se guardan los resultados de nuestra consulta
		String NIT;
		String nombre;

		conexion.SQL("Select * from cliente"); // metemos la consulta

		rs = conexion.resultSet(); // guarda el resultado de la consulta y devuelve todo lo de la consulta

		while (rs.next()) { // while para que vaya recoriendo y nos devuelva todos los elementos del rs 
			NIT = rs.getString("NIT");
			nombre = rs.getString("nombre");
			clientes.add(new Cliente(NIT, nombre)); // a�ade cliente nuevo 
		}

		return clientes;

	}

	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert(Cliente cliente) throws Throwable {

		conexion.SQL("Insert into cliente(NIT,nombre) VALUES(?,?)");//?? son parametros esta esperando dos parametros
		conexion.preparedStatement().setString(1, cliente.getNIT()); // set tipo de datos
		conexion.preparedStatement().setString(2, cliente.getNombre());
		conexion.CUD();

	}

	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search(Cliente cliente) throws Throwable { // recibe el cliente y va buscar la clave del cliente y devulve el nombre a ese cliente y lo cierra

		ResultSet rs;

		conexion.SQL("Select * from cliente where NIT=?");
		conexion.preparedStatement().setString(1, cliente.getNIT());
		rs = conexion.resultSet();

		while (rs.next()) {

			cliente.setNombre(rs.getString("nombre"));
		}

		rs.close();

	}

	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update(Cliente cliente) throws Throwable { // modifica datos del cliente con el nit
		String nombre;
		String NIT;
		if (cliente != null) {
			nombre = cliente.getNombre();
			NIT = cliente.getNIT();

			conexion.SQL("Update cliente set nombre = ? where NIT=?");
			conexion.preparedStatement().setString(1, nombre);
			conexion.preparedStatement().setString(2, NIT);
			conexion.CUD();
		}
	}

	
}
