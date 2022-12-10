package HomePage;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TableRowAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import com.aspose.words.Document;

class Generate5x5 {
    List<String> unique5marks = new ArrayList<String>();
    List<String> marks5 = new ArrayList<String>();
    String path, name, finalpath, subject, unitName;
    int sourceTotal, unitNo, maxMarks, formatMenu;
    Scanner sc = new Scanner(System.in);

    void generateQuestionPaper() throws Exception {
        System.out.println("Enter the path where the pool of questions is stored: ");
        path = sc.nextLine();
        path = path.replace("\\", "//");
        System.out.println("Enter the name of the file");
        name = sc.nextLine();
        finalpath = path + "//" + name + ".xlsx";
        FileInputStream sourceStream = new FileInputStream(new File(finalpath));
        XSSFWorkbook sourceWorkbook = new XSSFWorkbook(sourceStream);
        XSSFSheet sourceSheet = sourceWorkbook.getSheetAt(0);
        sourceTotal = sourceSheet.getLastRowNum();
        System.out.println("Enter the name of the subject ");
        subject = sc.nextLine();
        System.out.println("Enter the unit no. ");
        unitNo = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the unit name ");
        unitName = sc.nextLine();
        System.out.println("Enter the maximum marks ");
        maxMarks = sc.nextInt();
        XWPFDocument doc = new XWPFDocument();
        XWPFParagraph p1 = doc.createParagraph();
        XWPFRun r1 = p1.createRun();
        r1.setText("MIT ADT University");
        r1.addBreak();
        r1.setText(subject);
        r1.addBreak();
        r1.setText("TA Question Paper");
        r1.addBreak();
        r1.addBreak();
        r1.setText("UNIT " + unitNo + ": " + unitName);
        p1.setAlignment(ParagraphAlignment.CENTER);
        r1.setFontFamily("Times New Roman");
        r1.setBold(true);
        r1.setFontSize(12);
        XWPFParagraph p2 = doc.createParagraph();
        XWPFRun r2 = p2.createRun();
        r2.setText("Max Marks: " + maxMarks);
        r2.setBold(true);
        r2.setFontFamily("Times New Roman");
        r2.setFontSize(12);
        p2.setAlignment(ParagraphAlignment.RIGHT);
        XWPFParagraph p3 = doc.createParagraph();
        XWPFRun r3 = p3.createRun();
        r3.setText("-----------------------------------------------------------------------------------------------"
                + "-------------------------------------------");
        r3.addBreak();
        r3.setText("General Instructions: ");
        r3.addBreak();
        r3.setText("1) Assume suitable data if necessary");
        r3.addBreak();
        r3.setText("2) Use of nonprogrammable type of scientific calculator is allowed");
        r3.addBreak();
        r3.setText("3) Do not write anything other than the Enrolment number on the question paper");
        r3.addBreak();
        r3.setText("4) Figures to right indicate the marks allotted to the questions");
        r3.addBreak();
        r3.setText("5) Leave enough margin on all the sides and start each question on new page ");
        r3.addBreak();
        r3.setText("-----------------------------------------------------------------------------------------------"
                + "-------------------------------------------");
        p3.setAlignment(ParagraphAlignment.LEFT);
        r3.setBold(true);
        for (int i = 1; i <= sourceTotal; i++) {
            XSSFRow row = sourceSheet.getRow(i);
            XSSFCell cell = row.getCell(2);
            int marksCheck = (int) cell.getNumericCellValue();
            if (marksCheck == 5) {
                marks5.add(row.getCell(1).getStringCellValue());
            } else {
                continue;
            }
        }
        for (int i = 1; i <= 4; i++) {
            int random = ThreadLocalRandom.current().nextInt(1, marks5.size());
            String question1 = marks5.get(random - 1);
            if (!unique5marks.contains(question1)) {
                unique5marks.add(question1);
            } else {
                i--;
            }
        }

        finalpath = finalpath.replace(name, "Test");

        XWPFTable table = doc.createTable(6, 3);
        for (int i = 1; i <= 4; i++) {
            XWPFTableRow row = table.getRow(i - 1);
            XWPFRun run1 = row.getCell(0).addParagraph().createRun();
            run1.setText("Q" + i + ") ");
            run1.setFontFamily("Times New Roman");
            run1.setFontSize(12);
            XWPFRun run2 = row.getCell(1).addParagraph().createRun();
            run2.setText(unique5marks.get(i - 1));
            run2.setFontFamily("Times New Roman");
            run2.setFontSize(12);
            XWPFRun run3 = row.getCell(2).addParagraph().createRun();
            run3.setText("(5)");
            run3.setFontFamily("Times New Roman");
            run3.setFontSize(12);
            table.setTableAlignment(TableRowAlign.LEFT);
            table.removeBorders();
        }
        String docPath = finalpath.replace(".xlsx", ".docx");
        FileOutputStream output = new FileOutputStream(docPath);
        doc.write(output);
        output.close();
        Document conversionDoc = new Document(docPath);
        String pdfPath = finalpath.replace(".xlsx", ".pdf");
        conversionDoc.save(pdfPath);
        Desktop.getDesktop().open(new File(pdfPath));
    }
}
