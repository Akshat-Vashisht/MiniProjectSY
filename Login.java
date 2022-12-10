package HomePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Login {
    void signIn() throws Exception {
        Scanner sc = new Scanner(System.in);
        String userName, password;
        boolean usernameMatch = false, passwordMatch = false;
        FileInputStream fileCheck = new FileInputStream(
                new File("C:\\Users\\Akshat\\Desktop\\DataBase\\IdPassDataBase.xlsx"));
        XSSFWorkbook register = new XSSFWorkbook(fileCheck);
        XSSFSheet loginDetails = register.getSheet("Login Details");
        int rows = loginDetails.getLastRowNum();
        System.out.println("Enter your username");
        userName = sc.nextLine();
        System.out.println("Enter your password");
        password = sc.nextLine();
        for (int r = 1; r <= rows; r++) {
            XSSFRow row = loginDetails.getRow(r);
            XSSFCell usernameCell = row.getCell(0);
            if (usernameCell.toString().equals(userName)) {
                usernameMatch = true;
                XSSFCell passwordCell = row.getCell(1);
                if (passwordCell.toString().equals(password)) {
                    passwordMatch = true;
                    break;
                }

            }

        }
        if (passwordMatch == true && usernameMatch == true) {
            System.out.println("Login successful");
            System.out.println("Welcome " + userName + "!!!!");
            TeacherMainPage tmp = new TeacherMainPage();
            tmp.TeacherMainPageMenu();
        } else {
            System.out.println("Login Failed");
        }
        register.close();
    }
}