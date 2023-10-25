package org.example.system.title.controller;

import org.example.Container;
import org.example.Request;
import org.example.system.title.entity.Customer;
import org.example.system.title.entity.Title;

import java.util.ArrayList;
import java.util.List;

public class TitleController {
    List<Title> titles = new ArrayList<>();
    List<Customer> customers = new ArrayList<>();
    long lastWiseSaying = 0;
    Customer checkedlogin = null;

    //회원가입
    public void member() {
        long id = 1;
        String userId;
        if (checkedlogin == null) {
            Customer customer = new Customer(1, "홍길동", "1234");
            customers.add(customer);
            Customer customer1 = new Customer(2, "홍길순", "12345");
            customers.add(customer1);
            Customer customer2 = new Customer(3, "임꺽정", "123456");
            customers.add(customer2);
        }
        while (true) {
            System.out.print("새 아이디 :");
            userId = Container.getSc().nextLine().trim();
            boolean logincheck = false;

            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getUserId().equals(userId)) {
                    logincheck = true;
                }
            }
            if (logincheck != false) {
                System.out.println("이미 존재하는 아이디입니다. 새로 입력해주세요.");
                continue;
            }
            break;
        }
        String password;

        while (true) {

            System.out.print("새 비밀번호 :");
            password = Container.getSc().nextLine().trim();
            System.out.print("새 비밀번호 재확인 :");
            String passwordcheck = Container.getSc().nextLine().trim();
            if (password.equals(passwordcheck)){
                System.out.println("비밀번호가 입력되었습니다.");
            } else if (password != passwordcheck) {
                System.out.println("비밀번호가 다릅니다. 다시 입력해주세요.");
                continue;
            }
            break;
        }
        Customer customer = new Customer(id, userId, password);
        customers.add(customer);
        System.out.println("회원가입이 완료되었습니다. 환영합니다.");
    }
    public void login(){
        boolean useridchecked = false;
        Customer customer = null;

        if (checkedlogin != null){
            System.out.println("이미 로그인 되어있습니다.");
            return;
        }

        System.out.print("아이디 :");
        String userid = Container.getSc().nextLine().trim();
        System.out.print("비밀번호 :");
        String password = Container.getSc().nextLine().trim();

        for (int i = 0; i < customers.size(); i++){
            if (customers.get(i).getUserId().equals(userid)){
                customer = customers.get(i);
               useridchecked = true;
            }
        }
        if (useridchecked == false){
            System.out.println("아이디를 다시 입력해주세요.");
            return;
        }
        if (customer.getPassword().equals(password) == false){
            System.out.println("비밀번호가 다릅니다. 다시입력해주세요.");
            return;
        }
        checkedlogin = customer;
        System.out.println("로그인 되었습니다.");
    }
    public void write() {
        long id = lastWiseSaying + 1;
        System.out.print("명언 :");
        String content = Container.getSc().nextLine().trim();
        System.out.print("작가 :");
        String author = Container.getSc().nextLine().trim();
        System.out.println(id + "번 명언이 등록되었습니다.");
        Title title = new Title(id, content, author);
        titles.add(title);

        lastWiseSaying++;
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(17));
        for (int i = titles.size() - 1; i >= 0; i--) {
            Title title = titles.get(i);
            System.out.printf("%d, %s, %s\n", title.getId(), title.getAuthor(), title.getContent());
        }
    }

    public void remove(Request request) {
        int id = request.getIntparams("id", -1);

//             수정하기
        if (id == -1) {
            System.out.println("정수 id 값을 입력해주세요.");
            return;
        }

        Title title = findById(id);

        if (title == null) {
            System.out.println("값을 입력해주세요.");
        }
        titles.remove(title);
        System.out.println(id + "번 목록이 삭제되었습니다.");
    }

    public void modify(Request request) {
        int id = request.getIntparams("id", -1);

//             수정하기
        if (id == -1) {
            System.out.println("정수 id 값을 입력해주세요.");
            return;
        }

        Title title = findById(id);

        if (title == null) {
            System.out.println("값을 입력해주세요.");
        }
        System.out.printf("기존 명언 :%s\n", title.getContent());
        System.out.print("명언 :");
        String content = Container.getSc().nextLine().trim();
        System.out.printf("기존 작가 :%s\n", title.getAuthor());
        System.out.print("작가 :");
        String author = Container.getSc().nextLine().trim();

        title.setContent(content);
        title.setAuthor(author);

        System.out.println("목록이 수정되었습니다.");
    }

    public Title findById(int id) {
        for (Title title : titles) {
            if (title.getId() == id) {
                return title;
            }
        }
        return null;
    }
}
