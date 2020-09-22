package ton.kyuuri;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import ton.main.Register;

public class KyuuriTab extends CreativeTabs{
	public KyuuriTab(String label) {
		super(label);
	}
	@Override
	public Item getTabIconItem() {
		return Register.Kyuuri;
	}
}
