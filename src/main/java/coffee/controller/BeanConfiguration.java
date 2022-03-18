/**
 * @author SSene - Suzette Senephansiri
 * CIS175 - Spring 2022
 * Mar 10, 2022
 */

package coffee.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import coffee.beans.Customer;
import coffee.beans.Order;

@Configuration
public class BeanConfiguration {

	@Bean
	public Customer customer() {
		// TODO Auto-generated constructor stub
		Customer bean = new Customer();
		return bean;
	}

	@Bean
	public Order order() {
		Order bean = new Order("Mocha Java", "chocolate covered espresso beans");
		return bean;
	}
}
