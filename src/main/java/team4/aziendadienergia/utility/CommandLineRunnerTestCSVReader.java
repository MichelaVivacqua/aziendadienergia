package team4.aziendadienergia.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

@Component
public class CommandLineRunnerTestCSVReader implements CommandLineRunner {

    private final MyCSVReader csvReader;

    @Autowired
    public CommandLineRunnerTestCSVReader(MyCSVReader myCSVReader) {
        this.csvReader = myCSVReader;
    }

    @Override
    public void run(String... args) throws Exception {
        // Path dei file CSV
        Path csvPath1 = Paths.get("src/main/java/team4/aziendadienergia/CSV/comuni-italiani.csv");
        Path csvPath2 = Paths.get("src/main/java/team4/aziendadienergia/CSV/province-italiane.csv");

        // Lettura dei file
        List<String[]> csv1 = csvReader.readCsv(csvPath1);
        List<String[]> csv2 = csvReader.readCsv(csvPath2);

        // Inizio navigazione
        if (csv1 != null && !csv1.isEmpty() && csv2 != null && !csv2.isEmpty()) {
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("If you're reading this line, then the CSVs were read correctly");
            System.out.println("The CSV files have " + csv1.size() + " lines and " + csv2.size() + " lines");
            System.out.println("Type 1 to list the town names, type 2 to list the province code, type 3 to exit");

            Scanner scanner = new Scanner(System.in);
            int choice = 0;

            while (choice != 3) {
                System.out.print("Enter your choice: ");
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            for (String[] s : csv1) {
                                System.out.println(s[2]); // TERZA COLONNA PER PRENDERE IL TOWN NAME
                            }
                            break;
                        case 2:
                            for (String[] s : csv2) {
                                System.out.println(s[0]); // PRIMA COLONNA PER CODICE PROVINCIA
                            }
                            break;
                        case 3:
                            System.out.println("Exiting...");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please, type a number between 1 and 3.");
                }
            }
        } else {
            throw new Exception("Error reading the CSV files");
        }
    }
}