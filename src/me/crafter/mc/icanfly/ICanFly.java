package me.crafter.mc.icanfly;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ICanFly extends JavaPlugin {

	public final Logger logger = Logger.getLogger("Mincraft");
	public final FlyWorker pl = new FlyWorker();
	public FlyWorker fw = new FlyWorker();
	

    public void onEnable(){
    	this.logger.info("Plugin made by connection_lost. www.crafter.me");
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this.pl, this);
        }
 

    public void onDisable() {
    }


    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, final String[] args){
    	
    	Player p = (Player)sender;
    	
    	if (cmd.getName().equals("getyp")){
    		p.sendMessage("Yaw: "+p.getLocation().getYaw()+"  Pitch: "+p.getLocation().getPitch());
    		return true;
    	}
    	
    	if (cmd.getName().equals("flyf")){
    		
    		if (args.length != 1){
    			p.sendMessage(ChatColor.RED+"/flyf velocity");
    			return true;
    		}
    		fw.flyForward(p, Float.valueOf(args[0]));
    		return true;
    	}
    	
		return true;    	
    }
	
    
}
