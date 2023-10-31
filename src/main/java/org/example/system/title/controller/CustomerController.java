package org.example.system.title.controller;

import org.example.Container;
import org.example.system.title.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    List<Customer> customers = new ArrayList<>();
    Customer checkedCustomer = null;
    public void sign(){
        boolean checkedMember = false;
        System.out.println("회원가입을 진행해주세요.");
        long id = 1;
        String userId;
        String password;

        if (checkedCustomer == null){
            Customer customer1 = new Customer(1, "홍길동", "1234");
            customers.add(customer1);
            Customer customer2 = new Customer(2, "홍길순", "12345");
            customers.add(customer2);
            Customer customer3 = new Customer(3, "임꺽정", "123456");
            customers.add(customer3);
        }
        while (true){
            System.out.print("새 아이디 :");
            userId = Container.getSc().nextLine().trim();

            for (int i = 0; i < customers.size(); i++){
                if (customers.get(i).getUserId().equals(userId)){
                    checkedMember = true;
                }
            }
            if (checkedMember == true){
                System.out.println("이미 존재하는 아이디 입니다. 다시 입력해주세요.");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("새 비밀번호 :");
            password = Container.getSc().nextLine().trim();
            System.out.print("새 비밀번호 확인 :");
            String password2 = Container.getSc().nextLine().trim();
            if (password.equals(password2) == false) {
                System.out.println("비밀번호가 다릅니다. 다시 입력해주세요.");
                continue;
            }
            System.out.println("비밀번호가 입력되었습니다.");
            break;
        }

        Customer customer = new Customer(id, userId, password);
        customers.add(customer);
        id++;
        System.out.println("회원가입이 완료되었습니다.");
    }

    public void login(){
        if (checkedCustomer != null){
            System.out.println("로그인 되어있습니다. 로그아웃을 진행해주세요.");
            return;
        }

        boolean checkedUserId = false;
        Customer customer = null;
        System.out.print("아이디 :");
        String userId = Container.getSc().nextLine().trim();
        System.out.print("비밀번호 :");
        String password = Container.getSc().nextLine().trim();

        for (int i = 0; i < customers.size(); i++){
            if (customers.get(i).getUserId().equals(userId)){
                customer = customers.get(i);
                checkedUserId = true;
            }
        }

        if (checkedUserId == false){
            System.out.println("존재하지 않는 아이디입니다. 다시 입력해주세요.");
            return;
        }
        if (customer.getPassword().equals(password) == false){
            System.out.println("비밀번호가 틀렸습니다. 다시 입력해주세요.");
            return;
        }

        checkedCustomer = customer;

        System.out.println("로그인 되었습니다. 환영합니다." + userId + "님");

    }
    public void logout(){
        if (checkedCustomer != null){
            checkedCustomer = null;
            System.out.println("로그아웃 되었습니다.");
        } else if (checkedCustomer == null){
            System.out.println("로그아웃 되어있습니다. 로그인을 진행해주세요.");
        }
    }
}

