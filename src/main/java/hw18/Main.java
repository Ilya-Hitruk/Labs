package hw18;

public class Main {
    public static void main(String[] args) {

        ListInterface<Integer> listExample = new LinkedListExample<>();
        listExample.add(1);
        listExample.add(2);
        listExample.add(3);
        listExample.add(4);
        listExample.add(5);
        listExample.add(2, 10);
        listExample.set(3, 7);


        System.out.println(listExample);
        System.out.println("get = " + listExample.get(2));
        System.out.println("getFirst = " + listExample.getFirst());
        System.out.println("getLast = " + listExample.getLast() + "\n");

        System.out.println("remove = " + listExample.remove(5));
        System.out.println("removeFirst = " + listExample.removeFirst());
        System.out.println("removeLast = " + listExample.removeLast() + "\n");
        System.out.println(listExample);

        System.out.println("contains 10 = " + listExample.contains(10));
        System.out.println("is Empty = " + listExample.isEmpty());
        System.out.println("size = " + listExample.size());
        listExample.clear();
        System.out.println("cleared list isEmpty = " + listExample.isEmpty());
    }
}
