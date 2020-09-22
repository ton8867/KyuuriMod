package ton.achievement;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;
import ton.main.Core;
import ton.main.Register;

public class KyuuriAchievements {
	public static Achievement Oishiikyuuri;
	public static Achievement Omatsuridetabereruyatsu;
	public static Achievement utteruyatsu;
	public static Achievement oshio;
	public static void registory(Core mod) {
		Oishiikyuuri = new Achievement("OishiiKyuuri", "OishiiKyuuri",0,0, new ItemStack(Register.Kyuuri,0,0), null);
		oshio=new Achievement("oshio", "oshio", 2, 0, new ItemStack(Register.salt,0,0), Oishiikyuuri);
		Omatsuridetabereruyatsu=new Achievement("Omatsuridetavereruyatsu", "Omatsuridetavereruyatsu",4, 0, new ItemStack(Register.KyuuriShio,0,0), Oishiikyuuri);
		utteruyatsu = new Achievement("utteruyatsu", "utteruyatsu", 2, 1, new ItemStack(Register.comp_kyuuriseed,0,0),Oishiikyuuri);
		 AchievementPage.registerAchievementPage(new AchievementPage("KyuuriMod", new Achievement[] {Oishiikyuuri,Omatsuridetabereruyatsu,utteruyatsu,oshio}));
		MinecraftForge.EVENT_BUS.register(new Event());
		return;
	}
}