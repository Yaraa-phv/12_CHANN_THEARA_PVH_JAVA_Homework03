import java.util.ArrayList;

class Volunteer extends StaffMember{
    private double salary;

    public Volunteer(int id, String name, String address, double salary) {
        super(id, name, address);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\nVolunteer" +
                "\nID\t\t\t:\t" + id +
                "\nName\t\t:\t" + name+
                "\nAddress\t\t:\t" + address +
                "\nSalary\t\t:\t" +salary+
                "\n---------------------------";
    }

    @Override
    public double pay(){
        return salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
