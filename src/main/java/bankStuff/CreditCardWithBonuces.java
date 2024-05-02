package bankStuff;

import java.math.BigDecimal;

//Кредитная карта с накоплением 0.5% от суммы пополнения
public class CreditCardWithBonuces extends CreditCard{

    private static final BigDecimal topUpBonucePercent = BigDecimal.valueOf(0.005);

    public BigDecimal getTopUpBonucePercent() {
        return topUpBonucePercent;
    }

    @Override
    public void topUpBalance(BigDecimal addingAmount) {
        super.topUpBalance(addingAmount.add(addingAmount.multiply(this.getTopUpBonucePercent())));
    }
}
