Set objExcel = CreateObject("Excel.Application")
Set objWorkbook =  objExcel.Workbooks.Open("Teste.xlsm")
	           
objExcel.Application.Run"Teste.xlsm!mSla"
objExcel.ActivateWorkbook.Close
	            
objExcel.Application.Quit
WScript.Quit
	            