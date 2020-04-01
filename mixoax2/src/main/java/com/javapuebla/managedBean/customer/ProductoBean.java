package com.javapuebla.managedBean.customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.UploadedFile;

import com.javapuebla.bd.domain.Catalogo;
import com.javapuebla.bd.domain.Customer;
import com.javapuebla.bd.domain.Producto;
import com.javapuebla.bo.customer.CustomerBo;
import com.javapuebla.service.customer.CustomerService;
import com.javapuebla.service.customer.ICatalogoService;
import com.javapuebla.service.customer.IProductoService;

@Named
@ViewScoped
public class ProductoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	CustomerBo userBo;

	@Inject
	CustomerService customerService;

	@Inject
	IProductoService productoService;

	@Inject
	ICatalogoService catalogoService;

	transient List<Customer> customerList;

	private Producto producto;
	private Producto selectedProducto;
	// private Producto nuevoProducto;
	private List<Producto> registroTabla;
	private List<Producto> registrosFiltrados;
	private List<SelectItem> listCategoriaProducto;
	private List<SelectItem> listClasificacionProducto;
	private List<SelectItem> listTamanioProducto;
	private List<SelectItem> listTallaProducto;
	private List<SelectItem> listMaterialProducto;
	private List<SelectItem> listMarcaProducto;

	private List<Catalogo> listaCatalogo;
	private UploadedFile file;

	// private SelectItem selectedMarca;
	// private SelectItem selectedMaterial;
	// private SelectItem selectedCategoria;
	// private SelectItem selectedClasificacion;
	// private SelectItem selectedTalla;
	// private SelectItem selectedTamanio;

	@PostConstruct
	public void init() {
		this.producto = new Producto();
		this.listCategoriaProducto = new ArrayList<SelectItem>();
		this.listClasificacionProducto = new ArrayList<SelectItem>();
		this.listTamanioProducto = new ArrayList<SelectItem>();
		this.listTallaProducto = new ArrayList<SelectItem>();
		this.listMaterialProducto = new ArrayList<SelectItem>();
		this.listMarcaProducto = new ArrayList<SelectItem>();
		this.listaCatalogo = new ArrayList<Catalogo>();
		this.registrosFiltrados = new ArrayList<Producto>();
		this.initTabla();
		this.initListas();
	}

	public void initTabla() {
		try {
			this.registroTabla = this.productoService.obtenerProductos();
			this.registrosFiltrados.clear();
			if (this.registroTabla != null) {
				Producto producto;
				for (Producto p : this.registroTabla) {
					producto = new Producto();
					producto.copy(p);
					this.registrosFiltrados.add(producto);
				}
			}

			for (Producto prod : this.registroTabla) {
				prod.initNombrePropiedades();
			}
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Error", e.getMessage()));
		}
	}

	public void initListas() {
		try {
			SelectItem item;
			this.listaCatalogo = this.catalogoService.obtenerCatalogo(1);// marca
			for (Catalogo cat : this.listaCatalogo) {
				System.out.println(cat.toString());
				item = new SelectItem();
				item.setLabel(cat.getFcNombreCatalogo());
				item.setDescription(cat.getFcNombreCatalogo());
				item.setValue(cat.getFiIdCatalogo());
				this.listMarcaProducto.add(item);
			}
			this.listaCatalogo = this.catalogoService.obtenerCatalogo(2);// clasificacion
			for (Catalogo cat : this.listaCatalogo) {
				System.out.println(cat.toString());
				item = new SelectItem();
				item.setLabel(cat.getFcNombreCatalogo());
				item.setDescription(cat.getFcNombreCatalogo());
				item.setValue(cat.getFiIdCatalogo());
				this.listClasificacionProducto.add(item);
			}
			this.listaCatalogo = this.catalogoService.obtenerCatalogo(3);// categoria
			for (Catalogo cat : this.listaCatalogo) {
				System.out.println(cat.toString());
				item = new SelectItem();
				item.setLabel(cat.getFcNombreCatalogo());
				item.setDescription(cat.getFcNombreCatalogo());
				item.setValue(cat.getFiIdCatalogo());
				this.listCategoriaProducto.add(item);
			}
			this.listaCatalogo = this.catalogoService.obtenerCatalogo(4);// tamaño
			for (Catalogo cat : this.listaCatalogo) {
				System.out.println(cat.toString());
				item = new SelectItem();
				item.setLabel(cat.getFcNombreCatalogo());
				item.setDescription(cat.getFcNombreCatalogo());
				item.setValue(cat.getFiIdCatalogo());
				this.listTamanioProducto.add(item);
			}
			this.listaCatalogo = this.catalogoService.obtenerCatalogo(5);// tamaño
			for (Catalogo cat : this.listaCatalogo) {
				System.out.println(cat.toString());
				item = new SelectItem();
				item.setLabel(cat.getFcNombreCatalogo());
				item.setDescription(cat.getFcNombreCatalogo());
				item.setValue(cat.getFiIdCatalogo());
				this.listTallaProducto.add(item);
			}
			this.listaCatalogo = this.catalogoService.obtenerCatalogo(6);// material
			for (Catalogo cat : this.listaCatalogo) {
				System.out.println(cat.toString());
				item = new SelectItem();
				item.setLabel(cat.getFcNombreCatalogo());
				item.setDescription(cat.getFcNombreCatalogo());
				item.setValue(cat.getFiIdCatalogo());
				this.listMaterialProducto.add(item);
			}

		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Error", e.getMessage()));
		}
	}

	public void onGuardar() {

		FacesContext context = FacesContext.getCurrentInstance();

		try {
			this.producto.setFiEstado(1);
			System.out.println(this.producto.toString());
			this.productoService.insertarProducto(this.producto);
			this.initTabla();
			// this.registroTabla.add(this.producto);
			// this.registrosFiltrados.add(this.producto);
			this.resetProducto();

			RequestContext rc = RequestContext.getCurrentInstance();

			rc.update("formInit");
			rc.execute("PF('dlg').hide();");
			//
			// PrimeFacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage("Producto Creado Exitosamente", null));

		} catch (Exception e) {
			context.addMessage(null, new FacesMessage("Falló en la creacion del producto", e.getMessage()));

		}

	}

	public void onCancelar() {
		this.resetProducto();
		System.out.println("entro a onCancelar");

		// RequestContext rc = RequestContext.getCurrentInstance();
		//
		// rc.update("panelNuevoP formInit");
		// rc.execute("PF('dlg').hide();");
	}

	public void resetProducto() {
		this.producto = new Producto();
	}

	public void onRowEdit(RowEditEvent event) {

		try {
			Producto producto = (Producto) event.getObject();

			this.producto.setFiEstado(1);
			System.out.println("producto a editar:::::::::" + producto.toString());
			this.productoService.actualizarProducto(producto);
			Producto aux = this.productoService.obtenerProductoById(producto);
			producto.copy(aux);
			producto.initNombrePropiedades();
			// RequestContext rc = RequestContext.getCurrentInstance();
			// rc.update("tablaProductos");

			FacesMessage msg = new FacesMessage("Producto Editado Exitosamente", this.producto.getFcCodigo());
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (Exception e) {

			FacesMessage msg = new FacesMessage("Fallo al guardar los cambios", e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);

		}

	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edicion Cancelada", ((Producto) event.getObject()).getFcCodigo());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void eliminarProducto(Producto p) {

		try {
			this.selectedProducto = p;

			System.out.println("eliminar producto" + this.selectedProducto.toString());
			this.productoService.eliminarProducto(this.selectedProducto.getFiIdProducto());

			this.registroTabla.remove(this.selectedProducto);

			RequestContext rc = RequestContext.getCurrentInstance();
			rc.update("formInit");

			FacesMessage msg = new FacesMessage("Producto Eliminado Exitosamente", this.selectedProducto.getFcCodigo());
			FacesContext.getCurrentInstance().addMessage(null, msg);

			this.selectedProducto = null;

		} catch (Exception e) {
			FacesMessage msg = new FacesMessage("Falló al eliminar el producto de la lista", e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);

		}
	}

	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Car Selected", ((Producto) event.getObject()).getFcCodigo());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void upload() {
		if (file != null) {
			FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void handleFileUpload(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Producto getNuevoProducto() {
		return new Producto();
	}

	// public void setNuevoProducto(Producto nuevoProducto) {
	// this.nuevoProducto = nuevoProducto;
	// }

	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param producto
	 *            the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	/**
	 * @return the listCategoriaProducto
	 */
	public List<SelectItem> getListCategoriaProducto() {
		return listCategoriaProducto;
	}

	/**
	 * @param listCategoriaProducto
	 *            the listCategoriaProducto to set
	 */
	public void setListCategoriaProducto(List<SelectItem> listCategoriaProducto) {
		this.listCategoriaProducto = listCategoriaProducto;
	}

	/**
	 * @return the listClasificacionProducto
	 */
	public List<SelectItem> getListClasificacionProducto() {
		return listClasificacionProducto;
	}

	/**
	 * @param listClasificacionProducto
	 *            the listClasificacionProducto to set
	 */
	public void setListClasificacionProducto(List<SelectItem> listClasificacionProducto) {
		this.listClasificacionProducto = listClasificacionProducto;
	}

	/**
	 * @return the listTamanioProducto
	 */
	public List<SelectItem> getListTamanioProducto() {
		return listTamanioProducto;
	}

	/**
	 * @param listTamanioProducto
	 *            the listTamanioProducto to set
	 */
	public void setListTamanioProducto(List<SelectItem> listTamanioProducto) {
		this.listTamanioProducto = listTamanioProducto;
	}

	/**
	 * @return the listTallaProducto
	 */
	public List<SelectItem> getListTallaProducto() {
		return listTallaProducto;
	}

	/**
	 * @param listTallaProducto
	 *            the listTallaProducto to set
	 */
	public void setListTallaProducto(List<SelectItem> listTallaProducto) {
		this.listTallaProducto = listTallaProducto;
	}

	/**
	 * @return the listMaterialProducto
	 */
	public List<SelectItem> getListMaterialProducto() {
		return listMaterialProducto;
	}

	/**
	 * @param listMaterialProducto
	 *            the listMaterialProducto to set
	 */
	public void setListMaterialProducto(List<SelectItem> listMaterialProducto) {
		this.listMaterialProducto = listMaterialProducto;
	}

	/**
	 * @return the listMarcaProducto
	 */
	public List<SelectItem> getListMarcaProducto() {
		return listMarcaProducto;
	}

	/**
	 * @param listMarcaProducto
	 *            the listMarcaProducto to set
	 */
	public void setListMarcaProducto(List<SelectItem> listMarcaProducto) {
		this.listMarcaProducto = listMarcaProducto;
	}

	/**
	 * @return the registroTabla
	 */
	public List<Producto> getRegistroTabla() {
		return registroTabla;
	}

	/**
	 * @param registroTabla
	 *            the registroTabla to set
	 */
	public void setRegistroTabla(List<Producto> registroTabla) {
		this.registroTabla = registroTabla;
	}

	/**
	 * @return the selectedProducto
	 */
	public Producto getSelectedProducto() {
		return selectedProducto;
	}

	/**
	 * @param selectedProducto
	 *            the selectedProducto to set
	 */
	public void setSelectedProducto(Producto selectedProducto) {
		this.selectedProducto = selectedProducto;
	}

	/**
	 * @return the registrosFiltrados
	 */
	public List<Producto> getRegistrosFiltrados() {
		return registrosFiltrados;
	}

	/**
	 * @param registrosFiltrados
	 *            the registrosFiltrados to set
	 */
	public void setRegistrosFiltrados(List<Producto> registrosFiltrados) {
		this.registrosFiltrados = registrosFiltrados;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

}