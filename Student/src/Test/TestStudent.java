package Test;

import Student.*;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestStudent {

	@Test
	void test() throws FileNotFoundException {
		Student student=new Student();
		student.setId("12");
		student.setAdress("aaa");
		student.setAge(22);
		student.setGender("aa");
		student.setName("aa1a");
		student.setPhone("aa");
		student.setQQ("aa");
		new studentsx().addStudent(student); 
		//Student list=new studentsx().findOne(student);
		
			//System.out.println(student);
	}

}
