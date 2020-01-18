package com.rakesh.FileExporter.read;

import com.rakesh.FileExporter.model.Employee;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ReadExcel {
    List<Employee> ls = new LinkedList<>();
        public List<Employee> printFile() {

            try
            {
                FileInputStream file = new FileInputStream(new File("/Users/krishna/Desktop/file_loc/CandidatesProfilesexcel.xlsx"));

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext())
            {
                Employee curr = new Employee();
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                int i =0;
                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();

                    switch (cell.getCellType()) {
                        case NUMERIC:
                            curr.setId(cell.getNumericCellValue());
                            i++;
                            break;
                        case STRING:
                            String s = cell.getStringCellValue();
                            String[] arr = s.split(",");
                            if(i == 1) {
                                for (String k : arr){
                                    curr.profession.add(k);
                                }
                                i++;
                            }
                            else if (i == 2){
                                for(String k : arr){
                                    curr.specialization.add(k);
                                }
                            }
                    }
                }
                ls.add(curr);
            }
            file.close();
        }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            return ls;
        }
    }

