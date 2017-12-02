package com.ssi.schaefer.yanbal.order.insert;

import java.io.IOException;
import java.sql.SQLException;

import com.ssi.schaefer.yanbal.order.insert.msgwritter.OrderInsertWritterGeneric;
import com.ssi.schaefer.yanbal.order.insert.msgwritter.OrderInsertWritterPrize;
import com.ssi.schaefer.yanbal.util.conn.SendByFTP;

public class WebSenderOrderInsert {

	//*******************************************************************
	/** 						 				   ORDER INSERT BY WEB 						 
			                       .-.
			        .-""`""-.    |(@ @)
			     _/`oOoOoOoOo`\_ \ \-/
			    '.-=-=-=-=-=-=-.' \/ \
			      `-=.=-.-=.=-'    \ /\
			         ^  ^  ^       _H_ \    [575 afr] [368 pbl] [100 pdc]
	 **/
	//*******************************************************************

	static String[] arrDevice = { "AFR", "PBLUP", "PBLDOWN", "PBLMIX", "BAJ", "PRIZE", "MIX", };

	public void createArticleInsert(int orderInsertAframe, int orderInsertPblUp, int orderInsertPblDown, int orderInsertPblMixed, int orderInsertPdc, int orderInsertPrize, int orderInsertMix, String wamasHostIpRequested) throws ClassNotFoundException, SQLException, IOException {

		if (orderInsertAframe > 0) {
			String deviceType = arrDevice[0];
			int numberOfArticles = orderInsertAframe;
			String folderName = "/orderInsertAFR";
			OrderInsertWritterGeneric.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 9100000, "9100000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		if (orderInsertPblUp > 0) {
			String deviceType = arrDevice[1];
			int numberOfArticles = orderInsertPblUp;
			String folderName = "/orderInsertPBLup";
			OrderInsertWritterGeneric.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 9210000, "9210000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		if (orderInsertPblDown > 0) {
			String deviceType = arrDevice[2];
			int numberOfArticles = orderInsertPblDown;
			String folderName = "/orderInsertPBLdown";
			OrderInsertWritterGeneric.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 9220000, "9220000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		if (orderInsertPblMixed > 0) {
			String deviceType = arrDevice[3];
			int numberOfArticles = orderInsertPblMixed;
			String folderName = "/orderInsertPBLmix";
			OrderInsertWritterGeneric.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 9230000, "9230000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		if (orderInsertPdc > 0) {
			String deviceType = arrDevice[4];
			int numberOfArticles = orderInsertPdc;
			String folderName = "/orderInsertBAJ";
			OrderInsertWritterGeneric.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 9300000, "9300000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		if (orderInsertPrize > 0) {
			String deviceType = arrDevice[5];
			int numberOfArticles = orderInsertPrize;
			String folderName = "/orderInsertPRIZE";
			OrderInsertWritterPrize.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 9400000, "9400000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		if (orderInsertMix > 0) {
			String deviceType = arrDevice[6];
			int numberOfArticles = orderInsertMix;
			String folderName = "/orderInsertMIX";
			OrderInsertWritterGeneric.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 9990000, "9990000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}

	}
}