package com.javapuebla.bd.mappers;

import java.util.List;

import com.javapuebla.bd.domain.Catalogo;

public interface CatalogoMapper {
	List<Catalogo> obtenerCatalogo(int id);
	
}
