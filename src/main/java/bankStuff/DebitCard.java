package bankStuff;

import java.math.BigDecimal;

public class DebitCard extends BankCard {
    @Override
    public void topUpBalance(BigDecimal addingAmount) {
        this.bankCardBalance.add(addingAmount);
        System.out.println("Баланс успешно пополнен на: " + addingAmount);
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
        System.out.println("Баланс на дебетовой карте: = " + bankCardBalance);
    }

    @Override
    public void getInformationAboutAvailableFunds() {
        this.getBalanceInformation();
    }
}
