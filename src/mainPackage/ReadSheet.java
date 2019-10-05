package mainPackage;
//APIs que permitem o java manipular outros arquivos quaisquiser
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//API do iterator, que contar� cada linha e c�lula nos arquivos excel
import java.util.Iterator;

//imports das APIs para manipular os arquivos Wxcel
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ReadSheet {
	
	public void readEverything() throws IOException {
		
		 try
	        {
	            //Aqui instanciamos um arquivo para o java e pedimos para abr�-lo
			 	FileInputStream file = new FileInputStream(new File("Teste.xlsx"));
	            //FileInputStream file = new FileInputStream(new File("escolas_media_alunos_turma_2010.xlsx"));
	 
	            //Aqui, criamos um workbook, que guardar� as sheets do arquivo excel
	            XSSFWorkbook workbook = new XSSFWorkbook(file);
	 
	            //Instanciamos uma sheet para o java ler, no caso a sheet 0
	            XSSFSheet sheet = workbook.getSheetAt(0);
	 
	            //Criamos um iterator, que funciona como um array, guardando as linhas
	            Iterator<Row> rowIterator = sheet.iterator();
	            
	            //Vari�veis que ser�o usadas para controlar onde o java come�a e termina de ler o arquivo
	            int rowNum = 0;
	            int celNum = 0;
	            
	            
	            /*Esse primeiro while � um looping que vai nos dizer quantas c�lulas pular antes de come�ar
	            a ler o que queremos*/
	            while (rowNum < 0)
		            //while (rowIterator.hasNext())
		            {
	            		//Comando que manda o iterator para a pr�xima linha
		                Row row = rowIterator.next();
		                
		                Iterator<Cell> cellIterator = row.cellIterator();
		                 
		                //while (colNum < 3)
		                while (cellIterator.hasNext())
		                {
		                	//Comando que manda o iterator para a pr�xima c�lula
		                    Cell cell = cellIterator.next();
		                    
		                }
		                rowNum++;
		            }
	            //Fim do primeiro while
	            
	            rowNum=0;//reinicializa��o da quantidade de linhas que queremos ler
	            celNum=0;
	            
	            
	            while (rowNum < 3)
	            //while (rowIterator.hasNext())
	            {
	                Row row = rowIterator.next();
	                
	                Iterator<Cell> cellIterator = row.cellIterator();
	                 
	                //while (celNum < 1)
	                while (cellIterator.hasNext())
	                {
	                	//Instancia uma c�lula, v� se � um n�mero ou um String e o imprime
	                    Cell cell = cellIterator.next();
	                    switch (cell.getCellType())
	                    {
	                        case NUMERIC:
	                            System.out.print(cell.getNumericCellValue() + ";");
	                            break;
	                        case STRING:
	                            System.out.print(cell.getStringCellValue() + ";");
	                            break;
	                    }
	                    celNum++;
	                }
	                //Fim do loop de colunas
	                System.out.println("");
	                rowNum++;
	            }
	            //Fim do loop de Linhas
	            file.close();
	            workbook.close();
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
}
