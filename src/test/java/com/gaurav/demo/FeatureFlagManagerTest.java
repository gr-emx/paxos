package com.gaurav.demo;

import com.gaurav.demo.exception.FeatureNotEnabledException;
import com.gaurav.demo.featureflag.FeatureFlagManager;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FeatureFlagManagerTest {
    FeatureFlagManager featureFlagManager = new FeatureFlagManager();
    @Test
    public void testMapWithBoolean(){
        Map<String,Boolean> featureFlagMap = new HashMap<>();
        featureFlagMap.put(this.getClass().getName(),true);
        featureFlagMap.put(Object.class.getName(),false);
        featureFlagManager.setClassEnabled(featureFlagMap);

        //No Exception
        featureFlagManager.isEnabled(this.getClass());

        // Hate the JUnit days of catching exception to swallow and throwing to catch :-(

        try {
            featureFlagManager.isEnabled(Object.class);
            throw new RuntimeException("class objectg is not enabled");
        }
        catch (FeatureNotEnabledException fe){
            // This is expected
        }

    }
    @Test
    public void testNullFeatures(){
        Map<String,Boolean> featureFlagMap = new HashMap<>();

        featureFlagManager.setClassEnabled(featureFlagMap);



        // Hate the JUnit days of catching exception to swallow and throwing to catch :-(

        try {
            featureFlagManager.isEnabled(this.getClass());
            throw new RuntimeException("class objectg is not enabled");
        }
        catch (FeatureNotEnabledException fe){
            // This is expected
        }
    }
}
