package com.javapuebla.service.customer;

import java.util.List;

import com.javapuebla.bd.domain.Catalogo;

public interface ICatalogoService {
	List<Catalogo> obtenerCatalogo(int id) throws Exception;
}
