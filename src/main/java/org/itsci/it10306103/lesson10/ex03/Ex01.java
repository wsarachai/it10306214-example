package org.itsci.it10306103.lesson10.ex03;

public class Ex01 {

    public static void main(String[] args) {
        CompanyManager manager = new CompanyManager();
        Company companie = manager.getCompany(1);
        System.out.println(companie);
    }
}
