import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ExcelFormatConfigAdapter
		extends
		XmlAdapter<ExcelFormatConfigAdapter.ExcelFormatConfigXml, ExcelFormatConfig> {

	@XmlAccessorType(XmlAccessType.FIELD)
	static public class ExcelFormatConfigXml {
		@XmlElement(name="FormatConfigs")
		private List<FormatConfigList> listOfFormatConfigList;

		public List<FormatConfigList> getListOfFormatConfigList() {
			return listOfFormatConfigList;
		}

		public void setListOfFormatConfigList(
				List<FormatConfigList> listOfFormatConfigList) {
			this.listOfFormatConfigList = listOfFormatConfigList;
		}

	}

	@Override
	public ExcelFormatConfigXml marshal(ExcelFormatConfig obj) throws Exception {

		ExcelFormatConfigXml excelFormatConfigXml = new ExcelFormatConfigXml();
		List<FormatConfigList> listOfFormatConfigList = new ArrayList<>();

		Map<String, Map<String, Format>> map = obj.getExcelFormatConfigMap();

		for (Map.Entry<String, Map<String, Format>> formatConfigListentry : map
				.entrySet()) {

			FormatConfigList formatConfigList = new FormatConfigList();
			formatConfigList.setStoreProcedureName(Arrays
					.asList(formatConfigListentry.getKey()));
			List<FormatConfig> formatConfigs = new ArrayList<>();
			for (Map.Entry<String, Format> entry : formatConfigListentry
					.getValue().entrySet()) {
				formatConfigs.add(new FormatConfig(entry.getKey(), entry
						.getValue()));
			}
			formatConfigList.setFormatConfigs(formatConfigs);

			listOfFormatConfigList.add(formatConfigList);

		}

		excelFormatConfigXml.setListOfFormatConfigList(listOfFormatConfigList);
		return excelFormatConfigXml;
	}

	@Override
	public ExcelFormatConfig unmarshal(ExcelFormatConfigXml xml)
			throws Exception {
		Map<String, Map<String, Format>> map = new HashMap<String, Map<String, Format>>();
		ExcelFormatConfig excelFormatConfig = new ExcelFormatConfig();
		List<FormatConfigList> listOfFormatConfigList = xml
				.getListOfFormatConfigList();
		for (FormatConfigList formatConfigList : listOfFormatConfigList) {

			for (String storProcedure : formatConfigList
					.getStoreProcedureName()) {
				Map<String, Format> formatConfigMap = new HashMap<>();
				for (FormatConfig formatConfig : formatConfigList
						.getFormatConfigs()) {
					formatConfigMap.put(formatConfig.getColumnName(),
							formatConfig.getFormat());
				}
				map.put(storProcedure, formatConfigMap);
			}

		}
		excelFormatConfig.setExcelFormatConfigMap(map);
		return excelFormatConfig;
	}

}
