package pliki.pliki.zadanie3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by daniel on 09.06.17.
 */

/*
Zad. 3. Zadanie polega na stworzeniu dwóch funkcji:
 void szyfruj(String nazwaWe, int przesun)
 void deszyfruj(String nazwaWe, int przesun)
Funkcja szyfruj dokonuje szyfrowania pliku, którego nazwa podana została jako pierwszy parametr.
Szyfrowanie polega na zamianie każdej litery na znak przesunięty o wartość podaną drugim
parametrem np. dla przesunięcia równego 2 literka 'a' powinna zostać zastąpiona literką 'c', literka
'z' literką 'b' itp.

Wynikiem działania funkcji ma być plik o nazwie utworzonej na podstawie nazwy pliku
wejściowego poprzez dołączenie znaku '_' np. dla pliku dane.txt zaszyfrowana postać powinna mieć
nazwę _dane.txt. Funkcja deszyfruj powinna deszyfrować plik (niekoniecznie ten sam)
zaszyfrowany przez funkcję szyfruj
 */
public class MyClass {
    public static void main(String[] args) throws IOException {
        szyfruj("pliki.zadanie2_2.txt", 1);
//deszyfruj ta sama funkcja tylko z ujemnym znakiem
        //deszyfruj
//        szyfruj("pliki.zadanie2_2.txt", -1);

    }

    private static void szyfruj(String nazwaWe, int przesun) throws IOException {
        FileReader fileReader = null;
        String text = "";
        int symbol;
        try {
            fileReader = new FileReader(nazwaWe);

            while ((symbol = fileReader.read()) != -1) {
                if ((symbol >= 'a' && symbol <= 'z') || (symbol >= 'A' && symbol <= 'Z')) {

                    symbol += przesun;
                    if ((symbol > 'z') || (symbol > 'Z' && symbol < 'a')) {
                        symbol -= 26;
                    }
                }
                text += (char) symbol;
            }
            FileWriter fw = new FileWriter("_" + nazwaWe);
            fw.write(text);
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
        System.out.println(text);
    }

    private static void deszyfruj(String nazwaWe, int przesun) {
//to samo tylko z ujemnym znakiem
    }
}
