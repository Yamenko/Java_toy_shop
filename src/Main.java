import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ToyAssistant toy1 = new ToyAssistant("1", "Doll", 3);
        ToyAssistant toy2 = new ToyAssistant("2", "Car", 7);
        ToyAssistant toy3 = new ToyAssistant("3", "Puzzle", 4);

        Queue<ToyAssistant> toyQueue = new PriorityQueue<>((t1, t2) -> t2.getFrequency() - t1.getFrequency());

        toyQueue.add(toy1);
        toyQueue.add(toy2);
        toyQueue.add(toy3);

        try {
            FileWriter fileWriter = new FileWriter("result.txt");

            int size_q = 0;
            for (ToyAssistant toy : toyQueue) {
                size_q += toy.getFrequency();
            }

            for (int i = 0; i < size_q; i++) {
                ToyAssistant toy = toyQueue.poll();
                String result = "Toy ID: " + toy.getId() + ", Name: " + toy.getName() + "\n";
                fileWriter.write(result);

                toy.downgradeFrequency();
                toyQueue.add(toy);
            }
            fileWriter.close();
            System.out.println("Result written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}