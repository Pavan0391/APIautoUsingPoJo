package api.endPoints;

import java.io.*;
import java.util.*;

import org.json.JSONObject;


/*Swagger URL--> https://petstore.swagger.io
 
 Create(post): https://petstore.swagger.io/v2/user
 Get user(Get): https://petstore.swagger.io/v2/user/{username}
 Update user(put): https://petstore.swagger.io/v2/user/{username}
 Delete user (Delete): https://petstore.swagger.io/v2/user/{username}
 */

public class Routes {

	public static String base_url= "https://petstore.swagger.io/v2";
	
	//user module
	public static String post_url= base_url+"/user";
	public static String get_url= base_url+"/user/{username}";
	public static String update_url= base_url+"/user/{username}";
	public static String delete_url= base_url+"/user{username}";
	 
	
	
//	UserEndPoints parser = new UserEndPoints();
//    
//    	Object obj = parser.parse(new FileReader("C:/Users/pavan.t/Desktop/url.json"));
//      
//       JSONObject jsonObject = (JSONObject)obj;
//       String post = (String)jsonObject.get("post_url");
//       String get = (String)jsonObject.get("get_url");
//       String update = (String)jsonObject.get("update_url");
//       String delete = (String)jsonObject.get("delete_url");

} 
