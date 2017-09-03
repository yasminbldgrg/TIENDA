package com.tienda.view;

import java.util.ArrayList;import java.util.Scanner;

import com.tienda.control.ClienteCtrl;
import com.tienda.control.Conexion;
import com.tienda.control.DetalleVentaCtrl;
import com.tienda.entity.Cliente;
import com.tienda.entity.DetalleVenta;
import com.tienda.view.Menú.MenusCliente;
import com.tienda.view.Menú.MenusDetalleVenta;

public class DetalleVentaView {
	private Scanner scanner;
	private DetalleVenta detalleventa;
	private DetalleVentaCtrl detalleVentaCtrl;
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public DetalleVentaView(Conexion conexion, Scanner scanner) { // sirve para crear un cliente crl
	
		this.scanner = scanner; 
		detalleVentaCtrl = new  DetalleVentaCtrl(conexion);
		
	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() {
		int código;
	    int códigoProducto;
		int cantidad;
		int códigoVenta;

		código = ReadTypes.leerEntero(scanner, "Ingrese un código: ");
		códigoProducto = ReadTypes.leerEntero(scanner, "Ingrese un código: ");
		cantidad = ReadTypes.leerEntero(scanner, "Ingrese un código: ");
		códigoVenta = ReadTypes.leerEntero(scanner, "Ingrese un código: ");
		 //readtipes es una clase que hace para todo tipo de datos lee fecha enteros reales cadenas...
		
		
		detalleventa = new DetalleVenta(código,códigoProducto,cantidad,códigoVenta);
		
		try {
			detalleVentaCtrl.insert(detalleventa);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {  //maneja la lista
		ArrayList<DetalleVenta> detalleVenta; // lista clientes

		try {
			detalleVenta = detalleVentaCtrl.list();
			for (int i = 0; i < detalleVenta.size(); i++) { 
				System.out.println(detalleVenta.get(i)); // devuelve cada cliente
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int código) { // requiere un nid crea un cliente con ese nid y busca
		detalleventa= new DetalleVenta (código);//este cliente no fue declarado por eso da error si buscamos
		try {
			detalleVentaCtrl.search(detalleventa);
			System.out.println(detalleventa);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		int código;
		
		código = ReadTypes.leerEntero(scanner, "Ingrese el código de la venta a modificar; ");
		detalleventa= new DetalleVenta(código);
		try {
			detalleVentaCtrl.search(detalleventa);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusDetalleVenta.menuModificar(scanner, detalleventa);

		try {
			detalleVentaCtrl.update(detalleventa);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}


}
