package by.teachmeskills.yadevich.lesson14.sorterValidDocuments;

import by.teachmeskills.yadevich.lesson14.validator.contractValidator.ContractValidator;
import by.teachmeskills.yadevich.lesson14.validator.docnumValidator.DocnumValidator;

import java.io.*;

public class SorterValidDocument {

    public static void sorterDocument(String path) {
        String pathDocnumFile =
                "/Users/admin/Documents/IdeaProjects/Курс по Java/Teachmeskills/TeachMeSkills_C32_HW_Lesson14/resources/DocnumFile";
        String pathContractFile =
                "/Users/admin/Documents/IdeaProjects/Курс по Java/Teachmeskills/TeachMeSkills_C32_HW_Lesson14/resources/ContractFile";
        String pathInvalidDocuments =
                "/Users/admin/Documents/IdeaProjects/Курс по Java/Teachmeskills/TeachMeSkills_C32_HW_Lesson14/resources/InvalidDocuments";

        try (
                BufferedReader reader = new BufferedReader(new FileReader(path)); // входной файл читается построчно
                BufferedWriter writerDocnum = new BufferedWriter(new FileWriter(pathDocnumFile)); // если строка прошла проверку, она записывается в выходной файл.
                BufferedWriter writerContract = new BufferedWriter(new FileWriter(pathContractFile));
                BufferedWriter writerInvalidDocument = new BufferedWriter(new FileWriter(pathInvalidDocuments))
        ) {
            String numberDocument;
            while ((numberDocument = reader.readLine()) != null) { // читает построчно

                if (DocnumValidator.isValidDocnumNumber(numberDocument)) { // Проверка строки
                    writerDocnum.write(numberDocument);  // записывает строку в файл
                    writerDocnum.newLine();    // переходит на новую строку
                } else if (ContractValidator.isValidContractNumber(numberDocument)) {
                    writerContract.write(numberDocument);
                    writerContract.newLine();
                }else{
                    if (numberDocument.length() != 15) {
                        writerInvalidDocument.write(numberDocument + " ---- invalid length.");
                        writerInvalidDocument.newLine();
                    } else if (!(numberDocument.startsWith("docnum")) || !(numberDocument.startsWith("сontract"))) {
                        writerInvalidDocument.write(numberDocument + " ---- " +
                                "incorrect sequence of characters at the beginning.");
                        writerInvalidDocument.newLine();
                    }else if(!(numberDocument.matches("[a-zA-Z0-9]*"))) {
                        writerInvalidDocument.write(numberDocument + " ---- there are\n" +
                                "service characters in the document name.");
                        writerInvalidDocument.newLine();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());;
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
    }
}



