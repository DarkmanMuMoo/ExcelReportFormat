import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FormatConfig {
	
	@XmlAttribute
	private String columnName;
	@XmlAttribute
	private Format format;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public FormatConfig(String columnName, Format format) {
		super();
		this.columnName = columnName;
		this.format = format;
	}
	public FormatConfig(){}
	
	
}
