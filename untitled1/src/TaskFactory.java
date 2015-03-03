import com.workfusion.api.ApiAdapter;
import com.workfusion.api.ApiMessage;
import com.workfusion.api.TestApi;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vs on 3/3/2015.
 */
public class TaskFactory{};

class DraftTaskCreator extends TaskCreator {

}

class ActiveTaskCreator extends  TaskCreator {
    @Override
    public Task create(Campaign campaign, Answer answer, DataFile dataFile){
        Task task = super.create(campaign, answer, dataFile);
        try {
            ApiMessage.startRun(new HashMap<String, String>());
        } catch (Exception e) {

        }
        return task;
    }
}


abstract class TaskCreator {

    public Task create(Campaign campaign, Answer answer, DataFile dataFile) {
        Map<String, String> mapResponse;
        String stringResponse;
        TestApi testApi = new TestApi();
        try {
            mapResponse = testApi.createTask(campaign.getAsMap());
            campaign.setRunUUID(mapResponse.get("runUUID"));
            campaign.setCampaignUUID(mapResponse.get("runUUID"));

            answer.setRunUUID(campaign.getRunUUID());
            stringResponse = testApi.addAnswer(answer.getAsMap());
            answer.setAnswerId(stringResponse);


            testApi.uploadData(dataFile.getPathToFile(), campaign.getRunUUID(), dataFile.getDataType());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new DraftTask(answer, campaign, dataFile);
    }
}

class DraftTask extends Task {

    DraftTask(Answer answer, Campaign campaign, DataFile dataFile) {
        super(answer, campaign, dataFile);
    }
}
class ActiveTask extends Task {

    ActiveTask(Answer answer, Campaign campaign, DataFile dataFile) {
        super(answer, campaign, dataFile);
    }
}
