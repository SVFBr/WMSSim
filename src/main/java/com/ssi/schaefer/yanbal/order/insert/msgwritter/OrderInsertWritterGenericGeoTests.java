package com.ssi.schaefer.yanbal.order.insert.msgwritter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.ssi.schaefer.yanbal.util.dbutils.DatabaseQueries;
import com.ssi.schaefer.yanbal.util.tools.CSVUtils;
import com.ssi.schaefer.yanbal.util.tools.Tools;

public class OrderInsertWritterGenericGeoTests {

	/**
	 * 
	 * WRITTER for ORDER INSERT [GEOTESTES]
	 * 
	 */

	static String mapMaxOrderCodeSql;
	static String mapSql;
	static int files;
	static String orderCode;

	public static void main(String deviceType, int numberOfArticles, String folderName, String wamasHostIpRequested, int incrementPageNumber, String orderCodeSetter) throws ClassNotFoundException, SQLException, IOException {

		// --------------------------------------------------------------------
		// GEOTESTS [CONTROLLER]
		// --------------------------------------------------------------------

		String ocs = StringUtils.left(orderCodeSetter, 3);

		if (deviceType == "EACH_STATIONS") {
			mapMaxOrderCodeSql = "SELECT MAX(ORDER_CODE) FROM PWX.ORDER_REQUEST WHERE ORDER_CODE LIKE '" + ocs + "%'";
			mapSql = "SELECT SLM.SLM_ID, SKU.SKU_CODE, L.GEOCODE FROM SKU_LOCATION_MAP SLM INNER JOIN SKU ON SLM.SKU_ID = SKU.SKU_ID INNER JOIN LOCATION L ON L.L_ID = SLM.L_ID WHERE GEOCODE LIKE '" + deviceType + "%' ORDER BY SKU_CODE";
		} else {
			mapMaxOrderCodeSql = "SELECT MAX(ORDER_CODE) FROM PWX.ORDER_REQUEST WHERE ORDER_CODE LIKE '" + ocs + "%'";
			mapSql = "SELECT SLM.SLM_ID, SKU.SKU_CODE, L.GEOCODE FROM SKU_LOCATION_MAP SLM INNER JOIN SKU ON SLM.SKU_ID = SKU.SKU_ID INNER JOIN LOCATION L ON L.L_ID = SLM.L_ID WHERE GEOCODE LIKE '" + deviceType + "%' ORDER BY SKU_CODE";
		}

		List<HashMap<String, String>> mapMaxOrderCode = DatabaseQueries.executeQuery(mapMaxOrderCodeSql, wamasHostIpRequested);
		List<HashMap<String, String>> map = DatabaseQueries.executeQuery(mapSql, wamasHostIpRequested);

		if (map.size() > 0) {

			files = map.size();

			CSVUtils.genPath(folderName);
			CSVUtils.checkIfFileExistAt(folderName);

			// ORDER NUMBER LAUNCHER
			String newMapMaxOrderCode = mapMaxOrderCode.toString().replaceAll("[^0-9]", "");
			if (newMapMaxOrderCode.isEmpty()) {
				orderCode = orderCodeSetter;
			} else {
				orderCode = newMapMaxOrderCode;
				if (Integer.parseInt(orderCode) < Integer.parseInt(orderCodeSetter)) {
					orderCode = orderCodeSetter;
				}
			}
			Integer orderNumber = Integer.parseInt(orderCode);

			int i = 0;

			for (int fl = 1; fl <= files; fl++) {
				// ORDER_CODE
				orderNumber++;
				System.out.print("\n" + deviceType + " OR.............: ");
				String orNum = Integer.toString(orderNumber);
				System.out.print(StringUtils.leftPad(orNum, 7, "0"));
				System.out.print("\n");
				for (int or = 1; or <= 1; or++) {

					// JUST LINES
					File pathOnePage = CSVUtils.genPath(folderName);
					String csvFileOnePAge = pathOnePage + "/" + String.format("%07d", incrementPageNumber++) + ".dat";
					FileWriter writerOnePAge = new FileWriter(csvFileOnePAge);
					CSVUtils.writeLine(writerOnePAge, Arrays.asList("<order_insert order_id=\"" + StringUtils.leftPad(orNum, 7, "0") + "\" " + "sub_order_id=\"1" + "\" host_order_id=\"SPY\"" + " tu_type=\"" + Tools.getRandBoxType() + "\"" + " check=\"false\" departure_time=\"172531\" departure_date=\"20171105\" print=\"false\">"));
					CSVUtils.writeLine(writerOnePAge, Arrays.asList(" <station station_id=\"POP" + Tools.getRandRotate(1, 2) + "\"/>"));
					CSVUtils.writeLine(writerOnePAge, Arrays.asList(" <station station_id=\"POPXL\"/>"));
					CSVUtils.writeLine(writerOnePAge, Arrays.asList(" <station station_id=\"SHL0" + Tools.getRandRotate(1, 8) + "\"/>"));
					for (int li = 1; li <= 1; li++) {
						System.out.println("    li: " + li);
						CSVUtils.writeLine(writerOnePAge, Arrays.asList("	<line article_id=\"" + map.get(i++).get("SKU_CODE") + "\"" + " ordered_packunits=\"" + Tools.getRandRotate(1, 7) + "\" packunit_size=\"1\" host_line_id=\"" + li + "\"/>"));
					}
					CSVUtils.writeLine(writerOnePAge, Arrays.asList("</order_insert>"));
					writerOnePAge.flush();
					writerOnePAge.close();
				}
			}
		} else {
			System.out.println("\n Table SKU_LOCATION_MAP was not filled out for: " + deviceType + "\n");
		}
	}
}
