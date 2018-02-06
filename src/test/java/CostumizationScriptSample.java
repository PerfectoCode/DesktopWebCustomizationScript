import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResultFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class CostumizationScriptSample {

    private final static String CLOUD = "MyCloud.perfectomobile.com";
    private final static String TOKEN = "MyToken";

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("browserVersion", "latest");
        capabilities.setCapability("securityToken", TOKEN);

        // ============== Customization Script Capabilities ==============
        // Provide extra arguments to the playbook (if necessary)
        HashMap<String, Object> argumentsScriptArgs = new HashMap<>();
        argumentsScriptArgs.put("fileslist", new String[]{"selfsigned.cer"});

        // Playbook to run before test start
        capabilities.setCapability("customizationScript", "self-signed-demo.yml");
        capabilities.setCapability("customizationScriptArgs", argumentsScriptArgs);

        URL url = new URL("http://" + CLOUD + "/nexperience/perfectomobile/wd/hub/fast");
        RemoteWebDriver driver = new RemoteWebDriver(url, capabilities);
        ReportiumClient reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(new PerfectoExecutionContext
                .PerfectoExecutionContextBuilder()
                .withWebDriver(driver)
                .build());

        // test start
        reportiumClient.testStart("Demo - Install Certificates", new TestContext("DCS", "PM"));

        driver.get("https://self-signed.badssl.com/");
        // save screenshot in the report to validate that the certificate accepted
        driver.getScreenshotAs(OutputType.BASE64);
        Thread.sleep(5000);

        reportiumClient.testStop(TestResultFactory.createSuccess());

        driver.close();
        driver.quit();

    }

}
