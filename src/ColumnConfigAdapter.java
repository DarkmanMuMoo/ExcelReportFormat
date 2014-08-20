import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ColumnConfigAdapter
		extends
		XmlAdapter<ColumnConfigAdapter.HiddenColumnConfigList, ExcelHiddenColumnConfig> {

	@Override
	public HiddenColumnConfigList marshal(ExcelHiddenColumnConfig obj)
			throws Exception {

		HiddenColumnConfigList hiddenColumnConfigList = new HiddenColumnConfigList();

		hiddenColumnConfigList.setGlobalHiddenColumn(obj
				.getGlobalHiddenColumn());

		List<ColumnConfig> columnConfigList = new ArrayList<>();

		Map<String, String[]> TPNHiddenColumnConfig = obj
				.getTPNHiddenColumnConfig();

		Map<String, String[]> externalHiddenColumnConfig = obj
				.getExternalHiddenColumnConfig();

		Map<String, String[]> hiddenColumnConfig = obj.getHiddenColumnConfig();

		addHiddenColumn(columnConfigList, hiddenColumnConfig);

		for (Map.Entry<String, String[]> entry : TPNHiddenColumnConfig
				.entrySet()) {
			ColumnConfig columnConfig = new ColumnConfig(entry.getKey(),
					entry.getValue());
			columnConfig.setTPN(true);
			String[] values = externalHiddenColumnConfig.get(entry.getKey());
			if (values != null) {
				columnConfig.setExternal(true);
				externalHiddenColumnConfig.remove(entry.getKey());
			}
			columnConfigList.add(columnConfig);
		}

		for (Map.Entry<String, String[]> entry : externalHiddenColumnConfig
				.entrySet()) {
			ColumnConfig columnConfig = new ColumnConfig(entry.getKey(),
					entry.getValue());
			columnConfig.setExternal(true);
			columnConfigList.add(columnConfig);
		}

		hiddenColumnConfigList.setHiddenColumnConfigList(columnConfigList);

		return hiddenColumnConfigList;
	}

	private void addHiddenColumn(List<ColumnConfig> columnConfigList,
			Map<String, String[]> hiddenColumnConfig) {

		for (Map.Entry<String, String[]> entry : hiddenColumnConfig.entrySet()) {
			columnConfigList.add(new ColumnConfig(entry.getKey(), entry
					.getValue()));
		}

	}

	@Override
	public ExcelHiddenColumnConfig unmarshal(HiddenColumnConfigList xml)
			throws Exception {

		Map<String, String[]> TPNHiddenColumnConfig = new HashMap<>();

		Map<String, String[]> externalHiddenColumnConfig = new HashMap<>();

		Map<String, String[]> hiddenColumnConfig = new HashMap<>();

		for (ColumnConfig columnConfig : xml.getHiddenColumnConfigList()) {

			if (columnConfig.isTPN()) {
				TPNHiddenColumnConfig.put(columnConfig.getStoreProcedureName(),
						columnConfig.getColumnName());
			}
			if (columnConfig.isExternal()) {
				externalHiddenColumnConfig.put(columnConfig.getStoreProcedureName(),
						columnConfig.getColumnName());
			}
			
			if(!(columnConfig.isTPN()&&columnConfig.isExternal())){
				hiddenColumnConfig.put(columnConfig.getStoreProcedureName(),
						columnConfig.getColumnName());
			}
			
			
		}
		
		ExcelHiddenColumnConfig excelHiddenColumnConfig = new ExcelHiddenColumnConfig();
		excelHiddenColumnConfig.setExternalHiddenColumnConfig(externalHiddenColumnConfig);
		excelHiddenColumnConfig.setHiddenColumnConfig(hiddenColumnConfig);
		excelHiddenColumnConfig.setTPNHiddenColumnConfig(TPNHiddenColumnConfig);
		excelHiddenColumnConfig.setGlobalHiddenColumn(xml.getGlobalHiddenColumn());
		
		return excelHiddenColumnConfig;
	}

	
	@XmlAccessorType(XmlAccessType.FIELD)
	static public class HiddenColumnConfigList {

		@XmlElement(name="hiddenColumnConfig")
		private List<ColumnConfig> hiddenColumnConfigList;
		@XmlList
		private List<String> globalHiddenColumn = null;

		public List<ColumnConfig> getHiddenColumnConfigList() {
			return hiddenColumnConfigList;
		}

		public List<String> getGlobalHiddenColumn() {
			return globalHiddenColumn;
		}

		public void setGlobalHiddenColumn(List<String> globalHiddenColumn) {
			this.globalHiddenColumn = globalHiddenColumn;
		}

		public void setHiddenColumnConfigList(
				List<ColumnConfig> hiddenColumnConfigList) {
			this.hiddenColumnConfigList = hiddenColumnConfigList;
		}

	}

}
