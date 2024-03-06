package Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Baseclass {
    protected String username = "soh" + UUID.randomUUID().toString().substring(0, 5);
    protected String email = "soha" + UUID.randomUUID().toString().substring(0, 5) + "@gmail.com";
    protected String companyName = "soh" + UUID.randomUUID().toString().substring(0, 5).replaceAll("\\s+", "");

    public static void takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
        // Ensure the directory exists
        String screenshotsPath = "C:\\Users\\Mohammed Sohail\\git\\repository\\AppkubeSignup\\Screenshots_Test_passed";
        Path path = Paths.get(screenshotsPath, screenshotName + ".png");
        Files.createDirectories(path.getParent()); // This line ensures the directory exists

        // Take the screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), path);
    }
}