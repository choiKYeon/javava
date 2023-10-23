package org.example.system.title.controller;

import org.example.Container;
import org.example.Request;
import org.example.system.title.entity.Customer;
import org.example.system.title.entity.Title;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class TitleController {
    long titleLastId = 0;
    List<Title> titles = new ArrayList<>();
    List<Customer> customers = new ArrayList<>();

    public void member() {
        long id = 1;

        String userid;

        while (true) {
            System.out.printf("아이디) ");
            userid = Container.getSc().nextLine();
            boolean duplicatedUserId = false;

            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getUserId().equals(userid)) {
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
        System.out.println("비밀번호가 저장되었습니다.");
        Container.getSc().nextLine();
        id++;
    }

    public void customerlist() {
        System.out.println("번호 / 고객아이디 / 고객비밀번호");
        System.out.println("-".repeat(17));
        for (int i = customers.size() - 1; i >= 0; i--) {
            Customer customer = customers.get(i);
            System.out.printf("%d, %s, %s\n", customer.getId(), customer.getUserId(), customer.getPassword());
        }
    }

    public void write() {
        long id = titleLastId + 1;

        System.out.print("제목 :");
        String titleName = Container.getSc().nextLine().trim();
        System.out.print("내용 :");
        String content = Container.getSc().nextLine().trim();
        System.out.println(id + "번 게시글이 등록되었습니다.");
        Title title = new Title(id, titleName, content);
        titles.add(title);

        titleLastId++;
    }

    public void list() {
        System.out.println("번호 / 제목 / 내용");
        System.out.println("-".repeat(17));
        for (int i = titles.size() - 1; i >= 0; i--) {
            Title title = titles.get(i);
            System.out.printf("%d, %s, %s\n", title.getId(), title.getTitleName(), title.getContent());
        }
    }

    public void remove(Request request) {
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
        titles.remove(title);
        System.out.println(id + "번 목록이 삭제되었습니다.");
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
}
