package org.itsci.it10306103.lesson10.ex03;

import java.util.List;

public class Ex02 {

    public static void main(String[] args) {
        CompanyManager manager = new CompanyManager();
        List<Company> companies = manager.listAllCompanies();

        for (Company company : companies) {
            System.out.println(company);
            for (Employee employee : company.getEmployees()) {
                System.out.println(employee);
            }
        }
    }
}
