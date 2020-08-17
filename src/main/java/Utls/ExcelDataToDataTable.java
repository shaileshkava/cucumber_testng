package Utls;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

public class ExcelDataToDataTable implements TypeRegistryConfigurer {

	@Override
	public Locale locale() {
		return Locale.ENGLISH;
	}

	@Override
	public void configureTypeRegistry(TypeRegistry typeRegistry) {
		TableEntryTransformer<Excel> entryTransformer = new TableEntryTransformer<Excel>() {
			
			@Override
			public Excel transform(Map<String, String> entry) throws Throwable {
				ExcelReader reader = new ExcelReader.ExcelReaderBuilder()
						.setFileLocation(entry.get("Path"))
						.setSheet(entry.get("SheetIndex"))
						.build();
				
				List<List<String>> excelData = getExcelData(reader);
				return new Excel(excelData);
			}
		};
		
		typeRegistry.defineDataTableType(new DataTableType(Excel.class, entryTransformer)); 
		
	}
	
	private List<List<String>> getExcelData(Utls.ExcelReader reader) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		List<List<String>> excelData = new LinkedList<>();
		try {
			excelData = reader.getSheetDataAt();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return excelData;
	}

}