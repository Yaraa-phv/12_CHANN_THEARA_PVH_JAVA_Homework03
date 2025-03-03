public abstract class StaffMember {
    protected int id;
    protected String name;
    protected String address;
    protected static int count = 0;

    public StaffMember(int id, String name, String address){
        this.id = ++count;
        this.name = name;
        this.address = address;
    }

    public static int increaseID() {
        return count+1;
    }

    @Override
    public String toString() {
        return "\nStaffMember" +
                "\nID\t\t\t:\t" + id +
                "\nName\t\t:\t" + name+
                "\nAddress\t\t:\t" + address +
                "\n---------------------------";
    }

    public abstract double pay();

    public Integer getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
