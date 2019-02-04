import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan({"com.paulmalland"})
@PropertySource("app.properties")
public class AppConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	/**
	 * 
	 * case of setter injection
	 */
	// commented out to show autowiring using stereotype annotation @Service
//	@Bean(name = "customerService")
//	public CustomerService getCustomerService(){
//		CustomerServiceImpl service = new CustomerServiceImpl();
//		// commented out for the autowire case 
//		//service.setCustomerRepository(getCustomerRepository());
//		return service;
//		
//	}
	
	/**
	 * 
	 * case of constructor injection
	 */
//	@Bean(name = "customerService")
//	public CustomerService getCustomerService(){
//		CustomerServiceImpl service = new CustomerServiceImpl(getCustomerRepository());
//		//service.setCustomerRepository(getCustomerRepository());
//		return service;
//		
//	}
	
	// commented out to show autowiring using stereotype annotation @Repository
//	@Bean(name = "customerRepository")
//	public CustomerRepository getCustomerRepository(){
//		
//		return new HibernateCustomerRepositoryImpl();
//	}
//	
}
