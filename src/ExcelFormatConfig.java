import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import java.util.HashMap;
import java.util.Map;
@XmlAccessorType(XmlAccessType.FIELD)
public class ExcelFormatConfig {

	private Map<String,Map<String,Format>>  excelFormatConfigMap;

	public Map<String,Map<String, Format>> getExcelFormatConfigMap() {
		return excelFormatConfigMap;
	}

	public void setExcelFormatConfigMap(
			Map<String, Map<String, Format>> excelFormatConfigMap) {
		this.excelFormatConfigMap = excelFormatConfigMap;
	}
	
	
	
	
}
