

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ColumnConfig {
	@XmlAttribute(required=true)
	private String storeProcedureName;
	@XmlAttribute(required=true)
	private String[] columnName;
	@XmlAttribute
	private Boolean isTPN = null;
	@XmlAttribute
	private Boolean isExternal=null;
	 
	public String getStoreProcedureName() {
		return storeProcedureName;
	}

	public void setStoreProcedureName(String storeProcedureName) {
		this.storeProcedureName = storeProcedureName;
	}

	public String[] getColumnName() {
		return columnName;
	}

	public void setColumnName(String[] columnName) {
		this.columnName = columnName;
	}

	public ColumnConfig(){}
	
	public ColumnConfig(String storeProcedureName, String[] columnName) {
		super();
		this.storeProcedureName = storeProcedureName;
		this.columnName = columnName;
	}

	public boolean isTPN() {
		return isTPN;
	}

	public void setTPN(boolean isTPN) {
		this.isTPN = isTPN;
	}

	public boolean isExternal() {
		return isExternal;
	}

	public void setExternal(boolean isExternal) {
		this.isExternal = isExternal;
	}





}
