package bankStuff;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DebitCardWithBonucesTest {

    @Test
    public void payCheckBalance() {

        DebitCardWithBonuces testDebitCard = new DebitCardWithBonuces();

        //expected
        testDebitCard.topUpBalance(new BigDecimal(3333));
        testDebitCard.pay(new BigDecimal(333));
        BigDecimal expectedBalance = testDebitCard.getBankCardBalance();

        //actual
        BigDecimal actualBalance = new BigDecimal(3000);

        Assert.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void payCheckBonuces() {

        DebitCardWithBonuces testDebitCard = new DebitCardWithBonuces();

        //expected
        testDebitCard.topUpBalance(new BigDecimal(3333));
        testDebitCard.pay(new BigDecimal(333));
        BigDecimal expectedBonuces = testDebitCard.getDebitCardBonuceAmount();

        //actual
        BigDecimal actualBonuces = new BigDecimal(3);

        Assert.assertEquals(expectedBonuces, actualBonuces);
    }

    @Test
    public void getInformationAboutAvailableFunds() {

        DebitCardWithBonuces testDebitCard = new DebitCardWithBonuces();

        //expected
        testDebitCard.topUpBalance(new BigDecimal(3333));
        testDebitCard.pay(new BigDecimal(333));

        testDebitCard.getInformationAboutAvailableFunds();
    }
}