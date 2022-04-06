package com.swaroopAssignment1.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.swaroopAssignment1.BasePackage.TestBase;

public class ExcelUtils extends TestBase{
	
	public static FileInputStream fi;
	
	public static XSSFWorkbook wbook;
	public static XSSFSheet wSheet;
	public static XSSFRow wRow;
	public static XSSFCell wCell;
	
	public static int getRowCount(String filePath, String sheetName) throws IOException {
		int rowCount;
		fi = new FileInputStream(filePath);
		wbook = new XSSFWorkbook(fi);
		wSheet = wbook.getSheet(sheetName);
		rowCount = wSheet.getLastRowNum();
		logger.info("The Row Count is: "+rowCount);
		wbook.close();
		fi.close();
		return rowCount;
	}
	
	public static int getCellCount(String xFile, String xSheet, int rowno) throws IOException {

		int colCount;
		fi = new FileInputStream(xFile);
		wbook = new XSSFWorkbook(fi);
		wSheet = wbook.getSheet(xSheet);
		wRow = wSheet.getRow(rowno);
		colCount = wRow.getLastCellNum();
		wbook.close();
		fi.close();		
		System.out.println("The column count is: " + colCount);
		return colCount;
	}

	@SuppressWarnings("deprecation")
	public static String getCellData(String xFile, String xSheet, int rowno, int colno) throws IOException {

		String data;
		fi = new FileInputStream(xFile);
		wbook = new XSSFWorkbook(fi);
		wSheet = wbook.getSheet(xSheet);
		wRow = wSheet.getRow(rowno);
		wCell = wRow.getCell(colno);
//		wCell.setCellType(wCell.CELL_TYPE_STRING);
		data = wCell.getStringCellValue();
		return data;

	}

}
