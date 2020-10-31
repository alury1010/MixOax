package com.javapuebla.managedBean.customer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.primefaces.event.RowEditEvent;
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
	private BigDecimal totalImporte;
	private Date fecha;

	@PostConstruct
	public void init() {
		System.out.println("entro a postconstruct CotizadorBean");
		if (this.productosTarget == null) {
			this.productosTarget = new ArrayList<Producto>();
		} else {
			this.productosTarget.clear();
		}

		if (this.productosSource == null) {
			this.productosSource = new ArrayList<Producto>();
			initDualList();
		}

		this.setTotalImporte(new BigDecimal(0));

	}

	public void initDualList() {
		try {
			this.productosSource = this.productoService.obtenerProductos();
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

		this.totalImporte = new BigDecimal(0);

		System.out.println("productos en tabla " + this.productos.getTarget().size());

		this.productosTarget = this.productos.getTarget();

		for (Producto item : this.productosTarget) {

			builder.append(((Producto) item).getFcNombre()).append("<br />");

			this.totalImporte = this.totalImporte.add(((Producto) item).getFnImporte());
		}
	}

	public void onSelect(SelectEvent event) {

	}

	public void onUnselect(UnselectEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Unselected", event.getObject().toString()));
	}

	public void onReorder() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
	}

	/**
	 * Metodo que
	 * 
	 * @param document
	 */
	public void postProcessXLS(Object document) {
		HSSFWorkbook wb = (HSSFWorkbook) document;
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow header = sheet.getRow(0);
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setFillForegroundColor(HSSFColor.LIME.index);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		int i;
		for (i = 0; i < header.getPhysicalNumberOfCells(); i++) {
			header.getCell(i).setCellStyle(cellStyle);
		}

		int createNewRowAt = 0; // Add the new row between row 9 and 10

		sheet.shiftRows(createNewRowAt, sheet.getLastRowNum(), 1, true, false);
		HSSFRow newRow = sheet.createRow(0);

		String pattern = "MM-dd-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		newRow.createCell(4).setCellValue(date);

		sheet.shiftRows(1, sheet.getLastRowNum(), 1, true, false);
		HSSFRow newRow2 = sheet.createRow(1);
		newRow2 = sheet.getRow(1);

		int totalFilas = sheet.getPhysicalNumberOfRows();

		HSSFRow hssfRowNew = sheet.createRow(totalFilas);

		hssfRowNew.createCell(i - 2).setCellValue("TOTAL");
		hssfRowNew.createCell(i - 1).setCellValue(this.totalImporte.doubleValue());

		for (i = 1; i <= 10; i++) {
			sheet.createRow(totalFilas + i);
		}

		sheet.getRow(totalFilas + i - 2).createCell(1).setCellValue("PROVEEDORA DE EDICIONES CULTURALES MIX-OAX.");
		sheet.getRow(totalFilas + i - 1).createCell(1).setCellValue("Sello y Firma");

	}

	/**
	 * Metodo que permite la edicion de cantidad por producto para la cotizacion
	 * 
	 * @param event
	 */
	public void onRowEdit(RowEditEvent event) {

		try {
			this.setTotalImporte(new BigDecimal(0));

			for (Producto item : this.productosTarget) {
				this.totalImporte = this.totalImporte.add(((Producto) item).getFnImporte());
			}
			System.out.println("totalImporte:::::::::" + this.totalImporte);

			FacesMessage msg = new FacesMessage("Cantidad editada exitosamente", "");
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} catch (Exception e) {

			FacesMessage msg = new FacesMessage("Fallo al guardar los cambios", e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public List<Producto> getProductosSource() {
		return productosSource;
	}

	public void setProductosSource(List<Producto> productosSource) {
		this.productosSource = productosSource;
	}

	public List<Producto> getProductosTarget() {
		return this.getProductos().getTarget();
	}

	public void setProductosTarget(List<Producto> productosTarget) {
		this.productosTarget = productosTarget;
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edicion Cancelada", ((Producto) event.getObject()).getFcCodigo());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public BigDecimal getTotalImporte() {
		return totalImporte;
	}

	public void setTotalImporte(BigDecimal totalImporte) {
		this.totalImporte = totalImporte;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void limpiar() {
		System.out.println("Entro a limpiar");
		this.productosTarget.clear();

		// setProductos(new DualListModel<Producto>(productosSource, productosTarget));
		this.productos.setSource(this.productosSource);
		this.productos.setTarget(this.productosTarget);
		this.setTotalImporte(new BigDecimal(0));
	}

}
