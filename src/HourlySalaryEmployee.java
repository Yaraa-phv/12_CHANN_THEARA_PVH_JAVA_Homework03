class HourlySalaryEmployee extends StaffMember{
    private int hourWorked;
    private double rate;
    private double payment;

    public HourlySalaryEmployee (int id, String name, String address, int hourWorked, double rate){
        super(id, name, address);
        this.hourWorked = hourWorked;
        this.rate = rate;
        this.payment = hourWorked*rate;
    }

    @Override
    public String toString() {
        return "\nHourlyEmployee" +
                "\nID\t\t\t:\t" + id +
                "\nName\t\t:\t" + name+
                "\nAddress\t\t:\t" + address +
                "\nHoursWork\t:\t" + hourWorked+
                "\nRate\t\t:\t" + rate+
                "\nPayment\t\t:\t" +payment+
                "\n---------------------------";
    }

    @Override
    public double pay(){
        return payment = hourWorked*rate;
    }

    public int getHourWorked() {
        return hourWorked;
    }

    public void setHourWorked(int hourWorked) {
        this.hourWorked = hourWorked;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
