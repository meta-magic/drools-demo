package com.driot.service;

import java.io.StringReader;
import java.util.Calendar;

import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Component;

@Component
public class DroolsKSessionUtils {

	public KieSession getKSession(String drl) {
		KieServices ks = KieServices.Factory.get();
		String inMemoryDrlFileName = "src/main/resources/" + Calendar.getInstance().getTimeInMillis() + ".drl";
		KieFileSystem kfs = ks.newKieFileSystem();
		kfs.write(inMemoryDrlFileName, ks.getResources().newReaderResource(new StringReader(drl)).setResourceType(ResourceType.DRL));
		KieBuilder kieBuilder = ks.newKieBuilder(kfs).buildAll();
		if (kieBuilder.getResults().hasMessages(Message.Level.ERROR)) {
			System.err.println(kieBuilder.getResults().toString());
		}
		KieContainer kContainer = ks.newKieContainer(kieBuilder.getKieModule().getReleaseId());
		KieBaseConfiguration kbconf = ks.newKieBaseConfiguration();
		KieBase kbase = kContainer.newKieBase(kbconf);
		return kbase.newKieSession();
	}
}
