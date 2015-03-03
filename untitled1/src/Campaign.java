import com.workfusion.api.TestApi;
import resources.Data;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vs on 3/3/2015.
 */
public class Campaign {

    private String username;
    private String title;
    private String description;
    private String keywords;
    double price;
    private String workforceUUID;
    private boolean isSandbox;
    private int blockSize;
    private int maxAssignment;
    private boolean dynamicTaskRenderingEnabled;
    private String adjudicationRuleUUID;

    private String runUUID = "";
    private String campaignUUID = "";

    //all values
    public Campaign(String userName, String title, String description, String keywords, double price, String workforceUUID, boolean isSandbox, int blockSize, int maxAssignment, boolean dynamicTaskRenderingEnabled, String adjudicationRuleUUID) {
        this.username = userName;
        this.title = title;
        this.description = description;
        this.keywords = keywords;
        this.price = price;
        this.workforceUUID = workforceUUID;
        this.isSandbox = isSandbox;
        this.blockSize = blockSize;
        this.maxAssignment = maxAssignment;
        this.dynamicTaskRenderingEnabled = dynamicTaskRenderingEnabled;
        this.adjudicationRuleUUID = adjudicationRuleUUID;
    }

    //values by default
    public Campaign() {
        try {
            username = Data.userName;
            title = Data.taskName;
            description = Data.taskName;
            keywords = Data.taskName;
            price = 0.0;
            workforceUUID = new TestApi().getWorkforceUUIDByName(Data.cvWorkforceFromDb);
            isSandbox = true;
            blockSize = 1;
            maxAssignment = 1;
            dynamicTaskRenderingEnabled = true;
            adjudicationRuleUUID = new TestApi().getRuleUUIDByIndex("DROOLS", 0); //or something else
        } catch (Exception e) {}
    }

    public String getUserName() {
        return username;
    }

    public Campaign setUserName(String userName) {
        this.username = userName;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Campaign setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Campaign setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getKeywords() {
        return keywords;
    }

    public Campaign setKeywords(String keywords) {
        this.keywords = keywords;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Campaign setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getWorkforceUUID() {
        return workforceUUID;
    }

    public Campaign setWorkforceUUID(String workforceUUID) {
        this.workforceUUID = workforceUUID;
        return this;
    }

    public boolean isSandbox() {
        return isSandbox;
    }

    public Campaign setSandbox(boolean isSandbox) {
        this.isSandbox = isSandbox;
        return this;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public Campaign setBlockSize(int blockSize) {
        this.blockSize = blockSize;
        return this;
    }

    public int getMaxAssignment() {
        return maxAssignment;
    }

    public Campaign setMaxAssignment(int maxAssignment) {
        this.maxAssignment = maxAssignment;
        return this;
    }

    public boolean isDynamicTaskRenderingEnabled() {
        return dynamicTaskRenderingEnabled;
    }

    public Campaign setDynamicTaskRenderingEnabled(boolean isDynamicTaskRenderingEnabled) {
        this.dynamicTaskRenderingEnabled = isDynamicTaskRenderingEnabled;
        return this;
    }

    public String getAdjudicationRuleUUID() {
        return adjudicationRuleUUID;
    }

    public Campaign setAdjudicationRuleUUID(String adjudicationRuleUUID) {
        this.adjudicationRuleUUID = adjudicationRuleUUID;
        return this;
    }

    public String getRunUUID() {
        return runUUID;
    }

    public Campaign setRunUUID(String runUUID) {
        this.runUUID = runUUID;
        return this;
    }

    public String getCampaignUUID() {
        return campaignUUID;
    }

    public Campaign setCampaignUUID(String campaignUUID) {
        this.campaignUUID = campaignUUID;
        return this;
    }

    public HashMap<String, String> getAsMap() {
        Field[] fields = this.getClass().getDeclaredFields();
        HashMap<String, String> map = new HashMap<String, String>();
        for(Field f : fields)
            try {
                map.put(f.getName(), f.get(this).toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        return map;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "userName='" + username + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", keywords='" + keywords + '\'' +
                ", price=" + price +
                ", workforceUUID='" + workforceUUID + '\'' +
                ", isSandbox=" + isSandbox +
                ", blockSize=" + blockSize +
                ", maxAssignment=" + maxAssignment +
                ", isDynamicTaskRenderingEnabled=" + dynamicTaskRenderingEnabled +
                ", adjudicationRuleUUID='" + adjudicationRuleUUID + '\'' +
                ", runUUID='" + runUUID + '\'' +
                ", campaignUUID='" + campaignUUID + '\'' +
                '}';
    }
}
