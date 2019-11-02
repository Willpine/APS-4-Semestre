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

import java.io.InputStream;

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

    public static void readTableIniFin() throws Exception {
        File directory = null;
        String[] listaDir = null;
        int stampa = 0;
        while(true){    
            System.gc();
            if(stampa++ > 1000){System.out.println(".");stampa = 0;}else{System.out.println(".");}
            Thread.sleep(2000);
            //directory = new File("./resources/IDEB/IDEB/Dados/Por Escolas/");//E aqui
            //listaDir = directory.list();
            //if(listaDir.length > 0){
                File enMed = new File("./resources/IDEB/IDEB/Dados/Por Escolas/divulgacao_ensino_medio-escolas-2017.xlsx");//Aqui
                FileInputStream enMedStream = new FileInputStream(enMed.getAbsolutePath());
                XSSFWorkbook workbook = new XSSFWorkbook(enMedStream);
                XSSFSheet sheet = workbook.getSheetAt(0);//Diferente aqui
                for(int i =5; i < sheet.getLastRowNum();i++){
                    XSSFCell a1 = sheet.getRow(i).getCell(3);
                    XSSFCell a2 = sheet.getRow(i).getCell(4);
                    XSSFCell a3 = sheet.getRow(i).getCell(15);
                    if(a3.getCellType().equals(NUMERIC))
                    System.out.println(a1.getNumericCellValue()+" - "
                    +a2.getStringCellValue()+" - "+a3.getNumericCellValue());
                }
                enMedStream.close();workbook.close();
            //}
        }
    }

    
}
