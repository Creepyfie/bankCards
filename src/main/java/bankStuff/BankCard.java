package bankStuff;

import java.math.BigDecimal;

abstract class BankCard {

    private BigDecimal bankCardBalance = BigDecimal.ZERO;

    protected BigDecimal getBankCardBalance() {
        return this.bankCardBalance;
    }

    protected void setBankCardBalance(BigDecimal newBankCardBalance) {
        this.bankCardBalance = newBankCardBalance;
    }

    protected abstract void topUpBalance(BigDecimal addingAmount);

    protected abstract boolean pay(BigDecimal amountToPay);

    protected abstract void getBalanceInformation();

    protected void getInformationAboutAvailableFunds() {
        this.getBalanceInformation();
    }

}
