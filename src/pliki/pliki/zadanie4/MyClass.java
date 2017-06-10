package pliki.pliki.zadanie4;

import java.io.*;
import java.util.Scanner;

/**
 * Created by daniel on 10.06.17.
 */

/*
Zad. 4. Napisać funkcję emerytura(String nazwaPliku), która wczyta z pliku o podanej nazwie dane
pracowników zapisane w kolejnych wierszach w następujący sposób:
 Imię Nazwisko Płeć Wiek
Przykład:
 Tomasz Nowak M 45
 Marta Ziobro K 42
 Jan Kowalski M 27
 Ewelina Tusk K 59
Następnie funkcja dla każdego pracownika powinna wyznaczyć ile lat pozostało do jego emerytury.
Wyniki należy zapisać w następujący sposób:
 Nazwisko Imię "Lata do emerytury"
Przykład:
 Nowak Tomasz 20
 Kowalski Jan 38
Wyniki dla kobiet należy zapisać w pliku o nazwie "kobiety.txt", natomiast wyniki dla mężczyzn
należy zapisać w pliku "mezczyzni.txt".
 */
public class MyClass {

    public static void main(String[] args) {
        try {
            emerytura("doZadania4.txt");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static void emerytura(String nazwaPliku) throws IOException {

        FileWriter fw = new FileWriter("kobiety.txt", true);
        FileWriter fwM = new FileWriter("mezczyzni.txt", true);

        BufferedReader file = new BufferedReader(new FileReader(nazwaPliku));
        String line;
        String[] person;
        while ((line = file.readLine()) != null) {
            person = line.split(" ");
            line = person[0] + " " + person[1] + " " + (65 - Integer.parseInt(person[3])) + "\n";
            if (person[2].equals("M")) {
                fwM.write(line);
            } else {
                fw.write(line);
            }
        }

        fw.close();
        fwM.close();

    }
}
