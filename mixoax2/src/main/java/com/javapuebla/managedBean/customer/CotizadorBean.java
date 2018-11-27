package com.javapuebla.managedBean.customer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

import com.javapuebla.bd.domain.Producto;
import com.javapuebla.service.customer.IProductoService;

@Named
@ViewScoped
public class CotizadorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	IProductoService productoService;

	private DualListModel<Producto> productos;
	private List<Producto> productosSource;
	private List<Producto> productosTarget;
	private BigDecimal totalCotizacion;

	@PostConstruct
	public void init() {
		try {
			this.productosSource = this.productoService.obtenerProductos();
			this.productosTarget = new ArrayList<Producto>();

			setProductos(new DualListModel<Producto>(productosSource, productosTarget));
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Error", e.getMessage()));
		}
	}

	public DualListModel<Producto> getProductos() {
		return productos;
	}

	public void setProductos(DualListModel<Producto> productos) {
		this.productos = productos;
	}
	
	
	 public void onTransfer(TransferEvent event) {
	        StringBuilder builder = new StringBuilder();
	        this.totalCotizacion = new BigDecimal(0);
	        for(Object item : event.getItems()) {
	            builder.append(((Producto) item).getFcNombre()	).append("<br />");
	            this.totalCotizacion.add(((Producto) item).getFnPrecio());
	        }
	         
	        FacesMessage msg = new FacesMessage();
	        msg.setSeverity(FacesMessage.SEVERITY_INFO);
	        msg.setSummary("Items Transferred");
	        msg.setDetail(builder.toString());
	         
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }  
	     
	    public void onSelect(SelectEvent event) {
//	        FacesContext context = FacesContext.getCurrentInstance();
//	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", event.getObject().toString()));
	    }
	     
	    public void onUnselect(UnselectEvent event) {
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Unselected", event.getObject().toString()));
	    }
	     
	    public void onReorder() {
	        FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
	    }

		public List<Producto> getProductosSource() {
			return productosSource;
		}

		public void setProductosSource(List<Producto> productosSource) {
			this.productosSource = productosSource;
		}

		public List<Producto> getProductosTarget() {
			return productosTarget;
		}

		public void setProductosTarget(List<Producto> productosTarget) {
			this.productosTarget = productosTarget;
		}

		public BigDecimal getTotalCotizacion() {
			return totalCotizacion;
		}

		public void setTotalCotizacion(BigDecimal totalCotizacion) {
			this.totalCotizacion = totalCotizacion;
		}

	

}
