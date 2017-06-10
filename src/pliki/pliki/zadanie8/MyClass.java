package pliki.pliki.zadanie8;

import java.io.*;
import java.math.BigDecimal;

/**
 * Created by daniel on 10.06.17.
 */
/*
Dany jest plik w którym zapisano informacje o nieruchomościach w postaći kolejnych trójek:
String nazwDom;
int lKondygn;
BigDecimal cena;

napisać funkcję zwiększającą o 15 procent cenę dwomów 2 piętrowych i wpisującą dane tych domów do pliku tekstowego (dane
o jendym domu w jednym wierszu; cena po zmianie) i zwracającą jako swoją wartość liczbę domów których cen nie zmieniono
nazwy plików przekazywane jako parametry

 */
public class MyClass {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        myFunctionSave("objectDom.txt");
        myFunctionLoad("objectDom.txt");
    }

    private static int myFunctionLoad(String filePath) throws IOException, ClassNotFoundException {
        ObjectInputStream file = new ObjectInputStream(new FileInputStream(filePath));
        String nazwDom;
        int lKondygn;
        BigDecimal cena;
        int counter = 0;
        BufferedWriter saveFile = new BufferedWriter(new FileWriter("text_" + filePath, true));
        try {

            while (true) {
                nazwDom = file.readObject().toString();
                lKondygn = (int) file.readObject();
                cena = (BigDecimal) file.readObject();

                if (lKondygn == 2) {
                    cena = cena.multiply(new BigDecimal(1.15));
                    saveFile.write(nazwDom + " " + lKondygn + " " + cena.toString());
                    saveFile.newLine();
                } else {
                    counter++;
                }
            }
        } catch (IOException exception) {
            file.close();
            saveFile.close();
            return counter;
        }
    }

    // funkcja pomocnicza
    private static void myFunctionSave(String filePath) throws IOException {
        ObjectOutputStream file = null;

        try {

            file = new ObjectOutputStream(new FileOutputStream(filePath));

            file.writeObject("Dom1");
            file.writeObject(2);
            file.writeObject(new BigDecimal(10000));
            file.writeObject("Dom2");
            file.writeObject(1);
            file.writeObject(new BigDecimal(30000));
            file.writeObject("Dom3");
            file.writeObject(4);
            file.writeObject(new BigDecimal(200000));
            file.writeObject("Dom4");
            file.writeObject(2);
            file.writeObject(new BigDecimal(210000));

            file.close();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


}
