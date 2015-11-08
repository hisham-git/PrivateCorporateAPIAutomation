package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Excel2ConfigKey {

	private static final String FILE_PATH = "src/test/resources/Api_Config.xlsx" ;

	@Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
	public void testLoginAPI (Map<String, String> config ){
		//	System.out.println(json.toString(5));
		//	System.out.println(json.getJSONObject("Params").get("RoleIDs"));
		System.out.println(config.get("URL") +" | "+ config.get("Param") +" | "+ config.get("Schema"));
		System.out.println("==============================================================================");
	}

	@DataProvider
	public Iterator<Object[]> getAPIConfig(Method method) throws IOException {

		FileInputStream sourceFile = null;
		Workbook workbook = null;
		Sheet sheet = null;

		try {
			sourceFile = new FileInputStream( new File(FILE_PATH) );
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

		List<Object[]> jParamObj = new ArrayList<>();
		//List<Object[]> returnAPIConfigList = new ArrayList<Object[]>();
		//	List<String> HeaderKeys = new ArrayList<String>();
		List<String> configKeys = new ArrayList<String>();


		for ( Iterator<Row> rowsIT = sheet.rowIterator(); rowsIT.hasNext(); )
		{
			Row row = rowsIT.next();
			sheet.getRow(0);
			Iterator<Cell> headerIterator = row.cellIterator();

			// Config key extraction
			if ( row.getRowNum() == 0 ) {
				while ( headerIterator.hasNext() ) {
					Cell headerCell = headerIterator.next();
					configKeys.add((String) getCellValue(headerCell) );
				}

			} else {
				for ( Iterator<Cell> cellsIT = row.cellIterator(); cellsIT.hasNext(); )
				{
					Map<String, String> JcellObj = new HashMap<>();

					for (String getKey : configKeys) {
						if (cellsIT.hasNext())
						{
							Cell cell = cellsIT.next();
							JcellObj.put( getKey, (String) getCellValue(cell) );
						}
					}
					jParamObj.add(new Object[] {JcellObj});

				}
				//    returnAPIConfigList.add(new Object[]{jParamObj});
			}
		}
		workbook.close();

		//    return returnAPIConfigList.iterator();
		return jParamObj.iterator();
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
