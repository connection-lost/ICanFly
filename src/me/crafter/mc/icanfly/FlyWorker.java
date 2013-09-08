package me.crafter.mc.icanfly;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;

public class FlyWorker implements Listener {
	
	public void flyXYZ(Player p, float x, float y, float z){
		Vector vec = new Vector();
		vec.setX(x);
		vec.setY(y);
		vec.setZ(z);
		p.setVelocity(vec);
	}
	
	public void flyForward(Player p, float str){
		
		double up = (-p.getLocation().getPitch() * Math.PI / 180.0);
		double yaw = (p.getLocation().getYaw() * Math.PI / 180.0);
		
		if (up < 0.2F){
			up = 0.2F;
		}
		
		Vector vec = new Vector(-Math.cos(up) * Math.sin(yaw) * str * 5, Math.sin(up) * str, Math.cos(up) * Math.cos(yaw) * str * 5);
		
		p.setVelocity(vec);
		
	}

}


