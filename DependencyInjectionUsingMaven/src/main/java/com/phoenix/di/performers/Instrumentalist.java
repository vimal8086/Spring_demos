package com.phoenix.di.performers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.phoenix.di.instruments.Instrument;

@Component("Pyare_Mohan")
public class Instrumentalist implements Performer {

	//dependency
	@Autowired  // -> used to archive Dependency Injection for complex object
	private Instrument instrument;
	
	@Value("Nile Nile Ambr Pe...")  // -> used to archive Dependency Injection for complex object
	private String song;

	@Override
	public void perform() {
		System.out.println("Instrumentalist is Playing a Song " +song);
		instrument.paly();
	}

	
	

}
