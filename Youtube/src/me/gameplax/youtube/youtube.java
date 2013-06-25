package me.gameplax.youtube;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;


public class youtube extends JavaPlugin {
	private Inventory inv=null;
	public static Economy economy = null;
	public youtube plugin;
	
	@Override
	public void onDisable() {
		System.out.println("Youtube Disable!");
	}
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Inventarevent(), this);
		getServer().getPluginManager().registerEvents(new Eventsalle(), this);
		System.out.println("Youtube Enable!");			
		
		
		//Bungee Cord
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	}
	
	private boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
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
	 
	 if(cmd.getName().equalsIgnoreCase("lobby")){
		 
		 if(sender instanceof Player){
			 int price = 10;
			 if(this.economy.has(p.getName(), price)){
			 
			 Player pp = (Player) sender;
			 ByteArrayOutputStream b = new ByteArrayOutputStream();
			 DataOutputStream out = new DataOutputStream(b);
			 try{
				 out.writeUTF("Connect");
				 out.writeUTF("lobby");
			 }catch (IOException eee){
				 
			 }
			 pp.sendPluginMessage(this, "BungeeCord", b.toByteArray());
			 
			 this.economy.withdrawPlayer(p.getName(), price);
			 
			 }else {
				 p.sendMessage(ChatColor.YELLOW + "Du hast nicht genug " + this.economy.currencyNamePlural());
				 p.sendMessage(ChatColor.YELLOW + "Du brauchst " + price + this.economy.currencyNamePlural());
			 }
		 }
		 
		 
	 }
	 
	 if(cmd.getName().equalsIgnoreCase("open")){
		 if(args.length == 1){
			 if(args[0].equalsIgnoreCase("ender")){
				 p.openInventory(p.getEnderChest());
			 }else if(args[0].equalsIgnoreCase("chant")){
				 p.openEnchanting(null, true);
			 }
			 
		 }else if(args.length == 0){
			 p.sendMessage(ChatColor.YELLOW + "Benutz /open <ender/chant>");
		 }
	 }
	 if(cmd.getName().equalsIgnoreCase("outfit")){
		 if(args.length == 3){
			 if(args[0].equalsIgnoreCase("leder")){
				 if(args[1].equalsIgnoreCase("rot")){
					 p.getInventory().setArmorContents(null);
					 
					 ItemStack item1 = new ItemStack(Material.LEATHER_HELMET);
					 LeatherArmorMeta meta1 = (LeatherArmorMeta) item1.getItemMeta();
					 meta1.setColor(Color.RED);
					 item1.setItemMeta(meta1);
					 ItemMeta imeta1 = item1.getItemMeta();
					 p.getInventory().setHelmet(new ItemStack(item1));
					 
					 
				 }
			 }
		 }
	 }
	 
	 

	return erfolg;
	}
	

}
