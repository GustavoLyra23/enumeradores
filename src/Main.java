import entities.Department;
import entities.Worker;
import entities.WorkerLevel;
import services.HourContract;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Enter departments name: ");
        String name_dep = sc.nextLine();
        System.out.println("Enter Worker data:");
        System.out.print("Name:");
        String name = sc.nextLine();
        System.out.print("Level:");
        String level = sc.nextLine();
        System.out.print("Base salary:");
        Double salary = sc.nextDouble();
        Worker worker = new Worker(name, WorkerLevel.valueOf(level), salary, new Department(name_dep));
        System.out.print("How many contracts to this worker?");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter contract "+(i+1)+" data");
            System.out.print("Date(DD/MM/YYYY):");
            Date date = sdf.parse(sc.next());
            System.out.print("Value per hour");
            double value = sc.nextDouble();
            sc.nextLine();
            System.out.print("Duration(hours)");
            Integer duration = sc.nextInt();
            sc.nextLine();
            HourContract contract = new HourContract(date, value, duration);
            worker.addContract(contract);
        }
        System.out.println("Enter month and year to calculate income (MM/yyyy)");
        String MonthAndYear = sc.next();
        int month = Integer.parseInt(MonthAndYear.substring(0, 2));
        int year = Integer.parseInt(MonthAndYear.substring(3));
        System.out.println("Name:" + worker.getName());
        System.out.println("Departament: " + worker.getDepartment().getName());
        System.out.println("Income for " + MonthAndYear + ": " + String.format("%.2f", worker.income(month, year)));
    }
}