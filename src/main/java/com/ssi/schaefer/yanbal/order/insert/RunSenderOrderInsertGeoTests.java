package com.ssi.schaefer.yanbal.order.insert;

import java.io.IOException;
import java.sql.SQLException;

import com.ssi.schaefer.yanbal.order.insert.msgwritter.OrderInsertWritterGenericGeoTests;
import com.ssi.schaefer.yanbal.order.insert.msgwritter.OrderInsertWritterGenericGeoTestsAllStation;
import com.ssi.schaefer.yanbal.order.insert.msgwritter.OrderInsertWritterGenericGeoTestsEachStation;
import com.ssi.schaefer.yanbal.util.conn.SendByFTP;

public class RunSenderOrderInsertGeoTests {

	//*******************************************************************
	/** 						 		  ORDER INSERT BY FTP GEOTESTS						 
			                       .
			        .-""`""-.    |(@ @)
			     _/`oOoOoOoOo`\_ \ \-/
			    '.-=-=-=-=-=-=-.' \/ \
			      `-=.=-.-=.=-'    \ /\
			         ^  ^  ^       _H_ \   
	 **/
	//*******************************************************************

	static String[] arrDevice = { "AF", "P", "BAJ" , "EACH_STATIONS",  "ALL_STATIONS"};
	
	static String wamasHostIpRequested = "192.168.173.222";
	//static String wamasHostIpRequested = "10.34.234.2";

	//SETAR 0 ou 1 PARA GERAR ou NÃO 
	static int orderInsertAframe = 0;
	static int orderInsertPbl = 0;
	static int orderInsertPdc = 0;
	static int orderInsertEachStation = 1;
	static int orderInsertAllStations =0;

	//*******************************************************************

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		if (orderInsertAframe > 0) {
			String deviceType = arrDevice[0];
			int numberOfArticles = orderInsertAframe;
			String folderName = "/orderInsertAFRgt";
			OrderInsertWritterGenericGeoTests.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 2700000, "2700000");
	//		SendByFTP.main(folderName, wamasHostIpRequested);
		}
		
		if (orderInsertPbl > 0) {
			String deviceType = arrDevice[1];
			int numberOfArticles = orderInsertPbl;
			String folderName = "/orderInsertPBLgt";
			OrderInsertWritterGenericGeoTests.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 2800000, "2800000");
	//		SendByFTP.main(folderName, wamasHostIpRequested);
		}
	
		if (orderInsertPdc > 0) {
			String deviceType = arrDevice[2];
			int numberOfArticles = orderInsertPdc;
			String folderName = "/orderInsertBAJgt";
			OrderInsertWritterGenericGeoTests.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 2900000, "2900000");
	//		SendByFTP.main(folderName, wamasHostIpRequested);
		}
		
		if (orderInsertEachStation > 0) {
			String deviceType = arrDevice[3];
			int numberOfArticles = orderInsertEachStation;
			String folderName = "/orderInsertEACHSTATIONgt";
			OrderInsertWritterGenericGeoTestsEachStation.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 3000000, "3000000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}
	
		if (orderInsertAllStations > 0) {
			String deviceType = arrDevice[4];
			int numberOfArticles = orderInsertAllStations;
			String folderName = "/orderInsertALLSTATIONgt";
			OrderInsertWritterGenericGeoTestsAllStation.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 3100000, "3100000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}

		

	}
}
