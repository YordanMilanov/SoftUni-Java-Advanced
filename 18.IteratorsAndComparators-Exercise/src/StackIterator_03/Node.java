package StackIterator_03;

public class Node<Integer> {

    //Stack-a е съвкупност от nodes(група от данни която съдържа два елемента
    // -> стойността на елемента и позицията на елемента преди него(предишен елемент)).

    public int element;
    public Node<Integer> prev;

    public Node(int element) {
        this.element = element;
        this.prev = null;
    }
}
