package bankStuff;

import java.math.BigDecimal;

public class CreditCard extends BankCard {

    private static final BigDecimal creditCardCreditLimit = BigDecimal.valueOf(10000);
    private BigDecimal creditCardCreditFunds = new BigDecimal(10000);

    protected BigDecimal getCreditCardCreditFunds() {
        return this.creditCardCreditFunds;
    }

    protected void setCreditCardCreditFunds(BigDecimal updatedCreditCardCreditFunds) {
        this.creditCardCreditFunds = updatedCreditCardCreditFunds;
    }

    @Override
    public void topUpBalance(BigDecimal addingAmount) {
        BigDecimal creditFunds = this.getCreditCardCreditFunds();
        if (creditFunds.compareTo(creditCardCreditLimit) < 0) {
            if (creditFunds.add(addingAmount).compareTo(creditCardCreditLimit) <= 0) {
                creditFunds = creditFunds.add(addingAmount);
                this.setCreditCardCreditFunds(creditFunds);
            }
            else {
                BigDecimal afterTopUpBalance = this.getBankCardBalance()
                                        .add(addingAmount.subtract(creditCardCreditLimit.subtract(creditFunds)));
                this.setBankCardBalance(afterTopUpBalance);
                this.setCreditCardCreditFunds(creditCardCreditLimit);
            }
        } else {
            this.setBankCardBalance(this.getBankCardBalance().add(addingAmount));
        }
        System.out.println("Баланс успешно пополнен на: " + addingAmount);
    }

    @Override
    public boolean pay(BigDecimal amountToPay) {
        BigDecimal creditCardCashBalance = this.getBankCardBalance();
        BigDecimal creditFunds = this.getCreditCardCreditFunds();
        if (amountToPay.compareTo(creditCardCashBalance.add(creditFunds)) > 0){
            System.out.println("Недостаточно средств на карте и кредитном счету!");
            return false;
        } else
            if (creditCardCashBalance.compareTo(amountToPay) >= 0) {
                this.setBankCardBalance(creditCardCashBalance.subtract(amountToPay));
            }   else {
                creditFunds = creditFunds.subtract(amountToPay.subtract(creditCardCashBalance));
                this.setCreditCardCreditFunds(creditFunds);
                this.setBankCardBalance(BigDecimal.ZERO);
            }
            return true;
    }

    @Override
    protected void getBalanceInformation() {
        System.out.println("Кредитный лимит: " + creditCardCreditLimit);
        System.out.println("Кредитные средства: " + this.getCreditCardCreditFunds());
        System.out.println("Собственные средства: " + this.getBankCardBalance());
    }

    @Override
    public void getInformationAboutAvailableFunds() {
        this.getBalanceInformation();
    }
}
