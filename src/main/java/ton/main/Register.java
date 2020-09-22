package ton.main;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import ton.achievement.KyuuriAchievements;
import ton.kyuuri.CropsKyuuri;
import ton.kyuuri.FoodKyuuri;
import ton.kyuuri.FoodKyuuriShioduke;
import ton.kyuuri.SeedKyuuri;

public class Register {
	public static Item salt;
	public static Item water_saltbottle;
	public static Item comp_kyuuriseed;
	public static ItemSeeds kyuuri_seed;
	public static ItemFood Kyuuri;
	public static ItemFood KyuuriShio;
	public static Block kyuuricrop;
	public static void preregistry(Core mod) {
		salt=new Item() {
			@Override
			public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
				player.triggerAchievement(KyuuriAchievements.oshio);
			};
		}.setCreativeTab(Core.KyuuriTab).setMaxStackSize(64).setTextureName("ton:salt").setUnlocalizedName("salt");
		GameRegistry.registerItem(salt, "salt");
		Kyuuri=new FoodKyuuri();
		KyuuriShio=new FoodKyuuriShioduke() {
			@Override
			public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
				player.triggerAchievement(KyuuriAchievements.Omatsuridetabereruyatsu);
			};
		};
		water_saltbottle=new Item().setCreativeTab(Core.KyuuriTab).setMaxStackSize(64).setTextureName("ton:water_saltbottle").setUnlocalizedName("water_saltbottle");
		kyuuri_seed=new SeedKyuuri();
		GameRegistry.registerItem(water_saltbottle, "water_saltbottle");
		comp_kyuuriseed=new Item() {
			@Override
			public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
				player.triggerAchievement(KyuuriAchievements.utteruyatsu);
			};
		}.setTextureName("ton:compressed_kyuuri_seed").setCreativeTab(Core.KyuuriTab).setMaxStackSize(64).setUnlocalizedName("kyuuri_seed_comp");
		GameRegistry.registerItem(comp_kyuuriseed, "kyuuri_seed_comp");
		kyuuricrop=new CropsKyuuri();
		KyuuriAchievements.registory(mod);
	}
	public static void registry(Core mod) {
		GameRegistry.addSmelting(water_saltbottle, new ItemStack(salt,1), 0.1F);
		GameRegistry.addShapelessRecipe(new ItemStack(KyuuriShio,1),Kyuuri,salt.setContainerItem(Items.glass_bottle));
		GameRegistry.addShapelessRecipe(new ItemStack(water_saltbottle,1), Items.water_bucket.setContainerItem(Items.bucket),Items.glass_bottle);
		GameRegistry.addShapelessRecipe(new ItemStack(kyuuri_seed, 9),comp_kyuuriseed);
		GameRegistry.addRecipe(new ItemStack(comp_kyuuriseed,1),"XXX","XXX","XXX",'X',kyuuri_seed);
		GameRegistry.addShapelessRecipe(new ItemStack(kyuuri_seed,3), Kyuuri);
		MinecraftForge.addGrassSeed(new ItemStack(kyuuri_seed,1), 3);
		}
}
