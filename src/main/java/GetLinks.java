import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.net.*;
import java.util.Map;

public class GetLinks {
    private static final Map<Integer, String> STATES;
    private static WebDriver driver;
    static {
        STATES = new HashMap<>();
        STATES.put(200, "SUCCESSFUL");
        STATES.put(301, "MOVED PER");
        STATES.put(302, "MOVED TEMP");
        STATES.put(400, "BAD REQUEST");
        STATES.put(401, "UNAUTHORIZED REQUEST");
        STATES.put(403, "FORBIDDEN");
        STATES.put(404, "NOT FOUND");
        STATES.put(500, "SERVER INTERNAL ERROR");
        STATES.put(502, "BAD GATEWAY");
        STATES.put(503, "SERVICE UNAVAILABLE");
        STATES.put(504, "TIMEOUT");

        driver = new ChromeDriver();
    }

    GetLinks() {}

    public void run(String url) {
        if (url == null) { url = "https://www.google.com"; }
        driver.get(url);
        List<WebElement> elements = driver.findElements(By.tagName("a"));

        List<String> links = new ArrayList<>();

        for(WebElement element: elements) {
            String link = element.getAttribute("href");
            if (link != null && link.startsWith("http")) {
                links.add(element.getAttribute("href"));
            }
        }
        for(String link: links) {
            System.out.println(link);
            isConnected(link);
        }

        driver.quit();
    }

    public void isConnected(String link) {
        int status = -1;
        try {
            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            status = con.getResponseCode();
            System.out.println("The above link get code: " + status +" [" +
                    STATES.getOrDefault(status, "OTHER") + "]");
        } catch (Exception ex) {
            System.out.println("The above link is invalid [FAILED]");
        }
    }
}
