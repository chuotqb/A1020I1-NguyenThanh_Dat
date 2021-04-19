package Manager;

import Models.Customer;

import java.util.Comparator;

public class YearCustomerComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer o1, Customer o2) {
        int compareName=o1.getNameCustomer().compareTo(o2.getNameCustomer());
        if (compareName==0){
            return o1.getYearOfBirth().compareTo(o2.getYearOfBirth());
        }
        return compareName;
    }
}
