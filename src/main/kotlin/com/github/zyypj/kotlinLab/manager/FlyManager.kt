package com.github.zyypj.kotlinLab.manager

import com.github.zyypj.kotlinLab.LabPlugin
import org.bukkit.ChatColor
import org.bukkit.entity.Player

class FlyManager(
    private val plugin: LabPlugin
) {

    fun updateFly(player: Player) {
        if (player.allowFlight) {
            player.sendMessage(
                ChatColor.translateAlternateColorCodes(
                    '&',
                    plugin.config.getString("messages.fly-off")
                )
            )
            player.allowFlight = false
            player.isFlying = false;
        } else {
            player.sendMessage(
                ChatColor.translateAlternateColorCodes(
                    '&',
                    plugin.config.getString("messages.fly-on")
                )
            )
            player.allowFlight = true
            player.isFlying = true;
        }
    }
}