package ton.main;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import ton.kyuuri.KyuuriTab;

@Mod(modid=Reference.MOD_ID,name=Reference.MOD_NAME,version=Reference.MOD_VERSION)
public class Core {
	public static CreativeTabs KyuuriTab=new KyuuriTab("kyuuri");
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Register.preregistry(this);
	}
	@EventHandler
	public void init(FMLInitializationEvent event) {
		Register.registry(this);
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
