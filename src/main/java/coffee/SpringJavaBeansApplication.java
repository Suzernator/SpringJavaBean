package coffee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import coffee.beans.Customer;
import coffee.beans.Order;
import coffee.controller.BeanConfiguration;
import coffee.repository.CustomerRepository;

@SpringBootApplication
public class SpringJavaBeansApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringJavaBeansApplication.class, args);
		}
	
		@Autowired
		CustomerRepository repo;
		
		@Override
		public void run(String... args) throws Exception {
			
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
	
		Customer c = appContext.getBean("customer", Customer.class);
		c.setDinerPreference("dine in");
		repo.save(c);
	
		Customer cs = new Customer("Suzette", "Senephansiri", "to go");
		Order os = new Order("Cafe au Lait", "blueberry scone");
		cs.setOrder(os);
		repo.save(cs);
		
		List<Customer> allCustomers = repo.findAll();
		for(Customer people: allCustomers) {
			System.out.println(people.toString());
			}
		
		((AbstractApplicationContext) appContext).close();
		
		}
}
