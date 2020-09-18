import services.EventService;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EventService collectionEvents = new EventService();
        Scanner scanner = new Scanner(System.in);
        try {
            collectionEvents.loadFile(args[0]);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return;
        }
        chooseMenu(collectionEvents, scanner);
        scanner.close();
    }

    private static void chooseMenu(EventService collectionEvents, Scanner scanner) {
        final int PRINT_LIST = 1;
        final int SORT_LIST = 2;
        final int EXIT = 3;
        while (true) {
            System.out.println("Choose your action:\n" +
                    "1) Print list\n" +
                    "2) Sort list\n" +
                    "3) Exit");
            int action = Integer.parseInt(scanner.nextLine());
            System.out.println();
            switch (action) {
                case PRINT_LIST:
                    collectionEvents.printControlEvents();
                    System.out.println();
                    break;
                case SORT_LIST:
                    collectionEvents.sortControlEvents();
                    System.out.println("List sorted\n");
                    break;
                case EXIT:
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Choose the correct action!");
            }
        }
    }
}
