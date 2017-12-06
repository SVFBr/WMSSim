package com.ssi.schaefer.yanbal.barcode.insert;

import java.io.IOException;
import java.sql.SQLException;

import com.ssi.schaefer.yanbal.barcode.insert.msgwritter.BarcodeInsertWritter;
import com.ssi.schaefer.yanbal.util.conn.SendByFTP;
import com.ssi.schaefer.yanbal.util.tools.CSVUtils;

public class WebSenderBarcodeInsert {

	//*******************************************************************
	/** 						 				BARCODE INSERT BY WEB  						 
			                       .-.
			        .-""`""-.    |(@ @)
			     _/`oOoOoOoOo`\_ \ \-/
			    '.-=-=-=-=-=-=-.' \/ \
			      `-=.=-.-=.=-'    \ /\
			         ^  ^  ^       _H_ \   
	 **/
	//*******************************************************************

	public void createInsert(String wamasHostIpRequested) throws ClassNotFoundException, SQLException, IOException {

		BarcodeInsertWritter.main("/barcodeInsertAFR", "AFR", wamasHostIpRequested);
		SendByFTP.main("/barcodeInsertAFR", wamasHostIpRequested);

		BarcodeInsertWritter.main("/barcodeInsertPBL", "PBL", wamasHostIpRequested);
		SendByFTP.main("/barcodeInsertPBL", wamasHostIpRequested);

		BarcodeInsertWritter.main("/barcodeInserBAJ", "BAJ", wamasHostIpRequested);
		SendByFTP.main("/barcodeInsertBAJ", wamasHostIpRequested);
		
		CSVUtils.deleteAllFolders();
	}
}
