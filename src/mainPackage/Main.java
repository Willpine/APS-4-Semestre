package mainPackage;

//API de manipulação de arquivos
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

//API de manipulação de documentos Excel
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {

	public static void main(String[] args) throws IOException {
		File excelFile = new File("Teste.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);
		
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workBook.getSheetAt(0);
		
		Iterator<Row> rowIt = sheet.iterator();
		
		while(rowIt.hasNext()) {
			Row row = rowIt.next();
			
			Iterator<Cell> cellIterator = row.cellIterator();
			
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				System.out.print(cell.toString() + ";");
			}
			
			System.out.println();
		}
		
		workBook.close();
		fis.close();
	}

}
