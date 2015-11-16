package corporate;

import org.json.JSONException;
import org.testng.annotations.Test;
import utilities.APICaller;
import utilities.dataProvider.Excel2ConfigKey;

import java.util.Map;

public class AccountServiceTest {

    @Test(dataProvider = "getAPIConfig", dataProviderClass = Excel2ConfigKey.class)
    public void testGetAccountsAPI(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"),config.get("Param"),config.get("SchemaPath"));
    }
}
