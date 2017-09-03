package com.tienda.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.tienda.control.ClienteCtrl;
import com.tienda.control.Conexion;
import com.tienda.entity.Cliente;
import com.tienda.view.Menú.MenusCliente;

public class ClienteView {

	
	private Scanner scanner;
	private Cliente cliente;
	private ClienteCtrl clienteCtrl;
	
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public ClienteView(Conexion conexion, Scanner scanner) { // sirve para crear un cliente crl
	
		this.scanner = scanner; 
		clienteCtrl = new  ClienteCtrl(conexion);
		
	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void insertar() {
		String NIT;
		String nombre;

		NIT = ReadTypes.leerCadena(scanner, "Ingrese el NIT: "); //resdtipes es una clase que hace para todo tipo de datos lee fecha enteros reales cadenas...
		nombre = ReadTypes.leerCadena(scanner, "Ingrese el nombre: ");
		
		cliente = new Cliente(NIT,nombre);
		
		try {
			clienteCtrl.insert(cliente);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}
	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void listar() {  //maneja la lista
		ArrayList<Cliente> clientes; // lista clientes

		try {
			clientes = clienteCtrl.list();
			for (int i = 0; i < clientes.size(); i++) { 
				System.out.println(clientes.get(i)); // devuelve cada cliente
			}
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/
	public void buscar(String NIT) { // requiere un nid crea un cliente con ese nid y busca
		cliente= new Cliente (NIT);//este cliente no fue declarado por eso da error si buscamos
		try {
			clienteCtrl.search(cliente);
			System.out.println(cliente);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**********************************************************************************************************************
	*
	***********************************************************************************************************************/

	public void actualizar() {
		String NIT;
		
		NIT = ReadTypes.leerCadena(scanner, "Ingrese el NIT del cliente a modificar; ");
		cliente= new Cliente(NIT);
		try {
			clienteCtrl.search(cliente);
		} catch (Throwable e1) {
			System.out.println(e1.getMessage());
		}

		MenusCliente.menuModificar(scanner, cliente);

		try {
			clienteCtrl.update(cliente);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

}
