package com.axel.chapter1.learn._stack;

import java.util.Iterator;

/**
 * 使用数组实现的可变长的栈
 */
public class FixedStack<Item> implements Iterable<Item> {

    private int N; //number of elements
    private Object[] items;

    public FixedStack(int capacity) {
        items = new Object[capacity];
    }

    public int size() {
        return N;
    }

    public void push(Item item) {

        if (N == items.length) {
            resize(2 * items.length);
        }
        items[N++] = item;
    }

    public Item pop() {
        Item temp = (Item) items[N--];
        if (N == 0 || N < items.length / 4) {
            resize(items.length / 2);
        }
        return temp;
    }

    public Boolean isEmpty() {
        return N == 0;
    }

    //改变数组长度
    private void resize(int length) {
        Item[] temp = (Item[]) new Object[length];
        for (int i = 0; i < N; i++) {
            temp[i] = (Item) items[i];
        }
        items = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return (Item) items[--i];
        }

        @Override
        public void remove() {

        }
    }
}
