package sellingdogs;

public interface Management<T> {
    void display();

    void add(T t);

    void edit(String name, T t);
    void remove(String name);

    void editStatus(String name);

    void displayStatus(String status);
    int findByName (String name);
}