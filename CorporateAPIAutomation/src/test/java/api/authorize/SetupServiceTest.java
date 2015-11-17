package api.authorize;

import org.json.JSONException;
import org.testng.annotations.Test;
import utilities.APICaller;
import utilities.dataProvider.ExcelFileReaderConfig;

import java.util.Date;
import java.util.Map;

/**
 *  deleteRole check id in db and xl sheet before calling
 */
public class SetupServiceTest {

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void getLogicalRoles(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void insertRole(Map<String, String> config) throws JSONException {
        String body = "{\"Header\":{},\"Params\":{\"Name\":\"Role"+(new Date().getTime())+"\",\"Description\":\"Test Description\"}}";
        APICaller.callApi(config.get("URL"), body, config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void updateRole(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

    @Test(dataProvider = "getAPIConfig", dataProviderClass = ExcelFileReaderConfig.class)
    public void deleteRole(Map<String, String> config) throws JSONException {
        APICaller.callApi(config.get("URL"), config.get("Param"), config.get("SchemaPath"));
    }

}

/*


insertRole
updateRole
deleteRole




authorize	setup	getRoles
        authorize	setup	getLogicalRoles
        authorize	setup	insertRole
        authorize	setup	updateRole
        authorize	setup	deleteRole
        authorize	setup	getRights
        authorize	setup	getRoleUsers
        authorize	setup	getUserRoles
        authorize	setup	getUsers
        authorize	setup	addRightsToRole
        authorize	setup	removeRightsFromRole
        authorize	setup	addUsersToRole
        authorize	setup	removeUsersFromRole
        authorize	setup	insertUserStatus
        authorize	setup	updateUserStatus
        authorize	setup	deleteUserStatus
        authorize	setup	getUserStatus
        authorize	setup	getStatusRequestUsers
        authorize	setup	addStatusRequest
        authorize	setup	removeStatusRequest*/
