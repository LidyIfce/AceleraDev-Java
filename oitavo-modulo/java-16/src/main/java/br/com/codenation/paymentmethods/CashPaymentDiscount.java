package br.com.codenation.paymentmethods;

public class CashPaymentDiscount implements PriceStrategy{

    public static final Double DISCOUNT = 0.9;
    @Override
    public Double calculate(Double price) {
        return price * DISCOUNT;
    }
}
