package com.example.staffmanager.demos.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "zdyfile")
public class FileConfig {
    public static String profile;

    public static String getImportPath()
    {
        return profile + "/import";
    }

    public static String getDownloadPath()
    {
        return profile + "/download/";
    }
}
