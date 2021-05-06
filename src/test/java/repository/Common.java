package repository;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import executor.Runner;
import gherkin.formatter.JSONFormatter;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Common extends Runner{

	RequestSpecification httpRequest = null;
	String jsonresponse = "";
	public void baseURI(String uri) {
		RestAssured.baseURI = uri;
		
		 httpRequest = RestAssured.given();
	}
	
	public void get() {
		 Response response = httpRequest.request(Method.GET);
		 jsonresponse =  response.getBody().asString();
	}
	
	public boolean verifyresponse(String youtubeid) {
		return readjson().contentEquals(youtubeid);
	}
	
	public String readjson() {
		String youtubeid ="";
		JSONParser parser = new JSONParser();
	      try {
	         Object obj = parser.parse(jsonresponse);
	         JSONObject jsonObject = (JSONObject)obj;
	         Object subjects = jsonObject.get("links");
	         JSONObject outs = (JSONObject)subjects;
	         youtubeid = (String) outs.get("youtube_id");
	         System.out.println(youtubeid);
	         return youtubeid;
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	      return youtubeid;
	}
}
