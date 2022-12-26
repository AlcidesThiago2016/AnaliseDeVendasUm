package devsuperior.com.application;

import devsuperior.com.entities.Sale;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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

            list.stream()
                    .filter(p -> p.getYear() == 2016)
                    .sorted(Comparator.comparing(Sale::averagePrice).reversed())
                    .limit(5)
                    .collect(Collectors.toList())
                    .forEach(System.out::println);

            Double sumL = list.stream()
                    .filter(p -> (p.getSeller().equals("Logan") && p.getMonth() == 1)
                    || (p.getSeller().equals("Logan") && p.getMonth() == 7))
                    .map(s -> s.getTotal())
                    .reduce(0.0, (x, y) -> x + y);

            System.out.println();
            System.out.println("Valor total vendido pelo vendedor Logan nos meses 1 e 7 = " + sumL);

        }catch (FileNotFoundException e){
            System.out.println("Erro: "+ patch + " (O sistema não pode encontrar o arquivo especificado)");
        }catch (IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
        sc.close();
    }
}
