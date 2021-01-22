
import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements Iterable<E> {
    private Object[] items;
    private int capacity;
    public static final int DEFAULT_SIZE = 5;
    public static final int EXPANSION = 2;
    private int size;

    public ArrayList() {
        size = 0;
        capacity = DEFAULT_SIZE;
        items = new Object[DEFAULT_SIZE];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Object obj) {
        try {
            if (size >= capacity) {
                expand();
            }
            items[size] = obj;
            size++;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There is an error adding this word." + e.getMessage());
        }
    }

    private void expand() {
        Object[] newItems = new Object[capacity + EXPANSION];
        if (size >= 0) System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
        capacity = capacity + EXPANSION;
    }

    public E get(int index) {
        try {
            return (E) items[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("There is an error getting this word from position: " + e.getMessage());
        }
        return (E) items[index];
    }

    public boolean contains(Object o) {
        for (Object e : items
        ) {
            if (e.equals(o)) {
                return true;
            }
        }
        return false;
    }

    public void add(int index, E element) {
        try {
            size++;
            if (size >= capacity) {
                expand();
            }
            if (size - index >= 0) {
                System.arraycopy(items, index, items, index + 1, size - index);
            }
            items[index] = element;

        } catch (IndexOutOfBoundsException e) {
            System.out.println("There is an error adding this word to array at position: " + e.getMessage() + ".");
        }
    }

    public int indexOf(Object o) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        for (int i = items.length - 1; i >= 0; i--) {
            if (items[i] != null) {
                if (items[i].equals(o)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void set(int index, E element) {
        items[index] = element;
    }

    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(this.get(i))) {
                if (size - 1 - i >= 0) {
                    System.arraycopy(items, i + 1, items, i, size - 1 - i);
                    size--;
                }
                items[size] = null;
                return true;
            }
        }
        return false;
    }

    public E remove(int index) {
        try {
            E result = this.get(index);
            if (size - 1 - index >= 0) {
                System.arraycopy(items, index + 1, items, index, size - 1 - index);
                size--;
            }
            items[size] = null;
            return result;
        } catch (IndexOutOfBoundsException e) {
            System.out.print("There is an error removing this word from position " + e.getMessage());
        }
        return null;
    }

    public void clear() {
        Arrays.fill(items, null);
        size = 0;
    }

    public Object[] toArray() {
        int count = 0;
        for (Object o : items) {
            if (o == null) {
                count++;
            }
        }
        Object[] objects = new Object[items.length - count];
        System.arraycopy(items, 0, objects, 0, objects.length);
        return objects;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return items[currentIndex] != null;
            }

            @Override
            public E next() {
                return (E) items[currentIndex++];
            }
        };
    }
}

class Main {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        System.out.println(stringArrayList.isEmpty());
        System.out.println(stringArrayList.size());
        stringArrayList.add("1");
        System.out.println(stringArrayList.isEmpty());
        stringArrayList.add("2");
        stringArrayList.add("3");
        stringArrayList.add("4");
        stringArrayList.add("5");
        stringArrayList.add("6");
        stringArrayList.add("7");
        stringArrayList.add("8");
        for (String i : stringArrayList) {
            System.out.print(i + " ");
        }
        System.out.println();
        String get = stringArrayList.get(5);
        System.out.println(get);
        System.out.println(stringArrayList.contains("8"));
        stringArrayList.add(0, "9");
        System.out.println();
        for (String i : stringArrayList) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();
        int index = stringArrayList.indexOf("5");
        System.out.println(index);
        int lastIndex = stringArrayList.lastIndexOf(1);
        System.out.println(lastIndex);
        stringArrayList.set(0, "10");
        for (String i : stringArrayList) {
            System.out.print(i + " ");
        }
        boolean b = stringArrayList.remove("10");
        System.out.println();
        System.out.println(b);
        System.out.println();
        for (String i : stringArrayList) {
            System.out.print(i + " ");
        }
        System.out.println();
        String remove = stringArrayList.remove(0);
        System.out.println(remove);
        for (String s : stringArrayList) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(stringArrayList.toArray()));
        stringArrayList.clear();
        for (String s : stringArrayList) {
            System.out.print(s + " ");
        }
    }
}