package bankStuff;

import java.math.BigDecimal;
//Дебетовая карта с кэшбеком в размере 0,05% от суммы покупки при покупке от 5000 на баланс карты
public class DebitCardWithCashbackOnBalance extends DebitCard{

    private static final BigDecimal cashBackPerCent = BigDecimal.valueOf(0.0005);
    private static final BigDecimal cashBackWorkingStartSum = BigDecimal.valueOf(5000);
    private BigDecimal totalCashBack = BigDecimal.ZERO;

    protected BigDecimal getTotalCashBack() {
        return this.totalCashBack;
    }

    protected void setTotalCashBack(BigDecimal updatedTotalCashBack) {
        this.totalCashBack = updatedTotalCashBack;
    }

    @Override
    public boolean pay(BigDecimal amountToPay) {

        if (super.pay(amountToPay)){
            if (amountToPay.compareTo(cashBackWorkingStartSum) >= 0) {
                BigDecimal cashBack = amountToPay.multiply(cashBackPerCent);
                this.topUpBalance(cashBack);
                this.setTotalCashBack(this.getTotalCashBack().add(cashBack));
            }
            return true;
        }
        return false;
    }

    @Override
    public void getInformationAboutAvailableFunds() {
        this.getBalanceInformation();
        System.out.println("Всего накоплено кэшбека на баланс: " + this.getTotalCashBack());
    }
}
