package by.teachmeskills.yadevich.lesson14.validator.contractValidator;

public class ContractValidator {

    public static boolean isValidContractNumber(String numberDocument) {

        if (numberDocument.startsWith("contract") && numberDocument.length() == 15
                && numberDocument.matches("[a-zA-Z0-9]*")) {
            return true;
        }
        return false;
    }
}

