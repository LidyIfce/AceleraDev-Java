package br.com.codenation.paymentmethods;

public class DebitCardPaymentDiscount implements PriceStrategy {

    public static final Double DISCOUNT = 0.95;

    @Override
    public Double calculate(Double price) {
        return price * DISCOUNT;
    }
}
