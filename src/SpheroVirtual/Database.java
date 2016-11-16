package SpheroVirtual;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;

/**
 * Created by Bruno Schalch on 11/16/2016.
 */
public class Database {

    //saves and retrieves data from a text file
    //there are users and there is information associated with each user

    private static final int maxUsers = 1000000;
    private int[] allUsers = new int[maxUsers];

    public Database() {
        //populate allUsers for swift access later

    }

    public boolean createDB (String newUsername, String password) {
        int hashedUser = newUsername.hashCode();
        int hashedPassword = password.hashCode();
        File userDB = new File("./src/trabajandoconimagenes/"+hashedUser+".sdb"); //sphero data base


        return true;
    }

    public boolean openDB(String username, String password) {
        //verify a database exists with such information and open it
        File userDB = new File("./src/trabajandoconimagenes/"+username.hashCode()+".sdb"); //sphero data base
        if (userDB.exists()) {
            InputStream in = null;
            try {
                in = Files.newInputStream(userDB.toPath());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    if (password.hashCode()==Integer.parseInt(line)) { //This is a no go in the real world, password should be stored not as int hash codes but as Cryptographic salted hashes
                        //password matches!!
                        readDB();
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return false;
    }



    private void write() {

    }

    private void readDB() {



    }


}
