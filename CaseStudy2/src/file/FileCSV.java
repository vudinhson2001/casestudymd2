package file;

import sellingdogs.Dog;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileCSV {
        public static List<Dog> readFromFile() throws FileNotFoundException{
            File dogFile = new File("dog.csv");
            List<Dog> dogs = new ArrayList<>();
            Scanner scanner = new Scanner(dogFile);
            scanner.nextLine();
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                if(line.equals("")){
                    break;
                }else {
                    String arr[]= line.split(",");
                    dogs.add(new Dog(Integer.valueOf(arr[0]),arr[1],arr[2],arr[3],arr[4]));
                }
            }
            return dogs ;
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
