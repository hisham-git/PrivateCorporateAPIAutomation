package utilities.dataProvider;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class Excel2ConfigKey {

	//private static final String FILE_PATH = "src/test/resources/Api_Config.xlsx" ;

	@Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
	public void testLoginAPI (Map<String, String> config ){
		System.out.println(config.get("URL") +" |\n "+ config.get("Param") +" |\n "+ config.get("SchemaPath"));
		System.out.println("=================================" + "testMethod Executed" + "=========================================");
	}

	@DataProvider
	public static Iterator<Object[]> getAPIConfig(Method callingMethod) throws IOException {

		FileInputStream sourceFile = null;
		Workbook workbook = null;
		Sheet sheet = null;
		Excel2ConfigKey configKey = new Excel2ConfigKey();
		ClassLoader loader = configKey.getClass().getClassLoader();


		try {
			sourceFile = new FileInputStream( new File(loader.getResource("config/Api_Config.xlsx").getFile()) );
			workbook = WorkbookFactory.create( sourceFile );
		} catch (EncryptedDocumentException | InvalidFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		switch ( callingMethod.getName() ) {
		case "testLoginAPI":
			sheet = workbook.getSheet("login");
			break;
			
		case "testLogoutAPI":
			sheet = workbook.getSheet("logout");
			break;

		case "testRequestPasswordResetAPI":
			sheet = workbook.getSheet("requestPasswordReset");
			break;

		case "testVerifyPasswordResetTokenAPI":
			sheet = workbook.getSheet("verifyPasswordResetToken");
			break;

		case "testUpdatePasswordAPIforLoggedInUser":
			sheet = workbook.getSheet("updatePasswordLogged");
			break;
			
		case "testUpdatePasswordAPIforGuestUser":
			sheet = workbook.getSheet("updatePasswordGuest");
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
			
		case "testGetRoleUsersAPI":
			sheet = workbook.getSheet("getRoleUsers");
			break;
			
		case "testGetUsersAPI":
			sheet = workbook.getSheet("getUsers");
			break;
			
		case "testAddRightsToRoleAPI":
			sheet = workbook.getSheet("addRightsToRole");
			break;
			
		case "testRemoveRightsFromRoleAPI":
			sheet = workbook.getSheet("removeRightsFromRole");
			break;
			
		case "testAddUsersToRoleAPI":
			sheet = workbook.getSheet("addUsersToRole");
			break;
			
		case "testRemoveUsersFromRoleAPI":
			sheet = workbook.getSheet("removeUsersFromRole");
			break;
		case "testGetUserActionsAPI":
			sheet = workbook.getSheet("getUserActions");
			break;
		case "testGetRolesAuthenticatedUserAPI":
			sheet = workbook.getSheet("getRolesAuthenticatedUser");
			break;
        case "testGetAccountsAPI":
			sheet = workbook.getSheet("getGetAccounts");
			break;
		default:
			System.out.println("Test API does not have any related Excel sheet");
			workbook.close();

            return null;
		}

		List<Object[]> jParamObj = new ArrayList<>();
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
					Map<String, Object> JcellObj = new HashMap<>();

					for (String getKey : configKeys) {
						if (cellsIT.hasNext())
						{
							Cell cell = cellsIT.next();
							JcellObj.put( getKey, getCellValue(cell) );
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
			return "";
			
		default:
			return "";
			
		}

	}

}
