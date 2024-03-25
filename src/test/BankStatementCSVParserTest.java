import main.BankStatementCSVParser;
import main.BankStatementParser;
import main.BankTransaction;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class BankStatementCSVParserTest {
    private final BankStatementParser parser = new BankStatementCSVParser();

    @Test
    public void shouldParseOneCorrectLine() throws Exception{
        String transactionLine = "30-01-2017,-50,Tesco";

        BankTransaction result = parser.parseFromCsv(transactionLine);

        BankTransaction expected = new BankTransaction(
                LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");

        Assert.assertEquals(expected.date(), result.date());
        Assert.assertEquals(expected.amount(), result.amount(), 0.0d);
        Assert.assertEquals(expected.description(), result.description());


    }
}
