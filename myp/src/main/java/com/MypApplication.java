package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MypApplication {

	public static void main(String[] args) {
		SpringApplication.run(MypApplication.class, args);
	}
	
	// SqlSessionFactory 생성시application.properties 파일에 해도 되고 여기에 해도 된다.
	//@Bean
	//public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
	//	SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	//	sessionFactory.setDataSource(dataSource);
	//	Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/**/*.xml");
	//	sessionFactory.setMapperLocations(res);
	//	return sessionFactory.getObject();
    //	}

}
