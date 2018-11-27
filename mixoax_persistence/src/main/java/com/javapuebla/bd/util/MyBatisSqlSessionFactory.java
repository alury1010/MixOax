package com.javapuebla.bd.util;

import java.io.InputStream;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSqlSessionFactory {
	private static SqlSessionFactory sqlSessionFactory;

	public static SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory == null) {
			// Recupera el ServletContext para poder leer de WEB-INF el XML de
			// configuracion de MyBatis
			ServletContext servletContext = (ServletContext) FacesContext
					.getCurrentInstance().getExternalContext().getContext();

			InputStream inputStream = servletContext
					.getResourceAsStream("/WEB-INF/mybatis-config.xml");

			sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(inputStream);
		}
		return sqlSessionFactory;
	}

	public static SqlSession openSession() {
		return getSqlSessionFactory().openSession();
	}
}
