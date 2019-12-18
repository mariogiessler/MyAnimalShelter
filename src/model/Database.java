package model;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.HashMap;
import java.util.Iterator;

import static com.mongodb.client.model.Filters.eq;

public abstract class Database {
    static MongoClient connection = new MongoClient();
    static MongoDatabase db = connection.getDatabase("AnimalShelter");
    static MongoCollection<Document> collection = db.getCollection("Animals");
    private static HashMap<String, Object> formValues = new HashMap<>();

    public Database() {
    }

    public static boolean addAnimal() {
        Document animal = new Document(formValues);
        Document doc = collection.find(eq("tiername", animal.get("tiername"))).first();
        if (doc != null) {
            return false;
        } else {
            collection.insertOne(animal);
            return true;
        }
    }

    public static Object[][] getAnimals() {
        Object[][] Animals = new Object[(int) collection.count()][];
        Iterator<Document> it = collection.find().iterator();
        int i = 0;
        while (it.hasNext()) {
            Document Animal = it.next();
            Animals[i] = new Object[]{Animal.get("tiername"), Animal.get("tierart"), Animal.get("rasse"), Animal.get("alter"), Animal.get("geschlecht"), Animal.get("farbe")};
            i++;
        }
        return Animals;
    }

    public static HashMap<String, Object> getFormValues() {
        return formValues;
    }

    public static void clearFormValues() {
        formValues.clear();
    }
}

