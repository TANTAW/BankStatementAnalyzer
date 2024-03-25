package main;

import java.io.IOException;

public class MainApp {
    public static void main(String[] args){
        BankTransactionAnalyzer analyzer = new BankTransactionAnalyzer();
        try {
            analyzer.analyze("bank-data-simple.csv", new BankStatementCSVParser());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
