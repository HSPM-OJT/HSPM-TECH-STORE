package com.hspm.ojt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication 
public class HspmStoreApplication implements CommandLineRunner{
	
//	@Autowired
//	UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(HspmStoreApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		
//		User user1 = new User("pan@gmail.com", "Pan","Thu Kyaw", "09969610229", "12345678");
//		userService.saveOrUpdateUser(user1);
	}
}
