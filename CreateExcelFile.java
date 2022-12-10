package HomePage;

import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcelFile {
	public static void main(String[] args) throws IOException {
		XSSFWorkbook register = new XSSFWorkbook();
		XSSFSheet loginDetails = register.createSheet("Login Details");
		XSSFRow row = loginDetails.createRow(0);
		XSSFCell idCell = row.createCell(0);
		idCell.setCellValue("User Name");
		XSSFCell passCell = row.createCell(1);
		passCell.setCellValue("Password");
		XSSFCell initialsCell = row.createCell(2);
		initialsCell.setCellValue("Initials");
		XSSFCell emailCell = row.createCell(3);
		emailCell.setCellValue("Email address");
		XSSFCell phoneCell = row.createCell(4);
		phoneCell.setCellValue("Phone number");
		String filepath = "C:\\Users\\Akshat\\Desktop\\DataBase\\IdPassDataBase.xlsx";
		FileOutputStream output = new FileOutputStream(filepath);
		register.write(output);
		output.close();
		System.out.println("File created successfully");
		register.close();
	}
}