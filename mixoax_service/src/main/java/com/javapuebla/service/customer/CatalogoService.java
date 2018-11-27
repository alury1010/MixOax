package com.javapuebla.service.customer;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import com.javapuebla.bd.domain.Catalogo;
import com.javapuebla.dao.customer.ICatalogoDao;

@Named
public class CatalogoService implements ICatalogoService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	final static Logger logger = Logger.getLogger(CatalogoService.class);

	@Inject
	protected ICatalogoDao catalogoDao;

	public List<Catalogo> obtenerCatalogo(int id) throws Exception {
		try {
			logger.debug("id" + id);
			return catalogoDao.obtenerCatalogo(id);
		} catch (Exception e) {
			throw e;
		}
	}

}
