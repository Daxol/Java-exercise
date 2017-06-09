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
        String name;
        String age;
        String gender;
        String male = "";
        String female = "";
        FileWriter fw = new FileWriter("kobiety.txt",true);
        FileWriter fwM = new FileWriter("mezczyzni.txt",true);

            Scanner file = new Scanner(new BufferedReader(new FileReader(nazwaPliku)));
            while (file.hasNext()) {
                name = file.next();
                name += " " + file.next();
                gender = file.next();
                age = file.next();
                System.out.println(gender);
                if (gender.equals("M")) {
                    male += ("\n"+name + " " + (65 - Integer.parseInt(age)));
                    fwM.write(male);
                } else {
                    female +=  "\n"+name + " " + (65 - Integer.parseInt(age));
                    fw.write(female);
                }
            }

       fw.close();
       fwM.close();

    }
}
