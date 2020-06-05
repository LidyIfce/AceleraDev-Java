package br.com.codenation.paymentmethods;

public class CreditCardPaymentDiscount implements PriceStrategy{

    public static final Double DISCOUNT = 0.98;
    @Override
    public Double calculate(Double price) {
        return price * DISCOUNT;
    }
}
