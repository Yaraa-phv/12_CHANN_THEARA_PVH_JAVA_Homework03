import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.util.List;

public class TableCustom {

    static String Red = "\u001b[31;1m";
    static String Green = "\u001b[32m";
    static String Reset = "\u001b[0m";
    static String Blue = "\u001b[34m";
    static String White = "\u001b[97m";
    static String LightYellow = "\u001b[93m";



    public static void displayTable(){
        Table table = new Table(9, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        CellStyle tableStyle = new CellStyle(CellStyle.HorizontalAlign.center);

        table.setColumnWidth(0, 5, 10); //ID
        table.setColumnWidth(1, 20, 30); //NAME
        table.setColumnWidth(2, 15, 20); //ADDRESS
        table.setColumnWidth(3, 15, 20); //TYPE of STAFf
        table.setColumnWidth(4, 20, 30); //SALARY
        table.setColumnWidth(5, 10, 15); //BONUS
        table.setColumnWidth(6, 5, 10); //HOUR
        table.setColumnWidth(7, 10, 15); //RATE
        table.setColumnWidth(8, 20, 30); //PAYMENT


        table.addCell(Blue + "ID" + Reset, tableStyle);
        table.addCell(Blue + "NAME" + Reset, tableStyle);
        table.addCell(Blue + "ADDRESS" + Reset, tableStyle);
        table.addCell(Blue + "TYPE" + Reset, tableStyle);
        table.addCell(Blue + "SALARY" + Reset, tableStyle);
        table.addCell(Blue + "BONUS" + Reset, tableStyle);
        table.addCell(Blue + "HOUR" + Reset, tableStyle);
        table.addCell(Blue + "RATE" + Reset, tableStyle);
        table.addCell(Blue + "PAY" + Reset, tableStyle);

//        List<StaffMember> currentPageStaff = staffMembers.subList(startIndex, endIndex);
//        for (StaffMember staff : currentPageStaff) {
//            table.addCell(String.valueOf(staff.getId()));
//            table.addCell(staff.getName());
//            table.addCell(staff.getAddress());
//
//            String type = staff.getClass().getSimpleName();
//            table.addCell(type);
//
//            if (staff instanceof Volunteer) {
//                table.addCell(String.format("%.2f", staff.pay()));
//                table.addCell(String.format("---"));
//                table.addCell(String.format("---"));
//                table.addCell(String.format("---"));
//                table.addCell(String.format("%.2f", staff.pay()));
//            } else if (staff instanceof SalariedEmployee) {
//                SalariedEmployee salaryEmp = (SalariedEmployee) staff;
//                table.addCell(String.format("%.2f", salaryEmp.getSalary()));
//                table.addCell(String.format("%.2f", salaryEmp.getBonus()));
//                table.addCell(String.format("---"));
//                table.addCell(String.format("---"));
//                table.addCell(String.format("%.2f", staff.pay()));
//            } else if (staff instanceof HourlySalaryEmployee) {
//                table.addCell(String.format("---"));
//                table.addCell(String.format("---"));
//                HourlySalaryEmployee HourEmp = (HourlySalaryEmployee) staff;
//                table.addCell(HourEmp.getHourWorked() + "h");
//                table.addCell(String.format("$%.2f", HourEmp.getRate()) + "/h");
//                table.addCell(String.format("%.2f", staff.pay()));
//            } else {
//                table.addCell(String.format("%.2f", staff.pay()));
//            }
//        }
//
//        System.out.println(table.render());
//        System.out.println("Page " + currentPage + " of " + totalPages);
//
    }

}
