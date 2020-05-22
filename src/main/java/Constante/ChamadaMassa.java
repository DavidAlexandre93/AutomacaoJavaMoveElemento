package Constante;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ChamadaMassa {
	
	public JSONObject dadosJson() throws FileNotFoundException, IOException, ParseException {
		JSONObject obj;
		JSONParser parse = new JSONParser();
		obj = (JSONObject) parse.parse(new FileReader("src\\main\\java\\MassaDados\\Programacao.json"));
		
		return obj;
	}

}
