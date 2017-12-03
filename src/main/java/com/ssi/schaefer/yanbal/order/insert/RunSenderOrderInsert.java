package com.ssi.schaefer.yanbal.order.insert;

import java.io.IOException;
import java.sql.SQLException;

import com.ssi.schaefer.yanbal.order.insert.msgwritter.OrderInsertWritterGeneric;
import com.ssi.schaefer.yanbal.order.insert.msgwritter.OrderInsertWritterPrize;
import com.ssi.schaefer.yanbal.util.conn.SendByFTP;

public class RunSenderOrderInsert {

	//*******************************************************************
	/** 						 				ORDER INSERT BY FTP 						 
			                       .
			        .-""`""-.    |(@ @)
			     _/`oOoOoOoOo`\_ \ \-/
			    '.-=-=-=-=-=-=-.' \/ \
			      `-=.=-.-=.=-'    \ /\
			         ^  ^  ^       _H_ \   
	 **/
	//*******************************************************************

	static String[] arrDevice = { "AFR", "PBLUP", "PBLDOWN", "PBLMIX", "BAJ", "PRIZE", "MIX", };

	static String wamasHostIpRequested = "10.34.234.2";
	//static String wamasHostIpRequested = "192.168.173.222";
	
	static int orderInsertAframe = 5;
	static int orderInsertPblUp = 5;
	static int orderInsertPblDown = 5;
	static int orderInsertPblMixed = 5;
	static int orderInsertPdc = 5;
	static int orderInsertPrize = 5;
	static int orderInsertMix = 5;

	//*******************************************************************

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		if (orderInsertAframe > 0) {
			String deviceType = arrDevice[0];
			int numberOfArticles = orderInsertAframe;
			String folderName = "/orderInsertAFR";
			OrderInsertWritterGeneric.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 9100000, "9100000");
//			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		if (orderInsertPblUp > 0) {
			String deviceType = arrDevice[1];
			int numberOfArticles = orderInsertPblUp;
			String folderName = "/orderInsertPBL_up";
			OrderInsertWritterGeneric.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 9210000, "9210000");
//			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		if (orderInsertPblDown > 0) {
			String deviceType = arrDevice[2];
			int numberOfArticles = orderInsertPblDown;
			String folderName = "/orderInsertPBL_down";
			OrderInsertWritterGeneric.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 9220000, "9220000");
//			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		if (orderInsertPblMixed > 0) {
			String deviceType = arrDevice[3];
			int numberOfArticles = orderInsertPblMixed;
			String folderName = "/orderInsertPBL_mix";
			OrderInsertWritterGeneric.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 9230000, "9230000");
//			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		if (orderInsertPdc > 0) {
			String deviceType = arrDevice[4];
			int numberOfArticles = orderInsertPdc;
			String folderName = "/orderInsertBAJ";
			OrderInsertWritterGeneric.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 9300000, "9300000");
//			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		if (orderInsertPrize > 0) {
			String deviceType = arrDevice[5];
			int numberOfArticles = orderInsertPrize;
			String folderName = "/orderInsertPRIZE";
			OrderInsertWritterPrize.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 9400000, "9400000");
//			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		if (orderInsertMix > 0) {
			String deviceType = arrDevice[6];
			int numberOfArticles = orderInsertMix;
			String folderName = "/orderInsertMIX";
			OrderInsertWritterGeneric.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 9990000, "9990000");
//			SendByFTP.main(folderName, wamasHostIpRequested);
		}

	}
}
