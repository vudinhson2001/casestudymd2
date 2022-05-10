package manage;

import manage.Management;
import sellingdogs.Dog;

import java.util.ArrayList;
import java.util.List;

public class SellingDogsManagement implements Management<Dog> {
    List<Dog> sellingDogsList = new ArrayList<>()       ;

    public List<Dog> getSellingDogsList() {
        return sellingDogsList;
    }

    public void setSellingDogsList(List<Dog> sellingDogsList) {
        this.sellingDogsList = sellingDogsList;
    }

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
            System.err.println("khong co ten nay !!!!");
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
                if (sellingDogsList.get(i).getStatus().equals("da ban")) {
                    System.err.println("da ban roi !!!");
                } else {
                    sellingDogsList.get(i).setStatus("da ban");
                }
            }
        }
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
