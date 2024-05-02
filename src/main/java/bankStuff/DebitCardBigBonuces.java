package bankStuff;

import java.math.BigDecimal;
import java.math.RoundingMode;

//Дебетовая карта с бонусом в размере 1% от суммы покупки. 10 бонусов эквивалентно 1 валютной единице на карте
public class DebitCardBigBonuces extends DebitCard{

    BigDecimal debitCardBonuces;
    BigDecimal bonucesPerCent = BigDecimal.valueOf(0.01);

    @Override
    public boolean pay(BigDecimal amountToPay) {

        if (super.pay(amountToPay)){
            debitCardBonuces.add(amountToPay.multiply(bonucesPerCent).setScale(0, RoundingMode.HALF_UP));
            return true;
        }
        return false;
    }

    @Override
    public void getInformationAboutAvailableFunds() {
        this.getBalanceInformation();
        System.out.println("Бонусы на карте: " + debitCardBonuces);
    }
}
