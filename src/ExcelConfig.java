import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ExcelConfig {

	@XmlElement
	@XmlJavaTypeAdapter(ExcelFormatConfigAdapter.class)
	ExcelFormatConfig excelFormatConfig;
	@XmlElement(name = "HiddenColumnConfigList")
	@XmlJavaTypeAdapter(ColumnConfigAdapter.class)
	ExcelHiddenColumnConfig excelHiddenColumnConfig = null;

	public ExcelHiddenColumnConfig getExcelHiddenColumnConfig() {
		return excelHiddenColumnConfig;
	}

	public void setExcelHiddenColumnConfig(
			ExcelHiddenColumnConfig excelHiddenColumnConfig) {
		this.excelHiddenColumnConfig = excelHiddenColumnConfig;
	}

	public ExcelFormatConfig getExcelFormatConfig() {
		return excelFormatConfig;
	}

	public void setExcelFormatConfig(ExcelFormatConfig excelFormatConfig) {
		this.excelFormatConfig = excelFormatConfig;
	}

}
