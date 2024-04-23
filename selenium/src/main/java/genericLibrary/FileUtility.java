package genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class FileUtility {
	
	public static String getProperty(String key) {
		
		//step 1: Get the Java Representation of physical file
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./src/main/resources/CommonData.properties");
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//step 2: Create the Object of properties class
		Properties pObj = new Properties();
		
		//step 3: Load key and values of the properties object
		try {
			pObj.load(fis);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		//step 4: Get the Property
		return pObj.getProperty(key);
		
	}
	
	public static String readCellDataFromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		//Step 1: Get the java representation of excel file
		FileInputStream fis=new FileInputStream("./src/test/resources/testdata.xlsx");
		
		//Step 2: Get the Workbook
		Workbook book=WorkbookFactory.create(fis);
		
        //Step 3: Get the sheet from WorkBook
//		Sheet sheet=book.getSheet("register");
		
		//Step 4: Get the row from sheet
//		Row row=sheet.getRow(3);
		
//		Cell name=row.getCell(cell);
		
		// if the value is String inside the cell
//		name.getStringCellValue();
		// if the value is numeric inside the cell
//		name.getNumericCellValue();
		
		//Step 5: Get the cell from selected row
//		System.out.println(row.getCell(4));
		
		//Reading the data from cell using method chaining
		return WorkbookFactory.create(fis).getSheet(sheet).getRow(row).getCell(cell).toString();
		
	}
	
	
	public static String[][] readDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException{
		//Step 1: Get the java representation of physical file
		FileInputStream fis=new FileInputStream(".src/test/resources/testdata.xlsx");
		
		//Step 2: Get the Workbook
		Workbook book=WorkbookFactory.create(fis);
		
		//Step 3: Get the Workbook
		Sheet sheet=book.getSheet(sheetName);
		
		//Step 4: Get the count of rows having value
		int rowCount=sheet.getPhysicalNumberOfRows();
		
		//Step 5: Get the count of cell having value
		int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		//Step 5: Create a 2 dimensional array
		String [][] data=new String[rowCount-1][cellCount];
		
//it will get the data from sheet(xlFile) and store inside 2 dimensional array		
	//	data [0][0] = sheet.getRow(0).getCell(0).toString();
	//	data [0][1] = sheet.getRow(0).getCell(1).toString();
		//Step 6: Read the data from Excel and store inside 2 dimensional array.
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				data[i-1][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		//Return 2D array
		return data;
	}
	
	public static void main(String[] args) throws IOException {
		readDataFromExcel("register");
	}
}

