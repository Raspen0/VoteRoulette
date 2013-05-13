package com.mythicacraft.votifierlistener.listeners;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.mythicacraft.votifierlistener.VotifierListener;
import com.mythicacraft.votifierlistener.utils.ConfigAccessor;
import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;

public class VoteListener implements Listener {

	ConfigAccessor playerCfg = new ConfigAccessor("players.yml");

	private VotifierListener plugin;

	public VoteListener(VotifierListener plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority=EventPriority.NORMAL)
	public void onVotifierEvent(VotifierEvent event) {
		Vote vote = event.getVote();
		processVote(vote);
	}

	void processVote(Vote vote) {
		String playername = vote.getUsername();
		Player p = plugin.getServer().getPlayerExact(playername);
	}
}
