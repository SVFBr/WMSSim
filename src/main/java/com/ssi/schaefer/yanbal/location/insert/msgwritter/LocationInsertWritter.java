package com.ssi.schaefer.yanbal.location.insert.msgwritter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.ssi.schaefer.yanbal.util.dbutils.DatabaseQueries;
import com.ssi.schaefer.yanbal.util.tools.CSVUtils;

public class LocationInsertWritter {

	/**
	 * 
	 * WRITTER
	 * 
	 */

	static int incrementPageNumber = 700000000;

	static String mapLocationSql;
	static String mapSkuCodeSql;

	public static void main(String folderName, String deviceType, String wamasHostIpRequested) throws ClassNotFoundException, SQLException, IOException {

		if (deviceType == "AF") {
			mapLocationSql = "SELECT * FROM PWX.LOCATION WHERE GEOCODE_DEVICE LIKE 'AF%' ORDER BY GEOCODE ASC";
			mapSkuCodeSql = "SELECT SKU_CODE FROM PWX.SKU WHERE SKU_ID NOT IN (SELECT SKU_ID FROM PWX.SKU_LOCATION_MAP) AND SKU_CODE LIKE 'AF%'";
		}
		if (deviceType == "PB") {
			mapLocationSql = "SELECT * FROM PWX.LOCATION WHERE GEOCODE_DEVICE BETWEEN 'P01' AND 'P19' AND GEOCODE NOT LIKE 'MPF%' ORDER BY GEOCODE ASC";
			mapSkuCodeSql = "SELECT SKU_CODE FROM PWX.SKU WHERE SKU_ID NOT IN (SELECT SKU_ID FROM PWX.SKU_LOCATION_MAP) AND SKU_CODE LIKE 'PB%'";
		}
		if (deviceType == "PD") {
			mapLocationSql = "SELECT * FROM PWX.LOCATION WHERE GEOCODE_DEVICE LIKE 'PD%' ORDER BY GEOCODE ASC";
			mapSkuCodeSql = "SELECT SKU_CODE FROM PWX.SKU WHERE SKU_ID NOT IN (SELECT SKU_ID FROM PWX.SKU_LOCATION_MAP) AND SKU_CODE LIKE 'PD%'";
		}

		List<HashMap<String, String>> mapLocation = DatabaseQueries.executeQuery(mapLocationSql, wamasHostIpRequested);
		List<HashMap<String, String>> mapSkuCode = DatabaseQueries.executeQuery(mapSkuCodeSql, wamasHostIpRequested);

		System.out.println("\n" + mapLocation.size() + " " + deviceType + " SKUs " );
		System.out.println(mapSkuCode.size() + " SKUs without location " + deviceType);

		if (mapSkuCode.size() > 0) {

			int line = mapLocation.size();
			if (line >= mapSkuCode.size()) {
				line = mapSkuCode.size();
			}

			CSVUtils.checkIfFileExistAt(folderName);
			File pathOnePage = CSVUtils.genPath(folderName);
			String csvFileOnePAge = pathOnePage + "/" + incrementPageNumber++ + ".dat";
			FileWriter writer = new FileWriter(csvFileOnePAge);

			CSVUtils.writeLine(writer, Arrays.asList("<locations>"));
			for (int li = 0; li <= line - 1; li++) {
				CSVUtils.writeLine(writer, Arrays.asList(" ", "<location_insert article_id=\"" + (mapSkuCode.get(li).get("SKU_CODE")) + "\"" + " geo_code=\"" + (mapLocation.get(li).get("GEOCODE")) + "\"	/>"));
				System.out.print("  SET LOCATION: " + (mapLocation.get(li).get("GEOCODE")) + " TO SKU: " + mapSkuCode.get(li).get("SKU_CODE") + "\n");
			}
			CSVUtils.writeLine(writer, Arrays.asList("</locations>"));
			writer.flush();
			writer.close();
		}
	}
}
