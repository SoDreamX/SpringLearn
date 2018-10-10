package testAop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sxh.spring.testAop.PrintInterface;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:aop.xml"})
public class TestAop {
	@Autowired
	ApplicationContext ctx;
	Logger logger = LoggerFactory.getLogger("testAop");
	
	@Test
	public void testAop() {
		logger.info("进入testAop测试方法。");
		PrintInterface print1 = (PrintInterface) ctx.getBean("printimp1");
		PrintInterface print2 = (PrintInterface) ctx.getBean("printimp2");
		print1.printInfo();
		print1.doPrint();
		logger.info("================分割线============");
		print2.printInfo();
		print2.doPrint();
	}
}
