package com.ssi.schaefer.yanbal.order.insert;

import java.io.IOException;
import java.sql.SQLException;

import com.ssi.schaefer.yanbal.order.insert.msgwritter.OrderInsertWritterGeneric;
import com.ssi.schaefer.yanbal.order.insert.msgwritter.OrderInsertWritterGenericGeoTests;
import com.ssi.schaefer.yanbal.order.insert.msgwritter.OrderInsertWritterPrize;
import com.ssi.schaefer.yanbal.util.conn.SendByFTP;

public class RunSenderOrderInsertGeoTests {

	//*******************************************************************
	/** 						 		  ORDER INSERT BY SOCKET GEOTESTS						 
			                       .
			        .-""`""-.    |(@ @)
			     _/`oOoOoOoOo`\_ \ \-/
			    '.-=-=-=-=-=-=-.' \/ \
			      `-=.=-.-=.=-'    \ /\
			         ^  ^  ^       _H_ \   
	 **/
	//*******************************************************************

	static String[] arrDevice = { "AF", "P", "BAJ" , "EACH_STATIONS"};
	
	static String wamasHostIpRequested = "192.168.173.222";  //"10.34.234.2";

	static int orderInsertAframe = 0;
	static int orderInsertPbl = 0;
	static int orderInsertPdc = 0;
	static int orderInsertEachStation = 1;

	//*******************************************************************

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		if (orderInsertAframe > 0) {
			String deviceType = arrDevice[0];
			int numberOfArticles = orderInsertAframe;
			String folderName = "/orderInsertSocAframeGeoTests";
			OrderInsertWritterGenericGeoTests.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 2700000, "2700000");
			//SendByFTP.main(folderName, wamasHostIpRequested);
		}
		
		if (orderInsertPbl > 0) {
			String deviceType = arrDevice[1];
			int numberOfArticles = orderInsertPbl;
			String folderName = "/orderInsertSocPblGeoTests";
			OrderInsertWritterGenericGeoTests.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 2800000, "2800000");
			//SendByFTP.main(folderName, wamasHostIpRequested);
		}
		
		if (orderInsertPdc > 0) {
			String deviceType = arrDevice[2];
			int numberOfArticles = orderInsertPdc;
			String folderName = "/orderInsertSocPdcGeoTests";
			OrderInsertWritterGenericGeoTests.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 2900000, "2900000");
			//SendByFTP.main(folderName, wamasHostIpRequested);
		}
		
		if (orderInsertEachStation > 0) {
			String deviceType = arrDevice[3];
			int numberOfArticles = orderInsertEachStation;
			String folderName = "/orderInsertSocEachStationGeoTests";
			OrderInsertWritterGenericGeoTests.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 3000000, "3000000");
			//SendByFTP.main(folderName, wamasHostIpRequested);
		}
		

	}
}
