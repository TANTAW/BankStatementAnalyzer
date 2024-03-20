package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionAnalyzerSimple {

    private static final String RESOURCES = "src/main/resources/";

    public static void main(final String... args) throws IOException {
        final Path path = Paths.get(RESOURCES + "bank-data-simple.csv");
        final List<String> lines = Files.readAllLines(path);
        BankStatementCSVParser parser = new BankStatementCSVParser();
        List<BankTransaction> transactions = parser.parseLinesFromCSV(lines);

        System.out.println("The total for all transactions is " + calculateTotalAmount(transactions));
        System.out.println("The total transactions for JANUARY is " + selectInMonth(transactions, Month.JANUARY));
    }

    private static List<BankTransaction> selectInMonth(List<BankTransaction> transactions, Month month) {
        List<BankTransaction> transactionsPerMonth = new ArrayList<>();
        for (BankTransaction transaction : transactions) {
            if (transaction.date().getMonth() == month){
                transactionsPerMonth.add(transaction);
            }
        }
        return transactionsPerMonth;
    }

    private static double calculateTotalAmount(List<BankTransaction> transactions) {
        double total = 0d;
        for (BankTransaction transaction : transactions) {
            total += transaction.amount();
        }
        return total;
    }
}
