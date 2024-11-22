package by.teachmeskills.yadevich.lesson14.validator.docnumValidator;

public class DocnumValidator {

    public static boolean isValidDocnumNumber(String numberDocument) {

        if (numberDocument.startsWith("docnum") && numberDocument.length() == 15
                && numberDocument.matches("[a-zA-Z0-9]*")) {
            return true;
        }
        return false;
    }
}
