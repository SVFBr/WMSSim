package com.ssi.schaefer.yanbal.order.insert.msgwritter;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.ssi.schaefer.yanbal.util.dbutils.DatabaseQueries;

public class Teste {


	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		 String[] arrEachStation = { "AFP01", "P01", "P02", "P03", "P04", "P05", "P06", "P07", "P08", "P09", "P10", "P11", "P12", "P13", "P14", "P15", "P16", "P17", "P18", "P19", "PDC"};
		
		 for (int i = 0; i < arrEachStation.length ; i++) {
			

			String mapSql = "SELECT SKU.SKU_CODE, L.GEOCODE, L.GEOCODE_DEVICE FROM SKU_LOCATION_MAP SLM INNER JOIN SKU ON SLM.SKU_ID = SKU.SKU_ID INNER JOIN LOCATION L ON L.L_ID = SLM.L_ID WHERE GEOCODE_DEVICE LIKE '" + arrEachStation[i] + "%'";

			List<HashMap<String, String>> map = DatabaseQueries.executeQuery(mapSql, "192.168.173.222");

			System.out.println(arrEachStation[i].toString() + " " + map.toString());
		}

		
	}
}
