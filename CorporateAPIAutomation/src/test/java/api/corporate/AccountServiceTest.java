package api.corporate;

import org.testng.annotations.Test;
import org.codehaus.groovy.ast.stmt.TryCatchStatement;
import org.json.JSONException;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

import utilities.Util;
import utilities.dataProvider.ExcelFileReaderConfig;

import java.util.Date;
import java.util.Map;

public class AccountServiceTest {

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void getCollection_account(Map<String, String> config) throws JSONException {	
    	try {
        	Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
        	System.out.println( "Passed => | " + config.get("Test Case ID") + " | " + config.get("Test Case Description") );
        } catch (AssertionError e) {
        	System.out.println( "Failed => | " + config.get("Test Case ID") + " | " + config.get("Test Case Description") );
        	System.out.println(e.getMessage());
        }
    }
    
    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void get_account(Map<String, String> config) throws JSONException {    	
    	try {
        	Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
        	System.out.println( "Passed => | " + config.get("Test Case ID") + " | " + config.get("Test Case Description") );
        } catch (AssertionError e) {
        	System.out.println( "Failed => | " + config.get("Test Case ID") + " | " + config.get("Test Case Description") );
        	System.out.println(e.getMessage());
        }
    }
/*
    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void insertAccounts(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }
    
    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void insertAccount(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }
    
    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void insertAccounts(Map<String, String> config) throws JSONException {
        String insertParam = "{\"Header\":{},\"Params\":{\"Accounts\":[{\"Name\":\"test"+(new Date().getTime())+"\",\"AccountTypeID\":1}]}}";
        Util.callApi(config.get("URL"), insertParam, config.get("SchemaPath"), null);
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void updateAccounts(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }
    
    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void updateAccount(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void deleteAccount(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void getAccountContacts(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void addAccountContactAffiliations(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void removeAccountContactAffiliations(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void activateAccountContactAffiliations(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void deactivateAccountContactAffiliations(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }*/
}
