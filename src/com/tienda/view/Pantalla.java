package com.tienda.view;

import java.sql.SQLException;
import java.util.Scanner;

import com.tienda.control.Conexion;

public class Pantalla {

	private static int códigoVenta;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Conexion conexion = new Conexion();
		ClienteView clienteView = new ClienteView(conexion,scanner);
		VentaView ventaView = new VentaView(conexion,scanner);
		
		//clienteView.insertar();
		
/*		for (int i = 1; i < 3; i++) {
			ClienteView.insertar(conexion, scanner);
		}*/
		
		
		ventaView.insert();
		//ventaView.buscar("147");
		
		//clienteView.listar();
		
		//clienteView.buscar("123");
		
		//clienteView.actualizar();
		
		//clienteView.listar();
		
		
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println( e.getSQLState());
		}
		
		
		scanner.close();
		
		
		
	}


	
}
