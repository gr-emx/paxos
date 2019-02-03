package com.gaurav.demo.featureflag;

import com.gaurav.demo.exception.FeatureNotEnabledException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FeatureFlagManager {
    @Value("#{${classEnabled}}")
    private Map<String, Boolean> classEnabled;

    public void isEnabled(Class clazz) {

        if (classEnabled.get(clazz.getName()) == null || !classEnabled.get(clazz.getName())) {
            throw new FeatureNotEnabledException();
        }

    }

    public Map<String, Boolean> getClassEnabled() {
        return classEnabled;
    }

    public void setClassEnabled(Map<String, Boolean> classEnabled) {
        this.classEnabled = classEnabled;
    }
}
