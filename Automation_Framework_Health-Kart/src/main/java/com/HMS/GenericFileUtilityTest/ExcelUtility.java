package com.HMS.GenericFileUtilityTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	//To get data from EXCEL
	public String getDataFromExcelFile(String Sheet, int Row, int Cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/Test_Script_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String Data = wb.getSheet(Sheet).getRow(Row).getCell(Cell).getStringCellValue();
		wb.close();
		return Data;
	
	}
	
	//To get Number of Rows
	public int getRowCount(String Sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/Test_Script_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int RowCount = wb.getSheet(Sheet).getLastRowNum();
		wb.close();
		return RowCount;
		
	}
	
	//To get Number of Cells
		public int getCellCount(String Sheet,int Row) throws EncryptedDocumentException, IOException {
			FileInputStream fis = new FileInputStream("./TestData/Test_Script_Data.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			int RowCount = wb.getSheet(Sheet).getRow(Row).getLastCellNum();
			wb.close();
			return RowCount;
		}
	
	//To Pass the Data to EXCEL
	public void dataBackToExcel(String Sheet,int Row,int Cell,String data) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./TestData/Test_Script_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(Sheet).getRow(Row).createCell(Cell,CellType.STRING).setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./TestData/Test_Script_Data.xlsx");
		wb.write(fos);
		wb.close();
		
	}
	
		
		
		
	}
	
	
	


