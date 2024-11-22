package by.teachmeskills.yadevich.lesson14.validator.pathValidator;

import java.nio.file.InvalidPathException;

public class PathValidator {

    public static boolean checkPath(String path) throws InvalidPathException {

        if (path == null || path.isEmpty()) {
            throw new InvalidPathException("Path equal null or is empty.", "404");
        }
        return true;
    }
}
