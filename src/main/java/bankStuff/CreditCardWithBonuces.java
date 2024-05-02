package bankStuff;

import java.math.BigDecimal;

//Кредитная карта с накоплением 0.005% от суммы пополнения
public class CreditCardWithBonuces extends CreditCard{

    BigDecimal topUpBonucePercent = BigDecimal.valueOf(0.005);

    public CreditCardWithBonuces(BigDecimal creditCardCreditLimit) {
        super(creditCardCreditLimit);
    }

    @Override
    public void topUpBalance(BigDecimal addingAmount) {
        super.topUpBalance(addingAmount.add(addingAmount.multiply(topUpBonucePercent)));
    }
}
