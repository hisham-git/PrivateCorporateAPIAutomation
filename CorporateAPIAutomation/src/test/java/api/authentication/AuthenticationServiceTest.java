package api.authentication;

import org.json.JSONException;
import org.testng.annotations.Test;
import utilities.APICaller;
import utilities.dataProvider.ExcelFileReaderConfig;

import java.util.Map;


public class AuthenticationServiceTest {

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void requestPasswordReset(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"),config.get("Param"),config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void verifyPasswordResetTokenAPI(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"),config.get("Param"),config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void updatePasswordAPI(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

}
