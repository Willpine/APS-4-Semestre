//Fazer um while no método que retorna tudo pra ele ir retornando todos os valores do vetor
package mainPackage;
//APIs que permitem o java manipular outros arquivos quaisquiser

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//API do iterator, que contar� cada linha e c�lula nos arquivos excel
import java.util.Iterator;
import javax.swing.JTable;

//imports das APIs para manipular os arquivos Wxcel
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public abstract class ReadSheet extends javax.swing.JFrame {

    public static int col, row;

    public static void readTableMedio(JTable jTableMedio) throws IOException {
        FileInputStream file = new FileInputStream(new File("./resources/IDEB/IDEB/Dados/Por Escolas/divulgacao_ensino_medio-escolas-2017.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        Cell cell;

        col = 0;
        row = 0;

        for (int i = 7; i < 17; i++) {
            for (int j = 3; j < 5; j++) {
                cell = workbook.getSheetAt(0).getRow(i).getCell(j);
                switch (cell.getCellType()) {
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue() + " ; ");
                        jTableMedio.setValueAt(cell.getNumericCellValue(), row, col);
                        break;
                    case STRING:
                        System.out.print(cell.getStringCellValue() + " ; ");
                        jTableMedio.setValueAt(cell.getStringCellValue(), row, col);
                        break;
                }
                col++;
            }
            col+=2;
            for (int j = 15; j < 17; j++) {
                cell = workbook.getSheetAt(0).getRow(i).getCell(j);
                switch (cell.getCellType()) {
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue() + " ; ");
                        jTableMedio.setValueAt(cell.getNumericCellValue(), row, col);
                        break;
                    case STRING:
                        System.out.print(cell.getStringCellValue() + " ; ");
                        jTableMedio.setValueAt(cell.getStringCellValue(), row, col);
                        break;
                }
                col++;

            }

            col = 0;
            System.out.println("");
            row++;
        }
    }

}
