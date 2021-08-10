package com.phoenix.di.performers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.phoenix.di.instruments.Instrument;

/*
 * version 3.0
 * creation date 4-aug-2021
 */
public class Instrumentalist implements Performer {

	//dependency
	@Autowired  // -> used to archive Dependency Injection for complex object
	private Instrument instrument;
	
	@Value("Awara hu...")  // -> used to archive Dependency Injection for complex object
	private String song;

	@Override
	public void perform() {
		System.out.println("Instrumentalist is Playing a Song " +song);
		instrument.paly();
	}

	
	

}
