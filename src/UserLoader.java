import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class UserLoader {
	private static final String People = "file.json";
	
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
				
				switch(type) {
				case  "P" :
					Users.addUser(new PersonalUser(firstName, lastName, 
							phoneNumber, address,email, Double.valueOf(fines)));
					break;
				case "L" :
					Users.addUser(new Librarian(firstName, lastName, 
							phoneNumber, address,email, Double.valueOf(fines)));
					break;
				case "T" :
					Users.addUser(new Teacher(firstName, lastName, 
							phoneNumber, address,email, Double.valueOf(fines)));
				}
		        
				}
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
