package main;

import sellingdogs.Dog;
import sellingdogs.SellingDogsManagement;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SellingDogsManagement sellingDogsManagement1 = new SellingDogsManagement();
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        Scanner sc= new Scanner(System.in);
        sellingDogsManagement1.add(new Dog("Corgi", "6m", 6000000, 1, "Da Ban"));
        sellingDogsManagement1.add(new Dog("Husky", "7m", 7000000, 2, "Chua Ban"));
        sellingDogsManagement1.add(new Dog("Poodle", "15m", 8000000, 3, "Da Ban"));
        sellingDogsManagement1.add(new Dog("Chihuahua", "9m", 9000000, 4, "Chua Ban"));
        sellingDogsManagement1.add(new Dog("Becgie", "5m", 10000000, 5, "Chua Ban"));
        sellingDogsManagement1.add(new Dog("Alaska", "3m", 11000000, 6, "Da Ban"));
        sellingDogsManagement1.add(new Dog("pug", "8m", 12000000, 7, "Chua Ban"));
        sellingDogsManagement1.add(new Dog("Shiba", "12m", 13000000, 8, "Da Ban"));
        do {

            System.out.println("=====MENU======");
            System.out.println(
                    "1.Hien Thi Danh Sach\n" +
                            "2.Them Cho Canh\n" +
                            "3.Tim Kiem Cho Canh ( Theo Ten )\n" +
                            "4.Sua Thong Tin Cho Canh\n" +
                            "5.Sua Trang Thai \n" +
                            "6.Xoa Thong Tin Cho Canh\n" +
                            "7.Xem Lai MENU\n" +
                            "8.Thoat\n");
            System.out.println("Chon Chuc Nang :");

            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                sellingDogsManagement1.display();
            } else if (choice == 2) {
                System.out.println("Nhap ten : ");
                String nhapTen = scanner.nextLine();
                System.out.println("nhap tuoi :");
                String nhapTuoi = scanner.nextLine();
                System.out.println("Nhap id : ");
                int nhapId = sc.nextInt();
                System.out.println("nhap gia : ");
                int nhapGia = sc.nextInt();
                System.out.println("Nhap trang thai : ");
                String nhapStatus = scanner.nextLine();
                Dog dog = new Dog(nhapTen,nhapTuoi,nhapId,nhapGia,nhapStatus);
                sellingDogsManagement1.add(dog);
            } else if (choice == 3) {
                System.out.println("Nhap ten can tim :");
                String timKiem = scanner.nextLine();
                String s1Lower= timKiem.toLowerCase();
                sellingDogsManagement1.findByName(s1Lower);
            } else if (choice == 4) {
                System.out.println("Nhap ten cho can sua : ");
                String stt= scanner.nextLine();
                System.out.println("Nhap ten : ");
                String nhapTen1 = scanner.nextLine();
                System.out.println("nhap tuoi :");
                String nhapTuoi1 = scanner.nextLine();
                System.out.println("Nhap id : ");
                int nhapId1 = sc.nextInt();
                System.out.println("nhap gia : ");
                int nhapGia1 = sc.nextInt();
                System.out.println("Nhap trang thai : ");
                String nhapStatus1 = scanner.nextLine();
                Dog dog1 = new Dog(nhapTen1,nhapTuoi1,nhapId1,nhapGia1,nhapStatus1);
                sellingDogsManagement1.edit(stt,dog1);
            } else if (choice == 5) {
                System.out.println("nhap Ten sua Trang Thai :");
                String suaStatus= scanner.nextLine();
                String s1Lower= suaStatus.toLowerCase();
                sellingDogsManagement1.editStatus(s1Lower);
            } else if (choice == 6) {

            } else if (choice == 7) {

            } else if (choice == 8) {

            }
        } while (choice != 0);


    }
}
