package com.tienda.entity;

import java.util.Date;

public class Venta {
	private int códigoVenta;
	private Date fecha;
	private String NIT;
	
	
	public Venta(int códigoVenta,Date fecha, String NIT) {
		this.códigoVenta = códigoVenta;
		this.fecha = fecha;
		this.NIT = NIT;
	}
	public Venta(Date fecha, String NIT) {
		this.fecha = fecha;
		this.NIT = NIT;
	}
	
	public Venta(int códigoVenta) {
		this.códigoVenta = códigoVenta;
	}

	public int getCódigoVenta() {
		return códigoVenta;
	}

	public void setCódigoVenta(int códigoVenta) {
		this.códigoVenta = códigoVenta;
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
		return "Venta [códigoVenta=" + códigoVenta + ", fecha=" + fecha + ", NIT=" + NIT + "]";
	}
	
	

	
	
}
