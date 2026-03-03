package utils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    public static Object[][] getLoginData() {

        try {

            FileInputStream fis = new FileInputStream(
                "src/test/resources/testdata.xlsx");

            Workbook wb = new XSSFWorkbook(fis);
            Sheet sheet = wb.getSheet("LoginData");

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[rows-1][cols];

            for(int i=1; i<rows; i++) {
                for(int j=0; j<cols; j++) {
                    data[i-1][j] = sheet.getRow(i)
                                        .getCell(j)
                                        .toString();
                }
            }

            wb.close();
            return data;

        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}