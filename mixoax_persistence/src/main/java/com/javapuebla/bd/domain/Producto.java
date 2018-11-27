package com.javapuebla.bd.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Producto {
	private Integer fiIdProducto;
	private String fcCodigo;
	private String fcNombre;
	private String fcDetalle;
	private BigDecimal fnPrecio;
	private Integer fiEstado;
	private String estado;
	private Integer fiNumPiezas;
	private String fcCodigoSAT;

	private List<Catalogo> propiedades;

	private Integer fiIdMarca;
	private String fcMarca;
	private Integer fiIdClasificacion;
	private String fcClasificacion;
	private Integer fiIdCatalogo;
	private String fcCatalogo;
	private Integer fiIdTamanio;
	private String fcTamanio;
	private Integer fiIdTalla;
	private String fcTalla;
	private Integer fiIdMaterial;
	private String fcMaterial;
	private Integer fiIdRelProductoMarca;
	private Integer fiIdRelProductoClasificacion;
	private Integer fiIdRelProductoCatalogo;
	private Integer fiIdRelProductoTamanio;
	private Integer fiIdRelProductoTalla;
	private Integer fiIdRelProductoMaterial;
	
	public void copy(Producto p) {
		this.fiIdProducto = p.getFiIdProducto();
		this.fcCodigo = p.getFcCodigo();
		this.fcNombre = p.getFcNombre();
		this.fcDetalle = p.getFcDetalle();
		this.fnPrecio = p.getFnPrecio();
		this.fiEstado = p.getFiEstado();
		this.fiNumPiezas = p.getFiNumPiezas();
		this.fcCodigoSAT = p.getFcCodigoSAT();
		this.estado = p.getEstado();
		this.propiedades = new ArrayList<Catalogo>();
		Catalogo cat ;
		for(Catalogo c : p.getPropiedades()) {
			cat = new Catalogo();
			cat.copy(c);
			this.propiedades.add(cat);
		}
		
		
		fiIdMarca = p.getFiIdMarca();
		fcMarca = p.getFcMarca();
		fiIdClasificacion = p.getFiIdClasificacion();
		fcClasificacion = p.getFcClasificacion();
		fiIdCatalogo = p.getFiIdCatalogo();
		fcCatalogo = p.getFcCatalogo();
		fiIdTamanio = p.getFiIdTamanio();
		fcTamanio = p.getFcTamanio();
		fiIdTalla = p.getFiIdTalla();
		fcTalla = p.getFcTalla();
		fiIdMaterial = p.getFiIdMaterial();
		fcMaterial= p.getFcMaterial();
		fiIdRelProductoMarca = p.getFiIdRelProductoMarca();
		fiIdRelProductoClasificacion = p.getFiIdRelProductoClasificacion();
		fiIdRelProductoCatalogo = p.getFiIdRelProductoCatalogo();
		fiIdRelProductoTamanio = p.getFiIdRelProductoTamanio();
		fiIdRelProductoTalla = p.getFiIdRelProductoTalla();
		fiIdRelProductoMaterial = p.getFiIdRelProductoMaterial();
		
	}

	public String toString() {
		String s = "fiIdProducto = " + fiIdProducto + "\n";
		s += "fcCodigo = " + fcCodigo + "\n";
		s += "fcCodigoSAT = " + fcCodigoSAT + "\n";
		s += "fcNombre = " + fcNombre + "\n";
		s += "fcDetalle = " + fcDetalle + "\n";
		s += "fnPrecio = " + fnPrecio + "\n";
		s += "fiEstado = " + fiEstado + "\n";
		s += "estado = " + estado + "\n";
		s += "fiNumPiezas = " + fiNumPiezas + "\n";
		s += "fiIdMarca = " + fiIdMarca + "\n";
		s += "fiIdClasificacion = " + fiIdClasificacion + "\n";
		s += "fiIdCatalogo = " + fiIdCatalogo + "\n";
		s += "fiIdTamanio = " + fiIdTamanio + "\n";
		s += "fiIdTalla = " + fiIdTalla + "\n";
		s += "fiIdMaterial = " + fiIdMaterial + "\n";
		s += "fiIdRelProductoMarca = " + fiIdRelProductoMarca + "\n";
		s += "fiIdRelProductoClasificacion = " + fiIdRelProductoClasificacion
				+ "\n";
		s += "fiIdRelProductoCatalogo = " + fiIdRelProductoCatalogo + "\n";
		s += "fiIdRelProductoTamanio = " + fiIdRelProductoTamanio + "\n";
		s += "fiIdRelProductoTalla = " + fiIdRelProductoTalla + "\n";
		s += "fiIdRelProductoMaterial = " + fiIdRelProductoMaterial + "\n";

		return s;

	}

	public void initNombrePropiedades() {
		if (this.propiedades != null) {
			for (Catalogo cat : this.propiedades) {
				// marca
				switch (cat.getFiIdTipoCatalogo()) {
				case 1:// marca
					this.fcMarca = cat.getFcNombreCatalogo();
					this.fiIdRelProductoMarca = cat.getFiIdRelacionProducto();
					this.fiIdMarca = cat.getFiIdCatalogo();
					break;
				case 2:// clasificacion
					this.fcClasificacion = cat.getFcNombreCatalogo();
					this.fiIdRelProductoClasificacion = cat
							.getFiIdRelacionProducto();
					this.fiIdClasificacion = cat.getFiIdCatalogo();
					break;
				case 3:// categoria
					this.fcCatalogo = cat.getFcNombreCatalogo();
					this.fiIdRelProductoCatalogo = cat
							.getFiIdRelacionProducto();
					this.fiIdCatalogo = cat.getFiIdCatalogo();
					break;
				case 4:// tamanio
					this.fcTamanio = cat.getFcNombreCatalogo();
					this.fiIdRelProductoTamanio = cat.getFiIdRelacionProducto();
					this.fiIdTamanio = cat.getFiIdCatalogo();
					break;
				case 5:// talla
					this.fcTalla = cat.getFcNombreCatalogo();
					this.fiIdRelProductoTalla = cat.getFiIdRelacionProducto();
					this.fiIdTalla = cat.getFiIdCatalogo();
					break;
				case 6:// material
					this.fcMaterial = cat.getFcNombreCatalogo();
					this.fiIdRelProductoMaterial = cat
							.getFiIdRelacionProducto();
					this.fiIdMaterial = cat.getFiIdCatalogo();
					break;
				default:
					this.fcMaterial = "Otro";
					this.fcMarca = "Otro";
					this.fcClasificacion = "Otro";
					this.fcCatalogo = "Otro";
					this.fcTamanio = "Otro";
					this.fcTalla = "Otro";
					this.fcMaterial = "Otro";
					break;
				}
			}
		}
	}

	/**
	 * @return the fiIdProducto
	 */
	public Integer getFiIdProducto() {
		return fiIdProducto;
	}

	/**
	 * @param fiIdProducto
	 *            the fiIdProducto to set
	 */
	public void setFiIdProducto(Integer fiIdProducto) {
		this.fiIdProducto = fiIdProducto;
	}

	/**
	 * @return the fcCodigo
	 */
	public String getFcCodigo() {
		return fcCodigo;
	}

	/**
	 * @param fcCodigo
	 *            the fcCodigo to set
	 */
	public void setFcCodigo(String fcCodigo) {
		this.fcCodigo = fcCodigo;
	}

	/**
	 * @return the fcNombre
	 */
	public String getFcNombre() {
		return fcNombre;
	}

	/**
	 * @param fcNombre
	 *            the fcNombre to set
	 */
	public void setFcNombre(String fcNombre) {
		this.fcNombre = fcNombre;
	}

	/**
	 * @return the fcDetalle
	 */
	public String getFcDetalle() {
		return fcDetalle;
	}

	/**
	 * @param fcDetalle
	 *            the fcDetalle to set
	 */
	public void setFcDetalle(String fcDetalle) {
		this.fcDetalle = fcDetalle;
	}

	/**
	 * @return the fnPrecio
	 */
	public BigDecimal getFnPrecio() {
		return fnPrecio;
	}

	/**
	 * @param fnPrecio
	 *            the fnPrecio to set
	 */
	public void setFnPrecio(BigDecimal fnPrecio) {
		this.fnPrecio = fnPrecio;
	}

	/**
	 * @return the fiEstado
	 */
	public Integer getFiEstado() {
		return fiEstado;
	}

	/**
	 * @param fiEstado
	 *            the fiEstado to set
	 */
	public void setFiEstado(Integer fiEstado) {
		this.fiEstado = fiEstado;
	}

	/**
	 * @return the fiNumPiezas
	 */
	public Integer getFiNumPiezas() {
		return fiNumPiezas;
	}

	/**
	 * @param fiNumPiezas
	 *            the fiNumPiezas to set
	 */
	public void setFiNumPiezas(Integer fiNumPiezas) {
		this.fiNumPiezas = fiNumPiezas;
	}

	/**
	 * @return the propiedades
	 */
	public List<Catalogo> getPropiedades() {
		return propiedades;
	}

	/**
	 * @param propiedades
	 *            the propiedades to set
	 */
	public void setPropiedades(List<Catalogo> propiedades) {
		this.propiedades = propiedades;
	}

	/**
	 * @return the fiIdMarca
	 */
	public Integer getFiIdMarca() {
		return fiIdMarca;
	}

	/**
	 * @param fiIdMarca
	 *            the fiIdMarca to set
	 */
	public void setFiIdMarca(Integer fiIdMarca) {
		this.fiIdMarca = fiIdMarca;
	}

	/**
	 * @return the fiIdClasificacion
	 */
	public Integer getFiIdClasificacion() {
		return fiIdClasificacion;
	}

	/**
	 * @param fiIdClasificacion
	 *            the fiIdClasificacion to set
	 */
	public void setFiIdClasificacion(Integer fiIdClasificacion) {
		this.fiIdClasificacion = fiIdClasificacion;
	}

	/**
	 * @return the fiIdCatalogo
	 */
	public Integer getFiIdCatalogo() {
		return fiIdCatalogo;
	}

	/**
	 * @param fiIdCatalogo
	 *            the fiIdCatalogo to set
	 */
	public void setFiIdCatalogo(Integer fiIdCatalogo) {
		this.fiIdCatalogo = fiIdCatalogo;
	}

	/**
	 * @return the fiIdTalla
	 */
	public Integer getFiIdTalla() {
		return fiIdTalla;
	}

	/**
	 * @param fiIdTalla
	 *            the fiIdTalla to set
	 */
	public void setFiIdTalla(Integer fiIdTalla) {
		this.fiIdTalla = fiIdTalla;
	}

	/**
	 * @return the fiIdTamanio
	 */
	public Integer getFiIdTamanio() {
		return fiIdTamanio;
	}

	/**
	 * @param fiIdTamanio
	 *            the fiIdTamanio to set
	 */
	public void setFiIdTamanio(Integer fiIdTamanio) {
		this.fiIdTamanio = fiIdTamanio;
	}

	/**
	 * @return the fiIdMaterial
	 */
	public Integer getFiIdMaterial() {
		return fiIdMaterial;
	}

	/**
	 * @param fiIdMaterial
	 *            the fiIdMaterial to set
	 */
	public void setFiIdMaterial(Integer fiIdMaterial) {
		this.fiIdMaterial = fiIdMaterial;
	}

	/**
	 * @return the fiIdRelProductoMarca
	 */
	public Integer getFiIdRelProductoMarca() {
		return fiIdRelProductoMarca;
	}

	/**
	 * @param fiIdRelProductoMarca
	 *            the fiIdRelProductoMarca to set
	 */
	public void setFiIdRelProductoMarca(Integer fiIdRelProductoMarca) {
		this.fiIdRelProductoMarca = fiIdRelProductoMarca;
	}

	/**
	 * @return the fiIdRelProductoClasificacion
	 */
	public Integer getFiIdRelProductoClasificacion() {
		return fiIdRelProductoClasificacion;
	}

	/**
	 * @param fiIdRelProductoClasificacion
	 *            the fiIdRelProductoClasificacion to set
	 */
	public void setFiIdRelProductoClasificacion(
			Integer fiIdRelProductoClasificacion) {
		this.fiIdRelProductoClasificacion = fiIdRelProductoClasificacion;
	}

	/**
	 * @return the fiIdRelProductoCatalogo
	 */
	public Integer getFiIdRelProductoCatalogo() {
		return fiIdRelProductoCatalogo;
	}

	/**
	 * @param fiIdRelProductoCatalogo
	 *            the fiIdRelProductoCatalogo to set
	 */
	public void setFiIdRelProductoCatalogo(Integer fiIdRelProductoCatalogo) {
		this.fiIdRelProductoCatalogo = fiIdRelProductoCatalogo;
	}

	/**
	 * @return the fiIdRelProductoTamanio
	 */
	public Integer getFiIdRelProductoTamanio() {
		return fiIdRelProductoTamanio;
	}

	/**
	 * @param fiIdRelProductoTamanio
	 *            the fiIdRelProductoTamanio to set
	 */
	public void setFiIdRelProductoTamanio(Integer fiIdRelProductoTamanio) {
		this.fiIdRelProductoTamanio = fiIdRelProductoTamanio;
	}

	/**
	 * @return the fiIdRelProductoTalla
	 */
	public Integer getFiIdRelProductoTalla() {
		return fiIdRelProductoTalla;
	}

	/**
	 * @param fiIdRelProductoTalla
	 *            the fiIdRelProductoTalla to set
	 */
	public void setFiIdRelProductoTalla(Integer fiIdRelProductoTalla) {
		this.fiIdRelProductoTalla = fiIdRelProductoTalla;
	}

	/**
	 * @return the fiIdRelProductoMaterial
	 */
	public Integer getFiIdRelProductoMaterial() {
		return fiIdRelProductoMaterial;
	}

	/**
	 * @param fiIdRelProductoMaterial
	 *            the fiIdRelProductoMaterial to set
	 */
	public void setFiIdRelProductoMaterial(Integer fiIdRelProductoMaterial) {
		this.fiIdRelProductoMaterial = fiIdRelProductoMaterial;
	}

	/**
	 * @return the fcMarca
	 */
	public String getFcMarca() {
		return fcMarca;
	}

	/**
	 * @param fcMarca
	 *            the fcMarca to set
	 */
	public void setFcMarca(String fcMarca) {
		this.fcMarca = fcMarca;
	}

	/**
	 * @return the fcClasificacion
	 */
	public String getFcClasificacion() {
		return fcClasificacion;
	}

	/**
	 * @param fcClasificacion
	 *            the fcClasificacion to set
	 */
	public void setFcClasificacion(String fcClasificacion) {
		this.fcClasificacion = fcClasificacion;
	}

	/**
	 * @return the fcCatalogo
	 */
	public String getFcCatalogo() {
		return fcCatalogo;
	}

	/**
	 * @param fcCatalogo
	 *            the fcCatalogo to set
	 */
	public void setFcCatalogo(String fcCatalogo) {
		this.fcCatalogo = fcCatalogo;
	}

	/**
	 * @return the fcTamanio
	 */
	public String getFcTamanio() {
		return fcTamanio;
	}

	/**
	 * @param fcTamanio
	 *            the fcTamanio to set
	 */
	public void setFcTamanio(String fcTamanio) {
		this.fcTamanio = fcTamanio;
	}

	/**
	 * @return the fcTalla
	 */
	public String getFcTalla() {
		return fcTalla;
	}

	/**
	 * @param fcTalla
	 *            the fcTalla to set
	 */
	public void setFcTalla(String fcTalla) {
		this.fcTalla = fcTalla;
	}

	/**
	 * @return the fcMaterial
	 */
	public String getFcMaterial() {
		return fcMaterial;
	}

	/**
	 * @param fcMaterial
	 *            the fcMaterial to set
	 */
	public void setFcMaterial(String fcMaterial) {
		this.fcMaterial = fcMaterial;
	}

	public String getFcCodigoSAT() {
		return fcCodigoSAT;
	}

	public void setFcCodigoSAT(String fcCodigoSAT) {
		this.fcCodigoSAT = fcCodigoSAT;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
