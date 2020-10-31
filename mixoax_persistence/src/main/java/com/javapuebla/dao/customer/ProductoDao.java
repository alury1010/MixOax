package com.javapuebla.dao.customer;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;

import com.javapuebla.bd.domain.Producto;
import com.javapuebla.bd.mappers.ProductoMapper;
import com.javapuebla.bd.util.MyBatisSqlSessionFactory;

@Named
public class ProductoDao implements IProductoDao, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Producto> obtenerProductos() {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			List<Producto> listProductos = productoMapper.obtenerProductos();
			for (Producto registro : listProductos) {
				registro.setEstado(registro.getFiEstado() == 0 ? "Agotado" : "Existente");
			}
			return listProductos;
		}catch (Exception e) {
			System.err.print(e.getMessage());
			return null;
		} 
		finally {
			sqlSession.close();
		}
	}

	public void insertarProducto(Producto producto) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			productoMapper.insertarProducto(producto);

			// Confirma el registro
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	public void actualizarProducto(Producto producto) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			productoMapper.actualizarProducto(producto);

			// Confirma el registro
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void eliminarProducto(Integer idProducto) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			productoMapper.eliminarProducto(idProducto);

			// Confirma el registro
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	public Producto obtenerProductoById(Producto producto) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			ProductoMapper productoMapper = sqlSession.getMapper(ProductoMapper.class);
			Producto registro = productoMapper.obtenerProductoById(producto);
			registro.setEstado(registro.getFiEstado() == 0 ? "Agotado" : "Existente");
			return productoMapper.obtenerProductoById(producto);
		} finally {
			sqlSession.close();
		}
	}

}
