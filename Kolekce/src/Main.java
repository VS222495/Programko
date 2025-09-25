// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("Seznam: " + list);
        System.out.println("Velikost: " + list.size());
        System.out.println("Prvek [1]: " + list.get(0));




        list.set(1, 99);
        list.set(5, 77);
        System.out.println("Po změně: " + list);
    }
}
