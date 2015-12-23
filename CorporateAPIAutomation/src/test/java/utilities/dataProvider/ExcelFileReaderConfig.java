package utilities.dataProvider;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class ExcelFileReaderConfig {

    @DataProvider
    public static Iterator<Object[]> getAPIConfig(Method callingMethod) throws IOException {
        FileInputStream sourceFile = null;
        Workbook workbook = null;
        ExcelFileReaderConfig configKey = new ExcelFileReaderConfig();
        ClassLoader loader = configKey.getClass().getClassLoader();
        try {
            sourceFile = new FileInputStream( new File(loader.getResource("config/Api_Config.xlsx").getFile()) );
            workbook = WorkbookFactory.create(sourceFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Sheet sheet = workbook.getSheet(callingMethod.getName());
        List<Object[]> jParamObj = new ArrayList<>();
        List<String> configKeys = new ArrayList<String>();

        for ( Iterator<Row> rowsIT = sheet.rowIterator(); rowsIT.hasNext(); ) {
            Row row = rowsIT.next();
            sheet.getRow(0);
            Iterator<Cell> headerIterator = row.cellIterator();

            // Config key extraction
            if ( row.getRowNum() == 0 ) {
                while ( headerIterator.hasNext() ) {
                    Cell headerCell = headerIterator.next();
                    configKeys.add((String) getCellValue(headerCell) );
                }
            } else {
                for ( Iterator<Cell> cellsIT = row.cellIterator(); cellsIT.hasNext(); ){
                    Map<String, String> JcellObj = new HashMap<>();
                    for (String getKey : configKeys) {
                        if (cellsIT.hasNext()){
                            Cell cell = cellsIT.next();
                            JcellObj.put( getKey, String.valueOf(getCellValue(cell)) );
                        }
                    }
                    jParamObj.add(new Object[] {JcellObj});
                }
            }
        }
        workbook.close();
        return jParamObj.iterator();
    }

    private static Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue();
            case Cell.CELL_TYPE_NUMERIC:
                return cell.getNumericCellValue();
            case Cell.CELL_TYPE_BLANK:
                return "";
            default:
                return "";

        }

    }
}
