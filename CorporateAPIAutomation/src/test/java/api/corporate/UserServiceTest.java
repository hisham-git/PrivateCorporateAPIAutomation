package api.corporate;

import org.json.JSONException;
import org.testng.annotations.Test;
import utilities.APICaller;
import utilities.dataProvider.ExcelFileReaderConfig;

import java.util.Date;
import java.util.Map;


public class UserServiceTest {

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void insertUser(Map<String, String> config) throws JSONException {
        String body="{\"Header\":{},\"Params\":{\"UserName\":\"sazzad"+(new Date().getTime())+"@gmail.com\"," +
                "\"Password\":\"12345678\",\"FirstName\":\"abc\",\"LastName\":\"bcd\"" +
                ",\"EmailAddress\":\"sazzad"+(new Date().getTime())+"@gmail.com\"}}";
        APICaller.callApi(config.get("URL"), body, config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void updateUser(Map<String, String> config) throws JSONException {
        //APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
        //api error do later
    }


}
