package com.rakesh.FileExporter;

import com.rakesh.FileExporter.model.Employee;
import com.rakesh.FileExporter.read.ReadExcel;
import com.rakesh.FileExporter.write.WriteExcel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FileExporterApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileExporterApplication.class, args);
		String src = "/Users/krishna/Desktop/file_loc/CandidatesProfilesexcel.xlsx";
		String dest = "/Users/krishna/Desktop/file_loc/newfile.xlsx";
		ReadExcel re = new ReadExcel();
		List<Employee> res = re.printFile(src);
		WriteExcel we = new WriteExcel();
		we.createExcel(res, dest);
	}

}
