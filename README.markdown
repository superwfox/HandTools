# HandTools Plugin

## [【让我们说中文！】](https://github.com/superwfox/HandTools/blob/master/README_zh.markdown)

A lightweight Minecraft plugin for Bukkit/Spigot servers that enhances gameplay by allowing players to interact with tools and shulker boxes in a unique way. With **HandTools**, players can sneak (crouch) to open crafting tables, anvils, or shulker boxes directly from their hand, including support for nested shulker boxes (shulker box "doll" functionality).

## Features

- **Sneak-to-Use Tools**: When a player sneaks while holding a crafting table or anvil, the respective GUI opens instantly.
- **Shulker Box Interaction**: Sneak while holding a shulker box to open its inventory without placing it.
- **Nested Shulker Boxes**: Supports "shulker box in shulker box" functionality, allowing players to manage nested shulker box inventories seamlessly.
- **Inventory Synchronization**: Changes made to a shulker box's inventory are saved back to the item in the player's hand, ensuring no data loss.
- **Lightweight and Efficient**: Built with performance in mind, using Bukkit's event system and minimal resource overhead.

## Requirements

- **Minecraft Server**: Bukkit, Spigot, or Paper (compatible with versions 1.13+)
- **Java**: 8 or higher
- **No additional dependencies required**
  
## Usage

### Sneak-to-Use Tools
- Hold a **Crafting Table** or **Anvil** in your main hand.
- Sneak (default: Shift key) to open the respective GUI (crafting table or anvil interface).

### Shulker Box Interaction
- Hold a **Shulker Box** (any color) in your main hand.
- Sneak to open the shulker box's inventory in a custom GUI.
- Modify the contents as needed; changes are automatically saved to the shulker box when the inventory is closed or when clicking items.
- **Nested Shulker Boxes**: You can store shulker boxes inside other shulker boxes and access their inventories recursively.

### Notes
- If the player switches to an empty hand while the shulker box GUI is open, the inventory will close to prevent issues.
- All changes to shulker box contents are synchronized to the item in the player's hand, ensuring no data is lost.

## Code Overview

The plugin is structured into two main classes:

- **HandTools.java**: The main plugin class that registers event listeners for tool usage and shulker box interactions.
- **SkulkerBox.java**: Handles shulker box-specific logic, including opening the custom GUI, synchronizing inventory changes, and managing nested shulker boxes.

Key features are implemented using:
- Bukkit's event system (`PlayerToggleSneakEvent`, `InventoryClickEvent`, `InventoryCloseEvent`).
- A `HashMap` to track active shulker box sessions per player.
- `BukkitRunnable` for delayed inventory synchronization to ensure smooth operation.

---

Happy crafting! 🎮
