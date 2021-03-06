package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import model.User;

public class SerializableSave implements Serializable {

//	static String storageDir = "ser";
	static String storage = "src/users.dat";

	public void write(ArrayList<User> users) throws IOException {

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(storage));
		oos.writeObject(users);
		oos.close();
	}

	public static void save(ArrayList<User> users) throws IOException {

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(storage));
		oos.writeObject(users);
		oos.close();
	}

	public static ArrayList<User> read() throws IOException, ClassNotFoundException {

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(storage));
		ArrayList<User> users = (ArrayList<User>) ois.readObject();
		ois.close();
		return users;
	}
}
