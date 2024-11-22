package by.teachmeskills.yadevich.lesson14;

import by.teachmeskills.yadevich.lesson14.sorterValidDocuments.SorterValidDocument;
import by.teachmeskills.yadevich.lesson14.validator.pathValidator.PathValidator;

import java.nio.file.InvalidPathException;
import java.util.Scanner;

public class ApplicationRunner {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the path to the file: ");
            String path = scanner.nextLine();
            PathValidator.checkPath(path);
            scanner.close();
            SorterValidDocument.sorterDocument(path);
        }catch (InvalidPathException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
