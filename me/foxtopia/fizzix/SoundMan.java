package me.foxtopia.fizzix;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class SoundMan {

	@ForgeSubscribe
	public void onSound(SoundLoadEvent ev)
	{
		try
		{
		ev.manager.soundPoolSounds.addSound("rockslide.wav", Fizzix.class.getResource("rockslide.wav"));
	
		}
		catch(Exception e)
		{
		System.err.println("Failed to register one or more sounds.");
		}
	}
}
