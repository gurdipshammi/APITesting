package tajawal.qa.automation.api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @author Gurdip, July 6, 2019
 */

public class ApiUtils {
    static Properties prop = new Properties();

    public static void checkStatusIs200(Response response, String apiName) {
        System.out.println("Status Code :" + response.statusCode());
        Assert.assertEquals(response.getStatusCode(), 200, "Status Check Failed! for API : " + apiName);
    }

    public void verifyResponse(Response response, String path, String value) {
        String res = response.asString();
        ArrayList valueRes = new ArrayList();
        valueRes = ApiUtils.getValueFromResponseList(response, path);

        for (int i = 0; i < valueRes.size(); i++) {
            Assert.assertTrue((valueRes.get(i)).toString().toLowerCase().contains(value.toLowerCase()), value + " is not matching in Response");
        }
    }


    public static ArrayList getValueFromResponseList(Response response, String JsonPath) {
        ArrayList values = new ArrayList();
        String resString = response.asString();
        JsonPath js = new JsonPath(resString);
        values = js.get(JsonPath);
        return values;
    }


    public void verifyResponseValue(Response response, String path, String value) {
        String res = response.asString();
        value = ApiUtils.getValueFromResponse(response, path);
        Assert.assertTrue((value).toString().toLowerCase().contains(value.toLowerCase()), value + " is not matching in Response");
    }

    public static String getValueFromResponse(Response response, String JsonPath) {

        String resString = response.asString();
        JsonPath js = new JsonPath(resString);
        String value = js.get(JsonPath);
        return value;
    }

    public static String getProperty(String property){
        try {
            InputStream fs = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/tajawal/qa/automation/api/properties/endpoints.properties");
            prop.load(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String value = prop.getProperty(property);
        return value;
    }
}