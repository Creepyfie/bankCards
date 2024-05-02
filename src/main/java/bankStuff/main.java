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


        DebitCardBigBonuces debitCardBigBonuces = new DebitCardBigBonuces();
        debitCardBigBonuces.topUpBalance(new BigDecimal(2250));
        debitCardBigBonuces.getBalanceInformation();
        debitCardBigBonuces.pay(new BigDecimal(100));
        debitCardBigBonuces.getInformationAboutAvailableFunds();

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
