package Student;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

public class studentsx implements StudentOperator {

	@Override
	public void addStudent(Student student) {
		try
		{
			File file=new File("D:/Students.xml");
			Document doc=null;
			Element rootElem=null;
			if(!file.exists()) {
				doc=DocumentHelper.createDocument();
				rootElem=doc.addElement("Students");
			}else {
				doc=XMLUtil.getDocument();
				rootElem=doc.getRootElement();
			}
			Element studentElement=rootElem.addElement("Student");
			studentElement.addAttribute("id", student.getId());
			studentElement.addElement("name").setText(student.getName());
			studentElement.addElement("gender").setText(student.getGender());
			studentElement.addElement("age").setText(student.getId());
			studentElement.addElement("phone").setText(student.getPhone());
			studentElement.addElement("QQ").setText(student.getQQ());
			studentElement.addElement("adress").setText(student.getAdress());
			XMLUtil.writeXML(doc);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

   @Override
  public boolean updateStudent(Student student) {
	   Document doc=XMLUtil.getDocument();
		Element studentOne=(Element) doc.selectSingleNode("//Student[@id='"+student.getId()+"']");
		if(studentOne==null) {
			return false;
		}else {
			studentOne.element("name").setText(student.getName());
			studentOne.element("gender").setText(student.getGender());
			studentOne.element("age").setText(student.getAge()+"");
			studentOne.element("phone").setText(student.getPhone());
			studentOne.element("QQ").setText(student.getQQ());
			studentOne.element("adress").setText(student.getAdress());
			try {
				XMLUtil.writeXML(doc);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return true;
   }


	@Override
	public boolean deleteStudent(Student student) {
		Document doc=XMLUtil.getDocument();
		Element element=(Element) doc.selectSingleNode("//Student[@id='"+student.getId()+"']");
		if(element==null) {
			return false;
		}else {
			element.detach();
			try {
				XMLUtil.writeXML(doc);
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		Document document=XMLUtil.getDocument();
		List<Student> list=new ArrayList<Student>();
		List<Node> stuList = document.selectNodes("//Student");
		for(Node node :stuList) {
			Element element=(Element)node;
			Student student=new Student();
			setStudent(student, element);
			list.add(student);
		}
		return list;
	}
	
	@Override
	public Student findOne(Student student) {
		Document document=XMLUtil.getDocument();
		Element studentOne=(Element) document.selectSingleNode("//Student[@id='"+student.getId()+"']");
		if(studentOne==null) {
			return student;
		}
		setStudent(student, studentOne);
		return student;
	}

	private void setStudent(Student student, Element studentOne) {
		student.setAdress(studentOne.elementText("adress"));
		student.setAge(Integer.parseInt(studentOne.elementText("age")));
		student.setGender(studentOne.elementText("gender"));
		student.setId(studentOne.attributeValue("id"));
		student.setName(studentOne.elementText("name"));
		student.setPhone(studentOne.elementText("phone"));
		student.setQQ(studentOne.elementText("QQ"));
	}
}
