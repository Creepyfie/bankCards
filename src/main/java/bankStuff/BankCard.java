package bankStuff;

import java.math.BigDecimal;

public abstract class BankCard {

    public BigDecimal bankCardBalance;

    public abstract void topUpBalance(BigDecimal addingAmount);

    public abstract boolean pay(BigDecimal amountToPay);

    public abstract void getBalanceInformation();

    public abstract void getInformationAboutAvailableFunds();

}
