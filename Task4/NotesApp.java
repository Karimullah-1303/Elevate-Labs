import java.io.*;
import java.util.Scanner;

public class NotesApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "notes.txt";

        while (true) {
            System.out.println("\n--- Notes App ---");
            System.out.println("1. Write a note");
            System.out.println("2. Read notes");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1: // Write a note
                        System.out.print("Enter your note: ");
                        String note = scanner.nextLine();

                        FileWriter writer = new FileWriter(fileName, true); // append mode
                        writer.write(note + "\n");
                        writer.close();

                        System.out.println("Note saved successfully!");
                        break;

                    case 2: // Read notes
                        FileReader fr = new FileReader(fileName);
                        BufferedReader br = new BufferedReader(fr);

                        System.out.println("\n--- Your Notes ---");
                        String line;
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }

                        br.close();
                        fr.close();
                        break;

                    case 3: // Exit
                        System.out.println("Exiting... Goodbye!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
