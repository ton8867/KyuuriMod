package ton.kyuuri;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ton.achievement.KyuuriAchievements;
import ton.main.Core;

public class FoodKyuuri extends ItemFood{
	public FoodKyuuri() {
		super(5,2F, false);
		String name="kyuuri";
		this.setCreativeTab(Core.KyuuriTab);
		this.setMaxStackSize(64);
		this.setUnlocalizedName(name);
		this.setTextureName("ton:kyuuri");
		GameRegistry.registerItem(this, name);
	}
	@Override
	public ItemStack onEaten(ItemStack itemStack,World world, EntityPlayer player) {
		player.triggerAchievement(KyuuriAchievements.Oishiikyuuri);
		super.onEaten(itemStack, world, player);
		return itemStack;
	}
}
