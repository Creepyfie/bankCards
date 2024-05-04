package bankStuff;

import java.math.BigDecimal;

//Кредитная карта с накоплением 0.5% от суммы пополнения
public class CreditCardWithBonuces extends CreditCard{

    private static final BigDecimal topUpBonucePercent = BigDecimal.valueOf(0.005);
    private BigDecimal creditCardBonuceToUpAmount = BigDecimal.ZERO;

    public CreditCardWithBonuces(BigDecimal creditLimitToSet) {
        super(creditLimitToSet);
    }

    public CreditCardWithBonuces() {
        super();
    }

    public BigDecimal getCreditCardBonuceToUpAmount() {
        return creditCardBonuceToUpAmount;
    }

    public void setCreditCardBonuceToUpAmount(BigDecimal updatedBonuceTopUpAmount) {
        creditCardBonuceToUpAmount = updatedBonuceTopUpAmount;
    }


    @Override
    public void topUpBalance(BigDecimal addingAmount) {
        BigDecimal bonuceTopUp = addingAmount.multiply(topUpBonucePercent).setScale(1,BigDecimal.ROUND_UP);
        super.topUpBalance(addingAmount.add(bonuceTopUp));
        setCreditCardBonuceToUpAmount(getCreditCardBonuceToUpAmount().add(bonuceTopUp));
    }

    @Override
    public void getInformationAboutAvailableFunds() {
        System.out.println("Кредитный лимит: " + getCreditLimit());
        System.out.println("Кредитные средства: " + getCreditFunds());
        System.out.println("Собственные средства: " + getBankCardBalance());
        System.out.println("Всего накоплено кэшбека на баланс: " + getCreditCardBonuceToUpAmount());
    }
}
