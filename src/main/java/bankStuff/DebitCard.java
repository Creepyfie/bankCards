package bankStuff;

import java.math.BigDecimal;

public class DebitCard extends BankCard {

    @Override
    public void topUpBalance(BigDecimal addingAmount) {
        this.setBankCardBalance(this.getBankCardBalance().add(addingAmount));
        System.out.println("Баланс успешно пополнен на: " + addingAmount);
    }

    @Override
    public boolean pay(BigDecimal amountToPay) {
        BigDecimal debitCardBalance = this.getBankCardBalance();
        if (amountToPay.compareTo(debitCardBalance) > 0) {
            System.out.println("Недостаточно сресдтв на балансе");
            return false;
        } else {
            this.setBankCardBalance(debitCardBalance.subtract(amountToPay));
            System.out.println("Оплата прошла успешно!");
            return true;
        }
    }

    @Override
    public void getBalanceInformation() {
        System.out.println("Баланс на дебетовой карте: = " + this.getBankCardBalance());
    }

    @Override
    protected void getInformationAboutAvailableFunds() {
        this.getBalanceInformation();
    }
}
