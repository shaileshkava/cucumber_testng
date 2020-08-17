package Utls;

import java.util.List;

public class Excel {
	
	private List<List<String>> excelData; //outer list for row and inner list for column of row
	
	public Excel(List<List<String>> excelData) {
		this.excelData = excelData;
	}

	public List<List<String>> getExcelData() {
		return excelData;
	}
	
	
	
}
