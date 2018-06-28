package Managers;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriterManager {


    // https://poi.apache.org/spreadsheet/quick-guide.html SUPER IMPORTANT

    private Workbook workbook = new XSSFWorkbook();

    public void createNewTemplateFile() {
        try {


            CreationHelper creationHelper = workbook.getCreationHelper();


            Sheet product = workbook.createSheet("Products");
            Sheet Employee = workbook.createSheet("Objects.Employee");
            Sheet Store = workbook.createSheet("Objects.Store");

            addProductTemplate(product);


            FileOutputStream fileOut = fileOut = new FileOutputStream("File/FinalProject-Sanhueza.xlsx");
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();


        } catch (IOException ex) {
            ex.printStackTrace();
        }


        // Closing the workbook
    }

    private void addProductTemplate(Sheet sheet) {


        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 1: //Add Styles to ID Column
                    CellStyle IdStyle = workbook.createCellStyle();
                    IdStyle.setAlignment(HorizontalAlignment.CENTER);
                    IdStyle.setLocked(true);

                    sheet.setDefaultColumnStyle(i, IdStyle);
                    break;

                case 2: //Add validation to Objects.Product name
                    break;

                case 3: //Add formatting to Currency
                    CellStyle currencyStyle = workbook.createCellStyle();
                    currencyStyle.setDataFormat(workbook.createDataFormat().getFormat("$#,##0.00;-$#,##0.00"));

                    sheet.setDefaultColumnStyle(i, currencyStyle);
                    break;
            }
        }

        for (int i = 1; i <= 3; i++) {
            Row row = sheet.createRow(i);

            switch (i) {
                case 1:

                    CellStyle headerCellStyle = workbook.createCellStyle();
                    Font font = workbook.createFont();
                    font.setColor(HSSFColor.RED.index);
                    font.setBold(true);
                    headerCellStyle.setFont(font);
                    headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
                    headerCellStyle.setLocked(true);


                    Cell cellId = row.createCell(1);
                    cellId.setCellValue("ID");
                    cellId.setCellStyle(headerCellStyle);

                    Cell cellProduct = row.createCell(2);
                    cellProduct.setCellValue("Objects.Product Name");
                    cellProduct.setCellStyle(headerCellStyle);

                    Cell cellPrice = row.createCell(3);
                    cellPrice.setCellValue("Objects.Product price per bag");
                    cellPrice.setCellStyle(headerCellStyle);


                    Cell cellQuantity = row.createCell(4);
                    cellQuantity.setCellValue("Objects.Product quantity per bag");
                    cellQuantity.setCellStyle(headerCellStyle);
                    break;
            }
        }

        for (int i = 0; i < 6; i++) {
            sheet.autoSizeColumn(i);
        }
    }
}
