import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class UserLoader {
	private static final String People = "src/Users.json";
	
	public static void loadUsers() {
		try {
			FileReader f = new FileReader(People);
			JSONParser parse = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(f);
			JSONArray peopleJSON = (JSONArray)jsonData.get("users");
			
			for(int i=0; i < peopleJSON.size(); i++) {
				JSONObject personJSON = (JSONObject)peopleJSON.get(i);
				String firstName = (String)personJSON.get("firstName");
				String lastName = (String)personJSON.get("lastName");
				String phoneNumber = (String)personJSON.get("phoneNumber");
				String email = (String)personJSON.get("email");
				String address = (String)personJSON.get("address");
				String type = (String)personJSON.get("type");
				String fines = (String) personJSON.get("fines").toString();
				String username = (String) personJSON.get("username");
				String password = (String) personJSON.get("password");
				User u;
				
				switch(type) {
				case  "P" :
					u = new PersonalUser(firstName, lastName, 
							phoneNumber, address,email, Double.valueOf(fines));
					u.setUserName(username);
					u.setPassword(password);
					Users.addUser(u);
					
					break;
				case "L" :
					u = new Librarian(firstName, lastName, 
							phoneNumber, address,email, Double.valueOf(fines));
					u.setUserName(username);
					u.setPassword(password);
					Users.addUser(u);
					break;
				case "T" :
					u = new Teacher(firstName, lastName, 
							phoneNumber, address,email, Double.valueOf(fines));
					u.setUserName(username);
					u.setPassword(password);
					Users.addUser(u);
				}
		        
				}
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}