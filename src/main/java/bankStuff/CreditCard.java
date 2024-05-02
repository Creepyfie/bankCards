package bankStuff;

import java.math.BigDecimal;

public class CreditCard extends BankCard {

    private final BigDecimal creditCardCreditLimit;
    public BigDecimal creditCreditFundsFunds;

    public CreditCard(BigDecimal creditCardCreditLimit) {
        this.creditCardCreditLimit = creditCardCreditLimit;
    }

    @Override
    public void topUpBalance(BigDecimal addingAmount) {

        if (creditCreditFundsFunds.compareTo(creditCardCreditLimit) < 0) {
            if (creditCreditFundsFunds.add(addingAmount).compareTo(creditCardCreditLimit) <= 0) {
                creditCreditFundsFunds.add(addingAmount);
            }
            else {
                bankCardBalance.add(addingAmount.subtract(creditCardCreditLimit.subtract(creditCreditFundsFunds)));
                creditCreditFundsFunds = creditCardCreditLimit;
            }
        } else {
            bankCardBalance.add(addingAmount);
        }
    }

    @Override
    public boolean pay(BigDecimal payingAmount) {
        if (payingAmount.compareTo(bankCardBalance.add(creditCreditFundsFunds)) > 0){
            System.out.println("Недостаточно средств на карте и кредитном счету!");
            return false;
        } else
            if (bankCardBalance.compareTo(payingAmount) >= 0) {
                bankCardBalance.subtract(payingAmount);
            }   else {
                creditCreditFundsFunds.subtract(payingAmount.subtract(bankCardBalance));
                bankCardBalance = BigDecimal.ZERO;
            }
            return true;
    }

    @Override
    public void getBalanceInformation() {
        System.out.println("Кредитный лимит: " + creditCardCreditLimit);
        System.out.println("Кредитные средства: " + creditCreditFundsFunds);
        System.out.println("Собственные средства: " + bankCardBalance);
    }

    @Override
    public void getInformationAboutAvailableFunds() {
        this.getBalanceInformation();
    }
}
