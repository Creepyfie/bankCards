package bankStuff;

import java.math.BigDecimal;

public class CreditCard extends BankCard {

    protected static final BigDecimal creditCardCreditLimit = BigDecimal.valueOf(10000);
    private BigDecimal creditCardCreditFunds = new BigDecimal(10000);

    protected BigDecimal getCreditCardCreditFunds() {
        return creditCardCreditFunds;
    }

    protected void setCreditCardCreditFunds(BigDecimal updatedCreditCardCreditFunds) {
        this.creditCardCreditFunds = updatedCreditCardCreditFunds;
    }

    @Override
    public void topUpBalance(BigDecimal addingAmount) {
        BigDecimal creditFunds = getCreditCardCreditFunds();
        if (creditFunds.compareTo(creditCardCreditLimit) < 0) {
            if (creditFunds.add(addingAmount).compareTo(creditCardCreditLimit) <= 0) {
                creditFunds = creditFunds.add(addingAmount);
                setCreditCardCreditFunds(creditFunds);
            }
            else {
                BigDecimal afterTopUpBalance = getBankCardBalance()
                                        .add(addingAmount.subtract(creditCardCreditLimit.subtract(creditFunds)));
                setBankCardBalance(afterTopUpBalance);
                setCreditCardCreditFunds(creditCardCreditLimit);
            }
        } else {
            setBankCardBalance(getBankCardBalance().add(addingAmount));
        }
        System.out.println("Баланс успешно пополнен на: " + addingAmount);
    }

    @Override
    public boolean pay(BigDecimal amountToPay) {
        BigDecimal creditCardCashBalance = getBankCardBalance();
        BigDecimal creditFunds = getCreditCardCreditFunds();
        if (amountToPay.compareTo(creditCardCashBalance.add(creditFunds)) > 0){
            System.out.println("Недостаточно средств на карте и кредитном счету!");
            return false;
        } else
            if (creditCardCashBalance.compareTo(amountToPay) >= 0) {
                setBankCardBalance(creditCardCashBalance.subtract(amountToPay));
            }   else {
                creditFunds = creditFunds.subtract(amountToPay.subtract(creditCardCashBalance));
                setCreditCardCreditFunds(creditFunds);
                setBankCardBalance(BigDecimal.ZERO);
            }
            System.out.println("Оплата прошла успешно!");
            return true;
    }

    @Override
    protected void getBalanceInformation() {
        System.out.println("Кредитный лимит: " + creditCardCreditLimit);
        System.out.println("Кредитные средства: " + getCreditCardCreditFunds());
        System.out.println("Собственные средства: " + getBankCardBalance());
    }
}
