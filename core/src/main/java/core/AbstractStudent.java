package core;

import java.util.Random;    // This class is probably useless,
                        // remove further down the line

public class AbstractStudent {
    private int counter = 1000;
    private Random random = new Random();

    protected String generateID() {
        String id = "";
        int length = 10000000;
        while (length > 1000) {
            if (counter / length == 0) id += "0";
            length = length/10;
        }
        return id + counter++;
    }
}
