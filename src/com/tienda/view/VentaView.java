package com.tienda.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.tienda.control.VentaCtrl;
import com.tienda.control.Conexion;
import com.tienda.entity.Venta;
import com.tienda.view.Men�.MenusVenta;


public class VentaView {

	
	private Scanner scanner;
	private Venta Venta;
	private VentaCtrl VentaCtrl;
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public VentaView(Conexion conexion, Scanner scanner) {
	
		this.scanner = scanner;
		VentaCtrl = new  VentaCtrl(conexion);
		
	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insert() {
		int c�digoVenta;
		String NIT;
		Date fecha;
		
        //c�digoVenta = ReadTypes.leerEntero(scanner, "Ingrese el c�digo: "); 
		NIT = ReadTypes.leerCadena(scanner, "Ingrese el NIT: ");
		fecha = new Date();

		Venta = new Venta(fecha,NIT);
		
		try {
			VentaCtrl.insert(Venta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {
		ArrayList<Venta> Ventas;

		try {
			Ventas = VentaCtrl.list();
			for (int i = 0; i < Ventas.size(); i++) {
				System.out.println(Ventas.get(i));
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(int c�digoVenta) {
		Venta= new Venta (c�digoVenta);
		try {
			VentaCtrl.search(Venta);
			System.out.println(Venta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		int c�digoVenta;
		
		c�digoVenta = ReadTypes.leerEntero(scanner, "Ingrese el c�digo de la Venta a modificar; ");
		Venta= new Venta(c�digoVenta);
		//Venta.setNIT(NIT);
		try {
			VentaCtrl.search(Venta);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusVenta.menuModificar(scanner, Venta);

		try {
			VentaCtrl.update(Venta);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

}
