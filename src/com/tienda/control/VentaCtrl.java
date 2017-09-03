package com.tienda.control;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.tienda.entity.Venta;

public class VentaCtrl implements Control<Venta> {

private Conexion conexion;
	
	public VentaCtrl (Conexion conexion) {
		this.conexion = conexion;
	}

	/*
	 * *****************************************************************************
	 * List
	 ******************************************************************************/
	public ArrayList<Venta> list() throws Throwable {
		ArrayList<Venta> Ventas = new ArrayList<Venta>();
		ResultSet rs;
		int c�digoVenta;
		Date fecha;
		String NIT;

		conexion.SQL("Select * from Venta");

		rs = conexion.resultSet();

		while (rs.next()) {
			c�digoVenta = rs.getInt("c�digo");
			fecha = rs.getDate("fecha");
			NIT = rs.getString("NIT");
			Ventas.add(new Venta(c�digoVenta,fecha, NIT));
		}

		return Ventas;

	}

	/*
	 * *****************************************************************************
	 * Insert
	 ******************************************************************************/
	public void insert(Venta Venta) throws Throwable {

		conexion.SQL("Insert into Venta(fecha,NIT) VALUES(?,?)");
		//conexion.preparedStatement().setInt(1, Venta.getC�digoVenta());
		conexion.preparedStatement().setDate(1, new java.sql.Date( Venta.getFecha().getTime()));
		conexion.preparedStatement().setString(2, Venta.getNIT());
		conexion.CUD();

	}

	/*
	 * *****************************************************************************
	 * Search
	 ******************************************************************************/

	public void search(Venta Venta) throws Throwable {

		ResultSet rs;

		conexion.SQL("Select * from Venta where C�digo=?");
		conexion.preparedStatement().setInt(1, Venta.getC�digoVenta());
		//Venta.setNIT(null);
		Venta.setFecha(null);
		Venta.setNIT(null);
		
		rs = conexion.resultSet();

		while (rs.next()) {

			Venta.setFecha((java.util.Date) rs.getDate("fecha"));
			Venta.setNIT(rs.getString("NIT"));
			
		}

		rs.close();

	}

	/*
	 * *****************************************************************************
	 * Update
	 ******************************************************************************/

	public void update(Venta Venta) throws Throwable {
		int c�digoVenta;
		Date fecha;
		String NIT;
		if (Venta != null) {
			c�digoVenta = Venta.getC�digoVenta();
			fecha = Venta.getFecha();
			NIT = Venta.getNIT();

			conexion.SQL("Update Venta set fecha = ?, NIT = ? where c�digoVenta=?");
			conexion.preparedStatement().setDate(1, (java.sql.Date) fecha);
			conexion.preparedStatement().setString(2, NIT);
			conexion.preparedStatement().setInt(3, c�digoVenta);
			conexion.CUD();
		}
	}

	
}

