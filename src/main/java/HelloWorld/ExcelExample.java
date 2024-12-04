package HelloWorld;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelExample {
    public static void main(String[] args) throws IOException 
    {
        // Creare workbook și sheet
        FileInputStream file = new FileInputStream("exemplu.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);

        // Citirea unei valori dintr-o celulă
        String valoare = sheet.getRow(0).getCell(0).getStringCellValue();
        System.out.println("Valoarea citită: " + valoare);

        // Scrierea unei valori într-o celulă
        sheet.getRow(0).createCell(1).setCellValue("Nouă valoare");

        // Salvarea fișierului modificat
        FileOutputStream outputStream = new FileOutputStream("exemplu_modificat.xlsx");
        workbook.write(outputStream);

        // Închidere workbook și file stream
        workbook.close();
        file.close();
        outputStream.close();
    }
}
