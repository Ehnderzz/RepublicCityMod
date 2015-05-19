package com.tlaminecraft.RepublicCityMod;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener{
	
	 public static Economy economy = null;
	 
	 private boolean setupEconomy(){
	        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
	        if (economyProvider != null) {
	            economy = economyProvider.getProvider();
	        }

	        return (economy != null);
	    }
	 
	 public void onEnalbe(){
		 if(!setupEconomy()){
			 getLogger().severe("PLUGIN REQUIRES VAULT, ERROR SETTING UP ECONOMY");
			 Bukkit.getPluginManager().disablePlugin(this);
			 
		 }
	 }
}
