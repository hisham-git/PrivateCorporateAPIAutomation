package api.corporate;

import org.json.JSONException;
import org.testng.annotations.Test;
import utilities.APICaller;
import utilities.dataProvider.Excel2ConfigKey;
import utilities.dataProvider.ExcelFileReaderConfig;

import java.util.Map;

public class AccountServiceTest {

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void getAccounts(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"),config.get("Param"),config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void insertAccounts(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"),config.get("Param"),config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void updateAccounts(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"),config.get("Param"),config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void deleteAccounts(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"),config.get("Param"),config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void getAccountContacts(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"),config.get("Param"),config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void addAccountContactAffiliations(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"),config.get("Param"),config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void removeAccountContactAffiliations(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"),config.get("Param"),config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void activateAccountContactAffiliations(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"),config.get("Param"),config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void deactivateAccountContactAffiliations(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"),config.get("Param"),config.get("SchemaPath"));
    }
}
