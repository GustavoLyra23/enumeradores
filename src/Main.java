import entities.Department;
import entities.Worker;
import entities.WorkerLevel;
import services.HourContract;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter departments name: ");
        String name_dep = sc.nextLine();
        Department department = new Department(name_dep);
        System.out.println("Enter Worker data:");
        System.out.print("Name:");
        String name = sc.nextLine();
        System.out.print("Level:");
        WorkerLevel level = WorkerLevel.valueOf(sc.nextLine());
        System.out.print("Base salary:");
        Double salary = sc.nextDouble();
        Worker worker = new Worker(name, level, salary, department);
        System.out.print("How many contracts to this worker?");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter contract "+(i+1)+" data");
            System.out.print("Date(DD/MM/YYYY):");
            String time = sc.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date data = dateFormat.parse(time);
            System.out.print("Value per hour");
            double value = sc.nextDouble();
            sc.nextLine();
            System.out.print("Duration(hours)");
            Integer duration = sc.nextInt();
            sc.nextLine();
            HourContract contract = new HourContract(data,value,duration);
            worker.addContract(contract);
        }
        System.out.println("Enter month and year to calculate income (MM/yyyy)");
        Integer month = sc.nextInt();
        sc.nextLine();
        Integer year = sc.nextInt();
        System.out.println(worker.getName());
        System.out.println(worker.getDepartment());
        Calendar cal = Calendar.getInstance();
        double result = worker.income(month,year);
        System.out.println("Income for "+month+"/"+year+": "+result);
    }
}