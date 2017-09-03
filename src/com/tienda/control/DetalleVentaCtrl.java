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
	public ArrayList<DetalleVenta> list() throws Throwable { //arraylist es una estructura de tipo arreglo con tamaño indefinido es una estructura dinamica
		ArrayList<DetalleVenta> detalleVenta = new ArrayList<DetalleVenta>();//devolver una lista DetalleVenta
		ResultSet rs; //donde se guardan los resultados de nuestra consulta
		int código;
	    int códigoProducto;
		int cantidad;
		int códigoVenta;

		conexion.SQL("Select * from detalleVenta"); // metemos la consulta

		rs = conexion.resultSet(); // guarda el resultado de la consulta y devuelve todo lo de la consulta

		while (rs.next()) { // while para que vaya recoriendo y nos devuelva todos los elementos del rs 
			código = rs.getInt("código");
			códigoProducto = rs.getInt("códigoProducto");
			cantidad = rs.getInt("cantidad");
			códigoVenta = rs.getInt("códigoVenta");
			detalleVenta.add(new DetalleVenta(código, códigoProducto, cantidad, códigoVenta)); // añade DetalleVenta nuevo 
		}

		return detalleVenta;

	}

	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert1(DetalleVenta detalleVenta) throws Throwable {

		conexion.SQL("Insert into detalleVenta(código, códigoProducto, cantidad, códigoVenta) VALUES(?,?,?,?)");//?? son parametros esta esperando 4 parametros
		conexion.preparedStatement().setInt(1, detalleVenta.getCódigo()); // set tipo de datos
		conexion.preparedStatement().setInt(2, detalleVenta.getCódigoProducto());
		conexion.preparedStatement().setInt(1, detalleVenta.getCantidad());
		conexion.preparedStatement().setInt(1, detalleVenta.getCódigoVenta());
		conexion.CUD();

	}

	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search1(DetalleVenta detalleVenta) throws Throwable { // recibe el cliente y va buscar la clave del cliente y devulve el nombre a ese cliente y lo cierra

		ResultSet rs;

		conexion.SQL("Select * from detalleVenta where Código=?");
		conexion.preparedStatement().setInt(1, detalleVenta.getCódigo());
		rs = conexion.resultSet();

		while (rs.next()) {

			detalleVenta.setCódigoProducto(rs.getInt("códigoProducto"));
			detalleVenta.setCantidad(rs.getInt("cantidad"));
			detalleVenta.setCódigoVenta(rs.getInt("códigoVenta"));
		}

		rs.close();

	}

	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update1(DetalleVenta detalleVenta) throws Throwable { // modifica datos del cliente con el nid
		int código;
		int códigoProducto;
		int cantidad;
		int códigoVenta;
		if (detalleVenta != null) {
			código = detalleVenta.getCódigo();
			códigoProducto = detalleVenta.getCódigoProducto();
			cantidad= detalleVenta.getCantidad();
			códigoVenta = detalleVenta.getCódigoVenta();
			
			

			conexion.SQL("Update cliente set códigoProducto = ?, cantidad = ?, códigoVenta = ? where código=?");
			conexion.preparedStatement().setInt(1, códigoProducto);
			conexion.preparedStatement().setInt(2, cantidad);
			conexion.preparedStatement().setInt(3, códigoVenta);
			conexion.preparedStatement().setInt(4, código);
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
