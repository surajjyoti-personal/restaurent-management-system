package strategy;

import exceptions.InvalidPaymentModeException;
import models.PaymentMode;

public class StrategyManager {
    public static PaymentStrategy getPaymentStrategy(PaymentMode paymentMode) throws InvalidPaymentModeException {
        if (paymentMode == PaymentMode.CREDIT_CARD)
            return new CreditCardStrategy();
        // other methods
        else
            throw new InvalidPaymentModeException("paymentMode=" + paymentMode);
    }
}
