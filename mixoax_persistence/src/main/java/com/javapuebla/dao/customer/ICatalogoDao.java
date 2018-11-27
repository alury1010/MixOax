package com.javapuebla.dao.customer;

import java.util.List;

import com.javapuebla.bd.domain.Catalogo;

public interface ICatalogoDao {

	List<Catalogo> obtenerCatalogo(int id) throws Exception;

}
