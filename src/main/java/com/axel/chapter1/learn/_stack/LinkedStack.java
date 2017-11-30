package com.axel.chapter1.learn._stack;

import java.util.Iterator;

/**
 * 使用单链表实现的下压栈
 */
public class LinkedStack<Item> implements Iterable<Item> {

    private Node first; //头结点,栈顶
    private int N; //元素的数量

    @Override
    public Iterator<Item> iterator() {
        return new LinkIterator();
    }

    /**
     * 链表的内部类
     */
    private class Node {

        Item item;
        Node next;
    }

    private class LinkIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public Boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node old = first;
        Node temp = new Node();
        temp.item = item;
        temp.next = old;
        first = temp;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
}
