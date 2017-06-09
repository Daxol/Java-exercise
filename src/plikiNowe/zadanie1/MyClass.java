package plikiNowe.zadanie1;

import java.io.*;

class MyClass {

    public static void main(String[] args) throws IOException {
        saveFile("domy.txt");
        System.out.println(loadFileAndIncreasePrizeAndGetMaxFloorHouseName("domy.txt", true));
    }

    ////nie ma w treści zadanie saveFile
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

    //Treść zadania
    private static String loadFileAndIncreasePrizeAndGetMaxFloorHouseName(String filePath, boolean increase) throws IOException {
        RandomAccessFile file = null;
        int kondygnacja;

        String nameOfHouse;
        String nameOfHouseWithTheMostFloors = "";
        int maxFloors = -1;
        double prize;
        long filePointer;

        try {
            file = new RandomAccessFile(filePath, "rw");

            while (true) {
                nameOfHouse = file.readUTF();
                kondygnacja = file.readInt();
                filePointer = file.getFilePointer();
                prize = file.readDouble();

                if (kondygnacja == 1 && increase) {
                    file.seek(filePointer);
                    file.writeDouble(prize * 1.1);

                }
                if (kondygnacja >= maxFloors) {
                    maxFloors = kondygnacja;
                    nameOfHouseWithTheMostFloors = nameOfHouse;
                }
            }

        } catch (IOException exception) {
            System.err.print(exception);

            return nameOfHouseWithTheMostFloors;
        } finally {
            if (file != null) {
                file.close();
            }
        }


    }

}