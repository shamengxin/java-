package com.shemengxin.java.hashtab;

/**
 * ��ʾһ����Ա
 */
public class Emp {
    private int id;
    private String name;
    private Emp next;//nextĬ��Ϊnull

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Emp getNext() {
        return next;
    }

    public void setNext(Emp next) {
        this.next = next;
    }
}
