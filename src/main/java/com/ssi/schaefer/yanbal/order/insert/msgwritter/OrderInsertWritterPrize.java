package com.ssi.schaefer.yanbal.order.insert.msgwritter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

import com.ssi.schaefer.yanbal.util.dbutils.DatabaseQueries;
import com.ssi.schaefer.yanbal.util.tools.CSVUtils;
import com.ssi.schaefer.yanbal.util.tools.Tools;

public class OrderInsertWritterPrize {

	/**
	 * 
	 * WRITTER for ORDER INSERT [PRIZE]
	 * 
	 */

	static String mapMaxOrderCodeSql;
	static String mapSql;
	static int files;
	static String orderCode;

	public static void main(String deviceType, int numberOfArticles, String folderName, String wamasHostIpRequested, int incrementPageNumber, String orderCodeSetter) throws ClassNotFoundException, SQLException, IOException {

		if (deviceType == "PRIZE") {
			mapMaxOrderCodeSql = "SELECT MAX(ORDER_CODE) FROM PWX.ORDER_REQUEST";
			files = numberOfArticles;
		}

		List<HashMap<String, String>> mapMaxOrderCode = DatabaseQueries.executeQuery(mapMaxOrderCodeSql, wamasHostIpRequested);
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

		// FILES
				for (int fl = 1; fl <= files; fl++) {
					// ORDER_CODE
					orderNumber++;
					System.out.print("OR.............: ");
					String orNum = Integer.toString(orderNumber);
					System.out.print(StringUtils.leftPad(orNum, 7, "0"));
					System.out.print("\n");
					for (int or = 1; or <= 1; or++) {
						// GETTING JUST LINES
						File pathOnePage = CSVUtils.genPath(folderName);
						String csvFileOnePAge = pathOnePage + "/" + String.format("%07d", incrementPageNumber++) + ".dat";
						FileWriter writerOnePAge = new FileWriter(csvFileOnePAge);
						CSVUtils.writeLine(writerOnePAge, Arrays.asList("<order_insert_prize order_id=\"" + StringUtils.leftPad(orNum, 7, "0") + "\" sub_order_id=\"1" + "\" host_order_id=\"SPY\""  + " tu_type=\"" + Tools.getRandBoxType() + "\" start_station=\"AIP02\" check=\"false\" departure_time=\"172531\" departure_date=\"20171105\" print=\"false\" ramp_name=\"SHP0" + Tools.getRandRotate(1, 7)  + "\"/>"));
						//CSVUtils.writeLine(writerOnePAge, Arrays.asList(" <station station_id=\"SHL0" + Tools.getRotate(1, 8) + "\"/>"));
						//CSVUtils.writeLine(writerOnePAge, Arrays.asList("</order_insert_prize>"));
						writerOnePAge.flush();
						writerOnePAge.close();
			}
		}
	}
}
