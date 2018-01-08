package com.ssi.schaefer.yanbal.order.insert.msgwritter;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.ssi.schaefer.yanbal.util.dbutils.DatabaseQueries;
import com.ssi.schaefer.yanbal.util.tools.Tools;

public class Teste {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

/*		String mapSql = "SELECT * FROM PWX.YANBOG_USER_REG WHERE USERID = '001'";
		List<HashMap<String, String>> map = DatabaseQueries.executeQuery(mapSql, "192.168.173.222");		
		String[] arrEstadoAtual = { map.get(0).get("PBL04"), map.get(0).get("PBL05"), map.get(0).get("PBL06") };
	*/	
		
		String[] arrEstadoAtual = { "false", "true", "true"};
		String[] arrNovoEstado = { "true", "true", "true"};

		//get do  estado atual 
		System.out.print("arrEstadoAtual " );
		for (int i = 0; i < arrEstadoAtual.length; i++) {
			System.out.print(arrEstadoAtual[i].toString() +  ", ");
		}
		System.out.println("\n");
		
		
		//compara estado atual
		for (int i = 0; i < arrEstadoAtual.length; i++) {
			if (!arrNovoEstado[i].equals(arrEstadoAtual[i])) {
				arrEstadoAtual[i] = arrNovoEstado[i];
			}
		}

		//set novo estado 
		System.out.print("arrEstadoAtual ");
		for (int i = 0; i < arrEstadoAtual.length; i++) {
			System.out.print(arrEstadoAtual[i].toString() +  ", ");
		}

	}
}
