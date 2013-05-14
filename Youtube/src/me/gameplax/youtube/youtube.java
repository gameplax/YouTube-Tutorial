package me.gameplax.youtube;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;


public class youtube extends JavaPlugin {
	private Inventory inv=null;
	
	@Override
	public void onDisable() {
		System.out.println("Youtube Disable!");
	}
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Inventarevent(), this);
		System.out.println("Youtube Enable!");			
	}
	
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
	 boolean erfolg = false;
	 
	 Player p = (Player) sender;
	 
	 
	 if (cmd.getName().equalsIgnoreCase("kit")){
			if (args.length == 0){
				
				inv = p.getPlayer().getServer().createInventory(null, 9, "Kits");
				
					ItemStack istack = new ItemStack(Material.BOW, 1);
					ItemMeta istackMeta = istack.getItemMeta();
					istackMeta.setDisplayName("Archer");
					istack.setItemMeta(istackMeta);
				
					ItemStack istack2 = new ItemStack(Material.STONE_SWORD, 1);
					ItemMeta istackMeta2 = istack.getItemMeta();
					istackMeta2.setDisplayName("Solieder");
					istack2.setItemMeta(istackMeta2);
				
					
					inv.setItem(2, istack);
					inv.setItem(4, istack2);
				
				
					p.getPlayer().openInventory(inv);
					
					erfolg = true;
			}

	 }

	return erfolg;
	}

}
