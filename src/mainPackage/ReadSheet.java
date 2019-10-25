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

    public String[] col;
    public String[][] data;

    public void readEverything(int rowNum, int rowsToRead, int celNum, JTable mainTable) throws IOException {

        //Aqui instanciamos um arquivo para o java e pedimos para abr�-lo
        FileInputStream file = new FileInputStream(new File("./resources/Teste.xlsm"));
        //FileInputStream file = new FileInputStream(new File("./resources/divulgacao_anos_finais-escolas-2017.xlsm"));
        //FileInputStream file = new FileInputStream(new File("./resources/IDEB/IDEB/Dados/Por Escolas/divulgacao_ensino_medio-escolas-2017.xlsx"));

        //Aqui, criamos um workbook, que guardar� as sheets do arquivo excel
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //Instanciamos uma sheet para o java ler, no caso a sheet 0
        XSSFSheet sheet = workbook.getSheetAt(0);

        readTableEscolas(rowNum, rowsToRead, celNum, file, workbook, sheet, mainTable);

    }

    //Inicializa um workbook, pula linhas ou não, lê e printa o conteúdo de uma tabela Excel
    public void readTableEscolas(int rowNum, int rowsToRead, int celNum, FileInputStream file, XSSFWorkbook workbook, XSSFSheet sheet, JTable mainTable) throws IOException {
        //Criamos um iterator, que funciona como um array, guardando as linhas
        Iterator<Row> rowIterator = sheet.iterator();

        //Vari�veis que ser�o usadas para controlar onde o java come�a e termina de ler o arquivo
        //QUANTAS LINHAS SERÃO PULADAS
        /*Esse primeiro while � um looping que vai nos dizer quantas c�lulas pular antes de come�ar
         a ler o que queremos*/
        skipRows(1, 0, rowIterator);
	            //Fim do primeiro while

        //System.out.println(rowNum);//rowNum=0;//reinicialização da quantidade de linhas que queremos ler
        celNum = 0;
        rowNum = 0;
        int rowsToGo = 0;

        //QUANTAS LINHAS SERÃO LIDAS
        readRows(0, 10, 0, rowIterator, mainTable);
        file.close();
        workbook.close();
    }

    //Pula determinado número de linhas de uma tabela do Excel
    public void skipRows(int skip, int rowNum, Iterator<Row> rowIterator) {

        while (rowNum < skip) //while (rowIterator.hasNext())
        {
            //Comando que manda o iterator para a pr�xima linha
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();

            //while (colNum < 3)
            while (cellIterator.hasNext()) {
                //Comando que manda o iterator para a pr�xima c�lula
                Cell cell = cellIterator.next();

            }
            rowNum++;
        }
    }

    //Lê e printa tabelas do Excel
    public void readRows(int rowNum, int rowsToRead, int celNum, Iterator<Row> rowIterator, JTable mainTable) {
        //while (rowNum < (rowsToRead)) //OPÇÃO 1 - LÊ UM INTERVALO
        int i, j;
        i = 0;
        j = 0;
         while (i < 10)//OPÇÃO 1 - LÊ TUDO
        //while (rowIterator.hasNext())//OPÇÃO 2 - LÊ TUDO
        {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            //while (celNum < 1)
            while (cellIterator.hasNext()) {
                //Instancia uma c�lula, v� se � um n�mero ou um String e o imprime
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case NUMERIC:
                        mainTable.setValueAt(cell.getNumericCellValue(), i, j);
                        break;
                    case STRING:
                        mainTable.setValueAt(cell.getStringCellValue(), i, j);
                        break;
                }
                j++;
            }
            j=0;
            i++;
        }
    }
}
