package com.helbiz.helbizassignment.service;

import com.helbiz.helbizassignment.model.FBIResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class FBIService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String FBI_BASE_URL = "https://api.fbi.gov/wanted/list";

    public FBIResult getFbiResult(String name) {
        String fbiResourceUrl = generateUrl(name);
        ResponseEntity<FBIResult> response = restTemplate.getForEntity(fbiResourceUrl, FBIResult.class);
        return response.getBody();
    }

    private String generateUrl(String name) {
        return UriComponentsBuilder.fromHttpUrl(FBI_BASE_URL)
                .queryParam("title", name)
                .toUriString();
    }

}
