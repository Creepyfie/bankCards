package bankStuff;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CreditCardWithBonucesTest {

    @Test
    public void topUpBalance() {
        CreditCardWithBonuces testCreditCard = new CreditCardWithBonuces();

        //expected
        testCreditCard.topUpBalance(new BigDecimal(10000));
        BigDecimal expectedBalance = testCreditCard.getBankCardBalance();

        //actual
        BigDecimal actualBalance = BigDecimal.valueOf(10050.000);

        Assert.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void getInformationAboutAvailableFunds() {
        CreditCardWithBonuces testCreditCard = new CreditCardWithBonuces(new BigDecimal(7000));

        testCreditCard.topUpBalance(new BigDecimal(10000));

        testCreditCard.getInformationAboutAvailableFunds();
    }
}