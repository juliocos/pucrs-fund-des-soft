package Bar.Persistence;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Created by vinimtex on 31/08/2017.
 */
public class Bar {

    private final ObservableList<Customer> customers;

    public Bar(ObservableList<Customer> customers) {
        this.customers = customers;
    }

    public Bar() {
        this.customers = FXCollections.observableArrayList();
    }

    public ObservableList<Customer> getCustomers() {
        return customers;
    }

    private boolean saveCustomer(Customer c) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String filename = "Customers-" + now.format(dateFormat) + ".txt";

        String textCustomer = c.getName() + ";" + c.getCpf() + ";" + c.getGender() + ";" + c.getAge() + ";";
        textCustomer += c instanceof Member ? ((Member) c).getMemberId() + ";" : ";";

        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(new File(filename),true));
            writer.println(textCustomer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public void addCustomer(Customer c) {

        if(this.saveCustomer(c)) {
            customers.add(c);
        }

    }

    public int countFemaleCustomers() {
        int count = 0;
        for (Customer c: customers) {
            if(c.getGender() == 'F') {
                count++;
            }
        }
        return count;
    }

    public double percentMembers() {
        double percent = 0;
        if(this.customers.size() > 0) {
            percent = countMembers() * 100 / this.customers.size();
        }
        return percent;
    }

    public double percentMaleCustomers() {
        double percent = 0;

        if(this.customers.size() > 0) {
            percent = countMaleCustomers() * 100 / this.customers.size();
        }

        return percent;
    }

    public double percentFemaleCustomers() {
        double percent = 0;

        if(this.customers.size() > 0) {
            System.out.println(countFemaleCustomers());
            System.out.println(this.customers.size());
            percent = countFemaleCustomers() * 100 / this.customers.size();
        }
        System.out.println(percent);
        return percent;
    }

    public int countMaleCustomers() {
        int count = 0;
        for (Customer c: customers) {
            if(c.getGender() == 'M') {
                count++;
            }
        }
        return count;
    }

    public int countMembers() {
        int count = 0;
        for (Customer c: customers) {
            if(c instanceof Member){
                count++;
            }
        }
        return count;
    }

}
