import resources.Data;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vs on 3/3/2015.
 */
public class DataFile {

    private String file;
    private String runUUID = "";
    private String type;

    public DataFile(String pathToFile, String runUUID, DataTypesEnum dataTypeEnum) {
        this.file = pathToFile;
        this.runUUID = runUUID;
        this.type = dataTypeEnum.toString();
    }

    public DataFile() {
        this.file = Data.taskDataFilePriority1;
        this.type = DataTypesEnum.MAIN_DATA.toString();
    }

    public String getPathToFile() {
        return file;
    }

    public DataFile setPathToFile(String pathToFile) {
        this.file = pathToFile;
        return this;
    }

    public String getRunUUID() {
        return runUUID;
    }

    public DataFile setRunUUID(String runUUID) {
        this.runUUID = runUUID;
        return this;
    }

    public String getDataType() {
        return type;
    }

    public DataFile setDataType(String dataType) {
        this.type = dataType;
        return this;
    }

    public Map<String, String> getAsMap() {
        Field[] fields = this.getClass().getDeclaredFields();
        Map<String, String> map = new HashMap<String, String>();
        for(Field f : fields)
            try {
                System.out.println(f.getName() + " " + f.get(this).toString());

                map.put(f.getName(), f.get(this).toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        return map;
    }

    @Override
    public String toString() {
        return "DataFile{" +
                "pathToFile='" + file + '\'' +
                ", runUUID='" + runUUID + '\'' +
                ", dataType='" + type + '\'' +
                '}';
    }
}
