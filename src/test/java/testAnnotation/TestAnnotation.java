package testAnnotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sxh.spring.testAnnotation.AnimalFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class TestAnnotation {
	@Autowired
	ApplicationContext ctx;
	private static Logger logger = LoggerFactory.getLogger("testAnnotation");
	@Test
	public void test() {
		logger.info("==============begin=============");
		AnimalFactory zoo = (AnimalFactory) ctx.getBean("animalFactory");
		logger.info(zoo.toString());
		logger.info("==============end=============");
	}
}
