package Jar;

import java.util.ArrayDeque;

public class Jar<Т> {
    private ArrayDeque<Т> stack;


    public Jar() {
        this.stack = new ArrayDeque<>();
    }

    public void add(Т element) {
        this.stack.push(element);
    }

    public Т remove() {
       return this.stack.pop();
    }
}
