package com.ssi.schaefer.yanbal.util.dbutils;

import java.util.HashMap;
import java.util.List;

public class QueriesLauncher {

	HashMap<String, String> queriesMap = new HashMap<String, String>();

	//List<HashMap<String, String>> mapMaxSkuCode = DatabaseQueries.executeQuery(queriesLauncher.getQueriesMap().get("ARTICLE_INSERT_AFRAME"), wamasHostIpRequested);
	
	
	public HashMap<String, String> getQueriesMap() {


		queriesMap.put("AFRAME_ORDER_INSERT", "SELECT SLM.SLM_ID, SKU.SKU_CODE, L.GEOCODE FROM SKU_LOCATION_MAP SLM INNER JOIN SKU ON SLM.SKU_ID = SKU.SKU_ID INNER JOIN LOCATION L ON L.L_ID = SLM.L_ID WHERE GEOCODE LIKE 'AF%' ORDER BY SKU_CODE");
		
		queriesMap.put("PBL_ORDER_INSERT", "SELECT SLM.SLM_ID, SKU.SKU_CODE, L.GEOCODE FROM SKU_LOCATION_MAP SLM INNER JOIN SKU ON SLM.SKU_ID = SKU.SKU_ID INNER JOIN LOCATION L ON L.L_ID = SLM.L_ID WHERE GEOCODE LIKE 'P%' ORDER BY SKU_CODE");


		return queriesMap;
	}

	public void setQueriesMap(HashMap<String, String> queriesMap) {
		this.queriesMap = queriesMap;
	}
}
