package main;

import java.util.List;

public interface BankStatementParser {
    BankTransaction parseFromCsv(String line);

    List<BankTransaction> parseLinesFromCSV(List<String> lines);
}
