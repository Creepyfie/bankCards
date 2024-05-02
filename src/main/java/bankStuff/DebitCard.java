package bankStuff;

import java.math.BigDecimal;

public class DebitCard extends BankCard {
    @Override
    public void topUpBalance(BigDecimal amount) {
        this.bankCardBalance.add(amount);
    }

    @Override
    public boolean pay(BigDecimal amountToPay) {
        if (amountToPay.compareTo(bankCardBalance) > 0) {
            System.out.println("Недостаточно сресдтв на балансе");
            return false;
        } else {
            bankCardBalance.subtract(amountToPay);
            System.out.println("Оплата прошла успешно!");
            return true;
        }
    }

    @Override
    public void getBalanceInformation() {
        System.out.println("Кол-во денег на дебетовой карте: = " + bankCardBalance);
    }

    @Override
    public void getInformationAboutAvailableFunds() {
        this.getBalanceInformation();
    }
}
