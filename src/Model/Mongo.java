package Model;

import Control.Controller;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class Mongo {
	static MongoClient connection = new MongoClient();
	static MongoDatabase db = connection.getDatabase("AnimalShelter");
	static MongoCollection<Document> collection = db.getCollection("Animals");
	private static String[] tableTitles;
	private static ArrayList<ArrayList<Object>> dataSet;
	private Document entries;

	public Mongo() {
	}

	public static void addAnimal() {
		Document animal = new Document(Controller.getFormValues());
		collection.insertOne(animal);
		System.out.println(animal.values());
	}

	public static String[] getTableTitles() {
		return tableTitles = collection.find().first().keySet().toArray(new String[0]);
	}

	public static void getTableContent() {
		MongoCursor<Document> table = collection.find().iterator();
		dataSet = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> dataContent = new ArrayList<>();
		while (table.hasNext()) {

			dataContent.addAll(table.next().values());


		}
		dataSet.add(dataContent);
		for (ArrayList<Object> i : dataSet) {
			for (Object j : i) {
				System.out.println(i);
			}
		}

	}


}

