package testePratico3.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class AdvantageShoppingQuerys extends ConnectionFactory {
	private Connection connect;
	private Statement statement;
	private ResultSet results;
	private Map<String, String> resultMap;
	private String[] productSpecificationsDB = { "CUSTOMIZATION", "DISPLAY", "DISPLAY_RESOLUTION", "MEMORY",
			"OPERATING_SYSTEM", "PROCESSOR", "TOUCHSCREEN", "WEIGHT" };
	private String[] colorsDB = { "COLOR" };
	private String[] nameProductDB = { "NAME_PRODUCT" };

	public AdvantageShoppingQuerys() {
		ConnectionFactory connection = new ConnectionFactory();
		connect = connection.getConnection();
	}

	public static Map<String, String> mapResultDBGenerator(ResultSet results, String[] collunms) throws SQLException {
		Map<String, String> resultado = new HashMap<String, String>();
		if (!results.next()) {
			return resultado;
		}
		String result;
		for (String collunm : collunms) {
			if (results.isAfterLast())
				results.next();
			result = results.getString(collunm);
			resultado.put(collunm, result);
		}
		mapResultDBGenerator(results, collunms);
		return resultado;
	}

	public Map<String, String> productSpecificationsSelect() {
		String sql = "SELECT CUSTOMIZATION, DISPLAY, DISPLAY_RESOLUTION, MEMORY,OPERATING_SYSTEM,PROCESSOR,TOUCHSCREEN,WEIGHT FROM massas";
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(sql);
			resultMap = new HashMap<String, String>();
			resultMap = mapResultDBGenerator(results, productSpecificationsDB);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultMap;
	}
	
	public Map<String, String> corSelect() {
		String sql = "SELECT COLOR FROM massas";
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(sql);
			resultMap = new HashMap<String, String>();
			resultMap = mapResultDBGenerator(results, colorsDB);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultMap;
	}
	
	public Map<String, String> nameProductSelect() {
		String sql = "SELECT NAME_PRODUCT FROM massas";
		try {
			statement = connect.createStatement();
			results = statement.executeQuery(sql);
			resultMap = new HashMap<String, String>();
			resultMap = mapResultDBGenerator(results, nameProductDB);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultMap;
	}

	public boolean updateCorSelecionada(String column, String nome) {
		String sql = "UPDATE massas SET " + column + " = '" + nome + "' " + " WHERE IDMASSAS = 2";
		try {
			statement = connect.createStatement();
			int retorno = statement.executeUpdate(sql);
			if (retorno > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
