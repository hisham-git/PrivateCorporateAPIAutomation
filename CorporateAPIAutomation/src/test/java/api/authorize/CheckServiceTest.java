package api.authorize;

import org.json.JSONException;
import org.testng.annotations.Test;
import utilities.APICaller;
import utilities.AppConstant;
import utilities.dataProvider.ExcelFileReaderConfig;

import java.util.Map;

public class CheckServiceTest {

    //@Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void getRoleUsers(Map<String, String> config) throws JSONException {
        //APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
        //API not ready
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void getRoleActions(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void getRolesAuthenticatedUser(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void getUserActions(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

}
