import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FormatConfigList {
	@XmlAttribute
	private List<String> storeProcedureName;
	@XmlElement(name="formatConfig")
	private List<FormatConfig> formatConfigs;

	public List<String> getStoreProcedureName() {
		return storeProcedureName;
	}

	public void setStoreProcedureName(List<String> storeProcedureName) {
		this.storeProcedureName = storeProcedureName;
	}

	public List<FormatConfig> getFormatConfigs() {
		return formatConfigs;
	}

	public void setFormatConfigs(List<FormatConfig> formatConfigs) {
		this.formatConfigs = formatConfigs;
	}
	

}
