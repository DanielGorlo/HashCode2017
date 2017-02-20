import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Created by dvadmin on 2/20/2017.
 */
public class Utils {
    public static NumberOfExtras getNumberOfExras(Slice slice, Pizza pizza) {
        int t = 0;
        int m = 0;

        Extras[][] pizzaMatrix = pizza.getPizzaMatrix();

        //rows
        for (int i = slice.getX(); i < slice.getW(); i++) {
            //columns
            for (int j = slice.getY(); j < slice.getH(); j++) {
                if (pizzaMatrix[i][j] == Extras.Mushroom) {
                    m++;
                } else {
                    t++;
                }
            }
        }
        return new NumberOfExtras(m, t);
    }

    public static Pizza parsePizza(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String pizzaMetaLine = s.nextLine();
        String[] pizzaMeta = pizzaMetaLine.split(" ");

        int c = Integer.parseInt(pizzaMeta[0]);
        int r = Integer.parseInt(pizzaMeta[1]);
        int l = Integer.parseInt(pizzaMeta[2]);
        int h = Integer.parseInt(pizzaMeta[3]);


        Extras[][] extras = new Extras[r][c];

        int currentRow = 0;
        int currentColumn = 0;

        while (currentColumn < c) {
            currentRow = 0;
            String pizzaLine = s.nextLine();

            while (currentRow < r) {
                extras[currentRow][currentColumn] = Extras.fromChar(pizzaLine.charAt(currentRow));
                currentRow++;
            }
            currentColumn++;
        }
        return new Pizza(extras, l, h);
    }


    private static void handleFile(File file)
            throws IOException {
        try (InputStream in = new FileInputStream(file);
             Reader reader = new InputStreamReader(in, Charset.defaultCharset());
             // buffer for efficiency
             Reader buffer = new BufferedReader(reader)) {
            handleCharacters(buffer);
        }
    }

    private static void handleCharacters(Reader reader)
            throws IOException {
        int r;
        while ((r = reader.read()) != -1) {
            char ch = (char) r;
            System.out.println("Do something with " + ch);
        }
    }
}
