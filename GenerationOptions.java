package HomePage;

import java.util.Scanner;

public class GenerationOptions {
    Scanner sc = new Scanner(System.in);

    void generateQuestionPaper() throws Exception {
        System.out.println("Enter the format you want the question paper to be generated");
        System.out.println("1. 5x5");
        System.out.println("2. 6x4");
        int menu = sc.nextInt();
        switch (menu) {
            case 1:
                Generate5x5 g5x5 = new Generate5x5();
                g5x5.generateQuestionPaper();
                break;
            case 2:
                Generate6x4 g6x4 = new Generate6x4();
                g6x4.generateQuestionPaper();
                break;
            default:
                System.out.println("Enter the correct value");
                break;
        }
    }
}