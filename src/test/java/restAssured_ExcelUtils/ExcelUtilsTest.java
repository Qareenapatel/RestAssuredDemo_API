package restAssured_ExcelUtils;

public class ExcelUtilsTest {

	public static void main(String[] args) {
		
		String excelPath = "./data/dataDrivenExcelsheet.xlsx";
		String sheetName = "Sheet1";
		
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		excel.getRowCount();
		excel.getCellCount(1,0);
		excel.getCellCount(1,1);
		excel.getCellCount(1,2);
		
	}

}
