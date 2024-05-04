package bankStuff;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DebitCardTest {

    @Test
    public void topUpBalance() {

        DebitCard testDebitCard = new DebitCard();

        //expected
        testDebitCard.topUpBalance(new BigDecimal(3333));
        BigDecimal expectedBalance = testDebitCard.getBankCardBalance();

        //actual
        BigDecimal actualBalance = new BigDecimal(3333);

        Assert.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void pay() {

        DebitCard testDebitCard = new DebitCard();

        //expected
        testDebitCard.topUpBalance(new BigDecimal(3333));
        testDebitCard.pay(new BigDecimal(333));
        BigDecimal expectedBalance = testDebitCard.getBankCardBalance();

        //actual
        BigDecimal actualBalance = new BigDecimal(3000);

        Assert.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void getBalanceInformation() {

        DebitCard testDebitCard = new DebitCard();

        //expected
        testDebitCard.topUpBalance(new BigDecimal(6666));
        testDebitCard.pay(new BigDecimal(666));

        testDebitCard.getBalanceInformation();
    }
}