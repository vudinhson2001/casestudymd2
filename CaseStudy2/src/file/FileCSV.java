package file;

import sellingdogs.Dog;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileCSV {
        public static void readFromFile() throws IOException {
            File file = new File("dog.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Scanner sc= new Scanner(file);
            String line = "";
            while ((line =bufferedReader.readLine())!= null){
                System.out.println(line);
            }
            bufferedReader.close();
            }

        public static void writeToFile(List<Dog> list)throws FileNotFoundException{
            File dogFile = new File("dog.csv");
            PrintWriter printWriter = new PrintWriter(dogFile);
            printWriter.print("\n");
            for (int i=0;i<list.size();i++){
                printWriter.print(list.get(i));
            }
            printWriter.close();
        }
}
