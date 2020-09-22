package ton.kyuuri;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import ton.main.Register;

public class CropsKyuuri extends BlockCrops implements IPlantable, IGrowable{

	@SideOnly(Side.CLIENT)
	private IIcon[] iIcons;

	public CropsKyuuri() {
		super();
		String name ="kyuuri_crop";
		this.setTickRandomly(true);
		this.setCreativeTab(null);
		this.setHardness(0.0F);
		this.setStepSound(soundTypeGrass);
		this.disableStats();
		GameRegistry.registerBlock(this, name);
	}
	@Override
	protected boolean canPlaceBlockOn(Block block) {
		return block == Blocks.farmland;
	}
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		this.checkAndDropBlock(world, x, y, z);
	}
	@Override
	public IIcon getIcon(int side,int meta) {
		if(meta<5) {
			return this.iIcons[meta>>1];
		}else if(meta<7) {
			return this.iIcons[3];
		}else {
			return this.iIcons[4];
		}
	}
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}
	@Override
	public int quantityDropped(Random random) {
		return 1;
	}
	@Override
	public Item getItemDropped(int meta,Random random,int fortune) {
		if(meta>=7) {
			return this.func_149865_P();
		}else {
			return this.func_149866_i();
		}
	}
	@Override
	protected Item func_149866_i() {
		return Register.kyuuri_seed;
	}
	@Override
	protected Item func_149865_P() {
		return Register.Kyuuri;
	}
	@Override
	public boolean func_149852_a(World world,Random random, int x, int y, int z) {
		return true;
	}
	@Override
	public void func_149853_b(World world, Random random, int x, int y, int z) {
		this.func_149863_m(world, x, y, z);
	}
	@Override
	public void func_149863_m(World world,int x,int y,int z) {
		int l=world.getBlockMetadata(x, y, z)+MathHelper.getRandomIntegerInRange(world.rand, 2, 5);
		if(l>7) {
			l=7;
		}
		world.setBlockMetadataWithNotify(x, y, z, l, 2);
	}
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.iIcons=new IIcon[5];
		for (int i = 0;i<this.iIcons.length;++i) {
			this.iIcons[i]=iconRegister.registerIcon("ton:kyuuri_"+i);
		}
	}
	@Override
	public EnumPlantType getPlantType(IBlockAccess blockac,int x,int y,int z) {
		return EnumPlantType.Crop;
	}
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
}
