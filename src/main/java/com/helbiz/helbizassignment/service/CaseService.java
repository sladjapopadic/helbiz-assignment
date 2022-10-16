package com.helbiz.helbizassignment.service;

import com.helbiz.helbizassignment.exception.ValidationException;
import com.helbiz.helbizassignment.model.FBIResult;
import org.springframework.stereotype.Service;

@Service
public class CaseService {

    private final FBIService fbiService;

    public CaseService(FBIService fbiService) {
        this.fbiService = fbiService;
    }

    public void validateCase(String name) {
        FBIResult fbiResult = fbiService.getFbiResult(name);

        if (fbiResult == null || Integer.parseInt(fbiResult.getTotal()) < 1) {
            throw new ValidationException("Case " + name + " is not in FBI database");
        }
    }
}
