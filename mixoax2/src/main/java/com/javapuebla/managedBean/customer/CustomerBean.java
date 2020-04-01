package com.javapuebla.managedBean.customer;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import com.javapuebla.bd.domain.Customer;
import com.javapuebla.bo.customer.CustomerBo;
import com.javapuebla.service.customer.CustomerService;

@Named
@ViewScoped
public class CustomerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	CustomerBo userBo;
	
	@Inject
	CustomerService customerService;
	
	
	transient List<Customer> customerList;

	public List<Customer> getCustomerList() {
		
		//Asigna la primera ver para permintr tener un nuevo valor 
		//al actualizar desde dataTable de prime
		if(customerList == null)
		setCustomerList(customerService.findAllCustomer());
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public void setUserBo(CustomerBo userBo) {
		this.userBo = userBo;
	}

	public String printMsgFromSpring() {
		return userBo.getMessage();
	}
	
	/*public List<Customer> getCustomersData() {
		return customerService.findAllCustomer();
	}*/
	
	//Utilies para despliegue de grid editable con prime
	
	public void onRowEdit(RowEditEvent event) {
		//Recupera el cliente seleccionado y actualizacion de info
		Customer customer = ((Customer) event.getObject());
		
		System.out.println("status : " + customer.getStatus());
		
		customerService.updateUsuario(customer);
		
        FacesMessage msg = new FacesMessage("Cliente editado", customer.getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edición cancelada", ((Customer) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        System.out.println("verifica : " + newValue);
        
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente modificado", "Antes: " + oldValue + ", Ahora:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

}