package helpers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.*;

public class ReportHelper {

    public static void generateCucuReport() {
        File reportOPDirectory = new File("target");
        
        ArrayList<String> jfiles = new ArrayList<String>();
        jfiles.add("target/cucumber.json");
        String projName = "testng-cucumber";

        Configuration config = new Configuration(reportOPDirectory, projName);
        config.addClassifications("Platform", System.getProperty("os.name"));
        config.addClassifications("Browser", "Chrome");
        config.addClassifications("Branch", "release/1.0");

        // optionally add metadata presented on main page via properties file
        List<String> classificationFiles = new ArrayList<String>();
        classificationFiles.add("src/test/resources/config/configs.properties");
        config.addClassificationFiles(classificationFiles);

        ReportBuilder reportBldr = new ReportBuilder(jfiles, config);
        reportBldr.generateReports();
    }

}