package api.corporate;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.codehaus.groovy.ast.stmt.TryCatchStatement;
import org.json.JSONException;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

import utilities.Util;
import utilities.dataProvider.ExcelFileReaderConfig;

import java.util.Date;
import java.util.Map;

public class AddressServiceTest {
	
	@BeforeClass
	public void printStart(){
		System.out.println();
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< ADDRESS SERVICE TEST START >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println();
	}
	
	@AfterClass
	public void printEnd(){
		System.out.println();
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< ADDRESS SERVICE TEST END >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println();
	}

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void getCollection_address(Map<String, String> config) throws JSONException {
    	
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
    public void get_address(Map<String, String> config) throws JSONException {
    	
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
    public void postCollection_address(Map<String, String> config) throws JSONException {
    	
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
    public void post_address(Map<String, String> config) throws JSONException {
    	
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
    public void patchCollection_address(Map<String, String> config) throws JSONException {
    	
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
    public void patch_address(Map<String, String> config) throws JSONException {
    	
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
    public void delete_address(Map<String, String> config) throws JSONException {
    	
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

    
}
