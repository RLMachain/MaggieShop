package machain.com.maggieshop.data;

import org.json.JSONException;
import org.json.JSONObject;

public class DATA_Spinner {
    String valuefield;
    String displayfield;

    public DATA_Spinner(int id, String des) {
        this.valuefield = id+"";
        this.displayfield = des;
    }

    public DATA_Spinner(String id, String des) {
        this.valuefield = id+"";
        this.displayfield = des;
    }

    public DATA_Spinner() {
        this.valuefield = "";
        this.displayfield = "";
    }

    public DATA_Spinner(JSONObject json){
        try {
            this.valuefield=json.getString("valuefield");
            this.displayfield =json.getString("displayfield");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int  getValuefield() {
        return Integer.parseInt(valuefield);
    }

    public String getValueString(){ return valuefield;}

    public void setValuefield(String valuefield) {
        this.valuefield = valuefield;
    }

    public String getDisplayfield() {
        return displayfield;
    }

    public void setDisplayfield(String displayfield) {
        this.displayfield = displayfield;
    }

    //to display object as a string in spinner
    @Override
    public String toString() {
        return displayfield;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof DATA_Spinner){
            DATA_Spinner c = (DATA_Spinner) obj;
            if(c.getDisplayfield().equals(displayfield) && c.getValueString().equals(valuefield )) return true;
        }

        return false;
    }

    public boolean compare(String value){
        return displayfield.equals(value);
    }
}
