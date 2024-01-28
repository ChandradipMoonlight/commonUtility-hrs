package com.moonlight.commonutility.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.Map;

import static java.util.Map.entry;

@Component
public class HttpConfig {

    public HttpHeaders getDefaultHeaders() {
        Map<String, String> headersMap = Map.ofEntries(
//                entry(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                entry("Content-Type", "application/json")
        );
        HttpHeaders headers = new HttpHeaders();
        headersMap.forEach(headers::set);
        return headers;
    }

    public HttpHeaders setHeaders(Map<String, String> map) {
        HttpHeaders headers = new HttpHeaders();
        if (map!=null) map.forEach(headers::set);
        return headers;
    }

}
