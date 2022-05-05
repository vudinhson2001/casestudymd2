package sellingdogs;

import java.util.ArrayList;
import java.util.List;

public class SellingDogsManagement implements Management<Dog> {
    List<Dog> sellingDogsList = new ArrayList<>();


    public SellingDogsManagement() {

    }

    @Override
    public void display() {
        for (int i = 0; i < sellingDogsList.size(); i++) {
            System.out.println(sellingDogsList.get(i));
        }
    }

    @Override
    public void add(Dog dog) {
        sellingDogsList.add(dog);
    }

    @Override
    public void edit(String name, Dog dog) {
        int index0f = findByName(name);
        if (index0f == -1) {
            System.out.println("khong co ten nay !!!!");
        } else {
            sellingDogsList.set(index0f, dog);
        }
    }

    @Override
    public void remove(String name) {
        for (int i = 0; i < sellingDogsList.size(); i++) {
            if (sellingDogsList.get(i).getName().equals(name)) {
                sellingDogsList.remove(sellingDogsList.get(i));
                break;
            }
        }
    }

    @Override
    public void editStatus(String name) {
        for (int i = 0; i < sellingDogsList.size(); i++) {
            if (sellingDogsList.get(i).getName().equals(name)) {
                if (sellingDogsList.get(i).getStatus().equals("Da Ban")) {
                    System.out.println("da ban roi !!!");
                } else {
                    sellingDogsList.get(i).setStatus("Da Ban");
                }
            }
        }
    }

    @Override
    public void displayStatus(String status) {
    }

    @Override
    public int findByName(String name) {
        for (int i = 0; i < sellingDogsList.size(); i++) {
            if (sellingDogsList.get(i).getName().equals(name)) {
                System.out.println(sellingDogsList.get(i));
                return i;
            }
        }
        return -1;
    }
}
