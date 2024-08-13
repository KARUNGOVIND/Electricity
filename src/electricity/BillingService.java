package electricity;

public class BillingService {


    public double calculateBill(double unitsConsumed) {
        double bill = 0;
        double units=unitsConsumed;

        if (units <= 100) {
            bill = 0;  // First 100 units are free
        } else if (units <= 200) {
            bill = (units - 100) * 1.5;
        } else if (units <= 500) {
            bill = (100 * 0) + (100 * 1.5) + (units - 200) * 3;
        } else {
            bill = (100 * 0) + (100 * 1.5) + (300 * 3) + (units - 500) * 6.6;
        }

        return bill;
    }

    public void enterUsage(User user, double unitsConsumed) {
        double bill = calculateBill(unitsConsumed);
        System.out.println("Electricity usage for " + user.getName() + ": " + unitsConsumed + " units");
        System.out.println("Total bill: Rs." + bill);
    }
}
