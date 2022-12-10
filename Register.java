package HomePage;

import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;

class Register {
    void signUp() throws IOException {
        int flag = 0;
        String userName, password, emailAddress, initials;
        long phoneNumber;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the register page");

        FileInputStream fileCheck = new FileInputStream(
                new File("C:\\Users\\Akshat\\Desktop\\DataBase\\IdPassDataBase.xlsx"));
        XSSFWorkbook register = new XSSFWorkbook(fileCheck);
        XSSFSheet loginDetails = register.getSheet("Login Details");
        int rows = loginDetails.getLastRowNum();

        do {
            System.out.print("\nKindly enter a User Name: ");
            userName = sc.nextLine();
            for (int r = 1; r <= rows; r++) {

                XSSFRow row = loginDetails.getRow(r);
                XSSFCell cell = row.getCell(0);
                if (cell.toString().equals(userName)) {
                    System.out.println("That username already exists\n");
                    flag = 1;
                } else {
                    flag = 0;
                }
            }

        } while (flag != 0);
        do {
            System.out.println("\nKindly enter your Initials: ");
            System.out.print("This will be used to access your data: ");
            initials = sc.nextLine();
            for (int r = 1; r <= rows; r++) {

                XSSFRow row = loginDetails.getRow(r);
                XSSFCell cell = row.getCell(2);
                if (cell.toString().equals(initials)) {
                    System.out.println("This initial is already registered. Kindly enter a new one\n");
                    flag = 1;
                } else {
                    flag = 0;
                }
            }

        } while (flag != 0);

        try {
            int rowCount = loginDetails.getLastRowNum() + 1;
            XSSFRow row = loginDetails.createRow(rowCount);
            XSSFCell idCell = row.createCell(0);
            idCell.setCellValue(userName);
            XSSFCell passCell = row.createCell(1);
            System.out.print("\nEnter a strong password: ");
            password = sc.nextLine();
            passCell.setCellValue(password);
            XSSFCell initialsCell = row.createCell(2);
            initialsCell.setCellValue(initials);
            XSSFCell emailCell = row.createCell(3);
            System.out.print("\nEnter your email address: ");
            emailAddress = sc.nextLine();
            emailCell.setCellValue(emailAddress);
            XSSFCell phoneCell = row.createCell(4);
            System.out.print("\nEnter your phone number: ");
            phoneNumber = sc.nextLong();
            phoneCell.setCellValue(phoneNumber);
            FileOutputStream output = new FileOutputStream(
                    new File("C:\\Users\\Akshat\\Desktop\\DataBase\\IdPassDataBase.xlsx"));
            register.write(output);
            output.close();
            System.out.println("Update Successfully");
            register.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}