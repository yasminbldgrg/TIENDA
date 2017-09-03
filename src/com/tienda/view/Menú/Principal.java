package com.tienda.view.Menú;

import java.util.Scanner;

public class Principal {

	public static int menu(Scanner scanner) {

		int opcion;

		while (true) {
			try {
				System.out.println("Ingrese una opcion: ");
				System.out.println("------------------- ");
				System.out.println("1. Menú Venta" );
				System.out.println("2. Menú Producto " );
				System.out.println("0. Salir");
				System.out.println();

				opcion = scanner.nextInt();
				scanner.nextLine();

				if (opcion >= 0 && opcion <= 4) {
					return opcion;
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Ingrese solo valores numéricos");
				System.out.println();
				scanner.nextLine();
			}
		}
	}

	public static void subMenu(Scanner leer, String tipo) {
		boolean salir = false;
	
		while (!salir) {
			switch (menu(leer)) {
			case 0:
				salir = true;
				break;
			case 1:

				break;
			case 2:
				//MenuProducto.subMenu(leer, "Producto");
				break;
			case 3:

				break;
			case 4:

				break;
			}
		}
	}
}
