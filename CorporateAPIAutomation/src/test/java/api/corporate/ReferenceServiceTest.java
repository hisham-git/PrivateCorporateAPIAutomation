package api.corporate;

import org.json.JSONException;
import org.testng.annotations.Test;
import utilities.APICaller;
import utilities.dataProvider.Excel2ConfigKey;

import java.util.Map;

/**
 * Created by sazzad on 11/16/15.
 */
public class ReferenceServiceTest {
    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void getAccountTypes(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void getGenderTypes(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void getAddressTypes(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void getRegionCodes(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void getCountryCodes(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void getAccountAffiliationTypes(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }
}
