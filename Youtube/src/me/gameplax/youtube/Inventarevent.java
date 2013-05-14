package me.gameplax.youtube;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class Inventarevent implements Listener {
	
	
	@EventHandler
	public void Inventory(InventoryClickEvent event){
		Player p = (Player) event.getWhoClicked();
		
		
		if(event.getInventory().getName().equalsIgnoreCase("Kits")){
			event.setCancelled(true);
			
			if(event.getCurrentItem().getType() == Material.BOW){
				
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				p.getInventory().addItem(new ItemStack(Material.BOW, 1));
				p.getInventory().addItem(new ItemStack(Material.ARROW, 25));
				
				
				event.getView().close();
				
				
			}else if(event.getCurrentItem().getType() == Material.STONE_SWORD){
				
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				p.getInventory().addItem(new ItemStack(Material.STONE_SWORD, 1));
				
				event.getView().close();
				
				
			}

		}
		
	}

	
}
