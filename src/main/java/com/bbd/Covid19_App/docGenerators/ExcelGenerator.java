package com.bbd.Covid19_App.docGenerators;

import com.bbd.Covid19_App.entities.Patient;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;



public class ExcelGenerator {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Patient> patients;
    private static String[] columns = {"Lp.", "Imie", "Nazwisko", "Płeć", "Wiek", "Data uzyskania wyniku dodatniego", "Data pozyskania informacji przez PSSE",
                                        "Miejscowość zamieszkania chorego", "Województwo", "Miejsowość pobytu chorego", "Wojewódzwo", "Hospitalizowany tak/nie \n nazwa szpitala",
                                        "Poddany kwarantannie tak/nie", "Objęty nadzorem \n tak/nie", "Laboratorium wykonujące \n badanie", "Źródło zakażenia", "Numer telefonu"};


    public ExcelGenerator(List<Patient> patients) {
        this.workbook = new XSSFWorkbook();
        this.patients = patients;
    }

    private void createExcelDocument() {

        sheet = workbook.createSheet("Arkusz 1");

        Font headersFont = workbook.createFont();
        headersFont.setBold(true);
        headersFont.setFontName("Times");
        headersFont.setFontHeightInPoints((short) 12);
        headersFont.setColor(IndexedColors.BLACK.getIndex());

        CellStyle headerCellsStyle = workbook.createCellStyle();
        headerCellsStyle.setAlignment(HorizontalAlignment.CENTER);
        headerCellsStyle.setFont(headersFont);
        headerCellsStyle.setBorderBottom(BorderStyle.THIN);
        headerCellsStyle.setBorderLeft(BorderStyle.THIN);
        headerCellsStyle.setBorderRight(BorderStyle.THIN);
        headerCellsStyle.setBorderTop(BorderStyle.THIN);

        Row titleRow = sheet.createRow(0);
        Cell titleCells = titleRow.createCell(0);
        titleCells.setCellValue("Informacja o wynikach dodatnich uzyskanych z laboratoriów COVID19 z innych województw");
        titleCells.setCellStyle(headerCellsStyle);
        sheet.addMergedRegion(new CellRangeAddress(0,0,0, columns.length-1));


        Row headerRow = sheet.createRow(1);
        for (int i = 0; i < columns.length; i++) {
            Cell headerCells = headerRow.createCell(i);
            headerCells.setCellValue(columns[i]);
            headerCells.setCellStyle(headerCellsStyle);
        }


        Font textFont = workbook.createFont();
        textFont.setBold(false);
        textFont.setFontName("Times");
        textFont.setFontHeightInPoints((short) 12);
        textFont.setColor(IndexedColors.BLACK.getIndex());

        CreationHelper createHelper = workbook.getCreationHelper();
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setFont(textFont);
        dateCellStyle.setAlignment(HorizontalAlignment.CENTER);
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd.MM.yyyy"));
        dateCellStyle.setBorderBottom(BorderStyle.THIN);
        dateCellStyle.setBorderLeft(BorderStyle.THIN);
        dateCellStyle.setBorderRight(BorderStyle.THIN);
        dateCellStyle.setBorderTop(BorderStyle.THIN);

        CellStyle normalCellStyle = workbook.createCellStyle();
        normalCellStyle.setFont(textFont);
        normalCellStyle.setAlignment(HorizontalAlignment.CENTER);
        normalCellStyle.setBorderBottom(BorderStyle.THIN);
        normalCellStyle.setBorderLeft(BorderStyle.THIN);
        normalCellStyle.setBorderRight(BorderStyle.THIN);
        normalCellStyle.setBorderTop(BorderStyle.THIN);

        int rowNum = 2;
        for (Patient patient : patients) {

            Row row = sheet.createRow(rowNum);

            Cell lp = row.createCell(0);
            lp.setCellValue(rowNum-1);
            lp.setCellStyle(normalCellStyle);

            Cell name = row.createCell(1);
            name.setCellValue(patient.getName());
            name.setCellStyle(normalCellStyle);

            Cell surname = row.createCell(2);
            surname.setCellValue(patient.getSurname());
            surname.setCellStyle(normalCellStyle);

            Cell gender = row.createCell(3);
            gender.setCellValue(patient.getGender());
            gender.setCellStyle(normalCellStyle);

            Cell age = row.createCell(4);
            age.setCellValue(patient.getAge());
            age.setCellStyle(normalCellStyle);

            Cell dateOfpositiveCell = row.createCell(5);
            if (patient.getDatePositive() != null) {
                dateOfpositiveCell.setCellValue(localDate2Date(patient.getDatePositive()));
            }
            dateOfpositiveCell.setCellStyle(dateCellStyle);

            Cell dateOfPSSECell = row.createCell(6);
            if (patient.getDateInformation() != null) {
                dateOfPSSECell.setCellValue(localDate2Date(patient.getDateInformation()));
            }
            dateOfPSSECell.setCellStyle(dateCellStyle);

            Cell residenceCity = row.createCell(7);
            residenceCity.setCellValue(patient.getResidenceCity());
            residenceCity.setCellStyle(normalCellStyle);

            Cell residenceDistrict = row.createCell(8);
            residenceDistrict.setCellValue(patient.getResidenceDistrict());
            residenceDistrict.setCellStyle(normalCellStyle);


            Cell stayCity = row.createCell(9);
            stayCity.setCellValue(patient.getStayCity());
            stayCity.setCellStyle(normalCellStyle);


            Cell stayDistrict = row.createCell(10);
            stayDistrict.setCellValue(patient.getStayDistrict());
            stayDistrict.setCellStyle(normalCellStyle);


            Cell isHispitalized_nameHospital = row.createCell(11);
            String hospitalCell = (patient.getHospitalized()) ? "TAK/" + patient.getHospitalName() : "NIE";
            isHispitalized_nameHospital.setCellValue(hospitalCell);
            isHispitalized_nameHospital.setCellStyle(normalCellStyle);


            Cell inQuarantine = row.createCell(12);
            String inQuartineCell = (patient.getInQuarantine()) ? "TAK" : "NIE";
            inQuarantine.setCellValue(inQuartineCell);
            inQuarantine.setCellStyle(normalCellStyle);


            Cell supervision = row.createCell(13);
            String supervisionCell = (patient.getSupervision()) ? "TAK" : "NIE";
            supervision.setCellValue(supervisionCell);
            supervision.setCellStyle(normalCellStyle);

            Cell labName = row.createCell(14);
            labName.setCellValue(patient.getLabName());
            labName.setCellStyle(normalCellStyle);

            Cell infectionSource = row.createCell(15);
            infectionSource.setCellValue(patient.getInfectionSource());
            infectionSource.setCellStyle(normalCellStyle);

            Cell phoneNumber = row.createCell(16);
            StringBuilder sb = new StringBuilder(patient.getPhoneNumber());
            sb.insert(3, " ");
            sb.insert(7, " ");
            phoneNumber.setCellValue(sb.toString());
            phoneNumber.setCellStyle(normalCellStyle);

            rowNum++;
        }

        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
    }

    private  Date localDate2Date(LocalDate inDate) {
        Date outDate = Date.from(inDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return outDate;

    }

    public void export(HttpServletResponse response) throws IOException {
        createExcelDocument();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }
}
