package zadaniaOdNowa.zadanie1;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MyClass {

    public static void main(String[] args) throws IOException {
        saveToFile("domy.txt");
        loadFromFileAndIncreasePrice("domy.txt");
    }
// zapisywanie do pliku - nie ma w treści ale trzeba coś odczytać

    public static void saveToFile(String path) throws IOException {
        RandomAccessFile accessFile = null;

        try {
            accessFile = new RandomAccessFile( path, "rw");// w trybie rw - mozna odczytywac i zapisywac


            accessFile.writeUTF("Dom1"); // writeUTF to zapisywanie stringu
            accessFile.writeInt(1);
            accessFile.writeDouble(20000);

            accessFile.writeUTF("Dom2");
            accessFile.writeInt(6);
            accessFile.writeDouble(23000);

            accessFile.writeUTF("Dom3");
            accessFile.writeInt(2);
            accessFile.writeDouble(20000);

            accessFile.writeUTF("Dom4");
            accessFile.writeInt(4);
            accessFile.writeDouble(40000);


        } catch (IOException exception) {

        } finally {
            if (accessFile != null) {// sprawdzamy czy plik został otworzony jak tak to jest różny od null i go zamyka
                accessFile.close();
            }
        }
    }

    private static void loadFromFileAndIncreasePrice(String path) throws IOException {

        RandomAccessFile accessFile = null;
        String maxFloorsName = "";

        try {

            accessFile = new RandomAccessFile(path, "rw");
            long filePointer;
            String nazwDom;
            int lKondygn;
            double cena;
            int maxFloors = 0;

            while (true) {// wykonuje się aż wyskoczy błąð i wyjątek go obsłuży

                nazwDom = accessFile.readUTF();
                lKondygn = accessFile.readInt();
                filePointer = accessFile.getFilePointer();
                cena = accessFile.readDouble();

                if (lKondygn == 1) {

                    accessFile.seek(filePointer);
                    accessFile.writeDouble(cena * 1.1);
                }
                if (lKondygn >= maxFloors) {
                    maxFloors = lKondygn;
                    maxFloorsName = nazwDom;
                }
            }

        } catch (IOException exception) {
            System.out.printf("Dom o największej liczbie kondygnacji to dom o nazwie %s", maxFloorsName);
        } finally {
            if (accessFile != null) {
                accessFile.close();
            }
        }
    }
}
