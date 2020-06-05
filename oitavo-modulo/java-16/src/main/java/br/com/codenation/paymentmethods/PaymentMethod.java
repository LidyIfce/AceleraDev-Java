package br.com.codenation.paymentmethods;

public enum PaymentMethod {

    CASH(new CashPaymentDiscount()), DEBIT_CARD(new DebitCardPaymentDiscount()), CREDIT_CARD(new CreditCardPaymentDiscount()), TRANSFER(new TransferPaymentDiscount());

    private PriceStrategy priceStrategy;

    PaymentMethod(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public PriceStrategy getPaymentStrategy() {
        return priceStrategy;
    }
}