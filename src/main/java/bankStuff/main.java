package bankStuff;

import java.math.BigDecimal;

public class main {
    public static void main(String[] args){
        CreditCard creditCard = new CreditCard();
        creditCard.topUpBalance(new BigDecimal(3000));
        creditCard.getBalanceInformation();
        creditCard.pay(new BigDecimal(1000));
        creditCard.getBalanceInformation();
        creditCard.pay(new BigDecimal(4000));
        creditCard.getBalanceInformation();


        DebitCardWithBonuces debitCardWithBonuces = new DebitCardWithBonuces();
        debitCardWithBonuces.topUpBalance(new BigDecimal(2250));
        debitCardWithBonuces.getBalanceInformation();
        debitCardWithBonuces.pay(new BigDecimal(100));
        debitCardWithBonuces.getInformationAboutAvailableFunds();

        CreditCardWithBonuces creditCardWithBonuces = new CreditCardWithBonuces();
        creditCardWithBonuces.topUpBalance(new BigDecimal(10000));
        creditCardWithBonuces.getInformationAboutAvailableFunds();
        creditCardWithBonuces.pay(new BigDecimal(15000));
        creditCardWithBonuces.getInformationAboutAvailableFunds();

        DebitCardWithCashbackOnBalance cashBackCard = new DebitCardWithCashbackOnBalance();
        cashBackCard.topUpBalance(new BigDecimal(13000));
        cashBackCard.getInformationAboutAvailableFunds();
        cashBackCard.pay(new BigDecimal(10000));
        cashBackCard.getBalanceInformation();
        cashBackCard.getInformationAboutAvailableFunds();

    }
}
