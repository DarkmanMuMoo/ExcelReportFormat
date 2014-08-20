import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class anotherTest {

	@XmlElement
	private Map<String, HashMap<String, Format>> map;

	public static void main(String[] args) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(ExcelConfig.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		 File file = new File("F:\\file1.xml");
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		ExcelConfig excelFormatUnmarshall = (ExcelConfig) jaxbUnmarshaller
				.unmarshal(file);
	}

}
