package ru.first;

import java.util.*;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class LinkedList implements List<String> {
    int size;
    Node first;
    Node last;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {

        return false;

    }


    @Override
    public boolean contains(Object o) {
        Iterator it = listIterator();
        if (o == null) {
            while (it.hasNext()) {
                if (o.equals(it.next())) {
                    return true;
                }
            }
        } else {
            while (it.hasNext()) {
                if (o.equals(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public Iterator<String> emptyIterator() {
        Iterator<String> emptyIterator = new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public String next() {

                throw new java.util.NoSuchElementException();

            }
        };
        return emptyIterator;
    }


    @Override
    public Iterator<String> iterator() {
        return listIterator();
    }


    @Override
    public String[] toArray() {
        String[] newArray = new String[size];
        int i = 0;
        for (Node n = first; n != null; n = n.next) {
            newArray[i] = n.value;
            i++;
        }

        return newArray;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return List.super.toArray(generator);
    }

    @Override
    public boolean add(String s) {
        if (last == null) {
            first = new Node(s, null, null);
            last = first;
        } else {
            last.next = new Node(s, last, null);
            last = last.next;
        }

        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (contains(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            add(it.toString());
            return true;
        }

        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Iterator r = listIterator();
        Node n = first;
        while (r.hasNext()) {
            r.remove();
        }
        return true;
    }

    @Override
    public boolean removeIf(Predicate<? super String> filter) {
        return false;
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        int i = 0;
        boolean m = false;
        for (Object o : c) {
            if (contains(o)) {
                remove(i);
                i++;
                m = true;
            }
        }


        return m;
    }

    @Override
    public void replaceAll(UnaryOperator<String> operator) {
        List.super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super String> c) {
        List.super.sort(c);
    }

    @Override
    public void clear() {

    }

    public int getIndex(String val) {
        Node n = first;
        int i = 0;
        while (n != null) {
            if (val.equals(n.value)) {
                return i;
            }
            n = n.next;
            i++;
        }
        return 0;
    }

    @Override
    public String get(int index) {
        return node(index).value;
    }

    @Override
    public String set(int index, String element) {
        Node n = node(index);
        String s =n.value;
        n.value = element;
        return s;
    }

    @Override
    public void add(int index, String element) {
        if (last == null) {
            first = new Node(element, null, null, 0);
            last = first;
        } else {
            last.next = new Node(element, last, null, last.index++);
            last = last.next;
        }

        size++;

    }

    void unlink(Node n) {
        String e = n.value;
        Node prev = n.prev;
        Node next = n.next;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            n.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            n.next =null;

        }
        size= size-1;
        n.value = null;

    }

    @Override
    public String remove(int index) {
        Node n = first;
        int i = 0;
        while (n != null) {
            if (i == index) {
                unlink(n);
            }
            i++;
            n = n.next;
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    Node node(int index) {
        if (index < (size / 2)) {
            Node n = first;
            for (int i = 0; i < index; i++) {
                n = n.next;
            }
            return n;
        } else {
            Node n = last;
            for (int i = size-1; i > index; i--) {
                n = n.prev;
            }
            return n;

        }

    }

    @Override
    public ListIterator<String> listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return new ListItr(index);

    }

    private class ListItr implements ListIterator<String> {
        private Node next;
        private Node lastReturned;
        private int nextIndex;

        ListItr(int index) {
            this.next = (index == size) ? null : node(index);
            this.nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }


        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.value;
        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public String previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            lastReturned = next;
            next = (next == null) ? last : next.prev;
            nextIndex--;
            return lastReturned.value;
        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex--;
        }

        @Override
        public void remove() {
            if (lastReturned == null)
                throw new IllegalStateException();
            unlink(lastReturned);


        }

        @Override
        public void set(String s) {
            if (lastReturned == null)
                throw new IllegalStateException();
            lastReturned.value = s;

        }

        @Override
        public void add(String s) {
            if (next != null) {
                Node newNode = new Node(s, next.prev, next, nextIndex);
            } else {
                Node newNode = new Node(s, lastReturned, lastReturned.next, nextIndex);
            }
            nextIndex++;
            size++;

        }

    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator<String> spliterator() {
        return List.super.spliterator();
    }

    @Override
    public Stream<String> stream() {


        return List.super.stream();
    }

    @Override
    public Stream<String> parallelStream() {
        return List.super.parallelStream();
    }


}


