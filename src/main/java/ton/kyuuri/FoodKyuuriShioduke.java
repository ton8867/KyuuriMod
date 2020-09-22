package ton.kyuuri;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import ton.main.Core;

public class FoodKyuuriShioduke extends ItemFood{
	public FoodKyuuriShioduke() {
		super(6,5F, false);
		String name="kyuurishioduke";
		this.setUnlocalizedName(name);
		this.setCreativeTab(Core.KyuuriTab);
		this.setMaxStackSize(64);
		this.setTextureName("ton:kyuuri_shio");
		this.setPotionEffect(Potion.regeneration.id,0,0, 1F);
		GameRegistry.registerItem(this, name);
	}
}
