package me.foxtopia.fizzixcore;

import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;;
@TransformerExclusions({"me.foxtopia.fizzix"})
public class fzPluginLoader implements IFMLLoadingPlugin {

	@Override
	public String[] getLibraryRequestClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getASMTransformerClass() {
		// TODO Auto-generated method stub
		return new String[] {"me.foxtopia.fizzix.fzAccessTransformer"};
	}

	@Override
	public String getModContainerClass() {
		// TODO Auto-generated method stub
		return "me.foxtopia.fizzix.fzModContainer";
	}

	@Override
	public String getSetupClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {
		// TODO Auto-generated method stub

	}

}
