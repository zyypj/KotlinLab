package com.github.zyypj.kotlinLab.listeners

import com.github.zyypj.kotlinLab.LabPlugin
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerListeners(
    private val plugin: LabPlugin
) : Listener {

    @EventHandler
    fun onPlayerJoin(e: PlayerJoinEvent) {
        val player = e.player
        if (player.hasPermission(plugin.config.getString("permissions.fly-use"))) {
            plugin.flyManager.updateFly(player)
            plugin.debug("&a${player.name} entrou e teve o fly atualizado!", true)
        }
    }
}