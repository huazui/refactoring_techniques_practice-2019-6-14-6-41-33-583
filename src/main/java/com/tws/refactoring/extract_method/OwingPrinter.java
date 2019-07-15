package com.tws.refactoring.extract_method;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class OwingPrinter {
    public void printBanner() {
        String printFirstAndEnd="*****************************";
        String printMediem="****** Customer totals ******\n";
        System.out.println(printFirstAndEnd+"\n"+printMediem+"\n"+printFirstAndEnd);
    }
    public void printDetail(String name,double outstanding) {

        System.out.println("name: "+name);
        System.out.println("amount: "+outstanding);
    }
    public double getOwing(Iterator<Order> elements,double outstanding){
        while (elements.hasNext()) {
            Order each = (Order) elements.next();
            outstanding += each.getAmount();
        }
        return outstanding;
    }

    void printOwing(String name, List<Order> orders) {
        Iterator<Order> elements = orders.iterator();
        double outstanding = 0.0;
         printBanner();
         outstanding=getOwing(elements,outstanding);
         printDetail( name,outstanding);

    }
}

class Order {
    private final double amount;

    public Order(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

}
