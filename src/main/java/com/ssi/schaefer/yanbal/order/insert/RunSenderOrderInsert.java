package com.ssi.schaefer.yanbal.order.insert;

import java.io.IOException;
import java.sql.SQLException;

import com.ssi.schaefer.yanbal.order.insert.msgwritter.OrderInsertWritter;
import com.ssi.schaefer.yanbal.order.insert.msgwritter.OrderInsertWritterGeocodes;
import com.ssi.schaefer.yanbal.order.insert.msgwritter.OrderInsertWritterOneToAllStations;
import com.ssi.schaefer.yanbal.order.insert.msgwritter.OrderInsertWritterOneToEachStation;
import com.ssi.schaefer.yanbal.order.insert.msgwritter.OrderInsertWritterPrize;
import com.ssi.schaefer.yanbal.util.conn.SendByFTP;

public class RunSenderOrderInsert {

	// *******************************************************************
	/**
	 * ORDER INSERT BY FTP 
	 *
	 **/
	// *******************************************************************

	static String wamasHostIpRequested = "192.168.173.222";
	// static String wamasHostIpRequested = "10.34.234.2";

	// HERE YOU MUST INDICATE HOW MANY ORDERS SHOULD BE SEND TO HOST

	static String[] arrDevice = { "AFR", "PBLUP", "PBLDOWN", "PBLMIX", "BAJ", "PRIZE", "MIX" };
	static int orderInsertAframe = 0;
	static int orderInsertPblUp = 0;
	static int orderInsertPblDown = 0;
	static int orderInsertPblMixed = 0;
	static int orderInsertPdc = 0;
	static int orderInsertPrize = 0;
	static int orderInsertMix = 0;

	// HERE YOU MUST INDICATE 1-YES OR 0-NO TO SEND DEVICE TESTS

	static String[] arrDeviceII = { "OneToEachStation", "OneToAllStations", "AF", "P", "BAJ" };
	static int orderInsertOneToEachStation = 0;
	static int orderInsertOneToAllStations = 2;
	static int orderInsertAFrameAllGeocodes = 0;
	static int orderInsertPblAllGeocodes = 0;
	static int orderInsertPdcAllGeocodes = 0;

	// *******************************************************************

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		if (orderInsertAframe > 0) {
			String deviceType = arrDevice[0];
			int numberOfArticles = orderInsertAframe;
			String folderName = "/orderInsertAframe";
			OrderInsertWritter.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 9100000, "9100000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		if (orderInsertPblUp > 0) {
			String deviceType = arrDevice[1];
			int numberOfArticles = orderInsertPblUp;
			String folderName = "/orderInsertPblUp";
			OrderInsertWritter.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 9210000, "9210000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		if (orderInsertPblDown > 0) {
			String deviceType = arrDevice[2];
			int numberOfArticles = orderInsertPblDown;
			String folderName = "/orderInsertPblDown";
			OrderInsertWritter.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 9220000, "9220000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		if (orderInsertPblMixed > 0) {
			String deviceType = arrDevice[3];
			int numberOfArticles = orderInsertPblMixed;
			String folderName = "/orderInsertPblMixed";
			OrderInsertWritter.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 9230000, "9230000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		if (orderInsertPdc > 0) {
			String deviceType = arrDevice[4];
			int numberOfArticles = orderInsertPdc;
			String folderName = "/orderInsertPdc";
			OrderInsertWritter.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 9300000, "9300000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		if (orderInsertPrize > 0) {
			String deviceType = arrDevice[5];
			int numberOfArticles = orderInsertPrize;
			String folderName = "/orderInsertPrize";
			OrderInsertWritterPrize.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 9400000, "9400000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		if (orderInsertMix > 0) {
			String deviceType = arrDevice[6];
			int numberOfArticles = orderInsertMix;
			String folderName = "/orderInsertMix";
			OrderInsertWritter.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 9990000, "9990000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		if (orderInsertOneToEachStation > 0) {
			String deviceType = arrDeviceII[0];
			int numberOfArticles = orderInsertOneToEachStation;
			String folderName = "/orderInsertOneToEachStation";
			OrderInsertWritterOneToEachStation.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 2700000, "2700000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}

		if (orderInsertOneToAllStations > 0) {
			String deviceType = arrDeviceII[1];
			int numberOfArticles = orderInsertOneToAllStations;
			String folderName = "/orderInsertOneToAllStations";
			OrderInsertWritterOneToAllStations.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 2800000, "2800000");
			 SendByFTP.main(folderName, wamasHostIpRequested);
		}

		if (orderInsertAFrameAllGeocodes > 0) {
			String deviceType = arrDeviceII[2];
			int numberOfArticles = orderInsertAFrameAllGeocodes;
			String folderName = "/orderInsertAFrameAllGeocodes";
			OrderInsertWritterGeocodes.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 2900000, "2900000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}

		if (orderInsertPblAllGeocodes > 0) {
			String deviceType = arrDeviceII[3];
			int numberOfArticles = orderInsertPblAllGeocodes;
			String folderName = "/orderInsertPblAllGeocodes";
			OrderInsertWritterGeocodes.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 3000000, "3000000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}

		if (orderInsertPdcAllGeocodes > 0) {
			String deviceType = arrDeviceII[4];
			int numberOfArticles = orderInsertPdcAllGeocodes;
			String folderName = "/orderInsertPdcAllGeocodes";
			OrderInsertWritterGeocodes.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 3100000, "3100000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}

	}
}
