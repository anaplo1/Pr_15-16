package com.company;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CloseLinkedList<E> implements Iterable<E>, Cloneable {
    private Node head;
    private int size;

    CloseLinkedList() {
        initHead();
    }

    CloseLinkedList(Collection<? extends E> list) {
        this();
        addAll(list);
    }

    private void initHead() {
        this.head = new Node(null, null, null);
        this.head.next = this.head.prev = this.head;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Incorrect index output...");
        }
    }

    private Node getNodeByIndex(int index) {
        checkIndex(index);
        Node resultNode = null;
        int half = this.size / 2;
        int count = half > index ? index : this.size - index - 1;
        for (Node node = (half > index ? this.head.next : this.head.prev); node != this.head; node = (half > index ? node.next : node.prev)) {
            if (count-- == 0) {
                resultNode = node;
                break;
            }
        }
        return resultNode;
    }

    private int indexOfMove(E value, boolean reverse) {
        int index = -1;
        int search = 0;
        if (value != null) {
            for (Node node = (reverse ? this.head.prev : this.head.next); node != this.head; node = (reverse ? node.prev : node.next)) {
                if (node.value.equals(value)) {
                    index = reverse ? this.size - search - 1 : search;
                    break;
                }
                search++;
            }
        }
        return index;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        initHead();
        this.size = 0;
    }

    public boolean add(E value) {
        addLast(value);
        return true;
    }

    public void addFirst(E value) {
        if (value != null) {
            Node first = new Node(this.head.next, this.head, value);
            this.head.next = this.head.next.prev = first;
            this.size++;
        }
    }

    public void addLast(E value) {
        if (value != null) {
            Node last = new Node(this.head, this.head.prev, value);
            this.head.prev = this.head.prev.next = last;
            this.size++;
        }
    }

    public boolean addAll(Collection<? extends E> list) {
        boolean result;
        if (result = list != null && !list.isEmpty()) {
            for (E value : list) {
                result = result && add(value);
            }
        }
        return result;
    }

    public void add(int index, E value) {
        if (value != null) {
            if (index == 0) {
                addFirst(value);
            } else if (index == this.size) {
                addLast(value);
            } else {
                Node node = getNodeByIndex(index);
                if (node != null) {
                    Node newNode = new Node(node, node.prev, value);
                    node.prev = node.prev.next = newNode;
                    this.size++;
                }
            }
        }
    }

    @SafeVarargs
    public static <T> CloseLinkedList<T> of(T... values) {
        CloseLinkedList<T> list = new CloseLinkedList<>();
        if (values != null) {
            for (T value : values) {
                list.add(value);
            }
        }
        return list;
    }

    public int indexOf(E value) {
        return indexOfMove(value, false);
    }

    public int lastIndexOf(E value) {
        return indexOfMove(value, true);
    }

    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    public E get(int index) {
        return getNodeByIndex(index).value;
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Element not found...");
        }
        return this.head.next.value;
    }

    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Element not found...");
        }
        return this.head.prev.value;
    }

    public E set(int index, E value) {
        E element = null;
        if (value != null) {
            Node node = getNodeByIndex(index);
            if (node != null) {
                element = node.value;
                node.value = value;
            }
        }
        return element;
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Element not found...");
        }
        E oldElement = this.head.next.value;
        Node delete = this.head.next;
        this.head.next = delete.next;
        delete.next.prev = this.head;
        this.size--;
        return oldElement;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Element not found...");
        }
        E oldElement = this.head.prev.value;
        Node delete = this.head.prev;
        this.head.prev = delete.prev;
        delete.prev.next = this.head;
        this.size--;
        return oldElement;
    }

    public boolean remove(E value) {
        boolean result;
        if (result = value != null && !isEmpty()) {
            Node delete = null;
            for (Node node = this.head.next; node != this.head; node = node.next) {
                if (node.value.equals(value)) {
                    delete = node;
                    break;
                }
            }
            if (result = delete != null) {
                delete.prev.next = delete.next;
                delete.next.prev = delete.prev;
                this.size--;
            }
        }
        return result;
    }

    public E remove(int index) {
        E element = null;
        Node delete = getNodeByIndex(index);
        if (delete != null) {
            element = delete.value;
            delete.next.prev = delete.prev;
            delete.prev.next = delete.next;
            this.size--;
        }
        return element;
    }

    public Object[] toArray() {
        Object[] values = new Object[this.size];
        int index = 0;
        for (Node node = this.head.next; node != this.head; node = node.next) {
            values[index++] = node.value;
        }
        return values;
    }

    @SuppressWarnings("unchecked")
    public E[] toArray(E[] array) {
        E[] values = (E[]) Array.newInstance(array.getClass().getComponentType(), this.size);
        int index = 0;
        for (Node node = this.head.next; node != this.head; node = node.next) {
            values[index++] = node.value;
        }
        return values;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }

    @SuppressWarnings("unchecked")
    private CloseLinkedList<E> superClone() {
        try {
            return (CloseLinkedList<E>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    protected CloseLinkedList<E> clone() {
        CloseLinkedList<E> clone = superClone();
        clone.clear();
        for (Node node = this.head.next; node.value != this.head; node = node.next) {
            clone.add(node.value);
        }
        return clone;
    }

    public Stream<E> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorLinked();
    }

    private class IteratorLinked implements Iterator<E> {
        private Node cursor = head.next;

        @Override
        public boolean hasNext() {
            return cursor != head;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Elements not found...");
            }
            E value = cursor.value;
            cursor = cursor.next;
            return value;
        }
    }

    @SuppressWarnings("unchecked")
    public void sort() {
        E[] elements = (E[]) stream().sorted().toArray();
        clear();
        Arrays.stream(elements).forEach(this::add);
    }

    @SuppressWarnings("unchecked")
    public void sort(Comparator<? super E> c) {
        E[] elements = (E[]) stream().sorted(c).toArray();
        clear();
        Arrays.stream(elements).forEach(this::add);
    }

    private class Node {
        private Node next;
        private Node prev;
        private E value;

        Node(Node next, Node prev, E value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }
}
