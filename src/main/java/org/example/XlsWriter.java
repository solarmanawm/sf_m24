package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class XlsWriter {
    private static final Logger log = LogManager.getLogger(XlsWriter.class);
    private final Workbook workbook;

    XlsWriter() {
        this.workbook = new XSSFWorkbook();
    }

    private Sheet createSheet() {
        String sheetName = "Страница 1";
        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            sheet = workbook.createSheet(sheetName);
        }

        return sheet;
    }

    private Font createCellHeadersFont() {
        Font font = workbook.createFont();
        font.setBold(true);;
        font.setFontHeightInPoints((short) 18);

        return font;
    }

    private CellStyle createCellHeadersStyle(Font font) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(font);

        return cellStyle;
    }

    private void setCellHeaders(Sheet sheet, CellStyle cellStyle) {
        String[] cellNames = {
                "Профиль обучения",
                "Средний балл за экзамен",
                "Количество студентов",
                "Количество университетов",
                "Названия университетов",
        };

        Row row = sheet.createRow(0);

        int CELL_QTY = cellNames.length;
        for (int i = 0; i < CELL_QTY; i++) {
            Cell cell = row.createCell(i, CellType.STRING);;

            cell.setCellValue(cellNames[i]);
            cell.setCellStyle(cellStyle);
        }
    }

    private void writeToFile(String filePath) {
        File file = new File(filePath);

        try (FileOutputStream fos = new FileOutputStream(file)) {
            workbook.write(fos);
        } catch (IOException e) {
            log.error("Невозможно записать в файл " + filePath);
            System.exit(1);
        }
    }

    private void setContent(Sheet sheet, ArrayList<Statistics> statistics) {
        int index = 1;

        for (Statistics stats : statistics) {
            Row row = sheet.createRow(index);

            Cell cell0 = row.createCell(0, CellType.STRING);
            cell0.setCellValue(stats.getStudyProfile().toString());

            Cell cell1 = row.createCell(1, CellType.NUMERIC);
            cell1.setCellValue(stats.getAvgExamScore());

            Cell cell2 = row.createCell(2, CellType.NUMERIC);
            cell2.setCellValue(stats.getStudentsByStudyProfile());

            Cell cell3 = row.createCell(3, CellType.NUMERIC);
            cell3.setCellValue(stats.getUniversitiesByStudyProfile());

            Cell cell4 = row.createCell(4, CellType.STRING);
            cell4.setCellValue(String.join(", ", stats.getUniversitiesNames()));

            index++;
        }
    }

    void generateTableAndWriteToFile(ArrayList<Statistics> statistics, String filePath) throws IOException {
        Sheet sheet = createSheet();
        Font font = createCellHeadersFont();
        CellStyle cellHeadersStyle = createCellHeadersStyle(font);
        setCellHeaders(sheet, cellHeadersStyle);
        setContent(sheet, statistics);
        writeToFile(filePath);

        log.info("Данные успешно записались в файл");
    }
}
