package com.javapuebla.utils;

/** 
 * Utility class, where we will create methods for training read and write excel files,
 * with <a href="https://poi.apache.org/">Apache POI</a>, we use 
 * <a href="https://poi.apache.org/spreadsheet/">POI-HSSF and POI-XSSF - Java API To Access Microsoft</a>
 * HSSF is the POI Project's pure Java implementation of the Excel '97(-2007) file.
 * 
 * Clase de utilidades, donde crearemos métodos
 * para el aprendizaje de la lectura y escritura de ficheros excel con 
 * <a href="https://poi.apache.org/">Apache POI</a>, usaremos
 * <a href="https://poi.apache.org/spreadsheet/">POI-HSSF and POI-XSSF - Java API To Access Microsoft</a>
 * HSSF es el proyecto POI de implementación total en Java para ficheros Excel '97(-2007).
 *
 * @author Xules You can follow me on my website http://www.codigoxules.org/en
 * Puedes seguirme en mi web http://www.codigoxules.org).
 */
import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class JavaPoiUtils {

	public static void main(String args[]) throws IOException {

		FileInputStream file = new FileInputStream(
				new File("C:\\Users\\alury\\Documents\\Sistema MixOax\\Listas de Precios\\PRECIOS PAPELERIA.xlsx"));

		// Crear el objeto que tendra el libro de Excel

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		/*
		 * 
		 * Obtenemos la primera pestaña a la que se quiera procesar indicando el indice.
		 * 
		 * Una vez obtenida la hoja excel con las filas que se quieren leer obtenemos el
		 * iterator
		 * 
		 * que nos permite recorrer cada una de las filas que contiene.
		 * 
		 */

		XSSFSheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.iterator();

		Row row;

		StringBuilder sb;
		int codigo = 0;

		// Recorremos todas las filas para mostrar el contenido de cada celda

		while (rowIterator.hasNext()) {

			sb = new StringBuilder();
			sb.append("insert into mixoax_producto values (");
			sb.append("LAST_INSERT_ID(), '");
			sb.append(codigo).append("', ");
 			

			row = rowIterator.next();

			// Obtenemos el iterator que permite recorres todas las celdas de una fila

			Iterator<Cell> cellIterator = row.cellIterator();

			Cell celda;
			int j = 0;
			while (cellIterator.hasNext()) {

				celda = cellIterator.next();

				// Dependiendo del formato de la celda el valor se debe mostrar como String,
				// Fecha, boolean, entero...

				switch (celda.getCellType()) {

				case Cell.CELL_TYPE_NUMERIC:

					if (DateUtil.isCellDateFormatted(celda)) {

						if (j == 1 || j==2 || j==5) {
							sb.append("'").append(celda.getDateCellValue()).append("',");
						} else {
							sb.append(celda.getDateCellValue()).append(",");
						}
						// System.out.println(celda.getDateCellValue());

					} else {

						if (j == 1 || j==2 || j==5) {
							sb.append("'").append(celda.getNumericCellValue()).append("',");
						} else {
							sb.append(celda.getNumericCellValue()).append(",");
						}

						// System.out.println(celda.getNumericCellValue());

					}

					break;

				case Cell.CELL_TYPE_STRING:

					if (j == 1 || j==2 || j==5) {
						sb.append("'").append(celda.getStringCellValue()).append("',");
					} else {
						sb.append(celda.getStringCellValue()).append(",");
					}

					// System.out.println(celda.getStringCellValue());

					break;

				case Cell.CELL_TYPE_BOOLEAN:

					if (j == 1 || j==2 || j==5) {
						sb.append("'").append(celda.getBooleanCellValue()).append("',");
					} else {
						sb.append(celda.getBooleanCellValue()).append(",");
					}

					// System.out.println(celda.getBooleanCellValue());

					break;

				}

		
				j++;

			}
			sb.append("1,'").append(codigo).append("SAT');");
			codigo++;
			System.out.println(sb.toString());
		}

		// cerramos el libro excel

		workbook.close();

	}

}