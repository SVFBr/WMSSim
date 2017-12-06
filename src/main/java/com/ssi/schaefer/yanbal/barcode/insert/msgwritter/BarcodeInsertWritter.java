package com.ssi.schaefer.yanbal.barcode.insert.msgwritter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.ssi.schaefer.yanbal.util.conn.SendByFTP;
import com.ssi.schaefer.yanbal.util.dbutils.DatabaseQueries;
import com.ssi.schaefer.yanbal.util.dbutils.QueriesLauncher;
import com.ssi.schaefer.yanbal.util.tools.CSVUtils;

public class BarcodeInsertWritter {

	/**
	 * 
	 * WRITTER
	 * 
	 * */

	static int incrementPageNumber = 800000000;

	public static void main(String folderName, String deviceType, String wamasHostIpRequested) throws ClassNotFoundException, SQLException, IOException {

		String selectArticlesByDevice = "SELECT SKU_CODE FROM PWX.SKU WHERE SKU_ID NOT IN (SELECT SKU_ID FROM PWX.SKU_BARCODE) AND SKU_CODE LIKE '" + deviceType + "%' ORDER BY SKU_CODE";
		List<HashMap<String, String>> mapArticles = DatabaseQueries.executeQuery(selectArticlesByDevice, wamasHostIpRequested);

		System.out.println(mapArticles.size() + " SKUs sem barcodes para " + deviceType + "\n");

		if (mapArticles.size() > 0) {

			CSVUtils.checkIfFileExistAt(folderName);
			File pathOnePage = CSVUtils.genPath(folderName);
			String csvFileOnePAge = pathOnePage + "/" + incrementPageNumber++ + ".dat";
			FileWriter writer = new FileWriter(csvFileOnePAge);

			CSVUtils.writeLine(writer, Arrays.asList("<barcodes>"));
			for (int li = 0; li <= mapArticles.size() - 1; li++) {
				CSVUtils.writeLine(writer, Arrays.asList(" ", "<barcode_insert article_id=\"" + (mapArticles.get(li).get("SKU_CODE")) + "\"" + " barcode=\"" + StringUtils.leftPad(mapArticles.get(li).get("SKU_CODE"), 9, "0") + "\" bundle_size_base=\"1\" />"));
				System.out.print("SET BARCODE: " + StringUtils.leftPad(mapArticles.get(li).get("SKU_CODE"), 9, "0") + " TO SKU: " + mapArticles.get(li).get("SKU_CODE") + "\n");
			}
			CSVUtils.writeLine(writer, Arrays.asList("</barcodes>"));
			writer.flush();
			writer.close();

		}
	}
}
