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

public class Excel2Json {

	private static final String FILE_PATH = "src/test/resources/Api_RequestParam_Sheet.xlsx" ;

	@Test(dataProvider = "getRequestJSON")
	public void testLoginAPI (JSONObject json){
	//	System.out.println(json.toString(5));
	//	System.out.println(json.getJSONObject("Params").get("RoleIDs"));
		System.out.println(json.toString());
	}

	@DataProvider
	public static Iterator<Object[]> getRequestJSON(Method method) throws IOException {

		FileInputStream sourceFile = null;
		Workbook workbook = null;
		Sheet sheet = null;
		
		List<Object[]> returnJSONList = new ArrayList<Object[]>();
	//	List<String> HeaderKeys = new ArrayList<String>();
		List<String> paramKeys = new ArrayList<String>();
		Excel2Json excel2Json = new Excel2Json();
		ClassLoader classLoader = excel2Json.getClass().getClassLoader();
		File file = new File(classLoader.getResource("Api_RequestParam_Sheet.xlsx").getFile());
		
		try {
			sourceFile = new FileInputStream( file );
			workbook = WorkbookFactory.create( sourceFile );
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
			System.out.println("Test API doesn't have any related Excel sheet");
			workbook.close();
			return null;
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
		workbook.close();
		
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
			return cell.getRichStringCellValue();
			
		case Cell.CELL_TYPE_FORMULA:
			return cell.getArrayFormulaRange();
		}
		

		return null;
	}

}
