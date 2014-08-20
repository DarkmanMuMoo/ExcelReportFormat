import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class Test {

	public static void main(String[] args) throws JAXBException {
		// TODO Auto-generated method stub
		JAXBContext jaxbContext = JAXBContext.newInstance(ExcelConfig.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	     
	    ExcelHiddenColumnConfig excelHiddenColumnConfig = new ExcelHiddenColumnConfig();
	    Map<String,String[]> map = new HashMap<>();
	    map.put("bla",  new String[]{"col1","col2"});
	    map.put("bla2",  new String[]{"col1","col2"});
	    Map<String,String[]> map1 = new HashMap<>();
	    map1.put("TPNExternal",  new String[]{"col1","col2"});
	    map1.put("TPN",  new String[]{"col1","col2"});
	    Map<String,String[]> map2 = new HashMap<>();
	    map2.put("TPNExternal",  new String[]{"col1","col2"});
	    map2.put("External",  new String[]{"col1","col2"});
	    
	    excelHiddenColumnConfig.setHiddenColumnConfig(map);
	    excelHiddenColumnConfig.setTPNHiddenColumnConfig(map1);
	    excelHiddenColumnConfig.setExternalHiddenColumnConfig(map2);
	    excelHiddenColumnConfig.setGlobalHiddenColumn(Arrays.asList("bla","bla"));
	    //Marshal the employees list in console
	    ExcelConfig excelConfig=new ExcelConfig();
	    
	    ExcelFormatConfig excelFormatConfig = new ExcelFormatConfig();
	    
	    Map<String,Map<String,Format>>  excelFormatConfigMap = new HashMap<>();
	    
	    Map<String,Format>  FormatConfigMap = new HashMap<>();
	    FormatConfigMap.put("col1", Format.ALIGN_CENTER);
	    FormatConfigMap.put("col2", Format.STRING_FORMAT);
	    
	    
	    Map<String,Format>  FormatConfigMap2 = new HashMap<>();
	    FormatConfigMap2.put("col1", Format.ALIGN_CENTER);
	    FormatConfigMap2.put("col2", Format.STRING_FORMAT);
	    
	    excelFormatConfigMap.put("store1", FormatConfigMap);
	    excelFormatConfigMap.put("store2", FormatConfigMap2);
	    
	    excelFormatConfig.setExcelFormatConfigMap(excelFormatConfigMap);
	    
	    excelConfig.setExcelFormatConfig(excelFormatConfig);
	    excelConfig.setExcelHiddenColumnConfig(excelHiddenColumnConfig);
	    File file = new File("F:\\file.xml");
	    jaxbMarshaller.marshal(excelConfig, file);
	    
	    
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    
	    
	    ExcelConfig excelFormatUnmarshall = (ExcelConfig) jaxbUnmarshaller.unmarshal(file);
	    
	    System.out.println(excelFormatUnmarshall);
	}

}
