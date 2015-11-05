package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Excel2Json {

	private static final String FILE_PATH = "src/test/resources/Api_RequestParam_Sheet.xlsx" ;

	@Test(dataProvider = "getRequestJSON")
	public void testLoginAPI (JSONObject json){
	//	System.out.println(json.toString(5));
		System.out.println(json.getJSONObject("Params").getString("UserName"));
	//	System.out.println(json.toString());
	}

	@DataProvider
	public static Iterator<Object[]> getRequestJSON(Method method) throws JsonProcessingException {

		FileInputStream inp;
		Workbook workbook = null;
		Sheet sheet = null;
		
		List<Object[]> returnJSONList = new ArrayList<Object[]>();
	//	List<String> HeaderKeys = new ArrayList<String>();
		List<String> paramKeys = new ArrayList<String>();
		
		try {
			inp = new FileInputStream( new File(FILE_PATH) );
			workbook = WorkbookFactory.create( inp );
			} catch (EncryptedDocumentException | InvalidFormatException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		switch ( method.getName() ) {
		case "testLoginAPI":
			sheet = workbook.getSheet("login");
			break;
			
		case "testRequestPasswordResetAPI":
			sheet = workbook.getSheet("requestPasswordReset");
			break;
			
		case "testVerifyPasswordResetTokenAPI":
			sheet = workbook.getSheet("verifyPasswordResetToken");
			break;
			
		case "testUpdatePasswordAPI":
			sheet = workbook.getSheet("updatePassword");
			break;
			
		case "testInsertRoleAPI":
			sheet = workbook.getSheet("insertRole");
			break;
			
		case "testUpdateRoleAPI":
			sheet = workbook.getSheet("updateRole");
			break;
			
		case "testDeleteRoleAPI":
			sheet = workbook.getSheet("deleteRole");
			break;
			
		case "testGetRightsAPI":
			sheet = workbook.getSheet("getRights");
			break;

		default:
			System.out.println("Test method doesn't have any related sheet");
			break;
		}

		

		for ( Iterator<Row> rowsIT = sheet.rowIterator(); rowsIT.hasNext(); )
		{
			JSONObject jParamObj = new JSONObject();
			Row row = rowsIT.next();
			sheet.getRow(0);
			Iterator<Cell> headerIterator = row.cellIterator();
			
			// Param key extraction
			if ( row.getRowNum() == 0 ) {
				while ( headerIterator.hasNext() ) {
					Cell headerCell = headerIterator.next();
					paramKeys.add((String) getCellValue(headerCell) );
				}

			} else {
				for ( Iterator<Cell> cellsIT = row.cellIterator(); cellsIT.hasNext(); )
				{
					JSONObject JcellObj = new JSONObject();

					for (String getKey : paramKeys) {
						if (cellsIT.hasNext())
						{
							Cell cell = cellsIT.next();
							JcellObj.put( getKey, getCellValue(cell) );
						}
					}  
					jParamObj.put( "Params", JcellObj );
					
				}
				returnJSONList.add(new Object[]{jParamObj});
			}	
		}

		return returnJSONList.iterator();
	}

	private static Object getCellValue(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();

		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue();

		case Cell.CELL_TYPE_NUMERIC:
			return cell.getNumericCellValue();

		case Cell.CELL_TYPE_BLANK:
			return cell.getStringCellValue();
		}

		return null;
	}

}
