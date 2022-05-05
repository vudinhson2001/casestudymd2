package sellingdogs;

public class Dog {

    private String name ;
    private String age ;
    private  int price;
    private int id;
    private String status = "het hang" ; //Còn hàng/hết hàng

    public Dog() {
    }

    public Dog(String name, String age, int price, int id, String status) {
        this.name = name;
        this.age = age;
        this.price = price;
        this.id = id;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name = '" + name + '\'' +
                ", age = '" + age + '\'' +
                ", price = " + price +
                ", id = " + id +
                ", status = " + status+
                '}';
    }
}
