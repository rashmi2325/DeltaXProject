package com.deltax.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {

		String[][] tabArray = null;

		try {

			InputStream ExcelFile = new FileInputStream(FilePath);
			System.out.println("FilePath<<< " + FilePath);
			// Access the required test data sheet
			try {
				ExcelWBook = new XSSFWorkbook(ExcelFile);

				ExcelWSheet = ExcelWBook.getSheet(SheetName);

			} catch (Exception e) {

				System.out.println("Exception is : " + e.getMessage());
				e.printStackTrace();
			}
			if (ExcelWSheet != null) {
				System.out.println("***** Reading the " + SheetName + " in excel file " + FilePath + " ******** \n");

				int noOfColumns = ExcelWSheet.getRow(0).getLastCellNum();

				int noOfRows = ExcelWSheet.getPhysicalNumberOfRows();

				int ci = 0, cj = 0;
				tabArray = new String[noOfRows - 1][noOfColumns];

				for (int i = 1; i < noOfRows; i++) {
					for (int j = 0; j < noOfColumns; j++) {
						DataFormatter df = new DataFormatter();

						tabArray[ci][cj] = df.formatCellValue(ExcelWSheet.getRow(i).getCell(j));
						cj++;
					}
					cj = 0;
					ci++;

				}

			}

			else {
				throw new Exception(" The sheet " + SheetName + " not found in the excel file " + FilePath);
			}

		}

		catch (FileNotFoundException e) {

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		catch (IOException e) {

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}
		System.out.println("tabArray ");

		return (tabArray);

	}

}