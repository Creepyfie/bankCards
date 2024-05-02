package bankStuff;

import java.math.BigDecimal;
import java.math.RoundingMode;
//Дебетовая карта с кэшбеком в размере 0,05% от суммы покупки при покупке от 5000 на баланс карты
public class DebitCardWithCashbackOnBalance extends DebitCard{

    BigDecimal cashBackPerCent = BigDecimal.valueOf(0.0005);
    BigDecimal totalCashBack;

    @Override
    public boolean pay(BigDecimal amountToPay) {

        if (super.pay(amountToPay)){
            if (amountToPay.compareTo(BigDecimal.valueOf(5000)) >= 0) {
                BigDecimal cashBack = amountToPay.multiply(cashBackPerCent);
                this.topUpBalance(cashBack);
                totalCashBack.add(cashBack);
            }
            return true;
        }
        return false;
    }

    @Override
    public void getInformationAboutAvailableFunds() {
        this.getBalanceInformation();
        System.out.println("Всего накоплено кэшбека на баланс: ");
    }
}
