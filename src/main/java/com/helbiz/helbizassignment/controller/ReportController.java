package com.helbiz.helbizassignment.controller;

import com.helbiz.helbizassignment.dto.ReportDto;
import com.helbiz.helbizassignment.model.Report;
import com.helbiz.helbizassignment.service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping
    public ResponseEntity<Void> createReport(@RequestBody ReportDto reportDto) {
        reportService.addReport(reportDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
