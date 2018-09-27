package com.qa.WebScraper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private FileInputStream file;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	public ExcelUtils() {

		file = null;
		try {
			file = new FileInputStream(Constants.DATAPATH + Constants.FILENAME);
		} catch (FileNotFoundException e) {
		}

		workbook = null;
		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
		}

		sheet = workbook.getSheetAt(0);
	}

	public int getPhysicalNumberOfRows() {
		return sheet.getPhysicalNumberOfRows();
	}

	public String getCellString(int row, int col) {
		return sheet.getRow(row).getCell(col).getStringCellValue();
	}

	public void writeResult(boolean passed, int row, int col)	{

		try {
			if (passed)
				sheet.getRow(row).getCell(col).setCellValue("Pass");
			else
				sheet.getRow(row).getCell(col).setCellValue("Fail");
			
			FileOutputStream fileOut = new FileOutputStream(Constants.DATAPATH + Constants.DATAPATH);

			workbook.write(fileOut);

			fileOut.flush();
			fileOut.close();
		} catch (NullPointerException npx) {
			XSSFRow Row = sheet.getRow(row);
			@SuppressWarnings("unused")
			XSSFCell Cell = Row.createCell(col);
			writeResult(passed, row, col);
		} catch (IOException e) {
			System.out.println("you left the .xlsx file open");
		}
	}
}
