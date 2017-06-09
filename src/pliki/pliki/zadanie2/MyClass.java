package pliki.pliki.zadanie2;

import java.io.LineNumberReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by daniel on 09.06.17.
 */

/*
Zad. 2. Napisać funkcję:
void szukaj(String nazwaPlikWe, String nazwaPlikWy, String slowo)
której zadaniem jest znalezienie wszystkich wierszy w pliku, które zawierają szukane słowo.
Wszystkie wiersze, które zawierają słowo powinny zostać zapisane w pliku wynikowym wraz z nr
wiersza (z pierwszego pliku). Nazwa pierwszego pliku zapamiętana jest w parametrze
nazwaPlikWe, nazwa pliku wynikowego podana jest w parametrze nazwaPlikWy, natomiast szukane
słowo w parametrze slowo.
Przykład - plik wejściowy:
Ala ma jutro egzamin z biologii.
Jan myje auto.
Eh, jutro kolejny egzamin.
Nie lubie polityki.
Jeżeli szukanym słowem byłoby "egzamin", to plik wynikowy powinien wyglądać następująco:
1: Ala ma jutro egzamin z biologii.
3: Eh, jutro kolejny egzamin.
 */

public class MyClass {
    public static void main(String[] args) {
        zapisz("pliki.zadanie2_1.txt", "Ala ma kota \n a ko ma ale \n to jest to \n kot kot kot");
        szukaj("pliki.zadanie2_1.txt", "kot");
    }

    private static void zapisz(String filePath, String text) {
        try {
            FileWriter fw = new FileWriter(filePath);
            fw.write(text);
            fw.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static void szukaj(String filePath, String searchWord) {
        FileReader fw = null;
        String returnText = "";
        try {
            fw = new FileReader(filePath);
            LineNumberReader br = new LineNumberReader(fw);
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(searchWord)) {
                    returnText += (br.getLineNumber() + ": " + line + '\n');
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        zapisz("pliki.zadanie2_2.txt", returnText);
    }
}
