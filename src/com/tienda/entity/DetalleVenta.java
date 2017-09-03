package com.tienda.entity;

public class DetalleVenta {
	private int c�digo;
	private int c�digoProducto;
	private int cantidad;
	private int c�digoVenta;
	
	public DetalleVenta(int c�digo, int c�digoProducto, int cantidad, int c�digoVenta){
		this.c�digo = c�digo;
		this.c�digoProducto = c�digoProducto;
		this.cantidad = cantidad;
		this.c�digoVenta = c�digoVenta;
	}
	
	public DetalleVenta(int c�digo){
		this.c�digo=c�digo;
	}

	public int getC�digo() {
		return c�digo;
	}

	public void setC�digo(int c�digo) {
		this.c�digo = c�digo;
	}

	public int getC�digoProducto() {
		return c�digoProducto;
	}

	public void setC�digoProducto(int c�digoProducto) {
		this.c�digoProducto = c�digoProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getC�digoVenta() {
		return c�digoVenta;
	}

	public void setC�digoVenta(int c�digoVenta) {
		this.c�digoVenta = c�digoVenta;
	}

	@Override
	public String toString() {
		return "DetalleVenta [c�digo=" + c�digo + ", c�digoProducto=" + c�digoProducto + ", cantidad=" + cantidad
				+ ", c�digoVenta=" + c�digoVenta + "]";
	}
	
	
	

}
