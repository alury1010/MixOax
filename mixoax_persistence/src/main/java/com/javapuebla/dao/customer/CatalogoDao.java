package com.javapuebla.dao.customer;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;

import com.javapuebla.bd.domain.Catalogo;
import com.javapuebla.bd.mappers.CatalogoMapper;
import com.javapuebla.bd.util.MyBatisSqlSessionFactory;

@Named
public class CatalogoDao implements ICatalogoDao, Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Catalogo> obtenerCatalogo(int id) throws Exception {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			CatalogoMapper catalogoMapper = sqlSession
					.getMapper(CatalogoMapper.class);
			return catalogoMapper.obtenerCatalogo(id);
		} finally {
			sqlSession.close();
		}
	}




}
