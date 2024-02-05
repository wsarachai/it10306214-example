package org.itsci.it10306103.lesson10.ex03;

public class Ex05 {
    public static void main(String[] args) {
        CompanyManager manager = new CompanyManager();
        Company company = manager.getCompany(1);
        company.setAddress("Kamphaeng Phet");
        manager.updateCompany(company);
    }
}
