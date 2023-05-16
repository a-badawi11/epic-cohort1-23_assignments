/** Assignment #7: Implement custom hash map */

public class Assignment7 {

    public static void main(String[] args) {

        CHashMap<Integer, String> map = new CHashMap<>();

        map.put(1, "Ahmad");
        map.put(1, "Aaa");
        map.put(2, "Khaled");
        map.put(3, "Laith");

        map.remove(2);

        map.forEach( (k,v) -> {
            System.out.println("k = " + k + " v = " + v);
        });

        System.out.println("map.containsKey(1) = " + map.containsKey(1));
        System.out.println("map.size() = " + map.size());

    }
}
