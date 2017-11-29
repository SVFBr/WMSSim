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

	public void createArticleInsert(int orderInsertAframe, int orderInsertPbl, int orderInsertPdc, String wamasHostIpRequested) throws ClassNotFoundException, SQLException, IOException {

		if (orderInsertAframe > 0) {
			String deviceType = arrDevice[0];
			int numberOfArticles = orderInsertAframe;
			String folderName = "/orderInsertWebAframeGeoTests";
			OrderInsertWritterGenericGeoTests.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 2700000, "2270000");
//			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		
		if (orderInsertPbl > 0) {
			String deviceType = arrDevice[1];
			int numberOfArticles = orderInsertPbl;
			String folderName = "/orderInsertWebPblGeoTests";
			OrderInsertWritterGenericGeoTests.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 2800000, "2800000");
//			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		
		if (orderInsertPdc > 0) {
			String deviceType = arrDevice[2];
			int numberOfArticles = orderInsertPdc;
			String folderName = "/orderInsertWebPdcGeoTests";
			OrderInsertWritterGenericGeoTests.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 2900000, "2900000");
//			SendByFTP.main(folderName, wamasHostIpRequested);
		}

	}
}