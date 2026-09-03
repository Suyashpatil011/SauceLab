package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;

public class Hideads {

    private WebDriver driver;
    private Logger log;

    // Constructor to inject driver and logger
    public Hideads(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    public void hideAds() {
        try {
            // Wait briefly for ads to load
            Thread.sleep(2000);

            // Hide all Google ad iframes
            ((JavascriptExecutor) driver).executeScript(
                    "document.querySelectorAll('iframe[id^=\"aswift_\"]').forEach(e => e.style.display='none');"
            );

            // Hide bottom banners or overlays if present
            ((JavascriptExecutor) driver).executeScript(
                    "document.querySelectorAll('ins.adsbygoogle, div[id^=\"google_ads_\"]').forEach(e => e.style.display='none');"
            );

            log.info("Ad iframes and banners hidden successfully.");
        } catch (Exception e) {
            log.warn("No ads found or already hidden: " + e.getMessage());
        }
    }
}
