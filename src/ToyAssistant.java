import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;

public class ToyAssistant {
    private String id;
    private String name;
    private int frequency;

    public ToyAssistant(String id, String name, int frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFrequency() {
        return frequency;
    }
    public void downgradeFrequency() {
        frequency--;
    }
}