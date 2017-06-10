package pliki.pliki.zadanie6;

import java.io.*;

/**
 * Created by daniel on 10.06.17.
 */
/*
Napisać funkcję public static void sumujIZapisz(String nazwaPliku) , któ-
ra odczytuje plik o podanej nazwie zawierający liczby całkowite (po jednej w
wierszu). Funkcja ma za zadanie odczytać i zsumować wszystkie liczby z pliku,
a następnie dopisać na końcu pliku wyznaczoną sumę powiększoną o 1. Ponowne
uruchomienia funkcji będą skutkowały dopisywaniem kolejnych wierszy. Jeżeli
plik nie istnieje to ma zostać utworzony – suma dla pustego pliku wyniesie 0, a
więc należy dopisać wiersz zawierający 1.
 */
public class MyClass {
    public static void main(String[] args) throws IOException {
        sumujIZapisz("sumuj.txt");
    }

    private static void sumujIZapisz(String nazwaPliku) throws IOException {
        int sum = 1;
        BufferedWriter write = new BufferedWriter(new FileWriter(nazwaPliku, true));
        BufferedReader fileRead = new BufferedReader(new FileReader(nazwaPliku));

        String temp;
        while ((temp = fileRead.readLine()) != null) {
            sum += Integer.parseInt(temp);
        }
        fileRead.close();

        write.write(Integer.toString(sum));
        write.newLine();
        write.close();
    }
}
