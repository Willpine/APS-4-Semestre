package pseudomacro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//API do iterator, que contar� cada linha e c�lula nos arquivos excel
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

//imports das APIs para manipular os arquivos Wxcel
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ReadSheet {

    public static void readTable() throws IOException {
        FileInputStream file = new FileInputStream(new File("./resources/IDEB/IDEB/Dados/Por Escolas/divulgacao_ensino_medio-escolas-2017.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        Cell cell = workbook.getSheetAt(0).getRow(1).getCell(0);
        switch (cell.getCellType()) {
            case NUMERIC:
                System.out.println(cell.getNumericCellValue() + " ; ");
                break;
            case STRING:
                System.out.println(cell.getStringCellValue() + " ; ");
                break;
        }
    }

}
