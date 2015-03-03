/**
 * Created by vs on 3/3/2015.
 */
public abstract class Task {

    public Answer answer;
    public Campaign campaign;
    private DataFile dataFile;

    public String runUUID;

    protected Task(Answer answer, Campaign campaign, DataFile dataFile) {
        this.answer = answer;
        this.campaign = campaign;
        this.dataFile = dataFile;
    }
}
