package com.HMS.GenericFileUtilityTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		
		Object[][] Objarr=new Object[3][2];
		ExcelUtility Excel=new ExcelUtility();
		int RowCount = Excel.getRowCount("Mobiles");
		for(int i=0;i<RowCount;i++) {
			
			Objarr[i][0]=Excel.getDataFromExcelFile("Mobiles", i+1, 1);
			Objarr[i][1]=Excel.getDataFromExcelFile("Mobiles", i+1, 2);
		}
		return Objarr;
		
	}

}
