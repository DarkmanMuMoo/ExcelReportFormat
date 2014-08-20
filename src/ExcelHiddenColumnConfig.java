import java.util.List;
import java.util.Map;


import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;




@XmlAccessorType(XmlAccessType.FIELD)
public class ExcelHiddenColumnConfig {

	private Map<String,String[]> TPNHiddenColumnConfig = null;
	
	private Map<String,String[]> externalHiddenColumnConfig = null;
	
	private Map<String,String[]> hiddenColumnConfig = null;
	
	private List<String> globalHiddenColumn = null;
	
	
	public Map<String, String[]> getTPNHiddenColumnConfig() {
		return TPNHiddenColumnConfig;
	}
	public void setTPNHiddenColumnConfig(Map<String, String[]> tPNHiddenColumnConfig) {
		TPNHiddenColumnConfig = tPNHiddenColumnConfig;
	}
	public Map<String, String[]> getExternalHiddenColumnConfig() {
		return externalHiddenColumnConfig;
	}
	public void setExternalHiddenColumnConfig(
			Map<String, String[]> externalHiddenColumnConfig) {
		this.externalHiddenColumnConfig = externalHiddenColumnConfig;
	}
	public Map<String, String[]> getHiddenColumnConfig() {
		return hiddenColumnConfig;
	}
	public void setHiddenColumnConfig(Map<String, String[]> hiddenColumnConfig) {
		this.hiddenColumnConfig = hiddenColumnConfig;
	}
	public List<String> getGlobalHiddenColumn() {
		return globalHiddenColumn;
	}
	public void setGlobalHiddenColumn(List<String> globalHiddenColumn) {
		this.globalHiddenColumn = globalHiddenColumn;
	}
	
	

}
