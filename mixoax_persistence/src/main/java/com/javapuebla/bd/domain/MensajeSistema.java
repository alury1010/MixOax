//-----------------------------------------------------------------------------------
// Sistema Integral de Gestión Administrativa, Financiera y Desempeño SIGAFD
// Descripción General:clase que sirve para la comunicacion entre todas las
// capas de inversión.
// Autor: NJHL
// Fecha de creación: 14/03/2015
// Componente: ManejadorMensajesExcepciones.
// MacroProceso: Inversión pública.
//-----------------------------------------------------------------------------------

package com.javapuebla.bd.domain;

import java.util.List;

public class MensajeSistema<T> {

	/**
	 * Define el estatus de la petición realizada 1=correcto , 2=advertencia , 3= fallido.
	 */
	Integer status;

	/**
	 * Mensaje que se mostrará al usuario.
	 */
	String mensajeUsuario;

	/**
	 * Mensaje proporcionado por el sistema(si es que lo requiere).
	 */
	String mensajeSistema;

	/**
	 * Capa en la que se generó el mensaje.
	 */
	String origen;

	/**
	 * tipo de mensaje.
	 */
	String tipo;

	/**
	 * lista de registros del tipo que se defina.
	 */
	List<T> registros;

	/**
	 * registro del tipo que se defina.
	 */
	T registro;

	private String idMensaje;

	/**
	 * Constructor donde se setean los atributos siguientes.
	 * 
	 * @param status
	 *            valor que contendra el mensaje.
	 * @param mensajeUsuario
	 *            mensaje que se presentara al usuario.
	 * @param mensajeSistema
	 *            mensaje que arroja el sistema si es que hay.
	 * @param origen
	 *            origen del mensaje.
	 * @param tipo
	 *            tipo de menesaje.
	 * @param registros
	 *            registros que enviaremos el mensaje.
	 */
	public MensajeSistema(Integer status, String mensajeUsuario, String mensajeSistema, String origen, String tipo,
			List<T> registros) {
		this.setStatus(status);
		this.setMensajeUsuario(mensajeUsuario);
		this.setMensajeSistema(mensajeSistema);
		this.setOrigen(origen);
		this.setTipo(tipo);
		this.setRegistros(registros);
	}

	/**
	 * Constructor donde se setean los atributos siguientes.
	 * 
	 * @param status valor que contendra el mensaje.
	 * @param mensajeUsuario mensaje que se presentara al usuario.
	 * @param mensajeSistema mensaje que arroja el sistema si es que hay.
	 * @param origen origen del mensaje.
	 * @param tipo tipo de menesaje.
	 * @param registros registros que enviaremos el mensaje.
	 * @param registro registro que enviaremos el mensaje.
	 * @param idMesaje id del mensaje.
	 */
	public MensajeSistema(Integer status, String mensajeUsuario, String mensajeSistema, String origen, String tipo,
			List<T> registros, T registro, String idMesaje) {
		this.setStatus(status);
		this.setMensajeUsuario(mensajeUsuario);
		this.setMensajeSistema(mensajeSistema);
		this.setOrigen(origen);
		this.setTipo(tipo);
		this.setRegistros(registros);
		this.setRegistro(registro);
		this.setIdMensaje(idMesaje);
	}

	/**
	 * Método para obtener el valor del atributo registro.
	 * 
	 * @return el objeto registro.
	 */
	public T getRegistro() {
		return registro;
	}

	/**
	 * Metodo que coloca nuevo valor al atributo registro.
	 * 
	 * @param registro
	 *            que indica el nuevo valor del registro
	 */
	public void setRegistro(T registro) {
		this.registro = registro;
	}

	/**
	 * Metodo para imprimir los datos de la clase actual.
	 */
	@Override
	public String toString() {
		return "status: " + status + "\n mensajeUsuario: " + mensajeUsuario + " \n mensajeSistema: " + mensajeSistema
				+ " \n origen: " + origen + " \n tipo: " + tipo;
	}

	/**
	 * Método para obtener el valor del atributo status.
	 * 
	 * @return valor de status.
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * Metodo que coloca nuevo valor al atributo status.
	 * 
	 * @param status
	 *            nuevo valor
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * Método para obtener el valor del atributo mensajeUsuario.
	 * 
	 * @return valor de mensajeUsuario.
	 */
	public String getMensajeUsuario() {
		return mensajeUsuario;
	}

	/**
	 * Metodo que coloca nuevo valor al atributo mensajeUsuario.
	 * 
	 * @param mensajeUsuario
	 *            nuevo valor.
	 */
	public void setMensajeUsuario(String mensajeUsuario) {
		this.mensajeUsuario = mensajeUsuario;
	}

	/**
	 * Método para obtener el valor del atributo mensajeSistema.
	 * 
	 * @return valor de mensajeSistema.
	 */
	public String getMensajeSistema() {
		return mensajeSistema;
	}

	/**
	 * Metodo que coloca nuevo valor al atributo mensajeSistema.
	 * 
	 * @param mensajeSistema
	 *            nuevo valor.
	 */
	public void setMensajeSistema(String mensajeSistema) {
		this.mensajeSistema = mensajeSistema;
	}

	/**
	 * Método para obtener el valor del atributo origen.
	 * 
	 * @return valor de origen.
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * Metodo que coloca nuevo valor al atributo origen.
	 * 
	 * @param origen
	 *            nuevo valor.
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}

	/**
	 * Método para obtener el valor del atributo tipo.
	 * 
	 * @return valor de tipo.
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Metodo que coloca nuevo valor al atributo tipo.
	 * 
	 * @param tipo
	 *            nuevo valor
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Método para obtener la lista registros.
	 * 
	 * @return lista registros.
	 */
	public List<T> getRegistros() {
		return registros;
	}

	/**
	 * Metodo setea el valor para la lista registros.
	 * 
	 * @param registros
	 *            registros.
	 */
	public void setRegistros(List<T> registros) {
		this.registros = registros;
	}

	/**
	 * Método para obtener el valor del atributo idMensaje.
	 * 
	 * @return idMensaje
	 */
	public String getIdMensaje() {
		return idMensaje;
	}

	/**
	 * Método para insertar nuevo valor al atributo idMensaje.
	 * 
	 * @param idMensaje
	 *            valor nuevo para el atributo idMensaje.
	 */
	public void setIdMensaje(String idMensaje) {
		this.idMensaje = idMensaje;
	}
}
