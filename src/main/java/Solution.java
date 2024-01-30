import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Главный класс
 */
public class Solution {
    public static void main(String[] args)  {

       Merger merger = new Merger(args);
        merger.writeFile();
    }
}
