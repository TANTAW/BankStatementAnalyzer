package main;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> transactions;

    public BankStatementProcessor(List<BankTransaction> transactions) {
        this.transactions = transactions;
    }

    public List<BankTransaction> selectInMonth(Month month) {
        List<BankTransaction> transactionsPerMonth = new ArrayList<>();
        for (BankTransaction transaction : transactions) {
            if (transaction.date().getMonth() == month){
                transactionsPerMonth.add(transaction);
            }
        }
        return transactionsPerMonth;
    }

    public double calculateTotalAmount() {
        double total = 0d;
        for (BankTransaction transaction : transactions) {
            total += transaction.amount();
        }
        return total;
    }

    public double calculateTotalAmountForCategory(String category){
        double total = 0d;
        for (BankTransaction transaction : transactions) {
            if (transaction.description().equals(category))
                total += transaction.amount();
        }
        return total;
    }

}
