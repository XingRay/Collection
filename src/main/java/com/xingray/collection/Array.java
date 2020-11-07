package com.xingray.collection;

import java.util.*;

public class Array<T> {

    private final Object[] array;

    public Array(Object[] array) {
        this.array = array;
    }

    public Array(int length) {
        array = new Object[length];
    }

    public T get(int index) {
        //noinspection unchecked
        return (T) array[index];
    }

    public void set(int index, T t) {
        array[index] = t;
    }

    public int length() {
        return array.length;
    }

    public List<T> toList() {
        int length = length();
        if (length == 0) {
            return Collections.emptyList();
        }
        //noinspection unchecked
        return new ArrayList<T>((Collection<? extends T>) Arrays.asList(array));
    }

    public static <E> Array<E> of(Iterator<E> iterator) {
        if (iterator == null) {
            return null;
        }
        Collection<E> c;

        if (iterator instanceof Collection) {
            //noinspection unchecked
            c = (Collection<E>) iterator;
        } else {
            ArrayList<E> list = new ArrayList<>();
            while (iterator.hasNext()) {
                list.add(iterator.next());
            }
            c = list;
        }
        return new Array<>(c.toArray());
    }

}
