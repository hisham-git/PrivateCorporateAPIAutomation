package api.corporate;

import org.json.JSONException;
import org.testng.annotations.Test;
import utilities.Util;
import utilities.dataProvider.ExcelFileReaderConfig;

import java.util.Map;


public class UserServiceTest {

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void insertUser(Map<String, String> config) throws JSONException {
        Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"), null, null);
    }

    //@Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void updateUser(Map<String, String> config) throws JSONException {
        //Util.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
        //api error do later
    }


}
