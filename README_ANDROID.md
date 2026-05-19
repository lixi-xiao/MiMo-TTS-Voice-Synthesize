# MiMo TTS Android 版

[![Build Status](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions/workflows/android-build.yml/badge.svg?branch=android)](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions/workflows/android-build.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)

> ⚠️ **开发状态：未完成（Work in Progress）**
> 
> 本分支为 Android 版本的开发分支，功能尚未完全实现，仅供测试和学习使用。

---

## 📱 关于 Android 版本

这是 MiMo TTS 的 Android 移植版本，采用 **Jetpack Compose** 构建，支持手机和平板设备。

### 与桌面版的区别

| 特性 | 桌面版 (main分支) | Android版 (android分支) |
|------|------------------|------------------------|
| 平台 | Windows | Android 8.0+ |
| 技术栈 | Python + Streamlit + PyWebView | Kotlin + Jetpack Compose |
| 安装方式 | 单文件 exe | APK 安装包 |
| 离线运行 | ✅ 支持 | ❌ 需要网络 |
| 状态 | ✅ 已完成 | 🚧 开发中 |

---

## ✨ 已实现功能

- [x] **API 接入** - 支持 MiMo Plan Token 和 API Key
- [x] **预置音色** - 8种内置音色选择
- [x] **音色设计** - 文本描述生成音色
- [x] **音色克隆** - 上传音频样本克隆
- [x] **风格标签** - 情感/方言/风格/音效标签
- [x] **音频播放** - 内置播放器预览
- [x] **文件保存** - 本地保存合成结果
- [x] **Material You** - 动态主题支持
- [x] **响应式布局** - 手机/平板自适应

## 🚧 待开发功能

- [ ] 历史记录持久化
- [ ] 批量合成功能
- [ ] 音频分享功能
- [ ] 后台合成支持
- [ ] 离线缓存机制
- [ ] 更多设置选项

---

## 🚀 快速开始

### 下载 APK（自动编译）

每次推送到 `android` 分支，GitHub Actions 会自动编译 APK。

1. 进入 [Actions 页面](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions/workflows/android-build.yml)
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-APK` 工件
4. 解压得到 `app-debug.apk`
5. 安装到手机

### 手动编译

```bash
# 1. 克隆仓库并切换到 android 分支
git clone https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize.git
cd MiMo-TTS-Voice-Synthesize
git checkout android

# 2. 用 Android Studio 打开 app 文件夹
# File → Open → 选择 app 文件夹

# 3. 等待 Gradle 同步完成

# 4. 连接手机或启动模拟器

# 5. 点击 Run (▶️) 编译并安装
```

---

## 📋 系统要求

- **Android 版本**: 8.0 (API 26) 或更高
- **网络**: 需要联网访问 MiMo API
- **存储**: 需要存储权限保存音频文件
- **权限**: 
  - 互联网访问
  - 存储读写（保存音频）
  - 音频播放

---

## 🔧 技术栈

| 技术 | 用途 |
|------|------|
| **Kotlin** | 开发语言 |
| **Jetpack Compose** | UI 框架 |
| **Material Design 3** | 设计语言 |
| **Navigation Compose** | 页面导航 |
| **Koin** | 依赖注入 |
| **Ktor** | HTTP 客户端 |
| **DataStore** | 配置存储 |
| **Kotlinx Serialization** | JSON 序列化 |

---

## 📁 项目结构

```
app/
├── src/main/java/com/mimotts/android/
│   ├── MainActivity.kt              # 主入口
│   ├── MiMoTTSApp.kt                # Application
│   ├── data/
│   │   ├── api/MiMoApiService.kt    # API 调用
│   │   ├── datastore/               # 配置存储
│   │   └── model/                   # 数据模型
│   ├── di/                          # 依赖注入
│   └── ui/
│       ├── pages/                   # 页面
│       │   ├── tts/                 # TTS 主页面
│       │   ├── history/             # 历史记录
│       │   └── settings/            # 设置
│       └── theme/                   # 主题
└── build.gradle.kts                 # 构建配置
```

---

## ⚠️ 已知问题

1. **历史记录功能未实现** - 当前仅显示占位页面
2. **首次加载较慢** - 需要下载 Gradle 依赖
3. **大文件克隆可能失败** - 建议音频样本小于 10MB
4. **深色模式适配不完整** - 部分组件颜色可能不协调

---

## 🤝 贡献

Android 版本正在积极开发中，欢迎提交 Issue 和 PR！

### 开发计划

- [ ] 完善历史记录功能
- [ ] 添加音频导出分享
- [ ] 优化平板布局
- [ ] 添加更多动画效果
- [ ] 支持后台下载

---

## 📄 许可证

与主分支一致，采用 [MIT License](../LICENSE) 开源许可证。

---

## 🔗 相关链接

- [主分支 (桌面版)](../README.md)
- [GitHub Actions 构建状态](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions/workflows/android-build.yml)
- [MiMo 官方文档](https://platform.xiaomimimo.com/docs/zh-CN/api/chat/openai-api)

---

<p align="center">
  <b>⚠️ 注意：本分支为开发版本，不适合生产环境使用 ⚠️</b>
</p>

<p align="center">Made with ❤️ by lixi</p>
