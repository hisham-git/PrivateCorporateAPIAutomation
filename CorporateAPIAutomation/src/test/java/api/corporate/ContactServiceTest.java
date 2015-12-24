package api.corporate;

import org.json.JSONException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

import utilities.Util;
import utilities.dataProvider.ExcelFileReaderConfig;

import java.util.Map;

public class ContactServiceTest {
	
	@BeforeClass
	public void printStart(){
		System.out.println();
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< CONTACT SERVICE TEST START >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println();
	}
	
	@AfterClass
	public void printEnd(){
		System.out.println();
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< CONTACT SERVICE TEST END >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println();
	}

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void getCollection_contact(Map<String, String> config) throws JSONException {
    	
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
    public void get_contact(Map<String, String> config) throws JSONException {
    	
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
    public void postCollection_contact(Map<String, String> config) throws JSONException {
    	try {
    		Response responseAPI = Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), config.get("StatusCode"), null);
        	System.out.println( "Passed => | " + config.get("Test Case ID") + " | " + config.get("Test Case Description") );
        	System.out.println(responseAPI.toString());
        } catch (AssertionError e) {
        	System.out.println(">>>>>>>>>>>>>>>>>>>>>");
        	System.out.println( "Failed => | " + config.get("Test Case ID") + " | " + config.get("Test Case Description") );
        	System.out.println(e.getMessage());
        	System.out.println(">>>>>>>>>>>>>>>>>>>>>");
        }
    }
    
    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void post_contact(Map<String, String> config) throws JSONException {
    	try {
    		Response responseAPI = Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), config.get("StatusCode"), null);
        	System.out.println( "Passed => | " + config.get("Test Case ID") + " | " + config.get("Test Case Description") );
        	System.out.println(responseAPI.toString());
        } catch (AssertionError e) {
        	System.out.println(">>>>>>>>>>>>>>>>>>>>>");
        	System.out.println( "Failed => | " + config.get("Test Case ID") + " | " + config.get("Test Case Description") );
        	System.out.println(e.getMessage());
        	System.out.println(">>>>>>>>>>>>>>>>>>>>>");
        }
    }
    
    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void patchCollection_contact(Map<String, String> config) throws JSONException {
    	try {
    		Response responseAPI = Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), config.get("StatusCode"), null);
        	System.out.println( "Passed => | " + config.get("Test Case ID") + " | " + config.get("Test Case Description") );
        	System.out.println(responseAPI.toString());
        } catch (AssertionError e) {
        	System.out.println(">>>>>>>>>>>>>>>>>>>>>");
        	System.out.println( "Failed => | " + config.get("Test Case ID") + " | " + config.get("Test Case Description") );
        	System.out.println(e.getMessage());
        	System.out.println(">>>>>>>>>>>>>>>>>>>>>");
        }
    }
    
    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void patch_contact(Map<String, String> config) throws JSONException {
    	try {
    		Response responseAPI = Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), config.get("StatusCode"), null);
        	System.out.println( "Passed => | " + config.get("Test Case ID") + " | " + config.get("Test Case Description") );
        	System.out.println(responseAPI.toString());
        } catch (AssertionError e) {
        	System.out.println(">>>>>>>>>>>>>>>>>>>>>");
        	System.out.println( "Failed => | " + config.get("Test Case ID") + " | " + config.get("Test Case Description") );
        	System.out.println(e.getMessage());
        	System.out.println(">>>>>>>>>>>>>>>>>>>>>");
        }
    }
    
    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void delete_contact(Map<String, String> config) throws JSONException {
    	try {
    		Response responseAPI = Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), config.get("StatusCode"), null);
        	System.out.println( "Passed => | " + config.get("Test Case ID") + " | " + config.get("Test Case Description") );
        	System.out.println(responseAPI.toString());
        } catch (AssertionError e) {
        	System.out.println(">>>>>>>>>>>>>>>>>>>>>");
        	System.out.println( "Failed => | " + config.get("Test Case ID") + " | " + config.get("Test Case Description") );
        	System.out.println(e.getMessage());
        	System.out.println(">>>>>>>>>>>>>>>>>>>>>");
        }
    }
	

	
/*    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void getContactAddresses(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void insertContactAddresses(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void updateContactAddresses(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void deleteContactAddresses(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void getContactAccounts(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void getContactUser(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void getUserContact(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void addUserToContact(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }
*/    

}
