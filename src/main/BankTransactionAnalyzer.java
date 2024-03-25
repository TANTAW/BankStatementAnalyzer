package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;

import java.util.List;

public class BankTransactionAnalyzer {

    private static final String RESOURCES = "src/main/resources/";

    public void analyze(String fileName, BankStatementParser parser) throws IOException {
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);
        List<BankTransaction> transactions = parser.parseLinesFromCSV(lines);
        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(transactions);

        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total transactions for JANUARY is " + bankStatementProcessor.selectInMonth(Month.JANUARY));
        System.out.println("The total transactions for FEBRUARY is " + bankStatementProcessor.selectInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalAmountForCategory("Salary"));
    }


}
