package Map;

import java.util.Objects;

public class MyHashMap<K, V> {
    class MyNode<K,V> {
        public K key;
        public V value;
        public MyNode<K, V> next;

        public MyNode(K key, V value, MyNode<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public MyNode getNext() {
            return next;
        }



        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setNext(MyNode<K, V> next) {
            this.next = next;
        }



        @Override
        public String toString() {
            return "MyNode{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    private int capaсity = 16;

    private MyNode<K,V>[] table;

    public MyHashMap() {
        this.table = new MyNode[capaсity];
    }

    public MyHashMap(int capacity) {
        this.capaсity = capacity;
        this.table = new MyNode[capacity];
    }

    public void put(K key, V value) {
        int table_number = table_number(key);
        MyNode newMyNode = new MyNode(key, value, null);
        if (table[table_number] == null) {
            table[table_number] = newMyNode;
        } else {
            MyNode<K,V> current = table[table_number];
            MyNode<K,V> previous = null;
            while (current != null) {
                if (current.getKey().equals(key)) {
                    current.setValue(value);
                    break;
                }
                previous = current;
                current = current.getNext();
            }
            if (previous != null)
                previous.setNext(newMyNode);
        }

    }

    public V get(K key) {
        V value = null;
        int table_number = table_number(key);
        MyNode<K,V> current = table[table_number];
        while (current != null) {
            if (current.getKey().equals(key)) {
                value = current.getValue();
            }

            current = current.getNext();
        }
        return value;
    }

    public void remove(K key) {
        int table_number = table_number(key);
        MyNode<K,V> current = table[table_number];
        MyNode<K,V> previous = null;
        while (current != null) {
            if (current.getKey().equals(key)) {
                current.setNext(current.getNext());
                break;
            } else {
                previous.setNext(current.getNext());
            }

        }
    }

    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                MyNode<K,V> current = table[i];
                while (current != null) {
                    System.out.println(current.toString());
                    current = current.getNext();
                }
            }
        }
    }

    private int table_number(K key) {
        return key == null ? 0 : Math.abs(key.hashCode() % capaсity);
    }


}
