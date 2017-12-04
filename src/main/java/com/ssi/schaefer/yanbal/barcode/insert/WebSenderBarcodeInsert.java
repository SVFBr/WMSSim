package com.ssi.schaefer.yanbal.barcode.insert;

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
import com.ssi.schaefer.yanbal.util.conn.SendByFTP;
import com.ssi.schaefer.yanbal.util.dbutils.DatabaseQueries;
import com.ssi.schaefer.yanbal.util.dbutils.QueriesLauncher;
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
