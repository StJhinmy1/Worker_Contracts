package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


import entities.enums.WorkerLevel;
import entitites.Department;
import entitites.HourContract;
import entitites.Worker;

public class Contract {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Digite o nome do departamento: ");
		String departmentName = sc.nextLine();
		
		System.out.println("Digite os dados do trabalhador");
		System.out.print("Nome: ");
		String workerName = sc.nextLine();
		
		System.out.print("Level [junior / middle / senior]: ");
		String workerLevel = sc.nextLine().toUpperCase();
		
		System.out.print("Salário: R$");
		Double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.print("Digite o número de contratos que esse trabalhador possui: ");
		int n = sc.nextInt();		
		
		for(int i=1; i<=n; i++) {
			System.out.println("Digite os dados do contrato #" + i);
			System.out.print("Data (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			
			System.out.print("Valor por hora: ");
			double valuePerHour = sc.nextDouble();
			
			System.out.print("Duração em horas: ");
			int hours = sc.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.print("Digite o mes e o ano para calcular o salário (MM/YYYY): ");
		
		String monthYear = sc.next();
		int month = Integer.parseInt(monthYear.substring(0,2));
		int year = Integer.parseInt(monthYear.substring(3));
		
		System.out.println("Nome: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartment().getName());
		System.out.println("O trabalhador recebeu na data " + monthYear + ": " + String.format("R$%.2f", worker.income(year,month)));
		
		
		
		
		
		
		sc.close();
	}

}
