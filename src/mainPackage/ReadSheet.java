//Fazer um while no método que retorna tudo pra ele ir retornando todos os valores do vetor
package mainPackage;
//APIs que permitem o java manipular outros arquivos quaisquiser

import com.monitorjbl.xlsx.StreamingReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//API do iterator, que contar� cada linha e c�lula nos arquivos excel
import java.util.Iterator;
import javax.swing.JTable;

//imports das APIs para manipular os arquivos Wxcel
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.InputStream;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;

public abstract class ReadSheet extends javax.swing.JFrame {

    public static void readTableMedio(JTable jTableMedio) throws IOException {
        FileInputStream file = new FileInputStream(new File("./resources/IDEB/IDEB/Dados/Por Escolas/divulgacao_ensino_medio-escolas-2017.xlsx"));
        //FileInputStream file = new FileInputStream(new File("./resources/IDEB/IDEB/Dados/Por Escolas/divulgacao_anos_finais-escolas-2017.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Cell cell;

        int col, row, j;

        col = 0;
        row = 0;

        for (int i = 7; i < 11; i++) {
            j = 3;
            //Cod
            cell = workbook.getSheetAt(0).getRow(i).getCell(3);
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
            cell = workbook.getSheetAt(0).getRow(i).getCell(4);
            col++;
            //Nome
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
            col += 3;
            j = 15;
            //Notas médio
            while (j < 17) {
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
                j++;
            }

            col = 0;
            System.out.println("");
            row++;
        }
    }

    public static void readTableIniFin(boolean type) throws Exception {
        String file = null;
        if (type == false)
            file = "./resources/IDEB/IDEB/Dados/Por Escolas/divulgacao_anos_iniciais-escolas-2017.xlsx";
        else
            file = "./resources/IDEB/IDEB/Dados/Por Escolas/divulgacao_anos_finais-escolas-2017.xlsx";
        InputStream is = new FileInputStream(new File(file));
        Workbook workbook = StreamingReader.builder()
                .rowCacheSize(100) // number of rows to keep in memory (defaults to 10)
                .bufferSize(4096) // buffer size to use when reading InputStream to file (defaults to 1024)
                .open(is);            // InputStream or File for XLSX file (required)
        int row,cell,i,j;
        i=0;j=0;row=0;cell=0;
        for (Sheet sheet : workbook) {
            System.out.println(sheet.getSheetName());
            
            for (Row r : sheet) {
                for (Cell c : r) {
                    switch(c.getColumnIndex()){
                        case 3:
                        System.out.println(c.getStringCellValue() + ";");
                        break;
                        case 4:
                        System.out.println(c.getStringCellValue() + ";");
                        break;
                        case 68:
                        System.out.println(c.getStringCellValue() + ";");
                        break;
                        case 75:
                        System.out.println(c.getStringCellValue() + ";");
                        break;
                        default:
                        break;
                    }
                    i++;
                }
            }
            
        }
    }
}
