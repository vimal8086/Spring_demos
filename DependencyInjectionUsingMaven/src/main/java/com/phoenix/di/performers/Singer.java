package com.phoenix.di.performers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Singer implements Performer 
{
	
	@Value("A Odha ji.....")
	private String song;
	
	@Override
	public void perform() {
		// TODO Auto-generated method stub
		System.out.println("Singer is singing a song " +song);
	}

}
