import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.paulmalland.service.CustomerService;
import com.paulmalland.service.CustomerServiceImpl;

public class Application {

	public static void main(String[] args) {
		// 
		ApplicationContext appContext = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		CustomerService service = appContext.getBean("customerService", CustomerService.class);
		System.out.println(service);
//		CustomerService service = new CustomerServiceImpl();
		
		CustomerService service2 = appContext.getBean("customerService", CustomerService.class);
		System.out.println(service2);
		
		System.out.println(service.findAll().get(0).getFirstName());
	}

}
