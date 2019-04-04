package xyl.dyx.service;

import com.google.gson.FieldAttributes;

import java.util.List;

public class Exclusion implements com.google.gson.ExclusionStrategy {

    private List<String> skip;

    public Exclusion(List<String> skip) {
        this.skip = skip;
    }
    //此为转json的字段,当字段名与数组中的某个值一致时,不进行转json
    @Override
    public boolean shouldSkipField(FieldAttributes fa) {
        for (String s : skip) {
            if(s.equals(fa.getName())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> arg0) {
        // TODO Auto-generated method stub
        return false;
    }
}
