# HandTools 插件

一个为 Bukkit/Spigot 服务器设计的轻量级 Minecraft 插件，通过独特的方式增强游戏体验。**HandTools** 允许玩家在手持工具时通过潜行（下蹲）直接打开工作台、铁砧或潜影盒，并支持潜影盒嵌套（“潜影盒套娃”）功能。

## 功能

- **潜行使用工具**：玩家手持工作台或铁砧时潜行，可立即打开对应的界面。
- **潜影盒交互**：手持潜影盒潜行即可打开其库存，无需放置。
- **潜影盒嵌套**：支持在潜影盒中存储其他潜影盒，并无缝管理嵌套库存。
- **库存同步**：对潜影盒库存的修改会自动保存到玩家手中的物品，确保数据不丢失。
- **轻量高效**：基于 Bukkit 事件系统，资源占用极低，性能优越。

## 要求

- **Minecraft 服务器**：Bukkit、Spigot 或 Paper（兼容 1.13+ 版本）
- **Java**：8 或更高版本
- **无需额外依赖**

## 安装

1. 从 [Releases](https://github.com/yourusername/handtools/releases) 页面下载最新的 `HandTools.jar` 文件。
2. 将 `HandTools.jar` 文件放入服务器的 `plugins` 文件夹。
3. 重启服务器或使用 `/reload` 命令加载插件。
4. 插件将自动注册事件监听器并准备就绪。

## 使用方法

### 潜行使用工具
- 在主手持有一个 **工作台** 或 **铁砧**。
- 潜行（默认：Shift 键）以打开对应界面（工作台或铁砧界面）。

### 潜影盒交互
- 在主手持有一个 **潜影盒**（任意颜色）。
- 潜行以在自定义界面中打开潜影盒的库存。
- 根据需要修改库存内容；关闭界面或点击物品时，修改会自动保存到潜影盒。
- **嵌套潜影盒**：可以在潜影盒中存储其他潜影盒，并递归访问它们的库存。

### 注意事项
- 如果玩家在潜影盒界面打开时切换到空手，界面将自动关闭以避免问题。
- 对潜影盒内容的修改会同步到玩家手中的物品，确保数据完整。

## 代码概述

插件主要包含两个类：

- **HandTools.java**：主插件类，负责注册工具使用和潜影盒交互的事件监听器。
- **SkulkerBox.java**：处理潜影盒相关逻辑，包括打开自定义界面、同步库存变化和管理嵌套潜影盒。

主要功能基于以下技术实现：
- Bukkit 事件系统（`PlayerToggleSneakEvent`、`InventoryClickEvent`、`InventoryCloseEvent`）。
- 使用 `HashMap` 跟踪每个玩家的潜影盒会话。
- 使用 `BukkitRunnable` 实现延迟库存同步，确保操作流畅。

## 贡献

欢迎贡献代码！贡献步骤：
1. Fork 本仓库。
2. 创建新分支（`git checkout -b feature/your-feature`）。
3. 修改代码并提交（`git commit -m "添加你的功能"`）。
4. 推送分支（`git push origin feature/your-feature`）。
5. 提交 Pull Request。

请确保代码风格与现有代码一致，并包含适当的注释。

## 问题反馈

如遇到问题或有功能建议，请在 [GitHub Issues](https://github.com/yourusername/handtools/issues) 页面提交 issue。

## 许可证

本项目采用 MIT 许可证，详情见 [LICENSE](LICENSE) 文件。

## 联系方式

如有问题或需要支持，请通过 [GitHub](https://github.com/yourusername) 联系我或提交 issue。

---

祝您游戏愉快！🎮