package strategy;

public class CreditCardStrategy implements PaymentStrategy{
    @Override
    public double processPayment(double amount) {
        double totalAmount = amount * 1.2;
        System.out.println("Total billing amount: " + totalAmount + " is paid through credit card");
        return totalAmount;
    }
}
