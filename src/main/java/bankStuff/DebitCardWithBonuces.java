package bankStuff;

import java.math.*;

//Дебетовая карта с бонусом в размере 1% от суммы покупки.
public class DebitCardWithBonuces extends DebitCard{

    private static final BigDecimal bonucePerCent = BigDecimal.valueOf(0.01);
    private BigDecimal debitCardBonuceAmount = BigDecimal.ZERO;

    protected BigDecimal getDebitCardBonuceAmount() {
        return  debitCardBonuceAmount;
    }

    protected void setDebitCardBonuceAmount(BigDecimal updatedDebitCardBonuces) {
        debitCardBonuceAmount = updatedDebitCardBonuces;
    }

    @Override
    public boolean pay(BigDecimal amountToPay) {

        if (super.pay(amountToPay)){
            setDebitCardBonuceAmount(getDebitCardBonuceAmount().add(amountToPay
                    .multiply(bonucePerCent).setScale(0, 4)));
            return true;
        }
        return false;
    }

    @Override
    public void getInformationAboutAvailableFunds() {
        System.out.println("Баланс на дебетовой карте: " + getBankCardBalance());
        System.out.println("Бонусы на карте: " + getDebitCardBonuceAmount());
    }
}
