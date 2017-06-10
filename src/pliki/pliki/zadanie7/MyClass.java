package pliki.pliki.zadanie7;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by daniel on 10.06.17.
 */

/*
Dany jest plik, w którym zapisano (w postaci wewnętrznej) kolejne trójki danych tworzące informacje o budynkach:
 String nazwDom;
 int lKondygn;
 double cena;
 napisać funkcję zmniejszającą (bezpośrednio w pliku
bez wczytywania całego pliku do pamięci) o 10 procent cene domów parterowych i zzwrającą jako wartość
nazwę domu o największej liczbie kondygnacji. nazwa pliku przekazywana jest jako parametr

 */
public class MyClass {

    public static void main(String[] args) throws IOException {
        saveFile("dom.txt");
        System.out.println(myFunction("dom.txt"));
    }

    private static String myFunction(String filePath) throws IOException {
        String returnName = "";

        RandomAccessFile file = new RandomAccessFile(filePath, "rw");
        String nazwDom;
        int maxKondygn = -1;
        int lKondygn;
        double cena;
        long seekPointer;
        try {
            while (true) {
                nazwDom = file.readUTF();
                lKondygn = file.readInt();
                seekPointer = file.getFilePointer();
                cena = file.readDouble();
                if (maxKondygn < lKondygn) {
                    maxKondygn = lKondygn;
                    returnName = nazwDom;
                }
                if (lKondygn == 1) {
                    file.seek(seekPointer);
                    file.writeDouble(cena - (cena * 0.1));
                }
            }
        } catch (IOException exception) {
            file.close();
            return returnName;
        }
    }


    private static void saveFile(String filePath) throws IOException {
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile(filePath, "rw");

            file.writeUTF("dom1");
            file.writeInt(2);
            file.writeDouble(2000);

            file.writeUTF("dom2");
            file.writeInt(1);
            file.writeDouble(2000);

            file.writeUTF("dom3");
            file.writeInt(9);
            file.writeDouble(2000);

            file.writeUTF("dom4");
            file.writeInt(1);
            file.writeDouble(4000);

            file.writeUTF("dom5");
            file.writeInt(7);
            file.writeDouble(2000);

        } catch (IOException exception) {

            System.out.println("koniec");
        } finally {
            if (file != null) {
                file.close();
            }
        }
    }
}
