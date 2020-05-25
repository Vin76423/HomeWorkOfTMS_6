import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Computer [] computers = new Computer[5];

        for ( int i = 0; i < computers.length; i++ ) {
            String processorLine;
            if ( i % 2 == 0 ) processorLine = "Intel i5";
            else processorLine = "Intel i7";

            computers [i] = new Computer(processorLine, random.nextInt(20), random.nextInt(700), random.nextInt(50));
        }

        int maxIndex = 0;
        for ( int i = 1; i < computers.length; i++ ) {
            if ( computers [i].getCore() > computers [maxIndex].getCore() ) {
                maxIndex = i;
            }
        }

        System.out.println("Компьютером с наибольшим размером оперативной памяти - " +
                "является компьютер под номером " + (maxIndex + 1) + ". И имеет следующие характеристикаи:\n");

        computers [maxIndex].description();
    }
}
