package com.helbiz.helbizassignment.service;

import com.google.i18n.phonenumbers.Phonenumber;
import com.helbiz.helbizassignment.dto.ReportDto;
import com.helbiz.helbizassignment.model.Report;
import org.springframework.stereotype.Service;

@Service
public class ReportService {

    private final PhoneNumberService phoneNumberService;
    private final CaseService caseService;
    private final FileService fileService;

    public ReportService(PhoneNumberService phoneNumberService, CaseService caseService, FileService fileService) {
        this.phoneNumberService = phoneNumberService;
        this.caseService = caseService;
        this.fileService = fileService;
    }

    private Report createReport(ReportDto reportDto, String phoneNumberCountry) {
        return new Report(reportDto.getName(), reportDto.getPhoneNumber(), phoneNumberCountry);
    }

    public void addReport(ReportDto reportDto) {
        caseService.validateCase(reportDto.getName());
        Phonenumber.PhoneNumber number = phoneNumberService.parsePhoneNumber(reportDto.getPhoneNumber());
        phoneNumberService.validatePhoneNumber(number);
        String phoneNumberCountry = phoneNumberService.getPhoneNumberCountry(number);

        Report report = createReport(reportDto, phoneNumberCountry);
        fileService.writeReportToFile(report);
    }
}

