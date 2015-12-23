package api.corporate;

import org.json.JSONException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.Util;
import utilities.dataProvider.ExcelFileReaderConfig;

import java.util.Map;

public class ReferenceServiceTest {
	
	@BeforeClass
	public void printStart(){
		System.out.println();
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< REFERENCE SERVICE TEST START >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println();
	}
	
	@AfterClass
	public void printEnd(){
		System.out.println();
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< REFERENCE SERVICE TEST END >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println();
	}
    
	@Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void getCollection_reference(Map<String, String> config) throws JSONException {
		
        try {
        	Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), config.get("StatusCode"), null);
        	System.out.println( "Passed => | " + config.get("Test Case ID") + " | " + config.get("Test Case Description") );
        } catch (AssertionError e) {
        	System.out.println(">>>>>>>>>>>>>>>>>>>>>");
        	System.out.println( "Failed => | " + config.get("Test Case ID") + " | " + config.get("Test Case Description") );
        	System.out.println(e.getMessage());
        	System.out.println(">>>>>>>>>>>>>>>>>>>>>");
        }
    }
	
	@Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void get_reference(Map<String, String> config) throws JSONException {
		
		try {
        	Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), config.get("StatusCode"), null);
        	System.out.println( "Passed => | " + config.get("Test Case ID") + " | " + config.get("Test Case Description") );
        } catch (AssertionError e) {
        	System.out.println(">>>>>>>>>>>>>>>>>>>>>");
        	System.out.println( "Failed => | " + config.get("Test Case ID") + " | " + config.get("Test Case Description") );
        	System.out.println(e.getMessage());
        	System.out.println(">>>>>>>>>>>>>>>>>>>>>");
        }
    }
	
/*	
	@Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void getAccountTypes(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void getGenderTypes(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void getAddressTypes(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void getRegionCodes(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void getCountryCodes(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void getAccountAffiliationTypes(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }
    
*/
}
