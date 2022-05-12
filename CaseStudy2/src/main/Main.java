package main;

import account.AccountManagement;
import file.FileCSV;
import sellingdogs.Dog;
import menu.Menu;
import manage.SellingDogsManagement;
import account.Account;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final AccountManagement accountManagement = new AccountManagement();

    public static void main(String[] args) throws IOException {
        if (accountManagement.getAccountList().isEmpty()) {
            registrationProcessing();
        }
        handleLogin();
        SellingDogsManagement sellingDogsManagement1 = new SellingDogsManagement();
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        sellingDogsManagement1.add(new Dog("corgi", "6m", 300, 1, "da ban"));
        sellingDogsManagement1.add(new Dog("husky", "7m", 400, 2, "chua ban"));
        sellingDogsManagement1.add(new Dog("poodle", "15m", 800, 3, "da ban"));
        sellingDogsManagement1.add(new Dog("chihuahua", "9m", 200, 4, "chua ban"));
        sellingDogsManagement1.add(new Dog("becgie", "5m", 700, 5, "chua ban"));
        sellingDogsManagement1.add(new Dog("alaska", "3m", 700, 6, "da ban"));
        sellingDogsManagement1.add(new Dog("pug", "8m", 300, 7, "chua ban"));
        sellingDogsManagement1.add(new Dog("shiba", "12m", 600, 8, "da ban"));
        do {
            Menu.SellingDogsMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                sellingDogsManagement1.display();
            } else if (choice == 2) {
                System.out.println("Nhap ten : ");
                String nhapTen = scanner.nextLine();
                String nhapTenLower = nhapTen.toLowerCase();
                System.out.println("nhap tuoi :");
                String nhapTuoi = scanner.nextLine();
                String nhapTuoiLower = nhapTuoi.toLowerCase();
                System.out.println("Nhap id : ");
                int nhapId = sc.nextInt();
                System.out.println("nhap gia : ");
                int nhapGia = sc.nextInt();
                System.out.println("Nhap trang thai : ");
                String nhapStatus = scanner.nextLine();
                String nhapStatusLower = nhapStatus.toLowerCase();
                Dog dog = new Dog(nhapTenLower, nhapTuoiLower, nhapGia, nhapId, nhapStatusLower);
                sellingDogsManagement1.add(dog);
                FileCSV.writeToFile(sellingDogsManagement1.getSellingDogsList());
            } else if (choice == 3) {
                System.out.println("Nhap ten can tim :");
                String timKiem = scanner.nextLine();
                String s1Lower = timKiem.toLowerCase();
                sellingDogsManagement1.findByName(s1Lower);
            } else if (choice == 4) {
                System.out.println("Nhap ten cho can sua : ");
                String stt = scanner.nextLine();
                String sttLower = stt.toLowerCase();
                System.out.println("Nhap ten : ");
                String nhapTen1 = scanner.nextLine();
                String nhapTenLower = nhapTen1.toLowerCase();
                System.out.println("nhap tuoi :");
                String nhapTuoi1 = scanner.nextLine();
                String nhapTuoiLower = nhapTuoi1.toLowerCase();
                System.out.println("Nhap id : ");
                int nhapId1 = sc.nextInt();
                System.out.println("nhap gia : ");
                int nhapGia1 = sc.nextInt();
                System.out.println("Nhap trang thai : ");
                String nhapStatus1 = scanner.nextLine();
                String nhapStatusLower = nhapStatus1.toLowerCase();
                Dog dog1 = new Dog(nhapTenLower, nhapTuoiLower, nhapId1, nhapGia1, nhapStatusLower);
                sellingDogsManagement1.edit(sttLower, dog1);
            } else if (choice == 5) {
                System.out.println("Nhap Ten Sua Trang Thai :");
                String suaStatus = scanner.nextLine();
                String s1Lower = suaStatus.toLowerCase();
                sellingDogsManagement1.editStatus(s1Lower);
            } else if (choice == 6) {
                System.out.println("Nhap Ten Can Xoa :");
                String xoaTen = scanner.nextLine();
                String xoaTenLower = xoaTen.toLowerCase();
                sellingDogsManagement1.remove(xoaTenLower);
            } else if (choice == 7) {
                FileCSV.readFromFile();
            } else if (choice == 8) {
                System.exit(0);
            }
        } while (choice != 0);


    }

    // Đăng Kí
    public static void registrationProcessing() {
        Pattern pattern = Pattern.compile("((\\w{2,5}\\d{2,5})|(\\d{2,5}\\w{2,5}))");
        System.out.println(" -----DANG KI-----");
        Scanner scanner = new Scanner(System.in);
        String userName = "";
        Matcher matcherUs = null;
        String passWord = "";
        Matcher matcherPs = null;

        do {
            System.out.println("NHAP TEN TAI KHOAN(2-5 ki tu chu va 2-5 ki tu so)");
            userName = scanner.nextLine();
            matcherUs = pattern.matcher(userName);
            if (!matcherUs.matches()) {
                System.err.println("Sai dinh dang nhap lai !");
            }
        } while (!matcherUs.matches());
        do {
            System.out.println("NHAP MAT KHAU  (2-5 ki tu chu va 2-5 ki tu so)");
            passWord = scanner.nextLine();
            matcherPs = pattern.matcher(passWord);
            if (!matcherPs.matches()) {
                System.err.println("Sai dinh dang nhap lai !");
            }
        } while (!matcherPs.matches());
        System.out.println("DANG KI THANH CONG !");
        Account account = new Account(userName, passWord);
        accountManagement.registerAnAccount(account);
    }

    //Đăng nhập
    public static void handleLogin() {
        Scanner scanner = new Scanner(System.in);
        String userName = "";
        String passWord = "";
        boolean checkLogin = true;
        do {
            for (Account account : accountManagement.getAccountList()) {
                System.out.println("         -----DANG NHAP----- ");
                System.out.println("NHAP TEN TAI KHOAN ");
                userName = scanner.nextLine();
                System.out.println("NHAP MAT KHAU ");
                passWord = scanner.nextLine();
                if (account.getUserName().equals(userName) && account.getPassword().equals(passWord)) {
                    System.out.println("DANG NHAP THANH CONG !");
                    checkLogin = false;
                    break;
                } else {
                    System.err.println("Sai ten tai khoan hoac mat khau vui long thu lai  !");
                }
            }
        } while (checkLogin);

    }


}
