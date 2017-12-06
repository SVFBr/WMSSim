package com.ssi.schaefer.yanbal.order.insert;

import java.io.IOException;
import java.sql.SQLException;

import com.ssi.schaefer.yanbal.order.insert.msgwritter.OrderInsertWritter;
import com.ssi.schaefer.yanbal.order.insert.msgwritter.OrderInsertWritterGeocodes;
import com.ssi.schaefer.yanbal.order.insert.msgwritter.OrderInsertWritterOneToAllStations;
import com.ssi.schaefer.yanbal.order.insert.msgwritter.OrderInsertWritterOneToEachStation;
import com.ssi.schaefer.yanbal.order.insert.msgwritter.OrderInsertWritterPrize;
import com.ssi.schaefer.yanbal.util.conn.SendByFTP;
import com.ssi.schaefer.yanbal.util.tools.CSVUtils;

public class WebSenderOrderInsertDevicesTests {

	// *******************************************************************
	/**
	 * ORDER INSERT BY WEB GEOTESTS
	 * 
	 **/
	// *******************************************************************

	static String[] arrDeviceII = { "OneToEachStation", "OneToAllStations", "AF", "P", "BAJ" };

	public void createInsert(int orderInsertOneToEachStation, int orderInsertOneToAllStations, int orderInsertAFrameAllGeocodes, int orderInsertPblAllGeocodes, int orderInsertPdcAllGeocodes, String wamasHostIpRequested) throws ClassNotFoundException, SQLException, IOException {

		if (orderInsertOneToEachStation > 0) {
			String deviceType = arrDeviceII[0];
			int numberOfArticles = orderInsertOneToEachStation;
			String folderName = "/orderInsertOneToEachStation";
			OrderInsertWritterOneToEachStation.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 8100000, "8100000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}

		if (orderInsertOneToAllStations > 0) {
			String deviceType = arrDeviceII[1];
			int numberOfArticles = orderInsertOneToAllStations;
			String folderName = "/orderInsertOneToAllStations";
			OrderInsertWritterOneToAllStations.main(deviceType, numberOfArticles, folderName, wamasHostIpRequested, 8200000, "8200000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}

		if (orderInsertAFrameAllGeocodes > 0) {
			String deviceType = arrDeviceII[2];
			String folderName = "/orderInsertAFrameAllGeocodes";
			OrderInsertWritterGeocodes.main(deviceType, folderName, wamasHostIpRequested, 8300000, "8300000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}

		if (orderInsertPblAllGeocodes > 0) {
			String deviceType = arrDeviceII[3];
			String folderName = "/orderInsertPblAllGeocodes";
			OrderInsertWritterGeocodes.main(deviceType, folderName, wamasHostIpRequested, 8400000, "8400000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}

		if (orderInsertPdcAllGeocodes > 0) {
			String deviceType = arrDeviceII[4];
			String folderName = "/orderInsertPdcAllGeocodes";
			OrderInsertWritterGeocodes.main(deviceType, folderName, wamasHostIpRequested, 8500000, "8500000");
			SendByFTP.main(folderName, wamasHostIpRequested);
		}

		/////////////////////////////////////////////////////////////////////////
		
		CSVUtils.deleteAllFolders();
	}
}