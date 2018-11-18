import java.util.ArrayDeque;
import java.util.Deque;

public class MagicQueue {

    public static void queneView(int numberCola) {
        Deque<String> queue = new ArrayDeque<>();
        queue.add("Sheldon");
        queue.add("Leonard");
        queue.add("Volovitc");
        queue.add("Kutrapalli");
        queue.add("Penny");
        String tmp;
        for (int i = 0; i < numberCola; i++) {
            tmp = queue.poll();
            queue.add(tmp);
            queue.add(tmp);
        }
        System.out.print(queue.toString());
    }

}
