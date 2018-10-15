import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sxh.spring.mybatis.bean.Student;
import com.sxh.spring.mybatis.dao.StudentMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestMapper {
	@Autowired
	private StudentMapper studentMapper;
	@Test
	public void testMapper() {
		Student student;
		student = studentMapper.selectStudentById(1);
		System.out.println(student);
		Student student2 = studentMapper.selectStudentByIdName(student);
		System.out.println(student2);
	}
	
	public void testMapper2() {
		Student mstudent = new Student(3, "LiSi", 22, "1022566");
		studentMapper.insertStudent(mstudent);
		List<Student> list = studentMapper.selectStudentsById(1);
		System.out.println(list);
	}
}
