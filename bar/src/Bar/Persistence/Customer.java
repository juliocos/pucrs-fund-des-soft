package Bar.Persistence;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;

/**
 * Created by vinimtex on 31/08/2017.
 */
public class Customer{
    private String cpf;
    private String name;
    private int age;
    private char gender;

    public Customer(String cpf, String name, int age, char gender) {
        this.cpf = cpf;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object obj)
    {
        if ( obj == null || obj == this || !(obj instanceof Customer) )
            return false;
        Customer customer = (Customer) obj;

        if(customer.getName().compareTo(this.name) != 0)
            return false;
        if(customer.getGender() != this.gender)
            return false;
        if(customer.getAge() != this.age)
            return false;
        if(customer.getCpf().compareTo(this.cpf) != 0)
            return false;

        return true;
    }
}
