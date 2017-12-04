package com.ssi.schaefer.yanbal.article.insert;

import java.io.IOException;
import java.sql.SQLException;

import com.ssi.schaefer.yanbal.article.insert.msgwritter.ArticleInsertWritter;
import com.ssi.schaefer.yanbal.util.conn.SendByFTP;
import com.ssi.schaefer.yanbal.util.tools.CSVUtils;

public class WebSenderArticleInsert {

	//*******************************************************************
	/** 						 				   ARTICLES INSERT BY WEB 						 
			                       .-.
			        .-""`""-.    |(@ @)
			     _/`oOoOoOoOo`\_ \ \-/
			    '.-=-=-=-=-=-=-.' \/ \
			      `-=.=-.-=.=-'    \ /\					
			         ^  ^  ^       _H_ \    
			                           			1942 GEOCODES TOTAL YANBOG
															    575 AFRAME    
																   368 PBL    
																   999 PDC    
	**/
	//*******************************************************************

	static String[] arrDevice = { "AFR", "PBL", "BAJ" };

	public void createInsert(int articleInsertAFrame, int articleInsertPbl, int articleInsertPdc,
			String wamasHostIpRequested) throws ClassNotFoundException, SQLException, IOException {

		if (articleInsertAFrame > 0) {
			String deviceType = arrDevice[0];
			int numberOfArticles = articleInsertAFrame;
			String folderName = "/articleInsertAFR";
			ArticleInsertWritter.main(folderName, deviceType, wamasHostIpRequested, numberOfArticles);
			SendByFTP.main(folderName, wamasHostIpRequested);
		}

		if (articleInsertPbl > 0) {
			String deviceType = arrDevice[1];
			int numberOfArticles = articleInsertPbl;
			String folderName = "/articleInsertPBL";
			ArticleInsertWritter.main(folderName, deviceType, wamasHostIpRequested, numberOfArticles);
			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		if (articleInsertPdc > 0) {
			String deviceType = arrDevice[2];
			int numberOfArticles = articleInsertPdc;
			String folderName = "/articleInsertBAJ";
			ArticleInsertWritter.main(folderName, deviceType, wamasHostIpRequested, numberOfArticles);
			SendByFTP.main(folderName, wamasHostIpRequested);
		}
		
		CSVUtils.deleteAllFolders();
	}
}
