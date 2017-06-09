package plikiNowe.zadanie2;

import java.io.*;
import java.math.BigDecimal;

/**
 * Created by daniel on 20.05.17.
 */
public class MyClass {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        saveFile("longi.txt");
        System.out.println(getNumberOfNotChangedHouse("longi.txt", "save.txt"));
    }

    private static void saveFile(String filePath) throws IOException {
        ObjectOutputStream file = null;
        try {
            file = new ObjectOutputStream(new FileOutputStream(filePath));
            file.writeObject("dom55");
            file.writeObject(2);
            file.writeObject(new BigDecimal(10000));

            file.writeObject("dom2");
            file.writeObject(1);
            file.writeObject(new BigDecimal(30000));

            file.writeObject("dom3");
            file.writeObject(9);
            file.writeObject(new BigDecimal(40000));

            file.writeObject("dom4");
            file.writeObject(1);
            file.writeObject(new BigDecimal(50000));

            file.writeObject("dom5");
            file.writeObject(7);
            file.writeObject(new BigDecimal(80000));

        } catch (IOException exception) {

            System.out.println("koniec");
        } finally {
            if (file != null) {
                file.close();
            }
        }
    }

    private static int getNumberOfNotChangedHouse(String fileInPath, String fileOutPath) throws IOException, ClassNotFoundException {
        int numberOfNotChangedHouse = 0;

        ObjectInputStream fileIn = null;

        DataOutputStream fileOut = null;

        try {
            fileOut = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileOutPath)));
            fileIn = new ObjectInputStream(new FileInputStream(fileInPath));
            String nameOfHouse;
            int floors;
            BigDecimal price;


            while (true) {

                nameOfHouse = fileIn.readObject().toString();
                floors = (int) fileIn.readObject();
                price = (BigDecimal) fileIn.readObject();

                if (floors == 2) {
                    price = price.multiply(new BigDecimal(1.15));


                    fileOut.writeUTF(nameOfHouse);
                    fileOut.writeInt(floors);
                    fileOut.writeUTF(price.toString());
                } else {
                    numberOfNotChangedHouse++;
                }
            }

        } catch (IOException exception) {

            return numberOfNotChangedHouse;
        } finally {
            if (fileIn != null) {
                fileIn.close();
            }
            if (fileOut != null) {
                fileOut.close();
            }
        }
    }

}
