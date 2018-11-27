package com.javapuebla.service.customer;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.javapuebla.bd.domain.Producto;
import com.javapuebla.dao.customer.IProductoDao;

@Named
public class ProductoService implements IProductoService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	protected IProductoDao productoDao;

	public List<Producto> obtenerProductos() throws Exception {
		try {
			return productoDao.obtenerProductos();
		} catch (Exception e) {
			throw e;
		}
	}

	public void insertarProducto(Producto producto) throws Exception {
		try {
			productoDao.insertarProducto(producto);
		} catch (Exception e) {
			throw e;
		}

	}

	public void actualizarProducto(Producto producto) throws Exception {
		try {
			productoDao.actualizarProducto(producto);
		} catch (Exception e) {
			throw e;
		}
	}

	public void eliminarProducto(Integer idProducto) throws Exception {
		try {
			productoDao.eliminarProducto(idProducto);
			System.out.println("despues de eliminar producto");
		} catch (Exception e) {
			System.out.println("el metodo de servivio eliminarProducto devuelve la excepcion");
			throw e;
		}
	}

	public Producto obtenerProductoById(Producto producto) throws Exception {
		try {
			return productoDao.obtenerProductoById(producto);
		} catch (Exception e) {
			throw e;
		}
	}

}
