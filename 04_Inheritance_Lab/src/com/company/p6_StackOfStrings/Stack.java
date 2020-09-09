package com.company.p6_StackOfStrings;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private List<String> data;

    public Stack() {
        this.data = new ArrayList<>();
    }

    public void push(String name) {
        this.data.add(name);
    }

    public String pop() {
        if (!isEmpty()) {
            return this.data.remove(this.data.size()-1);
        } else {
            return "List is empty";
        }
    }

    public String peek() {
        return this.data.get(this.data.size()-1);
    }

    public boolean isEmpty() {
        if (data.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
