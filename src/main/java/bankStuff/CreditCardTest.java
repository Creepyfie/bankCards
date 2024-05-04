package bankStuff;

import org.junit.Assert;

import java.math.BigDecimal;

public class CreditCardTest {

    @org.junit.Test
    public void topUpBalance() {
        CreditCard testCreditCard = new CreditCard();

        //expected
        testCreditCard.topUpBalance(new BigDecimal(1000));
        BigDecimal expectedBalance = testCreditCard.getBankCardBalance();

        //actual
        BigDecimal actualBalance = new BigDecimal(1000);

        Assert.assertEquals(expectedBalance, actualBalance);
    }

    @org.junit.Test
    public void payFromBalance() {
        CreditCard testCreditCard = new CreditCard();

        //expected
        testCreditCard.topUpBalance(new BigDecimal(10000));
        testCreditCard.pay(new BigDecimal(1000));
        BigDecimal expectedBalance = testCreditCard.getBankCardBalance();

        //actual
        BigDecimal actualBalance = new BigDecimal(9000);

        Assert.assertEquals(expectedBalance, actualBalance);
    }

    @org.junit.Test
    public void payFromCreditFunds() {
        CreditCard testCreditCard = new CreditCard();

        //expected
        testCreditCard.pay(new BigDecimal(1000));
        BigDecimal expectedBalance = testCreditCard.getCreditFunds();

        //actual
        BigDecimal actualBalance = new BigDecimal(9000);

        Assert.assertEquals(expectedBalance, actualBalance);
    }

    @org.junit.Test
    public void getBalanceInformation() {
        CreditCard testCreditCard = new CreditCard(new BigDecimal(7000));

        testCreditCard.getBalanceInformation();

    }
}