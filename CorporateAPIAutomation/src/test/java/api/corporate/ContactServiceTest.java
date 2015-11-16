package api.corporate;

import org.json.JSONException;
import org.testng.annotations.Test;
import utilities.APICaller;
import utilities.dataProvider.Excel2ConfigKey;

import java.util.Map;

/**
 * Created by sazzad on 11/16/15.
 */
public class ContactServiceTest {

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void getContacts(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void getContactAddresses(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void insertContact(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void updateContact(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void deleteContact(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void insertContactAddresses(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void updateContactAddresses(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void deleteContactAddresses(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void getContactAccounts(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void getContactUser(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void getUserContact(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void addUserToContact(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

}
