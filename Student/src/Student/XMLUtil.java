package Student;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLUtil {
	//读取xml文件
	public static Document getDocument(){
		 try {
			Document document=new SAXReader().read(new File("D:/Students.xml"));
			return  document;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}
	public static void writeXML(Document doc) throws IOException {
		try {
			FileOutputStream fileOutputStream=new FileOutputStream("D:/Students.xml");
			OutputFormat format=OutputFormat.createPrettyPrint();
			format.setEncoding("utf-8");
			XMLWriter writer = new XMLWriter(fileOutputStream,format);
			writer.write(doc);
			writer.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
