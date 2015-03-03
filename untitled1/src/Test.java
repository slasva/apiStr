/**
 * Created by vs on 3/3/2015.
 */
public class Test {

    public static void main(String args[]) {
        System.out.println(AnswerTypesEnum.FREE_TEXT);
        new ActiveTaskCreator().create(new Campaign().setTitle("A2T_testApi"), new Answer(), new DataFile());
    }
}
