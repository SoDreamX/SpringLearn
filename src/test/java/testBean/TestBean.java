package testBean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sxh.spring.testBean.Family;
import com.sxh.spring.testBean.Person;
import com.sxh.spring.testBean.SingletonClass;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:beans.xml"})
public class TestBean {
	@Autowired
	ApplicationContext ctx;
	private static Logger logger = LoggerFactory.getLogger("test");
	
	@Test
	public void testPerson() {
		logger.info("=====begin======");
	    Person person1 = (Person)ctx.getBean("person");
	    Person person2 = (Person)ctx.getBean("person");
	    logger.info("person1 == person2:"+(person1 == person2));//true
	    //由此证明Spring默认以单例的形式给开发者构造出指定的bean。
	    logger.info("person1:"+person1);
	    
	    Family family = ctx.getBean("family", Family.class);
	    logger.info("family:"+family);
	    
	    SingletonClass singletonClass = SingletonClass.getInstance();
	    logger.info("singletonClass:"+singletonClass);
	    logger.info("=====end======");
	}
}
