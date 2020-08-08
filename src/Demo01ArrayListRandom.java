import java.util.ArrayList;
import java.util.Random;

public class Demo01ArrayListRandom {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            int m = random.nextInt(33) + 1;


            arrayList.add(m);
        }
    }
}
