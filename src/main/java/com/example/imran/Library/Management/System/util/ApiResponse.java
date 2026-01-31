package com.example.imran.Library.Management.System.util;

import java.util.HashMap;
import java.util.Map;

public class ApiResponse {
    public static Map<String, String> apiResponse(String message){
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return response;
    }
}
