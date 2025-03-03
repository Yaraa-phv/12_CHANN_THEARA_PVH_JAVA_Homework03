import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

public class StaffManagementSystem {
    static String Red = "\u001b[31;1m";
    static String Green = "\u001b[32m";
    static String Reset = "\u001b[0m";
    static String Blue = "\u001b[34m";
    static String White = "\u001b[97m";
    static String LightYellow = "\u001b[93m";

    static Scanner scanner = new Scanner(System.in);
    static int option = 0;
    static String name = "";
    static String address = "";
    static double salary = 0.0;
    static double bonus = 0.0;
    static int hour = 0;
    static double rate;

    private static List<StaffMember> staffMembers = new ArrayList<>(Arrays.asList(
            new Volunteer(1, "Sok Dara", "PP", 0.0),
            new Volunteer(4, "Kong Douch", "BTB", 0),
            new SalariedEmployee(2, "Love Love", "SR", 250, 0),
            new SalariedEmployee(5, "Ling Lon", "BTB", 250, 50),
            new HourlySalaryEmployee(3, "Lyvann So", "TK", 5, 10.5),
            new HourlySalaryEmployee(6, "Sou Syraa", "PP", 3, 15),
            new HourlySalaryEmployee(7, "SaeSae", "BMC", 7, 12)
    ));

    static int currentPage = 1;
    static int rowsPerPage = 3;
    static int totalColumn;

    static CellStyle tableStyle = new CellStyle(CellStyle.HorizontalAlign.center);

    public static void displayStaffMember() {
        if (staffMembers.isEmpty()) {
            System.out.println(Red + "NO STAFF MEMBER TO DISPLAY!!!" + Reset);
            return;
        }

        Table table = new Table(9, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        System.out.println("\n===============) DISPLAY STAFF MEMBERS (===============\n");

        int totalPages = (int) Math.ceil((double) staffMembers.size() / rowsPerPage);

        if (currentPage < 1) currentPage = 1;
        if (currentPage > totalPages) currentPage = totalPages;

        int startIndex = (currentPage - 1) * rowsPerPage;
        int endIndex = Math.min(startIndex + rowsPerPage, staffMembers.size());



        table.setColumnWidth(0, 20, 30); //TYPE of STAFf
        table.setColumnWidth(1, 5, 10); //ID
        table.setColumnWidth(2, 20, 30); //NAME
        table.setColumnWidth(3, 15, 20); //ADDRESS
        table.setColumnWidth(4, 15, 20); //SALARY
        table.setColumnWidth(5, 10, 15); //BONUS
        table.setColumnWidth(6, 5, 10); //HOUR
        table.setColumnWidth(7, 10, 15); //RATE
        table.setColumnWidth(8, 15, 20); //PAYMENT


        table.addCell(Blue + "TYPE" + Reset, tableStyle);
        table.addCell(Blue + "ID" + Reset, tableStyle);
        table.addCell(Blue + "NAME" + Reset, tableStyle);
        table.addCell(Blue + "ADDRESS" + Reset, tableStyle);
        table.addCell(Blue + "SALARY" + Reset, tableStyle);
        table.addCell(Blue + "BONUS" + Reset, tableStyle);
        table.addCell(Blue + "HOUR" + Reset, tableStyle);
        table.addCell(Blue + "RATE" + Reset, tableStyle);
        table.addCell(Blue + "PAY" + Reset, tableStyle);

        List<StaffMember> currentPageStaff = staffMembers.subList(startIndex, endIndex);
        for (StaffMember staff : currentPageStaff) {
            String type = staff.getClass().getSimpleName();
            table.addCell(type);

            table.addCell(String.valueOf(staff.getId()));
            table.addCell(staff.getName());
            table.addCell(staff.getAddress());

            if (staff instanceof Volunteer) {
                table.addCell(String.format("%.2f", staff.pay()));
                table.addCell(String.format("---"));
                table.addCell(String.format("---"));
                table.addCell(String.format("---"));
                table.addCell(String.format("%.2f", staff.pay()));
            } else if (staff instanceof SalariedEmployee) {
                SalariedEmployee salaryEmp = (SalariedEmployee) staff;
                table.addCell(String.format("%.2f", salaryEmp.getSalary()));
                table.addCell(String.format("%.2f", salaryEmp.getBonus()));
                table.addCell(String.format("---"));
                table.addCell(String.format("---"));
                table.addCell(String.format("%.2f", staff.pay()));
            } else if (staff instanceof HourlySalaryEmployee) {
                table.addCell(String.format("---"));
                table.addCell(String.format("---"));
                HourlySalaryEmployee HourEmp = (HourlySalaryEmployee) staff;
                table.addCell(HourEmp.getHourWorked() + "h");
                table.addCell(String.format("$%.2f", HourEmp.getRate()) + "/h");
                table.addCell(String.format("%.2f", staff.pay()));
            } else {
                table.addCell(String.format("%.2f", staff.pay()));
            }
        }

        System.out.println(table.render());
        System.out.println("Page " + currentPage + " of " + totalPages);

        if (totalPages > 1) {
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.print(LightYellow + "1. Previous\t\t"+ Reset);
            System.out.print(LightYellow + "2. Next\t\t"+ Reset);
            System.out.print(LightYellow + "3. First\t\t"+ Reset);
            System.out.print(LightYellow + "4. Last\t\t"+ Reset);
            System.out.print(LightYellow + "5. Go to Page\t\t"+ Reset);
            System.out.println(LightYellow + "6. Back to Menu\t\t"+ Reset);
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.print("Enter choice: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    if (currentPage > 1) currentPage--;
                    displayStaffMember();
                    break;
                case 2:
                    if (currentPage < totalPages) currentPage++;
                    displayStaffMember();
                    break;
                case 3:
                    currentPage = 1;
                    displayStaffMember();
                    break;
                case 4:
                    currentPage = totalPages;
                    displayStaffMember();
                    break;
                case 5:
                    System.out.print("Enter page number: ");
                    int pageNum = scanner.nextInt();
                    if (pageNum >= 1 && pageNum <= totalPages) {
                        currentPage = pageNum;
                    } else {
                        System.out.println(Red + "INVALID PAGE NUMBER!!!" + Reset);
                    }
                    displayStaffMember();
                    break;
                case 6:
                    Menu();
                    break;
                default:
                    System.out.println(Red + "INVALID OPTION!!!" + Reset);
                    displayStaffMember();
                    break;
            }
        }
    }

    static int id = staffMembers.size()+1;

    public static void insertStaffMember(StaffMember staffMember) {
        staffMembers.add(staffMember);
    }

    public static void insertVolunteer() {
        try {
            System.out.println(LightYellow + "\n===============) INSERT VOLUNTEER (===============\n" + Reset);
            System.out.println("ID\t\t\t\t:\t"+id);
            System.out.print("Enter Name\t\t:\t");
            name = scanner.next();
            System.out.print("Enter Address\t:\t");
            address = scanner.next();
            System.out.print("Enter Salary\t:\t");
            salary = scanner.nextDouble();
            System.out.println("--------------------------------------------------");

            insertStaffMember(new Volunteer(id, name, address, salary));

            System.out.println(Green + "SUCCESSFULLY ADDED " + name + " TO VOLUNTEER!" + Reset);
        } catch (InputMismatchException e) {
            System.out.println(Red + "INVALID INPUT! PLEASE ENTER THE CORRECT VALUE." + Reset);
            scanner.next();
        }
    }

    public static void insertSalariedEmployee() {
        try {
            System.out.println(LightYellow + "\n===============) INSERT SALARY EMPLOYEE (===============\n" + Reset);
            System.out.println("ID\t\t\t\t:\t"+id);
            System.out.print("Enter Name\t\t:\t");
            name = scanner.next();
            System.out.print("Enter Address\t:\t");
            address = scanner.next();
            System.out.print("Enter Salary\t:\t");
            salary = scanner.nextDouble();
            System.out.print("Enter Bonus\t\t:\t");
            bonus = scanner.nextDouble();
            System.out.println("--------------------------------------------------");

            insertStaffMember(new SalariedEmployee(id, name, address, salary, bonus));

            System.out.println(Green + "SUCCESSFULLY ADDED " + name + " TO SALARY EMPLOYEE!" + Reset);
        } catch (InputMismatchException e) {
            System.out.println(Red + "INVALID INPUT! PLEASE ENTER THE CORRECT VALUE." + Reset);
            scanner.next();
        }
    }

    public static void insertHourlyEmployee() {
        try {
            System.out.println(LightYellow + "\n===============) INSERT HOUR EMPLOYEE (===============\n" + Reset);
            System.out.println("ID\t\t\t\t:\t"+id);
            System.out.print("Enter Name\t\t:\t");
            name = scanner.next();
            System.out.print("Enter Address\t:\t");
            address = scanner.next();
            System.out.print("Enter Worked Hours\t:\t");
            hour = scanner.nextInt();
            System.out.print("Enter Rate per Hour\t:\t");
            rate = scanner.nextDouble();
            System.out.println("--------------------------------------------------");

            insertStaffMember(new HourlySalaryEmployee(id, name, address, hour, rate));

            System.out.println(Green + "SUCCESSFULLY ADDED " + name + " TO HOUR EMPLOYEE!" + Reset);
        } catch (InputMismatchException e) {
            System.out.println(Red + "INVALID INPUT! PLEASE ENTER THE CORRECT VALUE." + Reset);
            scanner.next();
        }
    }

    public static void insertEmployee() {
        System.out.println("\n===============) INSERT EMPLOYEE (===============\n");

        Table table = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND_HEADER_AND_COLUMNS);

        table.setColumnWidth(0, 40, 60);

        table.addCell("INSERT EMPLOYEE", tableStyle);
        table.addCell("1. Volunteer");
        table.addCell("2. Salaried Employee");
        table.addCell("1. Hourly Employee");

        System.out.println(table.render());
//        System.out.println("\n===============) INSERT EMPLOYEE (===============\n");
//        System.out.println("1. Volunteer");
//        System.out.println("2. Salaried Employee");
//        System.out.println("3. Hourly Employee");
//        System.out.println("--------------------------------------------------");
        System.out.print("\nCHOOSE A TYPE OF EMPLOYEE: ");

        option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                insertVolunteer();
                break;
            case 2:
                insertSalariedEmployee();
                break;
            case 3:
                insertHourlyEmployee();
                break;
            default:
                System.out.println("PLEASE CHECK YOUR INPUT!!!");
        }

        Menu();
    }

//    public static StaffMember updateEmployee(int id){
//        System.out.println("\n===============) UPDATE EMPLOYEE INFORMATION (===============\n");
//        System.out.println("Update Employee by ID : ");
//        id = scanner.nextInt();
//        for (int i = 0; i<staffMembers.size(); i++){
//            if (staffMembers.get(i).getId() == id){
//                return staffMembers.get(i);
//            }
//        }
//        return staffMembers.get(id);
//    }


    public static void removeEmployee() {
        System.out.print("\nEnter ID to Remove: ");
        int idToRemove = scanner.nextInt();
        staffMembers.removeIf(staff -> staff.getId() == idToRemove);
        System.out.println(Green + "EMPLOYEE REMOVED SUCCESSFULLY!" + Reset);
        Menu();
    }

//    public static void displayByType() {
//        System.out.println("=============== DISPLAY EMPLOYEES BY TYPE ===============");
//        Map<Class<?>, List<StaffMember>> grouped = staffMembers.stream()
//                .collect(Collectors.groupingBy(StaffMember::getClass));
//
//        grouped.forEach((type, employees) -> {
//            System.out.println(Blue + "--- " + type.getSimpleName() + " ---" + Reset);
//            employees.forEach(System.out::println);
//        });
//    }

    public static void Menu() {
        System.out.println("\n===============) STAFF MANAGEMENT SYSTEM (===============\n");

        Table table = new Table(1, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.SURROUND_HEADER_AND_COLUMNS);

        table.setColumnWidth(0, 50, 60);

        table.addCell("STAFF MANAGEMENT SYSTEM", tableStyle);
        table.addCell("1. Insert Employee");
        table.addCell("2. Display Employee");
        table.addCell("3. Update Employee");
        table.addCell("4. Remove Employee");
        table.addCell("5. Exit -->");

        //        System.out.println("1. Insert Employee");
//        System.out.println("2. Display Employee");
//        System.out.println("3. Update Employee");
//        System.out.println("4. Remove Employee");
//        System.out.println("5. Exit -->");
        System.out.println(table.render());
        displayMenu();
//        System.out.print("CHOOSE AN OPTION: ");
//
//        option = scanner.nextInt();
//        switch (option) {
//            case 1 -> insertEmployee();
//            case 2 -> displayStaffMember();
//            case 3 -> removeEmployee();
//            case 4 -> displayByType();
//            case 5 -> System.out.println("Goodbye!");
//            default -> System.out.println(Red + "Invalid option!" + Reset);
//        }
    }

    public static void displayMenu() {
        System.out.print("\nCHOOSE AN OPTION: ");
        option = scanner.nextInt();
        scanner.nextLine();

        menuActions.getOrDefault(option, () -> System.out.println("INVALID OPTION!!!")).run();

        if (option != 5) {
            displayMenu(); //RECURSIVE METHOD
        }
    }

    private static final Map<Integer, Runnable> menuActions = new HashMap<>();
    static {
        menuActions.put(1, StaffManagementSystem::insertEmployee);
        menuActions.put(2, StaffManagementSystem::displayStaffMember);
//        menuActions.put(3, StaffManagementSystem::updateEmployee);
        menuActions.put(4, StaffManagementSystem::removeEmployee);
        menuActions.put(5, () -> {
            System.out.println("--------------------------------------------------");
            System.out.println(LightYellow + "GoodBye!!!" +Reset);
            System.out.println("--------------------------------------------------");
        });
    }





//    public static void displayMenu() {
//        System.out.print("CHOOSE AN OPTION : ");
//        option = scanner.nextInt();
//        scanner.nextLine();
//
//        menuActions.getOrDefault(option, () -> System.out.println(Red + "Invalid Option!" + Reset)).run();
//
//        if (option != 5) Menu();
//    }



}
