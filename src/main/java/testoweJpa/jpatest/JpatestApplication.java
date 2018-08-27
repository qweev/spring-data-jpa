package testoweJpa.jpatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class JpatestApplication {

//	@Autowired
//	CustomerRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(JpatestApplication.class, args);

	}



		@Bean
		public CommandLineRunner demo(CustomerRepository repository) {
			return (args) -> {


				// save a couple of customers


				repository.save(new Customer("Jack", "Bauer"));
				repository.save(new Customer("Chloe", "O'Brian"));
				repository.save(new Customer("Kim", "Bauer"));
				repository.save(new Customer("David", "Palmer"));
				repository.save(new Customer("Michelle", "Dessler"));


				System.out.println("-----------------");
				System.out.println("-----------------");
				System.out.println("-----------------");

				System.out.println(" +++++++++++++++++++ Customers found with findAll():");

				for (Customer customer : repository.findAll()) {
					System.out.println(customer.toString());

				}



				System.out.println("-----------------");
				System.out.println("-----------------");
				System.out.println("-----------------");
				System.out.println("+++++++++++++++++++ Customer found with findByLastName('Bauer'):");

				repository.findByLastName("Bauer").forEach(x -> {
					System.out.println(x.toString());
				});

				System.out.println("-----------------");
				System.out.println("-----------------");
				System.out.println("-----------------");
				System.out.println("+++++++++++++++++++ Customer found with findByFirstName('Jack'):");

				repository.findByFirstName("Jack").forEach(x -> {
					System.out.println(x.toString());
				});
				System.out.println("-----------------");
				System.out.println("-----------------");
				System.out.println("-----------------");

				System.out.println("+++++++++++++++++++ Customer found with findByFirstNameAndLastName('Jack Bauer'):");

				repository.findByFirstNameAndLastName("Jack","Bauer" ).forEach(x -> {
					System.out.println(x.toString());
				});



				System.out.println("-----------------");
				System.out.println("-----------------");
				System.out.println("-----------------");

				System.out.println("+++++++++++++++++++ Customer found with fetchCustomers('Jack Bauer'):");

				repository.fetchCustomers("Jack","Bauer" ).forEach(x -> {
					System.out.println(x.toString());
				});

				System.out.println("-----------------");
				System.out.println("-----------------");
				System.out.println("-----------------");

			};
		}
}
