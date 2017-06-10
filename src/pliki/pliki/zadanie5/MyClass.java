package pliki.pliki.zadanie5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by daniel on 10.06.17.
 */
/*Zad. 5. Napisać program, którego zadaniem jest odczytanie danych tabelarycznych w pliku
tekstowym, a następnie zapisanie ich do nowego pliku w postaci kodu HTML.
Przykład:
Wejście:
"Waga" "Wzrost" "BMI" "Nadwaga"
70 1,8 21,6 "NIE"
67 1,77 21,39 "NIE"
85 1,7 29,41 "TAK"
100 1,92 27,13 "TAK"
Wynik:
<html><body>
<table>
<tr><td>"Waga"</td><td>"Wzrost"</td><td>"BMI"</td><td>"Nadwaga"
</td></tr>
<tr><td>70</td><td>1,8</td><td>21,6</td><td>"NIE"
</td></tr>
<tr><td>67</td><td>1,77</td><td>21,39</td><td>"NIE"
</td></tr>
<tr><td>85</td><td>1,7</td><td>29,41</td><td>"TAK"
</td></tr>
<tr><td>100</td><td>1,92</td><td>27,13</td><td>"TAK"</td></tr>
</table>
</body></html>
*/
public class MyClass {

    public static void main(String[] args) throws IOException {
        parseToHTML("toParseBMI.txt");
    }

    private static void parseToHTML(String filePath) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(filePath));
        String line;
        String[] tab;
        String outString = "<html><body>\n<table>\n";
        while ((line = file.readLine()) != null) {
            tab = line.split(" ");
            outString += "<tr>";
            for (String item : tab) {
                outString += "<td>" + item + "</td>";
            }
            outString += "</tr>\n";
        }
        outString += "</table>\n</body></html>";
        System.out.println(outString);
        FileWriter fw = new FileWriter("parsed_" + filePath);
        fw.write(outString);
        fw.close();
    }
}
