package bankStuff;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DebitCardWithCashbackOnBalanceTest {

    @Test
    public void payCheckBalance() {

        DebitCardWithCashbackOnBalance testCard = new DebitCardWithCashbackOnBalance();

        //expected
        testCard.topUpBalance(new BigDecimal(13000));
        testCard.pay(new BigDecimal(10000));

        BigDecimal expectedBalance = testCard.getBankCardBalance();

        //actual
        BigDecimal actualBalance = new BigDecimal(3005);

        Assert.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void payTotalCashBack() {

        DebitCardWithCashbackOnBalance testCard = new DebitCardWithCashbackOnBalance();

        //expected
        testCard.topUpBalance(new BigDecimal(23000));
        testCard.pay(new BigDecimal(10000));
        testCard.pay(new BigDecimal(10000));


        BigDecimal expectedBalance = testCard.getTotalCashBack();

        //actual
        BigDecimal actualBalance = new BigDecimal(10);

        Assert.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void getInformationAboutAvailableFunds() {

        DebitCardWithCashbackOnBalance testCard = new DebitCardWithCashbackOnBalance();

        //expected
        testCard.topUpBalance(new BigDecimal(23000));
        testCard.pay(new BigDecimal(10000));

        testCard.getInformationAboutAvailableFunds();

    }
}