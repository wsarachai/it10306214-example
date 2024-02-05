package org.itsci.it10306103.lesson10.ex03;

public class Ex00 {

    public static void main(String[] args) {
        CompanyManager manager = new CompanyManager();
        Company companie = new Company("ITSCI Company", "Chiang Mai", "053-7777777");
        manager.addCompany(companie);
    }

}
