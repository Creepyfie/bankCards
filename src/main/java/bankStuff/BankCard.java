package bankStuff;

import java.math.BigDecimal;

public abstract class BankCard {

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

    protected abstract void getInformationAboutAvailableFunds();

}
