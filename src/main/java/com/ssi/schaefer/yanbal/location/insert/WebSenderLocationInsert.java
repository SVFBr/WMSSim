package com.ssi.schaefer.yanbal.location.insert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.ssi.schaefer.yanbal.article.insert.msgwritter.ArticleInsertWritter;
import com.ssi.schaefer.yanbal.barcode.insert.msgwritter.BarcodeInsertWritter;
import com.ssi.schaefer.yanbal.location.insert.msgwritter.LocationInsertWritter;
import com.ssi.schaefer.yanbal.util.conn.SendByFTP;
import com.ssi.schaefer.yanbal.util.dbutils.DatabaseQueries;
import com.ssi.schaefer.yanbal.util.dbutils.QueriesLauncher;
import com.ssi.schaefer.yanbal.util.tools.CSVUtils;

public class WebSenderLocationInsert {

	//*******************************************************************
	/** 						 				BARCODE INSERT  						 
			                       .-.
			        .-""`""-.    |(@ @)
			     _/`oOoOoOoOo`\_ \ \-/
			    '.-=-=-=-=-=-=-.' \/ \
			      `-=.=-.-=.=-'    \ /\
			         ^  ^  ^       _H_ \   
	 **/
	//*******************************************************************

	public void createInsert(String wamasHostIpRequested) throws ClassNotFoundException, SQLException, IOException {

		LocationInsertWritter.main("/locationInsertAFR", "AFR", wamasHostIpRequested);
		SendByFTP.main("/locationInsertAFR", wamasHostIpRequested);

		LocationInsertWritter.main("/locationInsertPBL", "PBL", wamasHostIpRequested);
		SendByFTP.main("/locationInsertPBL", wamasHostIpRequested);

		LocationInsertWritter.main("/locationInsertBAJ", "BAJ", wamasHostIpRequested);
		SendByFTP.main("/locationInsertBAJ", wamasHostIpRequested);
	
		CSVUtils.deleteAllFolders();
	}
}
