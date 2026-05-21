# MiMo TTS Android

基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用。

## 📱 下载安装

访问 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面，下载最新的 `MiMoTTS-Android-APK` 工件，解压安装。

## ✨ 功能特性

- 🎙️ **预置音色** - 冰糖、茉莉、苏打、白桦等8种精品音色
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 60+ 标签控制情感、方言、风格、音效
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **历史记录** - 保存合成历史
- 📱 **高刷适配** - 支持 90/120/144Hz 高刷屏幕

## 🚀 快速开始

### 1. 获取 API 密钥

- **MiMo Plan**: [MiMo Plan 控制台](https://plan.xiaomimimo.com) 获取 Token
- **API Key**: [MiMo 开放平台](https://platform.xiaomimimo.com) 注册获取

### 2. 使用标签

```
(开心)你好呀，今天天气真好！
(东北话)哥们儿，整点啥？
(唱歌)小星星，亮晶晶
```

## 📋 系统要求

- Android 8.0+ (API 26+)
- 网络连接
- 存储权限

## 🔧 自行编译

```bash
git clone https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize.git
cd MiMo-TTS-Voice-Synthesize
git checkout android
```

用 Android Studio 打开项目，点击 Run 编译安装。

或命令行编译：

```bash
./gradlew assembleDebug
```

APK 位于：`app/build/outputs/apk/debug/app-debug.apk`

## 📄 许可证

MIT License

## 免责声明

1. **本工具为第三方开源客户端**，与小米公司无任何关联。
2. **API服务由小米官方提供**，用户须自行注册小米账号并申请API密钥（Access Key）。
   本工具仅提供API调用的技术封装，不预装、不提供、不共享任何API密钥。
3. **预填的API地址**来源于小米官方公开文档，仅供技术对接参考。
   如小米官方调整接口地址，请以官方最新文档为准。
4. **内容生成责任**：TTS音频内容由小米服务器根据用户输入文本生成，
   本工具不存储、不处理、不传播任何音频数据或文本内容。
5. **用户须自行遵守**《小米开发者协议》《小米AI服务条款》及相关法律法规，
   不得将本工具用于生成违法、侵权、虚假或欺诈性内容。
   因用户违反上述规定产生的法律责任，由用户自行承担。
6. 本工具基于 MIT 许可证开源，按"现状"（AS IS）提供，作者不提供任何明示或默示的担保，包括但不限于适销性、特定用途适用性及非侵权性的默示担保。

---

Made with ❤️ by lixi
