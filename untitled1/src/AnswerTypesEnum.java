/**
 * Created by vs on 3/3/2015.
 */
public enum AnswerTypesEnum {

    FREE_TEXT("FREE_TEXT"), LONG_TEXT("longText");

    String textValue;

    AnswerTypesEnum(String textValue){
        this.textValue = textValue;
    }

    @Override
    public String toString() {
        return textValue;
    }
}
