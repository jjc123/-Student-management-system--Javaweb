package Student;

import java.util.List;

public interface StudentOperator {
	public void addStudent(Student student);        //增加联系人
	public boolean updateStudent(Student student);     //修改联系人
	public boolean deleteStudent(Student student);           //根据ID删除联系人
	public List<Student> findAll();                 //查询所有联系人
	public Student findOne(Student student);
}
