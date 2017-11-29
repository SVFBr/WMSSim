package com.ssi.schaefer.yanbal.article.insert.msgwritter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.ssi.schaefer.yanbal.util.dbutils.DatabaseQueries;
import com.ssi.schaefer.yanbal.util.tools.CSVUtils;

public class ArticleInsertWritter {

	/**
	 * 
	 * WRITTER
	 * 
	 * */
	
	static String skuCode;
	static int incrementPageNumber = 900000000;

	public static void main(String folderName, String deviceType, String wamasHostIpRequested, int numberOfarticles) throws IOException, ClassNotFoundException, SQLException {

		String selectSkuMaxCode = "SELECT MAX(SKU_CODE) FROM PWX.SKU WHERE SKU_CODE LIKE '" + deviceType + "%'";
		List<HashMap<String, String>> mapMaxSkuCode = DatabaseQueries.executeQuery(selectSkuMaxCode, wamasHostIpRequested);
	
		String newMapSkuCode = mapMaxSkuCode.toString().replaceAll("[^0-9]", "");
		if (newMapSkuCode.isEmpty()) {
			skuCode = "1000";
		} else {
			skuCode = newMapSkuCode;
		}
		Integer skuNumber = Integer.parseInt(skuCode);
		skuNumber = skuNumber + 1;
		
		CSVUtils.genPath(folderName);
		CSVUtils.checkIfFileExistAt(folderName);
		File pathOnePage = CSVUtils.genPath(folderName);
		String csvFileOnePAge = pathOnePage + "/" + incrementPageNumber++ + ".dat";
		FileWriter writer = new FileWriter(csvFileOnePAge);
		
		CSVUtils.writeLine(writer, Arrays.asList("<articles>"));
		for (int li = 1; li <= numberOfarticles; li++) {
			System.out.print("SKU LINE: ");
			String skuNum = Integer.toString(skuNumber);
			System.out.print(deviceType + skuNum);
			System.out.print("\n");
			CSVUtils.writeLine(writer, Arrays.asList(" ", "<article_insert article_id=\"" + deviceType + skuNum + "\"", "article_name=\"" + deviceType + skuNum + "\"", "art_description=\"item description\" art_has_weight=\"false\" art_weight=\"1\" art_length=\"1\" art_width=\"1\" art_height=\"1\" bundle_size_base=\"1\"	/>"));
			skuNumber++;
		}
		CSVUtils.writeLine(writer, Arrays.asList("</articles>"));
		writer.flush();
		writer.close();
	}

}
