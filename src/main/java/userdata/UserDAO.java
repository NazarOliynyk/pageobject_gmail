package userdata;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private Gson gson = new Gson();

    private String PATH_COOKIES_FILE = System.getProperty("user.dir") +
            File.separator +"src\\main\\resources\\userdata.json";

    @SuppressWarnings("unchecked")
    public void saveAll(List<User> userList) throws Exception {

        JSONArray ja = new JSONArray();
        userList.forEach(a-> ja.add(gson.toJson(a)));
        FileWriter fileWriter = new FileWriter(PATH_COOKIES_FILE);
        fileWriter.write(ja.toJSONString());
        fileWriter.flush();
        fileWriter.close();
    }

    @SuppressWarnings("unchecked")
    public List<User> getAll() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader fileReader = new FileReader(PATH_COOKIES_FILE);
        JSONArray ja = (JSONArray) jsonParser.parse(fileReader);
        List<User> userList = new ArrayList<>();
        ja.forEach(jsonObject-> userList.add(gson.fromJson(jsonObject.toString(), User.class)));
        fileReader.close();
        return userList;
    }
}
