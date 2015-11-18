package api.authentication;

import org.json.JSONException;
import org.testng.annotations.Test;
import utilities.APICaller;
import utilities.dataProvider.ExcelFileReaderConfig;

import java.util.Map;


public class Default {

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void login(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void logout(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void getAuthenticatedUser(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

}
