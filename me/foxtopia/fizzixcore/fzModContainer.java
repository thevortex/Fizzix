package me.foxtopia.fizzixcore;


	import java.util.Arrays;
import java.util.Random;

import net.minecraft.block.Block;

	import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

	import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

	public class fzModContainer extends DummyModContainer {
	        public fzModContainer() {
	            super(new ModMetadata());
                /* ModMetadata is the same as mcmod.info */
                ModMetadata myMeta = super.getMetadata();
                myMeta.authorList = Arrays.asList(new String[] { "thevortex" });
                myMeta.description = "";
                myMeta.modId = "Fizzex-Core";
                myMeta.version = "1.0";
                myMeta.name = "AccessTransformer";
                myMeta.url = "";
	        }
	        
	        public boolean registerBus(EventBus bus, LoadController controller) {
	        bus.register(this);
	        return true;
	        }
	        /* 
	         * Use this in place of @Init, @Preinit, @Postinit in the file.
	         */
	        @Subscribe                 /* Remember to use the right event! */
	        public void onServerStarting(FMLServerStartingEvent ev) {
	               	                
	        }
	        
}
