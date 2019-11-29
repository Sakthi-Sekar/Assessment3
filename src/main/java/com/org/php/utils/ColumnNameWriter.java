package com.org.php.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

/**
 * This class is to create a column name
 * 
 * @author sakthi
 *
 */

@Test
public class ColumnNameWriter {
	public void writeColumnName(String filePath,String columnName, String sheetName, int columNumber) throws IOException {
		File source = new File(filePath);
		FileInputStream input = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet sheet = wb.getSheet(sheetName);
		sheet.getRow(0).createCell(columNumber).setCellValue(columnName);
		FileOutputStream output = new FileOutputStream(source);
		wb.write(output);
		wb.close();

	}
}