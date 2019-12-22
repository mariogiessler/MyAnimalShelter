package model;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import view.messages.MyLogin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import static com.mongodb.client.model.Filters.eq;

// Connection to a Mongo-DB
// on this programm it is a local DB for testing enviroment
// this is choose abstract to make sure of having no instance,
// because of only static methods and no objects

public abstract class Database {
    static MongoClient connection = new MongoClient();
    static MongoDatabase db = connection.getDatabase("AnimalShelter");
    static MongoCollection<Document> collection = db.getCollection("Animals");

    // HashMaqp for the input fields
    private static HashMap<String, Object> formValues = new HashMap<>();

    // setter for adding an animal
    // *** uncommenting the following lines (*) does prohibit to add a animalname twice ***
    public static boolean addAnimal() {
        Document animal = new Document(formValues);
        System.out.println(animal);
        // *        Document doc = collection.find(eq("tiername", animal.get("tiername"))).first();
        if (animal.get("tiername") == null || animal.get("tierart") == null) {
            return false;
            // *       } else if (doc != null) {
            // *            return false;
        } else {
            collection.insertOne(animal);
            return true;
        }
    }

    // getter for the tableview
    // is reading the whole Database
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

    // getter for table filter
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

    // getter for form values (input fields)
    public static HashMap<String, Object> getFormValues() {
        return formValues;
    }

    // clearing the storagee of input datas
    public static void clearFormValues() {
        formValues.clear();
    }

    // to enter the Database to do an entry, you must authorisize yourself
    // notice that you must create a "Users"-Collection in your Mongo-DB
    public static boolean authorize() {
        String[] userData = MyLogin.returnLoginData();
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

