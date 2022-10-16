package com.helbiz.helbizassignment.service;

import com.helbiz.helbizassignment.exception.FileException;
import com.helbiz.helbizassignment.model.Report;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

@Service
public class FileService {

    public void writeReportToFile(Report report) {

        File file = new File("reports.txt");
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(report.toString());
            printWriter.close();
        } catch (Exception e) {
            throw new FileException("Writing to file failed", e);
        }
    }
}
