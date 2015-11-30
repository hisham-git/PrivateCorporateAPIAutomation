package api.corporate;

import org.json.JSONException;
import org.testng.annotations.Test;
import utilities.Util;
import utilities.dataProvider.ExcelFileReaderConfig;

import java.util.Map;

public class ContactServiceTest {

	@Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void readContact(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }
	
	@Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void getContacts(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }
	
	@Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void insertContact(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }
    
    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void insertContacts(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void updateContact(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }
    
    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void updateContacts(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void deleteContact(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }
    
    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void deleteContacts(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null);
    }
	
    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
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

}
