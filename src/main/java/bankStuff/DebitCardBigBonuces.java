package bankStuff;

import java.math.*;

//Дебетовая карта с бонусом в размере 1% от суммы покупки.
public class DebitCardBigBonuces extends DebitCard{

    private static final BigDecimal bonucePerCent = BigDecimal.valueOf(0.01);
    private BigDecimal debitCardBonuceAmount = BigDecimal.ZERO;

    protected BigDecimal getDebitCardBonuceAmount() {
        return  this.debitCardBonuceAmount;
    }

    protected void setDebitCardBonuceAmount(BigDecimal updatedDebitCardBonuces) {
        this.debitCardBonuceAmount = updatedDebitCardBonuces;
    }

    @Override
    public boolean pay(BigDecimal amountToPay) {

        if (super.pay(amountToPay)){
            this.setDebitCardBonuceAmount(this.getDebitCardBonuceAmount().add(amountToPay
                    .multiply(bonucePerCent).setScale(0, RoundingMode.HALF_UP)));
            return true;
        }
        return false;
    }

    @Override
    public void getInformationAboutAvailableFunds() {
        this.getBalanceInformation();
        System.out.println("Бонусы на карте: " + this.getDebitCardBonuceAmount());
    }
}
