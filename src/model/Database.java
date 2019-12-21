package model;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import view.messages.MyLogin;
import view.sites.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import static com.mongodb.client.model.Filters.eq;

public abstract class Database {
    static MongoClient connection = new MongoClient();
    static MongoDatabase db = connection.getDatabase("AnimalShelter");
    static MongoCollection<Document> collection = db.getCollection("Animals");
    private static HashMap<String, Object> formValues = new HashMap<>();

    public static boolean addAnimal() {
        Document animal = new Document(formValues);
        System.out.println(animal);
//        Document doc = collection.find(eq("tiername", animal.get("tiername"))).first();
        if (animal.get("tiername") == null || animal.get("tierart") == null) {
            return false;
//        } else if (doc != null) {
//            return false;
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

    public static Object[][] getAnimals(String arg) {
        MongoIterable<Document> documents = collection.find();
        Iterator<Document> it = documents.iterator();
        ArrayList<Document> Animals = new ArrayList<>();
        while (it.hasNext()) {
            Document Animal = it.next();
            for (Object value : Animal.values()) {
                if (value instanceof String && ((String) value).toLowerCase().contains(arg.toLowerCase())) {
                    Animals.add(Animal);
                    break;
                }
            }
        }
        Object[][] result = new Object[Animals.size()][];
        for (int i = 0; i < Animals.size(); i++) {
            result[i] = new Object[]{Animals.get(i).get("tiername"), Animals.get(i).get("tierart"), Animals.get(i).get("rasse"), Animals.get(i).get("alter"), Animals.get(i).get("geschlecht"), Animals.get(i).get("farbe")};
        }
        return result;
    }

    public static HashMap<String, Object> getFormValues() {
        return formValues;
    }

    public static void clearFormValues() {
        formValues.clear();
    }

    public static boolean authorize() {
        String[]userData= MyLogin.returnLoginData();
        MongoCollection<Document> users = db.getCollection("Users");
        if (userData[0] == null || userData[1] == null) {
            return false;
        }
        Document user = users.find(eq("name", userData[0])).first();
        if (user != null && user.get("password").equals(userData[1])) {
            return true;
        }
        return false;
    }
}

