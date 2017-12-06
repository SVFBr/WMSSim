package com.ssi.schaefer.yanbal.barcode.insert;

import java.io.IOException;
import java.sql.SQLException;

import com.ssi.schaefer.yanbal.barcode.insert.msgwritter.BarcodeInsertWritter;
import com.ssi.schaefer.yanbal.util.conn.SendByFTP;
import com.ssi.schaefer.yanbal.util.tools.CSVUtils;

public class RunSenderBarcodeInsert {

	//*******************************************************************
	/** 						 				BARCODE INSERT BY FTP						 
			                       .-.
			        .-""`""-.    |(@ @)
			     _/`oOoOoOoOo`\_ \ \-/
			    '.-=-=-=-=-=-=-.' \/ \
			      `-=.=-.-=.=-'    \ /\
			         ^  ^  ^       _H_ \  
	 **/
	//*******************************************************************

	static String wamasHostIpRequested = "192.168.173.222";
//	static String wamasHostIpRequested = "10.34.234.2";

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		BarcodeInsertWritter.main("/barcodeInsertAFR", "AFR", wamasHostIpRequested);
		SendByFTP.main("/barcodeInsertAFR", wamasHostIpRequested);

		BarcodeInsertWritter.main("/barcodeInsertBAJ", "BAJ", wamasHostIpRequested);
		SendByFTP.main("/barcodeInsertBAJ", wamasHostIpRequested);
		
		BarcodeInsertWritter.main("/barcodeInsertPBL", "PBL", wamasHostIpRequested);
		SendByFTP.main("/barcodeInsertPBL", wamasHostIpRequested);

		CSVUtils.deleteAllFolders();
	}
}
