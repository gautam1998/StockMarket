package com.stockmarket.upload.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.stockmarket.upload.model.StockPrice;

public class ExcelHelper {
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  static String[] HEADERs = { "CompanyName", "StockExchange","Price","Date","Time" };
  static String SHEET = "Sheet1";

  public static boolean hasExcelFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
      return false;
    }

    return true;
  }

  public static List<StockPrice> excelToTutorials(InputStream is) {
    try {
      Workbook workbook = new XSSFWorkbook(is);

      Sheet sheet = workbook.getSheet(SHEET);
      Iterator<Row> rows = sheet.iterator();

      List<StockPrice> tutorials = new ArrayList<StockPrice>();

      int rowNumber = 0;
      while (rows.hasNext()) {
        Row currentRow = rows.next();

        // skip header
        if (rowNumber == 0) {
          rowNumber++;
          continue;
        }

        Iterator<Cell> cellsInRow = currentRow.iterator();

        StockPrice tutorial = new StockPrice();

        int cellIdx = 0;
        while (cellsInRow.hasNext()) {
          Cell currentCell = cellsInRow.next();

          switch (cellIdx) {
          case 0:
        	 System.out.println(currentCell.getStringCellValue());
            //tutorial.setId(currentCell.getNumericCellValue());
            break;

          case 1:
        	System.out.println(currentCell.getStringCellValue()); 
            //tutorial.setTitle(currentCell.getStringCellValue());
            break;

          case 2:
        	System.out.println(currentCell.getNumericCellValue());
            //tutorial.setDescription(currentCell.getStringCellValue());
            break;

          case 3:
        	System.out.println(currentCell.getStringCellValue());
            //tutorial.setPublished(currentCell.getBooleanCellValue());
            break;
            
          case 4:
          	System.out.println(currentCell.getStringCellValue());
              //tutorial.setPublished(currentCell.getBooleanCellValue());
              break;

          default:
            break;
          }

          cellIdx++;
        }

        tutorials.add(tutorial);
      }

      workbook.close();

      return tutorials;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
    }
  }
}
