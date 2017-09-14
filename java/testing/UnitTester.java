package testing;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import solutions.Solution;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Executable;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnitTester {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String packageName = "solutions";

        // Get the file directory of the solutions package
        File directory = new File(URLDecoder.decode(classLoader.getResources(packageName).nextElement().getFile(), "UTF-8"));

        // Get all files from the directory, and map to the class contained in the file
        List<Class> classes = Arrays.stream(directory.listFiles())
                .map(file -> {
                    try {
                        return Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .filter(c -> !c.isInterface())
                .collect(Collectors.toList());


        // Get the correct values from numerical solutions


        // Generate tests

        System.out.println(new File("../../numericalsolutions.txt").getName());
    }

}
