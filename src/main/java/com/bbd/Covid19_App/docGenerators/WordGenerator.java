package com.bbd.Covid19_App.docGenerators;

import com.bbd.Covid19_App.entities.Patient;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.tomcat.jni.Local;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class WordGenerator {


    HWPFDocument document;
    Patient patient;
    String wordFileName;
    FileInputStream tempFileInputStream;
    Map<String, String> contentMap;


    public WordGenerator(Patient patient, String wordFileName) throws Exception{
        this.patient = patient;
        this.wordFileName = wordFileName;
        tempFileInputStream = new FileInputStream(wordFileName);
        this.document = new HWPFDocument(tempFileInputStream);
        this.contentMap = new HashMap<String, String>();

        contentMap.put("nameAndSurname",patient.getName() + " " + patient.getSurname());
        contentMap.put("id", patient.getPatientId().toString());
        contentMap.put("streetAndApartmentNumber", "ul. " + patient.getResidenceStreet() + " " + patient.getResidenceApartmentNumber());
        contentMap.put("cityCodeAndCity", patient.getResidenceCityCode() + " " + patient.getResidenceCity());
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        contentMap.put("date",  formattedDate);
    }

    private void createWordDocument() {
        Range bodyRange = document.getRange();

        for (Map.Entry<String, String> entry : contentMap.entrySet()) {
            bodyRange.replaceText("${" + entry.getKey() + "}", entry.getValue());
        }

    }

    public void export(HttpServletResponse response) throws IOException {
        createWordDocument();

        ServletOutputStream outputStream = response.getOutputStream();
        document.write(outputStream);
        document.close();

        outputStream.close();

    }
}
