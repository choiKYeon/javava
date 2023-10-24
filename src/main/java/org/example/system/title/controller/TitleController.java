package org.example.system.title.controller;

import org.example.Container;
import org.example.Request;
import org.example.system.title.entity.Customer;
import org.example.system.title.entity.Title;

import java.util.ArrayList;
import java.util.List;

public class TitleController {
    long titleLastId = 0;
    List<Title> titles = new ArrayList<>();
    List<Customer> customers = new ArrayList<>();
    Customer logincustomer = null;

    public void member() {
        long id = 1;
        String userid;
        if (logincustomer == null) {
            Customer customer = new Customer(1, "홍길동", 1234);
            customers.add(customer);
            customer = new Customer(2, "홍길순", 12345);
            customers.add(customer);
            customer = new Customer(3, "임꺽정", 123456);
            customers.add(customer);
        }
        while (true) {
            System.out.printf("아이디) ");
            userid = Container.getSc().nextLine();
            boolean duplicatedUserId = false;

            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getUserid().equals(userid)) {
                    duplicatedUserId = true;
                }
            }
            if (duplicatedUserId) {
                System.out.println("존재하는 아이디 입니다.");
                continue;
            }
            break;
        }
        long password;
        while (true) {
            System.out.printf("비번) ");
            password = Container.getSc().nextInt();

            System.out.printf("비번 확인) ");
            long passwordConfirm = Container.getSc().nextInt();

            if (password != passwordConfirm) {
                System.out.println("비밀번호가 일치하지 않습니다.");
                continue;
            }
            break;
        }
        Customer customer = new Customer(id, userid, password);
        customers.add(customer);
        System.out.println("회원가입이 완료되었습니다.");
        Container.getSc().nextLine();
    }

    public void login() {
        boolean checkedUserId = false;
        Customer customer = null;

        System.out.printf("아이디) ");
        String userId = Container.getSc().nextLine();
        System.out.printf("비번) ");
        long password = Container.getSc().nextInt();

        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getUserid().equals(userId)) {
                customer = customers.get(i);
                checkedUserId = true;
                break;
            }
        }
        if (checkedUserId == false) {
            System.out.println("해당 회원이 존재하지 않습니다.");
            Container.getSc().nextLine();
            return;
        }
        if (customer.getPassword() != password) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            Container.getSc().nextLine();
            return;
        }
        if (logincustomer != null) {
            System.out.println("이미 로그인 상태입니다.");
            Container.getSc().nextLine();
            return;
        }
        logincustomer = customer;
        System.out.println("로그인 성공!" + customer.getUserid() + "님 환영합니다.");
        Container.getSc().nextLine();
    }

    public void logout() {
        if (logincustomer == null) {
            System.out.println("로그인 상태가 아닙니다.");
        } else {
            logincustomer = null;
            System.out.println("로그아웃 되었습니다.");
        }
    }

    public void customerlist() {
        System.out.println("번호 / 고객아이디 / 고객비밀번호");
        System.out.println("-".repeat(17));
        for (int i = customers.size() - 1; i >= 0; i--) {
            Customer customer = customers.get(i);
            System.out.printf("%d, %s, %s\n", customer.getId(), customer.getUserid(), customer.getPassword());
        }
    }

    public void write() {
        long id = titleLastId + 1;

        if (logincustomer == null) {
            System.out.println("로그인 상태가 아닙니다.");
            return;
        }

        System.out.print("제목 :");
        String titleName = Container.getSc().nextLine().trim();
        System.out.print("내용 :");
        String content = Container.getSc().nextLine().trim();
        System.out.println(id + "번 게시글이 등록되었습니다.");
        Title title = new Title(id, titleName, content, logincustomer.getUserid());
        titles.add(title);

        titleLastId++;
    }
    public void list() {

        if (logincustomer == null) {
            System.out.println("로그인 상태가 아닙니다.");
            return;
        }

        System.out.println("번호 / 제목 / 내용/ 작성자");
        System.out.println("-".repeat(23));
        for (int i = titles.size() - 1; i >= 0; i--) {
            Title title = titles.get(i);
            System.out.printf("%d, %s, %s, %s\n", title.getId(), title.getTitleName(), title.getContent(), title.getUserId());
        }
    }

    public void remove(Request request) {

        if (logincustomer == null) {
            System.out.println("로그인 상태가 아닙니다.");
            return;
        }

        int id = request.getIntParams("id", -1);


        if (id == -1) {
            System.out.println("정수 id값을 입력해주세요.");
            return;
        }
        Title title = findById(id);
        if (findById(id) == null) {
            System.out.println("목록이 존재하지 않습니다");
            return;
        }

        String userId = logincustomer.getUserid();
        Customer customer = this.findByUserId(userId);
        if (title.getUserId() != logincustomer.getUserid()){
            System.out.println("접근할 수 없는 게시물 입니다.");
            return;
        }
        if (customer == null){
            System.out.println("게시글이 존재하지 않습니다.");
            return;
        }
        titles.remove(title);
        System.out.println("삭제되었습니다.");
    }

    public void modify(Request request) {
        int id = request.getIntParams("id", -1);

        if (id == -1) {
            System.out.println("정수 id값을 입력해주세요.");
            return;
        }
        Title title = findById(id);
        if (findById(id) == null) {
            System.out.println("목록이 존재하지 않습니다");
            return;
        }
        System.out.printf("기존 제목 : %s\n", title.getTitleName());
        System.out.print("제목 :");
        String titleName = Container.getSc().nextLine().trim();

        System.out.printf("기존 내용 : %s\n", title.getTitleName());
        System.out.print("내용 :");
        String content = Container.getSc().nextLine().trim();

        title.setTitleName(titleName);
        title.setContent(content);

        System.out.println(id + "번 목록이 수정되었습니다.");
    }

    public Title findById(int id) {
        for (Title title : titles) {
            if (title.getId() == id) {
                return title;
            }
        }
        return null;
    }

    private Customer findByUserId(String userId) {
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (customer.getUserid().equals(userId)){
                return customer;
            }
        }
        return null;
    }
}