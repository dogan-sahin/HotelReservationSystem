package domain;

public class Customer {

    private static int nextId = 0;

    private int customerId;
    private String name;


    public Customer(String name) {
        customerId = ++nextId;
        this.name = name;
    }

    public int getCustomerId() {
        return customerId;
    }


    public String getName() {
        return name;
    }

}
