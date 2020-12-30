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

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
