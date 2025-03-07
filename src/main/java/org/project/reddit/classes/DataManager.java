package org.project.reddit.classes;

import java.io.*;
import java.util.ArrayList;

public class DataManager
{
    public static void saveData ()
    {
        try (ObjectOutputStream outputStream = new ObjectOutputStream (new FileOutputStream ("Data")))
        {
            outputStream.writeObject (User.getUserList ());
        }
        catch (IOException e)
        {
            e.printStackTrace ();
        }
    }

    public static void loadData ()
    {
        try (ObjectInputStream inputStream = new ObjectInputStream (new FileInputStream ("Data")))
        {
            ArrayList <User> loadedUsers = (ArrayList <User>) inputStream.readObject ();
            User.setUserList (loadedUsers);
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace ();
        }
    }
}
