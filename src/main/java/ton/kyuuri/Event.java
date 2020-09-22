package ton.kyuuri;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import ton.achievement.KyuuriAchievements;
import ton.main.Register;

public class Event {
	@SubscribeEvent
	public void EntityItemPickUpEvent (EntityItemPickupEvent e) {
		if (e.entityPlayer != null && e.item != null && e.item.getEntityItem() != null&& e.item.getEntityItem().getItem() == Register.Kyuuri){
			e.entityPlayer.triggerAchievement(KyuuriAchievements.Oishiikyuuri);
		}
	}
}
