package me.gameplax.youtube;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Eventsalle implements Listener {
	
	
	@EventHandler
	public void onPlayerDeathEvent(PlayerDeathEvent event){
		
		Player p = event.getEntity().getPlayer();
		
		event.setDeathMessage(null);
		
		p.setHealth(20);
		p.setFoodLevel(20);
		p.setFireTicks(0);
		
		p.teleport(new Location(Bukkit.getServer().getWorld("world"), -13, 93, 371));
		
	}
	


}
