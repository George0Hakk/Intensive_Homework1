package Map;

public class main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map= new MyHashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.printTable();
    }
}
