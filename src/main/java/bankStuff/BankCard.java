package bankStuff;

import java.math.BigDecimal;

public abstract class BankCard {

    public BigDecimal bankCardBalance;

    public abstract void topUpBalance(BigDecimal amount);

    public abstract boolean pay(BigDecimal amount);

    public abstract void getBalanceInformation();

    public abstract void getInformationAboutAvailableFunds();

}
