package com.javapuebla.bd.mappers;

import java.util.List;

import com.javapuebla.bd.domain.Producto;

public interface ProductoMapper {
	List<Producto> obtenerProductos();
	void insertarProducto(Producto producto);
	void actualizarProducto(Producto producto);
	void eliminarProducto(Integer idProducto);
	Producto obtenerProductoById(Producto producto);
}
