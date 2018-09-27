package com.qa.AutomatedTestingAssessment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private FileInputStream file;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	public int currentRow = 1;

	public ExcelUtils() {

		file = null;
		try {
			file = new FileInputStream(Constants.DATAFPATH + Constants.DATAFNAME);
		} catch (FileNotFoundException e) {
		}

		workbook = null;
		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
		}

		sheet = workbook.getSheetAt(0);
	}
	
	public void updateCurrentRow(String username)	{
		for (int i = 1; i < this.getPhysicalNumberOfRows(); i++)	{
			if (sheet.getRow(i) == null) continue;
			if (sheet.getRow(i).getCell(0).getStringCellValue().equals(username))	{
				currentRow = i;
				break;
			}
		}
	}

	public int getPhysicalNumberOfRows() {
		return sheet.getPhysicalNumberOfRows();
	}

	public String getCellValueAt(int row, int col) {
		return sheet.getRow(row).getCell(col).getStringCellValue();
	}

	public void writeToCell(String str, int row, int col)	{
		try {
			sheet.getRow(row).getCell(col).setCellValue(str);
			
			FileOutputStream fileOut = new FileOutputStream(Constants.DATAFPATH + Constants.DATAFNAME);

			workbook.write(fileOut);

			fileOut.flush();
			fileOut.close();
		} catch (NullPointerException npx) {
			if (sheet.getRow(row) == null)	{
				sheet.createRow(row);
			}
			sheet.getRow(row).createCell(col);
			writeToCell(str, row, col);
		} catch (IOException e) {
			System.out.println("you left the .xlsx file open");
		}
	}
	
	public void deleteRow(int row)	{
		sheet.removeRow(sheet.getRow(row));
	}
}
