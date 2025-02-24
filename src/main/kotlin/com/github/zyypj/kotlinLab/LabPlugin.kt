package com.github.zyypj.kotlinLab

import com.github.zyypj.kotlinLab.commands.FlyCommand
import com.github.zyypj.kotlinLab.listeners.PlayerListeners
import com.github.zyypj.kotlinLab.manager.FlyManager
import org.bukkit.ChatColor
import org.bukkit.plugin.java.JavaPlugin

class LabPlugin : JavaPlugin() {

    lateinit var flyManager: FlyManager

    override fun onEnable() {
        setupFiles()
        debug("", false)
        debug("&aAtivando &lKotlinLab&a...", false)

        setupManagers()

        setupCommands()
        setupListeners()

        debug("&2&lKotlinLab&a foi ativado com sucesso!", false)
        debug("", false)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    fun debug(message: String, debug: Boolean) {
        val formattedMessage = ChatColor.translateAlternateColorCodes('&', message)
        if (debug) {
            if (config.getBoolean("debug", false)) {
                server.consoleSender.sendMessage("§5§l[KotlinLab-DEBUG] §f$formattedMessage")
            }
            return
        }

        server.consoleSender.sendMessage("§f$formattedMessage")
    }

    private fun setupFiles() {
        saveDefaultConfig()
    }

    private fun setupManagers() {
        flyManager = FlyManager(this)
    }

    private fun setupCommands() {
        getCommand("fly")?.executor = FlyCommand(this)
    }

    private fun setupListeners() {
        server.pluginManager.registerEvents(PlayerListeners(this), this)
    }
}