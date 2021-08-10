package br.com.effective.java.cap2.Item9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author  Lucien Jospin
 * try-with-resources with a catch clause
 */
public class TryWithResourceWithCatchClause {

    public static String firstLineOfFile(String path, String defaultVal) {

        try (BufferedReader br = new BufferedReader(
                new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            return defaultVal;
        }
    }

}
