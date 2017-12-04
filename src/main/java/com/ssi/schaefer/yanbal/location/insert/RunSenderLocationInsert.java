package com.ssi.schaefer.yanbal.location.insert;

import java.io.IOException;
import java.sql.SQLException;

import com.ssi.schaefer.yanbal.location.insert.msgwritter.LocationInsertWritter;
import com.ssi.schaefer.yanbal.util.conn.SendByFTP;
import com.ssi.schaefer.yanbal.util.tools.CSVUtils;

public class RunSenderLocationInsert {

	//*******************************************************************
	/** 						 				LOCATION INSERT BY FTP					 
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

		LocationInsertWritter.main("/locationInsertAFR", "AFR", wamasHostIpRequested);
		SendByFTP.main("/locationInsertAFR", wamasHostIpRequested);

		LocationInsertWritter.main("/locationInsertPBL", "PBL", wamasHostIpRequested);
		SendByFTP.main("/locationInsertPBL", wamasHostIpRequested);

		LocationInsertWritter.main("/locationInsertPDC", "BAJ", wamasHostIpRequested);
		SendByFTP.main("/locationInsertBAJ", wamasHostIpRequested);
		
		CSVUtils.deleteAllFolders();

	}
}
