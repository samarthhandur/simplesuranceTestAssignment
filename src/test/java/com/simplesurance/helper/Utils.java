package com.simplesurance.helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Class for setting up the excel file for data driven approach
 */
public class Utils extends BaseTest{
	@SuppressWarnings("rawtypes")
	
	/**
	 * Defining ExcelWorksheet 
	 */
	private static XSSFSheet ExcelWSheet;
	 
	/**
	 * Defining ExcelWorkbook 
	 */
	private static XSSFWorkbook ExcelWBook;

	/**
	 * Defining ExcelWorksheet cell 
	 */
	private static XSSFCell Cell;

	/**
	 * Defining ExcelWorksheet row
	 */
	private static XSSFRow Row;
	
	/**
	 * Constructor to initialize Utils class
	 * @param WebDriver driver 
	 */
	public Utils(WebDriver driver) {
		PageFactory.initElements(driver, this);
	    }
		
	/**
	 * Instance method to scroll into the web page
	 * @param WebElement 
	 */
	public void scrollTillElement(WebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);" , element);
	}

	/**
	 * Initializing the excel file 
	 * @param Path, SheetName
	 */
	public static void setExcelFile(String Path,String SheetName) throws Exception {
		 
			try {

   			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			} catch (Exception e){

				throw (e);

			}

	}

	/**
	 * This method is to read the test data from the Excel cell
	 * @param rownNum, ColNum 
	 */
    public static String getCellData(int RowNum, int ColNum) throws Exception{
    	DataFormatter formatter = new DataFormatter();
			try{
			
  			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
  			
  			String CellData = formatter.formatCellValue(Cell);
  			return CellData;

  			}catch (Exception e){
  				System.out.println(e);
				return"";
  			}
    }

     /**
	 * This method is to write the test data to the Excel cell
	 * @param rownNum, ColNum 
	 */
	@SuppressWarnings("static-access")
	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception	{
			try{

  			Row  = ExcelWSheet.getRow(RowNum);

			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

			if (Cell == null) {

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);

				} else {

					Cell.setCellValue(Result);

				}

  // Constant variables Test Data path and Test Data file name

  				FileOutputStream fileOut = new FileOutputStream(Constants.Path_TestData + Constants.File_TestData);

  				ExcelWBook.write(fileOut);

  				fileOut.flush();

					fileOut.close();

				}catch(Exception e){

					throw (e);
			}
		}
}

