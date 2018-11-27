package com.javapuebla.bd.domain;

public class Catalogo {
	
	private Integer fiIdRelacionProducto;
	private Integer fiIdCatalogo;
	private String  fcNombreCatalogo;
	private String  fcDescripcionCatalogo;
	private Integer fiIdTipoCatalogo;
	private String fcNombreTipoCatalogo;
	
	
	public void copy(Catalogo c) {
		this.fiIdRelacionProducto = c.getFiIdRelacionProducto();
		this.fiIdCatalogo = c.getFiIdCatalogo();
		this.fcNombreCatalogo = c.getFcNombreCatalogo();
		this.fcDescripcionCatalogo = c.getFcDescripcionCatalogo();
		this.fiIdTipoCatalogo = c.getFiIdTipoCatalogo();
		this.fcNombreTipoCatalogo = c.getFcNombreTipoCatalogo();
	}
	
	public String toString(){
		String s = "fiIdRelacionProducto = "+fiIdRelacionProducto + "\n";
		s+= "fiIdCatalogo = "+fiIdCatalogo + "\n";
		s+= "fcNombreCatalogo = "+fcNombreCatalogo + "\n";
		s+= "fcDescripcionCatalogo = "+fcDescripcionCatalogo + "\n";
		s+= "fiIdTipoCatalogo = "+fiIdTipoCatalogo + "\n";
		s+= "fcNombreTipoCatalogo = "+fcNombreTipoCatalogo + "\n";
		return s;
		
	}
	/**
	 * @return the fiIdCatalogo
	 */
	public Integer getFiIdCatalogo() {
		return fiIdCatalogo;
	}
	/**
	 * @param fiIdCatalogo the fiIdCatalogo to set
	 */
	public void setFiIdCatalogo(Integer fiIdCatalogo) {
		this.fiIdCatalogo = fiIdCatalogo;
	}
	/**
	 * @return the fiIdTipoCatalogo
	 */
	public Integer getFiIdTipoCatalogo() {
		return fiIdTipoCatalogo;
	}
	/**
	 * @param fiIdTipoCatalogo the fiIdTipoCatalogo to set
	 */
	public void setFiIdTipoCatalogo(Integer fiIdTipoCatalogo) {
		this.fiIdTipoCatalogo = fiIdTipoCatalogo;
	}
	/**
	 * @return the fiIdRelacionProducto
	 */
	public Integer getFiIdRelacionProducto() {
		return fiIdRelacionProducto;
	}
	/**
	 * @param fiIdRelacionProducto the fiIdRelacionProducto to set
	 */
	public void setFiIdRelacionProducto(Integer fiIdRelacionProducto) {
		this.fiIdRelacionProducto = fiIdRelacionProducto;
	}
	/**
	 * @return the fcNombreCatalogo
	 */
	public String getFcNombreCatalogo() {
		return fcNombreCatalogo;
	}
	/**
	 * @param fcNombreCatalogo the fcNombreCatalogo to set
	 */
	public void setFcNombreCatalogo(String fcNombreCatalogo) {
		this.fcNombreCatalogo = fcNombreCatalogo;
	}
	/**
	 * @return the fcNombreTipoCatalogo
	 */
	public String getFcNombreTipoCatalogo() {
		return fcNombreTipoCatalogo;
	}
	/**
	 * @param fcNombreTipoCatalogo the fcNombreTipoCatalogo to set
	 */
	public void setFcNombreTipoCatalogo(String fcNombreTipoCatalogo) {
		this.fcNombreTipoCatalogo = fcNombreTipoCatalogo;
	}
	/**
	 * @return the fcDescripcionCatalogo
	 */
	public String getFcDescripcionCatalogo() {
		return fcDescripcionCatalogo;
	}
	/**
	 * @param fcDescripcionCatalogo the fcDescripcionCatalogo to set
	 */
	public void setFcDescripcionCatalogo(String fcDescripcionCatalogo) {
		this.fcDescripcionCatalogo = fcDescripcionCatalogo;
	}

}
