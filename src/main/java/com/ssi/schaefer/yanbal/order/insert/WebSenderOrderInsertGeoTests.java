package com.ssi.schaefer.yanbal.order.insert;

import java.io.IOException;
import java.sql.SQLException;

import com.ssi.schaefer.yanbal.order.insert.msgwritter.OrderInsertWritterGeneric;
import com.ssi.schaefer.yanbal.order.insert.msgwritter.OrderInsertWritterGenericGeoTests;
import com.ssi.schaefer.yanbal.order.insert.msgwritter.OrderInsertWritterPrize;
import com.ssi.schaefer.yanbal.util.conn.SendByFTP;

public class WebSenderOrderInsertGeoTests {

	//*******************************************************************
	/**    				 				     ORDER INSERT BY WEB GEOTESTS 						 
			                       .-.
			        .-""`""-.    |(@ @)
			     _/`oOoOoOoOo`\_ \ \-/
			    '.-=-=-=-=-=-=-.' \/ \
			      `-=.=-.-=.=-'    \ /\
			         ^  ^  ^       _H_ \    
	 **/
	//*******************************************************************

	static String[] arrDevice = { "AF", "P", "S0" };

	public void createArticleInsert(int orderInsertAframeGeoTests, int orderInsertPblGeoTests, int orderInsertPdcGeoTests, String wamasHostIpRequested) throws ClassNotFoundException, SQLException, IOException {

		if (orderInsertAframeGeoTests == 1) {
			String deviceType = arrDevice[0];
			int numberOfArticles = orderInsertAframeGeoTests;
			String folderName = "/orderInsertWebAframeGeoTests";
			OrderInsertWritterGenericGeoTests.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 2700000, "2270000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		
		if (orderInsertPblGeoTests == 1) {
			String deviceType = arrDevice[1];
			int numberOfArticles = orderInsertPblGeoTests;
			String folderName = "/orderInsertWebPblGeoTests";
			OrderInsertWritterGenericGeoTests.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 2800000, "2800000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		
		if (orderInsertPdcGeoTests == 1) {
			String deviceType = arrDevice[2];
			int numberOfArticles = orderInsertPdcGeoTests;
			String folderName = "/orderInsertWebPdcGeoTests";
			OrderInsertWritterGenericGeoTests.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 2900000, "2900000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}

	}
}