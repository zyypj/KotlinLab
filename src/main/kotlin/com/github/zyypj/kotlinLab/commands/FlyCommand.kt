package com.github.zyypj.kotlinLab.commands

import com.github.zyypj.kotlinLab.LabPlugin
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class FlyCommand(private val plugin: LabPlugin) : CommandExecutor {

    override fun onCommand(
        sender: CommandSender?,
        command: Command?,
        label: String?,
        args: Array<out String>
    ): Boolean {

        if (sender !is Player) {
            sender?.sendMessage("§cApenas jogadores podem usar este comando!")
            return false
        }

        if (!sender.hasPermission(plugin.config.getString("permissions.fly-use") ?: "default.permission")) {
            sender.sendMessage(
                ChatColor.translateAlternateColorCodes(
                    '&',
                    plugin.config.getString("messages.no-permission") ?: "§cVocê não tem permissão!"
                )
            )
            return false
        }

        if (args.isEmpty()) {
            plugin.flyManager.updateFly(sender)
            return true
        }

        sender.sendMessage("§cVai se foder!")
        return false
    }
}