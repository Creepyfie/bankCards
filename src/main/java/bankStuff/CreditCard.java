package bankStuff;

import java.math.BigDecimal;

public class CreditCard extends BankCard {

    protected static final BigDecimal DEFAULTCREDITLIMIT = BigDecimal.valueOf(10000);
    private BigDecimal creditLimit;
    private BigDecimal creditFunds;

    protected BigDecimal getCreditLimit() {
        return creditLimit;
    }

    protected void setCreditLimit(BigDecimal creditLimitToSet) {
        creditLimit = creditLimitToSet;
    }

    protected BigDecimal getCreditFunds() {
        return creditFunds;
    }

    protected void setCreditFunds(BigDecimal updatedCreditCardCreditFunds) {
        this.creditFunds = updatedCreditCardCreditFunds;
    }

    public CreditCard(BigDecimal creditLimit) {
        setCreditLimit(creditLimit);
        setCreditFunds(creditLimit);
    }

    public CreditCard() {
        setCreditLimit(DEFAULTCREDITLIMIT);
        setCreditFunds(DEFAULTCREDITLIMIT);
    }

    @Override
    public void topUpBalance(BigDecimal addingAmount) {
        BigDecimal creditFunds = getCreditFunds();
        if (creditFunds.compareTo(getCreditLimit()) < 0) {
            if (creditFunds.add(addingAmount).compareTo(getCreditLimit()) <= 0) {
                creditFunds = creditFunds.add(addingAmount);
                setCreditFunds(creditFunds);
            }
            else {
                BigDecimal afterTopUpBalance = getBankCardBalance()
                                        .add(addingAmount.subtract(getCreditLimit().subtract(creditFunds)));
                setBankCardBalance(afterTopUpBalance);
                setCreditFunds(getCreditLimit());
            }
        } else {
            setBankCardBalance(getBankCardBalance().add(addingAmount));
        }
        System.out.println("Баланс успешно пополнен на: " + addingAmount);
    }

    @Override
    public boolean pay(BigDecimal amountToPay) {
        BigDecimal creditCardCashBalance = getBankCardBalance();
        BigDecimal creditFunds = getCreditFunds();
        if (amountToPay.compareTo(creditCardCashBalance.add(creditFunds)) > 0){
            System.out.println("Недостаточно средств на карте и кредитном счету!");
            return false;
        } else
            if (creditCardCashBalance.compareTo(amountToPay) >= 0) {
                setBankCardBalance(creditCardCashBalance.subtract(amountToPay));
            }   else {
                creditFunds = creditFunds.subtract(amountToPay.subtract(creditCardCashBalance));
                setCreditFunds(creditFunds);
                setBankCardBalance(BigDecimal.ZERO);
            }
            System.out.println("Оплата прошла успешно!");
            return true;
    }

    @Override
    protected void getBalanceInformation() {
        System.out.println("Кредитный лимит: " + getCreditLimit());
        System.out.println("Кредитные средства: " + getCreditFunds());
        System.out.println("Собственные средства: " + getBankCardBalance());
    }
}
