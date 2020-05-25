import java.util.Random;
import java.util.Scanner;

public class Computer {
    private String processor;
    private int core;
    private int hardDisk;
    private int counterCycle;
    private boolean isLive = true;
    private boolean switched = false;

    public Computer(String processor, int core, int hardDisk, int counterCycle) {
        this.processor = processor;
        this.core = core;
        this.hardDisk = hardDisk;
        this.counterCycle = counterCycle;
    }

    public String getProcessor() {
        return processor;
    }

    public int getCore() {
        return core;
    }

    public int getHardDisk() {
        return hardDisk;
    }

    public int getCounterCycle() {
        return counterCycle;
    }

    public void description () {
        System.out.println("Процессор: " + processor + "\nОперативная память: " + core + " Гб" + "\nЕмкость жесткого диска: " +
                hardDisk + " Гб" + "\nКоличество полных рабочих циклов: " + counterCycle);
    }


    public void start () {
        if ( switched ) {
            System.out.println("Компьютер и так уже включен.");
        } else if ( isLive && counterCycle > 0 ) {
            Random random = new Random();
            int value = random.nextInt(2);

            if ( value == input() ) {
                switched = true;
                System.out.println("Компьютер Включился :)");
            } else {
                isLive = false;
                System.out.println("Компьютер сгорел, сорян....");
            }

        } else {
            System.out.println("Компьютер сгорел, сорян....");
        }
    }

    public void stop () {
        if ( switched ) {
            Random random = new Random();
            int value = random.nextInt(2);

            if ( value == input() ) {
                switched = false;
                counterCycle--;
                System.out.println("Компьютер ВЫключился :)");
            } else {
                isLive = false;
                System.out.println("Компьютер сгорел, сорян....");
            }

        } else {
            System.out.println("Компьютер и так выключен.");
        }
    }

    private int input () {
        int input;
        System.out.println("Введите 0 или 1:");

        while ( true ) {
            Scanner scanner = new Scanner(System.in);
            if ( scanner.hasNextInt() ) {
                input = scanner.nextInt();
                if ( input == 0 || input == 1 ) {
                    break;
                }
            }
            System.out.println("Значение не корректно, попробуйте еще раз:");
        }
        return input;
    }
}
