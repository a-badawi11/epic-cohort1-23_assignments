
public class Assignment8 {

    public static void main(String[] args) {

        MyLinkedList<Integer> list1 = MyLinkedList.of(24,23,22);
        MyLinkedList<String> list2 = MyLinkedList.of("Ahmad", "Mohammad", "Khaled");

        MyLinkedList<Tuple<Integer, String>> zippedList = list1.zip(list2);

        Tuple<MyLinkedList<Integer>, MyLinkedList<String>> r = MyLinkedList.unZip(zippedList);

        r._1.forEach(System.out::println);
        System.out.println("");
        r._2.forEach(System.out::println);

    }

}
