package HomePage;

import java.io.IOException;
import java.util.Scanner;

public class MainPage {

    Register signUp = new Register();
    AboutUs ourInfo = new AboutUs();
    Login login = new Login();
    int menu = 0;
    Scanner sc = new Scanner(System.in);

    void MainPageMenu() throws Exception {

        System.out.println("\t**WELCOME TO AUTOMATIC QUESTION PAPER GENERATION SYSTEM PROGRAM**");
        do {
            System.out.println("\nKindly choose the operation you want to perform\n");
            System.out.println("1. Sign up");
            System.out.println("2. Sign in ");
            System.out.println("3. About us");
            System.out.println("4. Exit");
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    signUp.signUp();
                    break;
                case 2:
                    login.signIn();
                    break;
                case 3:
                    ourInfo.aboutUs();
                    break;
                case 4:
                    System.out.println("Thank you for using the program of Automatic Question Paper Generation System");
                    break;
                default:
                    System.out.println("Kindly enter a valid input based on the choices provided");
                    break;
            }
        } while (menu != 4);
    }

    public static void main(String[] args) throws Exception {
        MainPage mp = new MainPage();
        mp.MainPageMenu();
    }

}