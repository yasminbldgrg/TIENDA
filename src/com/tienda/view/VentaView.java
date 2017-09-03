package com.tienda.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import com.tienda.control.VentaCtrl;
import com.tienda.control.Conexion;
import com.tienda.entity.Venta;
import com.tienda.view.Menú.MenusVenta;


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
		int códigoVenta;
		String NIT;
		Date fecha;
		
        //códigoVenta = ReadTypes.leerEntero(scanner, "Ingrese el código: "); 
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
	public void buscar(int códigoVenta) {
		Venta= new Venta (códigoVenta);
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
		int códigoVenta;
		
		códigoVenta = ReadTypes.leerEntero(scanner, "Ingrese el código de la Venta a modificar; ");
		Venta= new Venta(códigoVenta);
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
