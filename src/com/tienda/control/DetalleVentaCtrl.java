package com.tienda.control;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.tienda.entity.DetalleVenta;

public class DetalleVentaCtrl  implements Control<DetalleVenta>{  // implementa los metodos de control para detalleVenta a interfase insert search delete update
	
	private Conexion conexion; // unico atributo
	
	public DetalleVentaCtrl (Conexion conexion) { //constructor de la clase conexion se ocupa de conectar java con la base de datos y es una interfase de datos 
		this.conexion = conexion;             
	}

	/*
	 * *****************************************************************************
	 * List
	 ******************************************************************************/
	public ArrayList<DetalleVenta> list() throws Throwable { //arraylist es una estructura de tipo arreglo con tama�o indefinido es una estructura dinamica
		ArrayList<DetalleVenta> detalleVenta = new ArrayList<DetalleVenta>();//devolver una lista DetalleVenta
		ResultSet rs; //donde se guardan los resultados de nuestra consulta
		int c�digo;
	    int c�digoProducto;
		int cantidad;
		int c�digoVenta;

		conexion.SQL("Select * from detalleVenta"); // metemos la consulta

		rs = conexion.resultSet(); // guarda el resultado de la consulta y devuelve todo lo de la consulta

		while (rs.next()) { // while para que vaya recoriendo y nos devuelva todos los elementos del rs 
			c�digo = rs.getInt("c�digo");
			c�digoProducto = rs.getInt("c�digoProducto");
			cantidad = rs.getInt("cantidad");
			c�digoVenta = rs.getInt("c�digoVenta");
			detalleVenta.add(new DetalleVenta(c�digo, c�digoProducto, cantidad, c�digoVenta)); // a�ade DetalleVenta nuevo 
		}

		return detalleVenta;

	}

	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert1(DetalleVenta detalleVenta) throws Throwable {

		conexion.SQL("Insert into detalleVenta(c�digo, c�digoProducto, cantidad, c�digoVenta) VALUES(?,?,?,?)");//?? son parametros esta esperando 4 parametros
		conexion.preparedStatement().setInt(1, detalleVenta.getC�digo()); // set tipo de datos
		conexion.preparedStatement().setInt(2, detalleVenta.getC�digoProducto());
		conexion.preparedStatement().setInt(1, detalleVenta.getCantidad());
		conexion.preparedStatement().setInt(1, detalleVenta.getC�digoVenta());
		conexion.CUD();

	}

	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search1(DetalleVenta detalleVenta) throws Throwable { // recibe el cliente y va buscar la clave del cliente y devulve el nombre a ese cliente y lo cierra

		ResultSet rs;

		conexion.SQL("Select * from detalleVenta where C�digo=?");
		conexion.preparedStatement().setInt(1, detalleVenta.getC�digo());
		rs = conexion.resultSet();

		while (rs.next()) {

			detalleVenta.setC�digoProducto(rs.getInt("c�digoProducto"));
			detalleVenta.setCantidad(rs.getInt("cantidad"));
			detalleVenta.setC�digoVenta(rs.getInt("c�digoVenta"));
		}

		rs.close();

	}

	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update1(DetalleVenta detalleVenta) throws Throwable { // modifica datos del cliente con el nid
		int c�digo;
		int c�digoProducto;
		int cantidad;
		int c�digoVenta;
		if (detalleVenta != null) {
			c�digo = detalleVenta.getC�digo();
			c�digoProducto = detalleVenta.getC�digoProducto();
			cantidad= detalleVenta.getCantidad();
			c�digoVenta = detalleVenta.getC�digoVenta();
			
			

			conexion.SQL("Update cliente set c�digoProducto = ?, cantidad = ?, c�digoVenta = ? where c�digo=?");
			conexion.preparedStatement().setInt(1, c�digoProducto);
			conexion.preparedStatement().setInt(2, cantidad);
			conexion.preparedStatement().setInt(3, c�digoVenta);
			conexion.preparedStatement().setInt(4, c�digo);
			conexion.CUD();
		}
	}

	@Override
	public void insert(DetalleVenta entity) throws Throwable {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void search(DetalleVenta entity) throws Throwable {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(DetalleVenta entity) throws Throwable {
		// TODO Auto-generated method stub
		
	}
	
}
