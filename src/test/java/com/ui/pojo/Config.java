package com.ui.pojo;

import java.util.HashMap;
import java.util.Map;

public class Config {
Map<String, Environment> environment =new HashMap<>();

public Map<String, Environment> getEnvironment() {
	return environment;
}

public void setEnvironment(Map<String, Environment> environment) {
	this.environment = environment;
}


}
