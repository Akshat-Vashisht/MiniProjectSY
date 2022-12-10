package HomePage;

import java.io.IOException;
import java.util.Scanner;

public class TeacherMainPage {
    void TeacherMainPageMenu() throws Exception {
        int menu;
        MainPage mp = new MainPage();
        GenerationOptions go = new GenerationOptions();
        Scanner sc = new Scanner(System.in);
        System.out.println("\t**TEACHER PAGE**");
        do {
            System.out.println("\nKindly choose the operation you want to perform\n");
            System.out.println("1. Add a new pool of questions");
            System.out.println("2. Make changes to the existing pool of question");
            System.out.println("3. Add a new set of constraints");
            System.out.println("4. Check and update your existing constraints");
            System.out.println("5. Generate question paper");
            System.out.println("6. Exit");
            menu = sc.nextInt();
            switch (menu) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    break;
                case 5:
                    go.generateQuestionPaper();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Kindly enter a valid input based on the choices provided");
                    break;
            }
        } while (menu != 6);
    }
}