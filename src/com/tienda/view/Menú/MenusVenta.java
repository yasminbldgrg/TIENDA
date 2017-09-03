package com.tienda.view.Men�;

import java.util.Scanner;

import com.tienda.entity.Venta;
import com.tienda.view.ReadTypes;

public class MenusVenta {
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public static int opcionesModificar(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Actualizar C�digo");
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 4) {
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo valores num�ricos");
				System.out.println();
				scanner.nextLine();
			}
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public static void menuModificar(Scanner scanner, Venta venta) {
		boolean salir = false;

		while (!salir) {
			switch (opcionesModificar(scanner)) {
			case 0:
				salir = true;
				break;
			case 1:
				System.out.print("Nombre anterior: ");
				System.out.println(venta.getC�digoVenta());
				int c�digoVenta = ReadTypes.leerEntero(scanner, "Ingrese el nuevo valor del c�digo: ");
				venta.setC�digoVenta(c�digoVenta);
				break;
			}
		}
	}
}
