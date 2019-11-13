import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*
 * Used by MediaLibrary to Load JSON files
 * 
 * @author Matt Kemp
 * @version 1.0
 */
public class MediaLoader {
	private static final String MEDIA_FILE = "src/mediaFile.json";
	
	public static void loadMedia() {
		try {
			FileReader f = new FileReader(MEDIA_FILE);
			JSONParser parse = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(f);
			JSONArray mediaJSON = (JSONArray)jsonData.get("media");
			
			for(int i=0; i < mediaJSON.size(); i++) {
				JSONObject m = (JSONObject)mediaJSON.get(i);
				long id = (long)m.get("id");
				String type = (String)m.get("type");
				String title = (String)m.get("title");
				String pubYear = (String)m.get("pubYear");
				double price = (double)m.get("price");
				String condition = (String)m.get("condition");
				boolean isNewRelease = (boolean)m.get("isNewRelease");
				String genre = (String)m.get("genre");
				int numCopies = Integer.parseInt(m.get("numCopies").toString());
				int numAvailable = Integer.parseInt(m.get("numAvailable").toString());
				//JSONArray[] ratingUsers = (JSONArray[]) m.get("ratingUsers");
				//JSONArray[] ratings  =  (JSONArray[]) m.get("ratings");
				//String[] waitlist = (String[])m.get("waitlist");
				
				MediaLibrary ml = MediaLibrary.getInstance();
				
				switch(type) {
				case  "book" :
					String author = (String)m.get("author");
					String isbn = (String)m.get("isbn");
					String publisher = (String)m.get("publisher");
					Book b = new Book(type, title, pubYear, price, condition, isNewRelease, 
							genre, author, isbn, publisher);
					b.setId(id);
					b.setNumCopies(numCopies);
					b.setNumAvailable(numAvailable);
					/*
					for(int j = 0; j < ratingUsers.length; j++) {
						b.rateMedia(ratingUsers[j].toString(), Double.valueOf(ratings[j].toString()));
					}
					/*for(int j = 0; j < waitlist.length; j++) {
						b.addToWaitList(waitlist[j]);
					}*/
					
					b.rateMedia("Bob", 5.0);
					ml.addNewMedia(b);
					break;
				case "dvd" :
					
					break;
				case "mag" :
					
				}
		        
				}
		} catch (Exception e){
			e.printStackTrace();
		}
		
	}
	public static double[] ratings(JSONArray j) {
		double [] ratings = new double[j.size()];
		for(int i =0; i < j.size(); ++i) {
			ratings[i] = Double.parseDouble(j.toString());
			
		}
		return ratings;
	}
}
