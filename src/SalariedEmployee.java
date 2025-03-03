class SalariedEmployee extends StaffMember{
    private double salary;
    private double bonus;
    private double payment;

    public SalariedEmployee(int id, String name, String address, double salary, double bonus){
        super(id, name, address);
        this.salary = salary;
        this.bonus = bonus;
        this.payment = salary + bonus;
    }

    @Override
    public String toString() {
        return "\nSalariedEmployee" +
                "\nID\t\t\t:\t" + id +
                "\nName\t\t:\t" + name+
                "\nAddress\t\t:\t" + address +
                "\nSalary\t\t:\t" + salary+
                "\nBonus\t\t:\t" + bonus+
                "\nPayment\t\t:\t" +payment+
                "\n---------------------------";
    }

    @Override
    public double pay(){
        return payment = salary + bonus;
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

}

