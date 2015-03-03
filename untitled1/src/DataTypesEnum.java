/**
 * Created by vs on 3/3/2015.
 */
public enum DataTypesEnum {

    MAIN_DATA("MAIN_DATA"), GOLD_DATA("GOLD_DATA");

    private String textValue;

    DataTypesEnum(String textValue) {
        this.textValue = textValue;
    }

    @Override
    public String toString() {
        return textValue;
    }
}
