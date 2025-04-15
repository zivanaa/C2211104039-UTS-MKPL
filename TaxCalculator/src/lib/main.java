package lib;

public class main {
    public static void main(String[] args) {
        Employee emp = new Employee(
                "EMP001", "Zivana", "Yulianto", "2211104039", "Purwokerto",
                2022, 3, 15, false, false);

        emp.setMonthlySalary(2);
        emp.setAdditionalIncome(1000000);
        emp.setAnnualDeductible(5000000);
        emp.setSpouse("Fauzan", "987654321");
        emp.addChild("Anak1", "56789");
        emp.addChild("Anak2", "67890");

        int tax = emp.getAnnualIncomeTax();
        System.out.println("Pajak Tahunan: Rp " + tax);
    }
}
