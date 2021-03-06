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

public class OrderInsertWritterOneToAllStations {

	/**
	 * 
	 * WRITTER for ORDER INSERT [ONE (OR MORE) ORDER THAT GOES THROUGH ALL STATIONS]
	 * 
	 */

	static String mapMaxOrderCodeSql;
	static String mapSql;
	static int files;
	static String orderCode;
	static List<HashMap<String, String>> mapMaxOrderCode;
	static List<HashMap<String, String>> map;

	public static void main(String deviceType, int numberOfArticles, String folderName, String wamasHostIpRequested, int incrementPageNumber, String orderCodeSetter) throws ClassNotFoundException, SQLException, IOException {

		List<HashMap<String, String>> mapGP = DatabaseQueries.executeQuery("SELECT SKU.SKU_CODE, L.GEOCODE, L.GEOCODE_DEVICE FROM SKU_LOCATION_MAP SLM INNER JOIN SKU ON SLM.SKU_ID = SKU.SKU_ID INNER JOIN LOCATION L ON L.L_ID = SLM.L_ID", wamasHostIpRequested);
		if (mapGP.size() > 0) {

			String[] arrEachStation = { "AFP01", "P01", "P02", "P03", "P04", "P05", "P06", "P07", "P08", "P09", "P10", "P11", "P12", "P13", "P14", "P15", "P16", "P17", "P18", "P19", "PDC" };
			files = numberOfArticles;

			mapMaxOrderCodeSql = "SELECT MAX(ORDER_CODE) FROM PWX.ORDER_REQUEST WHERE ORDER_CODE LIKE '820%'";
			mapMaxOrderCode = DatabaseQueries.executeQuery(mapMaxOrderCodeSql, wamasHostIpRequested);

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

			for (int fl = 1; fl <= files; fl++) {
				orderNumber++;
				System.out.print("\n" + deviceType + " OR.............: ");
				String orNum = Integer.toString(orderNumber);
				System.out.print(StringUtils.leftPad(orNum, 7, "0"));
				System.out.print("\n");

				File pathOnePage = CSVUtils.genPath(folderName);
				String csvFileOnePAge = pathOnePage + "/" + String.format("%07d", incrementPageNumber++) + ".dat";

				FileWriter writerOnePAge = new FileWriter(csvFileOnePAge);
				CSVUtils.writeLine(writerOnePAge, Arrays.asList("<order_insert order_id=\"" + StringUtils.leftPad(orNum, 7, "0") + "\" " + "sub_order_id=\"1" + "\" host_order_id=\"SPY\"" + " tu_type=\"" + Tools.getRandBoxTypeN() + "\"" + " check=\"false\" departure_time=\"172531\" departure_date=\"20171105\" print=\"false\">"));
				CSVUtils.writeLine(writerOnePAge, Arrays.asList(" <station station_id=\"POP" + Tools.getRandRotate(1, 2) + "\"/>"));
				CSVUtils.writeLine(writerOnePAge, Arrays.asList(" <station station_id=\"POPXL\"/>"));
				CSVUtils.writeLine(writerOnePAge, Arrays.asList(" <station station_id=\"SHL0" + Tools.getRandRotate(1, 8) + "\"/>"));

				for (int li = 0; li < arrEachStation.length; li++) {
					mapSql = "SELECT SKU.SKU_CODE, L.GEOCODE, L.GEOCODE_DEVICE FROM SKU_LOCATION_MAP SLM INNER JOIN SKU ON SLM.SKU_ID = SKU.SKU_ID INNER JOIN LOCATION L ON L.L_ID = SLM.L_ID WHERE GEOCODE_DEVICE LIKE '" + arrEachStation[li] + "%'";
					map = DatabaseQueries.executeQuery(mapSql, wamasHostIpRequested);
					if (map.size() > 0) {
						System.out.println("    li: " + li);
						CSVUtils.writeLine(writerOnePAge, Arrays.asList("	<line article_id=\"" + map.get(0).get("SKU_CODE") + "\"" + " ordered_packunits=\"" + Tools.getRandRotate(1, 7) + "\" packunit_size=\"1\" host_line_id=\"" + li + "\"/>"));
					} else {
						System.out.println("\n Table SKU_LOCATION_MAP was not filled out for: " + arrEachStation[li] + "\n");
					}
				}
				CSVUtils.writeLine(writerOnePAge, Arrays.asList("</order_insert>"));
				writerOnePAge.flush();
				writerOnePAge.close();
			}
		} else {
			System.out.println("\n Table SKU_LOCATION_MAP must be filled for at least one station \n");

		}
	}
}
