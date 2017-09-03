package com.tienda.entity;

import java.util.Date;

public class Venta {
	private int c�digoVenta;
	private Date fecha;
	private String NIT;
	
	
	public Venta(int c�digoVenta,Date fecha, String NIT) {
		this.c�digoVenta = c�digoVenta;
		this.fecha = fecha;
		this.NIT = NIT;
	}
	public Venta(Date fecha, String NIT) {
		this.fecha = fecha;
		this.NIT = NIT;
	}
	
	public Venta(int c�digoVenta) {
		this.c�digoVenta = c�digoVenta;
	}

	public int getC�digoVenta() {
		return c�digoVenta;
	}

	public void setC�digoVenta(int c�digoVenta) {
		this.c�digoVenta = c�digoVenta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNIT() {
		return NIT;
	}

	public void setNIT(String NIT) {
		this.NIT = NIT;
	}

	@Override
	public String toString() {
		return "Venta [c�digoVenta=" + c�digoVenta + ", fecha=" + fecha + ", NIT=" + NIT + "]";
	}
	
	

	
	
}
