package DependencyInjectionExample.src;

public class DependencyInjectionTest {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);

        System.out.println(service.getCustomer(101));
    }
}

