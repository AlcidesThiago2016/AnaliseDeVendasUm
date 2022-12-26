package devsuperior.com.application;

import devsuperior.com.entities.Sale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre com o caminho do arquivo:  ");
        String patch = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(patch))){
            List<Sale> list = new ArrayList<>();

            String line = br.readLine();
            while (line != null){
                String[] fields = line.split(",");
                list.add(new Sale(Integer.parseInt(fields[0]),Integer.parseInt(fields[1]),fields[2],
                        Integer.parseInt(fields[3]),Double.parseDouble(fields[4])));
                line = br.readLine();
            }

        }catch (IOException e){
            System.out.println("Error: "+ e.getMessage());
        }
        sc.close();
    }
}
