/*
1. Fișierul judete_in.txt, conține lista neordonată a județelor din țară. Să se încarce
datele din fișier într-un tablou de String-uri și să se ordoneze acest tablou cu ajutorul metodei
sort() din clasa Arrays. Să se returneze pe ce poziție se află în vectorul ordonat un județ
introdus de la tastatură. Se va utiliza metoda de căutare binară din clasa Arrays.
 */

import java.io.*;
import java.util.*;

public class MainApp
{
    public static void main(String[] args)
    {

        String fileName = "E:\\Java\\Proiecte\\Tema Lab 2 - Ex1\\src\\judete_in.txt";

        try       // fac citirea din fisier intr-o lista cu tratarea erorilor
        {
            List<String> judeteList = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
            {
                String line;
                while ((line = br.readLine()) != null)
                {
                    judeteList.add(line.trim());
                }
            }

            String[] judete = judeteList.toArray(new String[0]);
            Arrays.sort(judete);  // functie pt sortarea judetelor din lista
            //afisare
            System.out.println("Judetele ordonate alfabetic:");
            for (String judet : judete)
            {
                System.out.println(judet);
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduceți un judet pentru a afla pe ce pozitie se afla in lista: ");
            String judetCautat = scanner.nextLine();

            int pozitie = Arrays.binarySearch(judete, judetCautat);

            if (pozitie >= 0)
            {
                System.out.println("Judetul " + judetCautat + " este pe pozitia " + (pozitie + 1));
            } else
            {
                System.out.println("Judetul " + judetCautat + " NU este in fisierul cu judete introdus!");
            }

        } catch (IOException e)
        {
            System.out.println("Eroare la citirea fișierului: " + e.getMessage());
        }
    }
}