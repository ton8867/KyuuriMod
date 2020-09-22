package ton.kyuuri;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import ton.main.Core;
import ton.main.Register;

public class SeedKyuuri extends ItemSeeds implements IPlantable{
	public SeedKyuuri() {
		super(Register.kyuuricrop, Blocks.farmland);
		String name ="kyuuri_seed";
		this.setCreativeTab(Core.KyuuriTab);
		this.setMaxStackSize(64);
		this.setTextureName("ton:kyuuri_seed");
		this.setUnlocalizedName(name);
		GameRegistry.registerItem(this, name);
	}
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return EnumPlantType.Crop;
	}
	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		return 0;
	}
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (side != 1) {
			return false;
		} else if (player.canPlayerEdit(x, y, z, side, itemStack) && player.canPlayerEdit(x, y + 1, z, side, itemStack)) {
			if (world.getBlock(x, y, z).canSustainPlant(world, x, y, z, ForgeDirection.UP, this) && world.isAirBlock(x, y + 1, z)) {
				world.setBlock(x, y + 1, z, Register.kyuuricrop);
				--itemStack.stackSize;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		return Register.kyuuricrop;
	}
}
