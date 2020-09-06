package userdata;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class UserDAO {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private String PATH_JSON_FILE = System.getProperty("user.dir") +
            File.separator + "src\\main\\resources\\userdata.json";

    void saveAll(List<User> userList) throws IOException {
        Writer fileWriter = new FileWriter(PATH_JSON_FILE);
        fileWriter.write(gson.toJson(userList));
        fileWriter.close();
    }

    @SuppressWarnings("unchecked")
    public List<User> getAll() throws IOException {
        FileReader fileReader = new FileReader(PATH_JSON_FILE);
        List<User> userList = Arrays.asList(gson.fromJson(fileReader, User[].class));
        fileReader.close();
        return userList;
    }
}
