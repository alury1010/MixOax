package com.javapuebla.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Fecha {

	public static void main(String[] args) {
		Date horaInicio = new Date();
		Date horaFin = new Date();
		Date totalLlamada = new Date();

		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();

		String h1 = "2019-01-04 00:1:00";
		String h2 = "2019-01-04 00:1:17";
		String h3 = "00:86:00";

		DateFormat hora = new SimpleDateFormat("HH:mm:ss");
		DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			horaFin = fechaHora.parse(h2);
			horaInicio = fechaHora.parse(h1);

			cal1.setTime(horaFin);
			cal2.setTime(horaInicio);

			System.out.println("fecha fin: " + fechaHora.format(cal1.getTime()));
			System.out.println("fecha inicio:" + fechaHora.format(cal2.getTime()));

			cal1.add(Calendar.HOUR_OF_DAY, -cal2.get(Calendar.HOUR_OF_DAY));
			cal1.add(Calendar.MINUTE, -cal2.get(Calendar.MINUTE));
			cal1.add(Calendar.SECOND, -cal2.get(Calendar.SECOND));

			System.out.println("diferencia de horaFin - horaInicio: " + hora.format(cal1.getTime()));

			totalLlamada = hora.parse(h3);
			cal3.setTime(totalLlamada);
			System.out.println("total llamada : " + cal3.getTime());

			cal3.add(Calendar.HOUR_OF_DAY, -cal1.get(Calendar.HOUR_OF_DAY));
			cal3.add(Calendar.MINUTE, -cal1.get(Calendar.MINUTE));
			cal3.add(Calendar.SECOND, -cal1.get(Calendar.SECOND));

			System.out.println("tiempo de espera : " + cal3.getTime());

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
