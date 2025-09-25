import java.util.Arrays;

public class MyList implements MyListInterface {
    private int[] data;
    private int count;

    public MyList() {
        data = new int[0];
        count = 0;
    }

    @Override
    public void set(int index, int value) {
        if (index < 0 || index >= count) {
            System.out.println("Chyba: index " + index + " je mimo rozsah.");
            return;
        }
        data[index] = value;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= count) {
            System.out.println("Chyba: index " + index + " je mimo rozsah.");

        }
        return data[index];
    }

    @Override
    public void add(int value) {
        int[] newData = new int[count + 1];
        for (int i = 0; i < count; i++) {
            newData[i] = data[i];
        }
        newData[count] = value;
        data = newData;
        count++;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < count; i++) {
            result = result + data[i];
            if (i < count - 1) {
                result = result + ", ";
            }
        }
        result = result + "]";
        return result;
    }
}
