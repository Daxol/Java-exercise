package pliki.pliki.zadanie1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by daniel on 09.06.17.
 */
/*
Zad. 1. Napisać funkcję liczZnakiSlowa, która zlicza:
 • liczbę znaków w pliku,
 • liczbę białych znaków w pliku (białe znaki to spacja, tabulator, znacznik końca wiersza),
 • liczbę słów w pliku,
Wynikiem funkcji jest tablica złożona z 3 liczb całkowitych po jednej dla wymienionych
podpunktów.
 */
public class MyClass {
    public static void main(String[] args) {

        try {
            System.out.println("tu");
            zapiszZnakiSłowa("pliki.zadanie1.txt", " Ala ma kota a kot Ma Ale \n nowa linia");
            int[] tab = liczZnakiSlowa("pliki.zadanie1.txt");
            System.out.printf("w pliku znajduje się %d znaków, %d białych znaków oraz %d wyrazów", tab[0], tab[1], tab[2]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] liczZnakiSlowa(String filePath) throws IOException {
        int[] returnArray = {0, 0, 0};
        FileReader fileRead = null;
        String text = "a";
        char symbol;

        try {
            fileRead = new FileReader(filePath);

            while ((symbol = (char) fileRead.read()) != (char) -1) {
                returnArray[0]++;
                text += symbol;
                if (Character.isWhitespace(symbol)) {
                    returnArray[1]++;
                }
            }
            returnArray[2] = text.split("\\s+").length;
        } catch (IOException exception) {


            exception.printStackTrace();
        } finally {
            if (fileRead != null) {
                fileRead.close();
            }
        }


        return returnArray;
    }

    //dodatkowe

    private static void zapiszZnakiSłowa(String filePath, String text) throws IOException {


        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(filePath);
            fileWriter.write(text);
        } catch (IOException exception) {
            System.out.println("error occurred");
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }
}
