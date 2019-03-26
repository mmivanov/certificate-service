package ru.mmivanov.cs.models;

import java.util.HashMap;
import java.util.Map;

public class CertificateStatus {
    public static final String active = "green";
    public static final String suspended = "orange";
    public static final String canceled = "red";
    public static final String archived = "purple";
    public static final String unknown = "gray";
    public static final Map<String, String> statuses = new HashMap<String, String>() {{
        put("green", "active");
        put("orange", "suspended");
        put("red", "canceled");
        put("purple", "archieved");
        put("gray", "unknown");
    }};
}
