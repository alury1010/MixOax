package com.javapuebla.dao.customer;

import java.util.List;

import com.javapuebla.bd.domain.Producto;

public interface IProductoDao {

	List<Producto> obtenerProductos() throws Exception;

	void insertarProducto(Producto producto) throws Exception;

	void actualizarProducto(Producto producto) throws Exception;

	void eliminarProducto(Integer idProducto) throws Exception;
	
	Producto obtenerProductoById(Producto producto) throws Exception;
}
