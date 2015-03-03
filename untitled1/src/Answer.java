import resources.Data;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vs on 3/3/2015.
 */
public class Answer {

    private String runUUID;
    private String answerName;
    private String answerType;
    private String answerCode;
    private String description;
    private String options;
    private boolean required;
    private boolean allowNA;
    private boolean nonAdjudicated;
    private String defaultValue;

    private String answerId = "";

    public Answer(String runUUID, String answerName, AnswerTypesEnum answerTypesEnum, String answerCode, String description, String options, boolean isRequired, boolean isAllowNA, boolean isNonAdjudicated, String defaultValue) {
        this.runUUID = runUUID;
        this.answerName = answerName;
        this.answerType = answerTypesEnum.FREE_TEXT.toString();
        this.answerCode = answerCode;
        this.description = description;
        this.options = options;
        this.required = isRequired;
        this.allowNA = isAllowNA;
        this.nonAdjudicated = isNonAdjudicated;
        this.defaultValue = defaultValue;
    }

    public Answer() {
        this.runUUID = "";
        this.answerName = Data.answerCode;
        this.answerType = AnswerTypesEnum.FREE_TEXT.toString();
        this.answerCode = Data.answerCode;
        this.description = Data.answerDescription;
        this.options = "";
        this.required = false;
        this.allowNA = false;
        this.nonAdjudicated = false;
        this.defaultValue = "";
    }


    public String getRunUUID() {
        return runUUID;
    }

    public Answer setRunUUID(String runUUID) {
        this.runUUID = runUUID;
        return this;
    }

    public String getAnswerName() {
        return answerName;
    }

    public Answer setAnswerName(String answerName) {
        this.answerName = answerName;
        return this;
    }

    public String getAnswerType() {
        return answerType;
    }

    public Answer setAnswerType(String answerType) {
        this.answerType = answerType;
        return this;
    }

    public String getAnswerCode() {
        return answerCode;
    }

    public Answer setAnswerCode(String answerCode) {
        this.answerCode = answerCode;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Answer setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getOptions() {
        return options;
    }

    public Answer setOptions(String options) {
        this.options = options;
        return this;
    }

    public boolean isRequired() {
        return required;
    }

    public Answer setRequired(boolean isRequired) {
        this.required = isRequired;
        return this;
    }

    public boolean isAllowNA() {
        return allowNA;
    }

    public Answer setAllowNA(boolean isAllowNA) {
        this.allowNA = isAllowNA;
        return this;
    }

    public boolean isNonAdjudicated() {
        return nonAdjudicated;
    }

    public Answer setNonAdjudicated(boolean isNonAdjudicated) {
        this.nonAdjudicated = isNonAdjudicated;
        return this;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public Answer setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    public String getAnswerId() {
        return answerId;
    }

    public Answer setAnswerId(String answerId) {
        this.answerId = answerId;
        return this;
    }

    public HashMap<String, String> getAsMap() {
        Field[] fields = this.getClass().getDeclaredFields();
        HashMap<String, String> map = new HashMap<String, String>();
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
        return "Answer{" +
                "runUUID='" + runUUID + '\'' +
                ", answerName='" + answerName + '\'' +
                ", answerType='" + answerType + '\'' +
                ", answerCode='" + answerCode + '\'' +
                ", description='" + description + '\'' +
                ", options='" + options + '\'' +
                ", isRequired=" + required +
                ", isAllowNA=" + allowNA +
                ", isNonAdjudicated=" + nonAdjudicated +
                ", defaultValue='" + defaultValue + '\'' +
                '}';
    }
}
