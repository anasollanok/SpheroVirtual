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
    int hashedUser;
    int hashedPassword;

    public Database() {
        //populate allUsers for swift access later
        File usersDB = new File("./src/SpheroVirtual/DATA/hashedUsers.txt"); //simple text format
        if (usersDB.exists()) {
            InputStream in = null;
            try {
                in = Files.newInputStream(usersDB.toPath());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] hashedUserandPassword = line.split(",");
                    int userHash = Integer.parseInt(hashedUserandPassword[0]);
                    allUsers[userHash % maxUsers] = Integer.parseInt(hashedUserandPassword[1]); //% is never done before storing, only after reading to support changes in maxUsers size
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean createDB (String newUsername, String password) {
        hashedUser = newUsername.hashCode();
        hashedPassword = password.hashCode();



        return true;
    }

    public boolean deleteDB() {
        return false;
    }

    public boolean openDB(String username, String password) {
        hashedUser=username.hashCode();
        hashedPassword=password.hashCode();
        //verify a database exists with such information and open it
        File userDB = new File("./src/SpheroVirtual/DATA/"+password.hashCode()+".sdb"); //sphero data base
        if (allUsers[hashedUser%maxUsers]==hashedPassword && userDB.exists()) {
            readUserDB(userDB); //password match and there are saved sessions
        }

        return false;
    }



    private void writeUserDB() {
        File userDB = new File("./src/SpheroVirtual/DATA/"+hashedUser+".sdb"); //sphero data base
    }

    private void readUserDB(File userDB) {
        InputStream in = null;
        try {
            in = Files.newInputStream(userDB.toPath());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = reader.readLine()) != null) {
                    //get sessions info
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
