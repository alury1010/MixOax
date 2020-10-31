package com.javapuebla.managedBean.security;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

@Named(value = "loginMgmtBean")
@RequestScoped
public class LoginBean {
	private String userName;

	private String password;
	
	private String mensaje;

	@Inject
	// representa lo que se configuro en el security-config.xml
	private AuthenticationManager authenticationManager;

	public String login() {
		try {
			System.out.println("usr: " + this.getUserName() + " pass:" + this.getPassword());
			
			Authentication request = new UsernamePasswordAuthenticationToken(this.getUserName(), this.getPassword());
			Authentication result = authenticationManager.authenticate(request);
			SecurityContextHolder.getContext().setAuthentication(result);
		} catch (AuthenticationException e) {
			System.out.println("Credenciales incorrectas reintente de nuevo");
			this.setUserName("");
			this.setPassword("");
			this.setMensaje("Credenciales incorrectas reintente de nuevo.");
			
			FacesMessage msg = new FacesMessage("Credenciales incorrectas reintente de nuevo.");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "/sysmixoax_pages/sysmixoax_unsecure/login2";
		}

		return "/sysmixoax_pages/sysmixoax_secure/bienvenida";
	}

	/**
	 * @return el userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            el userName a establecer
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
