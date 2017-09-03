package com.tienda.control; //intefase es una structura que permite generar erencia multipla osea una clase genera varia clases a la ves 
// structura que permite definir los procedimientos
// todas las clases que van implementar el interfase van implementar estos metodos

import java.util.ArrayList;

public interface Control<Entity> { // una entidad puede ser cliente detalle de venta puede ser cualquiera 
	                                // <> en una estructura generica y funciona en cualquier tipo de clase
	
	public ArrayList<Entity> list() throws Throwable;
	public void insert(Entity entity) throws Throwable;
	public void search(Entity entity) throws Throwable;
	public void update(Entity entity) throws Throwable;
}
