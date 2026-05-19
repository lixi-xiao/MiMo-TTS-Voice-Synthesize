# MiMo TTS 语音合成器

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Python 3.8+](https://img.shields.io/badge/python-3.8+-blue.svg)](https://www.python.org/downloads/)
[![Streamlit](https://img.shields.io/badge/Streamlit-FF4B4B?logo=Streamlit\&logoColor=white)](https://streamlit.io/)

> 一款基于小米 MiMo-V2.5-TTS 的桌面端文本转语音应用，支持音色设计、声音克隆和多种说话风格。

## ✨ 功能特性

- 🎙️ **预置音色** - 开箱即用，内置多种精品音色
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 基于音频样本复刻任意音色
- 🎵 **风格控制** - 支持语速、情绪、方言等多种风格
- 🎤 **唱歌模式** - 支持将歌词合成歌曲
- 💻 **桌面应用** - 基于 WebView2 的独立桌面程序
- 📦 **便携版本** - 单文件可执行程序，无需安装

## 🚀 快速开始

### 方式一：使用打包好的程序（推荐）

1. 下载最新版本的 `MiMoTTS语音合成器.exe`
2. 双击运行即可

### 方式二：从源码运行

```bash
# 克隆仓库
git clone https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize.git
cd MiMo-TTS-Voice-Synthesize

# 安装依赖
pip install -r requirements.txt

# 运行网页版
streamlit run src/mimo_tts_app.py

# 或运行桌面版
python src/desktop_app.py
```

## 📦 打包应用

```bash
python src/build_desktop_app.py
```

打包后的文件位于 `dist/MiMoTTS语音合成器.exe`

## 🔧 系统要求

- Windows 10/11
- .NET Framework 4.7.2 或更高版本
- WebView2 Runtime（首次运行会自动安装）

## 📝 使用说明

1. 获取 MiMo API Key
2. 在应用中输入 API Key
3. 选择模型和音色
4. 输入文本，点击合成
5. 下载生成的音频文件

## 🛠️ 技术栈

- [Python](https://www.python.org/) - 后端逻辑
- [Streamlit](https://streamlit.io/) - Web 界面
- [PyWebView](https://pywebview.flowrl.com/) - 桌面窗口
- [PyInstaller](https://pyinstaller.org/) - 应用打包

## 📄 许可证

本项目采用 [MIT License](LICENSE) 开源许可证。

## 🤝 贡献

欢迎提交 Issue 和 Pull Request！

## 📧 联系

如有问题，请通过 GitHub Issues 联系。

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

***

<p align="center">Made with ❤️ by lixi</p>
# MiMo T# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xia# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK
# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/M# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** -# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
-# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
-# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）
# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型和音色
5. 输入文本，点击合成

### 3. 使用标签# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型和音色
5. 输入文本，点击合成

### 3. 使用标签

在文本中插入标签控制语音风格：

```
(开心)你好呀，今天天气真好！
(# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型和音色
5. 输入文本，点击合成

### 3. 使用标签

在文本中插入标签控制语音风格：

```
(开心)你好呀，今天天气真好！
(东北话)哥们儿，整点啥？
(唱歌)小星星，亮晶晶
# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型和音色
5. 输入文本，点击合成

### 3. 使用标签

在文本中插入标签控制语音风格：

```
(开心)你好呀，今天天气真好！
(东北话)哥们儿，整点啥？
(唱歌)小星星，亮晶晶
[笑]哈哈哈
```

## 📋 系统要求

- Android 8.0+ (API 26+)
-# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型和音色
5. 输入文本，点击合成

### 3. 使用标签

在文本中插入标签控制语音风格：

```
(开心)你好呀，今天天气真好！
(东北话)哥们儿，整点啥？
(唱歌)小星星，亮晶晶
[笑]哈哈哈
```

## 📋 系统要求

- Android 8.0+ (API 26+)
- 网络连接（用于调用 MiMo API）# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型和音色
5. 输入文本，点击合成

### 3. 使用标签

在文本中插入标签控制语音风格：

```
(开心)你好呀，今天天气真好！
(东北话)哥们儿，整点啥？
(唱歌)小星星，亮晶晶
[笑]哈哈哈
```

## 📋 系统要求

- Android 8.0+ (API 26+)
- 网络连接（用于调用 MiMo API）
- 存储权限（用于保存音频文件）

## 🛠️ 技术# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型和音色
5. 输入文本，点击合成

### 3. 使用标签

在文本中插入标签控制语音风格：

```
(开心)你好呀，今天天气真好！
(东北话)哥们儿，整点啥？
(唱歌)小星星，亮晶晶
[笑]哈哈哈
```

## 📋 系统要求

- Android 8.0+ (API 26+)
- 网络连接（用于调用 MiMo API）
- 存储权限（用于保存音频文件）

## 🛠️ 技术栈

- [Kotlin](https://kotlin# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型和音色
5. 输入文本，点击合成

### 3. 使用标签

在文本中插入标签控制语音风格：

```
(开心)你好呀，今天天气真好！
(东北话)哥们儿，整点啥？
(唱歌)小星星，亮晶晶
[笑]哈哈哈
```

## 📋 系统要求

- Android 8.0+ (API 26+)
- 网络连接（用于调用 MiMo API）
- 存储权限（用于保存音频文件）

## 🛠️ 技术栈

- [Kotlin](https://kotlinlang.org/) - 开发语言
- [Jetpack Compose](https://developer.android.com/j# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型和音色
5. 输入文本，点击合成

### 3. 使用标签

在文本中插入标签控制语音风格：

```
(开心)你好呀，今天天气真好！
(东北话)哥们儿，整点啥？
(唱歌)小星星，亮晶晶
[笑]哈哈哈
```

## 📋 系统要求

- Android 8.0+ (API 26+)
- 网络连接（用于调用 MiMo API）
- 存储权限（用于保存音频文件）

## 🛠️ 技术栈

- [Kotlin](https://kotlinlang.org/) - 开发语言
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - UI 框架
- [Material Design 3](https://m# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型和音色
5. 输入文本，点击合成

### 3. 使用标签

在文本中插入标签控制语音风格：

```
(开心)你好呀，今天天气真好！
(东北话)哥们儿，整点啥？
(唱歌)小星星，亮晶晶
[笑]哈哈哈
```

## 📋 系统要求

- Android 8.0+ (API 26+)
- 网络连接（用于调用 MiMo API）
- 存储权限（用于保存音频文件）

## 🛠️ 技术栈

- [Kotlin](https://kotlinlang.org/) - 开发语言
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - UI 框架
- [Material Design 3](https://m3.material.io/) - 设计系统
- [Navigation Compose](https://developer.android.com/j# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型和音色
5. 输入文本，点击合成

### 3. 使用标签

在文本中插入标签控制语音风格：

```
(开心)你好呀，今天天气真好！
(东北话)哥们儿，整点啥？
(唱歌)小星星，亮晶晶
[笑]哈哈哈
```

## 📋 系统要求

- Android 8.0+ (API 26+)
- 网络连接（用于调用 MiMo API）
- 存储权限（用于保存音频文件）

## 🛠️ 技术栈

- [Kotlin](https://kotlinlang.org/) - 开发语言
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - UI 框架
- [Material Design 3](https://m3.material.io/) - 设计系统
- [Navigation Compose](https://developer.android.com/jetpack/compose/navigation) - 导航
- [Koin](https://insert-k# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型和音色
5. 输入文本，点击合成

### 3. 使用标签

在文本中插入标签控制语音风格：

```
(开心)你好呀，今天天气真好！
(东北话)哥们儿，整点啥？
(唱歌)小星星，亮晶晶
[笑]哈哈哈
```

## 📋 系统要求

- Android 8.0+ (API 26+)
- 网络连接（用于调用 MiMo API）
- 存储权限（用于保存音频文件）

## 🛠️ 技术栈

- [Kotlin](https://kotlinlang.org/) - 开发语言
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - UI 框架
- [Material Design 3](https://m3.material.io/) - 设计系统
- [Navigation Compose](https://developer.android.com/jetpack/compose/navigation) - 导航
- [Koin](https://insert-koin.io/) - 依赖注入
- [Ktor](https://ktor.io/) - HTTP 客户端
- [DataStore](https://# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型和音色
5. 输入文本，点击合成

### 3. 使用标签

在文本中插入标签控制语音风格：

```
(开心)你好呀，今天天气真好！
(东北话)哥们儿，整点啥？
(唱歌)小星星，亮晶晶
[笑]哈哈哈
```

## 📋 系统要求

- Android 8.0+ (API 26+)
- 网络连接（用于调用 MiMo API）
- 存储权限（用于保存音频文件）

## 🛠️ 技术栈

- [Kotlin](https://kotlinlang.org/) - 开发语言
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - UI 框架
- [Material Design 3](https://m3.material.io/) - 设计系统
- [Navigation Compose](https://developer.android.com/jetpack/compose/navigation) - 导航
- [Koin](https://insert-koin.io/) - 依赖注入
- [Ktor](https://ktor.io/) - HTTP 客户端
- [DataStore](https://developer.android.com/topic/libraries/architecture/datastore) - 数据存储

## 🔧# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型和音色
5. 输入文本，点击合成

### 3. 使用标签

在文本中插入标签控制语音风格：

```
(开心)你好呀，今天天气真好！
(东北话)哥们儿，整点啥？
(唱歌)小星星，亮晶晶
[笑]哈哈哈
```

## 📋 系统要求

- Android 8.0+ (API 26+)
- 网络连接（用于调用 MiMo API）
- 存储权限（用于保存音频文件）

## 🛠️ 技术栈

- [Kotlin](https://kotlinlang.org/) - 开发语言
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - UI 框架
- [Material Design 3](https://m3.material.io/) - 设计系统
- [Navigation Compose](https://developer.android.com/jetpack/compose/navigation) - 导航
- [Koin](https://insert-koin.io/) - 依赖注入
- [Ktor](https://ktor.io/) - HTTP 客户端
- [DataStore](https://developer.android.com/topic/libraries/architecture/datastore) - 数据存储

## 🔧 自行编译

### 环境要求

# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型和音色
5. 输入文本，点击合成

### 3. 使用标签

在文本中插入标签控制语音风格：

```
(开心)你好呀，今天天气真好！
(东北话)哥们儿，整点啥？
(唱歌)小星星，亮晶晶
[笑]哈哈哈
```

## 📋 系统要求

- Android 8.0+ (API 26+)
- 网络连接（用于调用 MiMo API）
- 存储权限（用于保存音频文件）

## 🛠️ 技术栈

- [Kotlin](https://kotlinlang.org/) - 开发语言
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - UI 框架
- [Material Design 3](https://m3.material.io/) - 设计系统
- [Navigation Compose](https://developer.android.com/jetpack/compose/navigation) - 导航
- [Koin](https://insert-koin.io/) - 依赖注入
- [Ktor](https://ktor.io/) - HTTP 客户端
- [DataStore](https://developer.android.com/topic/libraries/architecture/datastore) - 数据存储

## 🔧 自行编译

### 环境要求

- Android Studio Ladybug (2024.2# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型和音色
5. 输入文本，点击合成

### 3. 使用标签

在文本中插入标签控制语音风格：

```
(开心)你好呀，今天天气真好！
(东北话)哥们儿，整点啥？
(唱歌)小星星，亮晶晶
[笑]哈哈哈
```

## 📋 系统要求

- Android 8.0+ (API 26+)
- 网络连接（用于调用 MiMo API）
- 存储权限（用于保存音频文件）

## 🛠️ 技术栈

- [Kotlin](https://kotlinlang.org/) - 开发语言
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - UI 框架
- [Material Design 3](https://m3.material.io/) - 设计系统
- [Navigation Compose](https://developer.android.com/jetpack/compose/navigation) - 导航
- [Koin](https://insert-koin.io/) - 依赖注入
- [Ktor](https://ktor.io/) - HTTP 客户端
- [DataStore](https://developer.android.com/topic/libraries/architecture/datastore) - 数据存储

## 🔧 自行编译

### 环境要求

- Android Studio Ladybug (2024.2.1) 或更新版本
- JDK 17 或更高版本
- Android SDK 35

### 编译步骤

# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型和音色
5. 输入文本，点击合成

### 3. 使用标签

在文本中插入标签控制语音风格：

```
(开心)你好呀，今天天气真好！
(东北话)哥们儿，整点啥？
(唱歌)小星星，亮晶晶
[笑]哈哈哈
```

## 📋 系统要求

- Android 8.0+ (API 26+)
- 网络连接（用于调用 MiMo API）
- 存储权限（用于保存音频文件）

## 🛠️ 技术栈

- [Kotlin](https://kotlinlang.org/) - 开发语言
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - UI 框架
- [Material Design 3](https://m3.material.io/) - 设计系统
- [Navigation Compose](https://developer.android.com/jetpack/compose/navigation) - 导航
- [Koin](https://insert-koin.io/) - 依赖注入
- [Ktor](https://ktor.io/) - HTTP 客户端
- [DataStore](https://developer.android.com/topic/libraries/architecture/datastore) - 数据存储

## 🔧 自行编译

### 环境要求

- Android Studio Ladybug (2024.2.1) 或更新版本
- JDK 17 或更高版本
- Android SDK 35

### 编译步骤

```bash
# 1. 克隆仓库
git clone https://github.com/xia# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型和音色
5. 输入文本，点击合成

### 3. 使用标签

在文本中插入标签控制语音风格：

```
(开心)你好呀，今天天气真好！
(东北话)哥们儿，整点啥？
(唱歌)小星星，亮晶晶
[笑]哈哈哈
```

## 📋 系统要求

- Android 8.0+ (API 26+)
- 网络连接（用于调用 MiMo API）
- 存储权限（用于保存音频文件）

## 🛠️ 技术栈

- [Kotlin](https://kotlinlang.org/) - 开发语言
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - UI 框架
- [Material Design 3](https://m3.material.io/) - 设计系统
- [Navigation Compose](https://developer.android.com/jetpack/compose/navigation) - 导航
- [Koin](https://insert-koin.io/) - 依赖注入
- [Ktor](https://ktor.io/) - HTTP 客户端
- [DataStore](https://developer.android.com/topic/libraries/architecture/datastore) - 数据存储

## 🔧 自行编译

### 环境要求

- Android Studio Ladybug (2024.2.1) 或更新版本
- JDK 17 或更高版本
- Android SDK 35

### 编译步骤

```bash
# 1. 克隆仓库
git clone https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize.git
cd MiMo-TTS# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型和音色
5. 输入文本，点击合成

### 3. 使用标签

在文本中插入标签控制语音风格：

```
(开心)你好呀，今天天气真好！
(东北话)哥们儿，整点啥？
(唱歌)小星星，亮晶晶
[笑]哈哈哈
```

## 📋 系统要求

- Android 8.0+ (API 26+)
- 网络连接（用于调用 MiMo API）
- 存储权限（用于保存音频文件）

## 🛠️ 技术栈

- [Kotlin](https://kotlinlang.org/) - 开发语言
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - UI 框架
- [Material Design 3](https://m3.material.io/) - 设计系统
- [Navigation Compose](https://developer.android.com/jetpack/compose/navigation) - 导航
- [Koin](https://insert-koin.io/) - 依赖注入
- [Ktor](https://ktor.io/) - HTTP 客户端
- [DataStore](https://developer.android.com/topic/libraries/architecture/datastore) - 数据存储

## 🔧 自行编译

### 环境要求

- Android Studio Ladybug (2024.2.1) 或更新版本
- JDK 17 或更高版本
- Android SDK 35

### 编译步骤

```bash
# 1. 克隆仓库
git clone https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize.git
cd MiMo-TTS-Voice-Synthesize

# 2. 切换到 android 分支
git checkout android# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型和音色
5. 输入文本，点击合成

### 3. 使用标签

在文本中插入标签控制语音风格：

```
(开心)你好呀，今天天气真好！
(东北话)哥们儿，整点啥？
(唱歌)小星星，亮晶晶
[笑]哈哈哈
```

## 📋 系统要求

- Android 8.0+ (API 26+)
- 网络连接（用于调用 MiMo API）
- 存储权限（用于保存音频文件）

## 🛠️ 技术栈

- [Kotlin](https://kotlinlang.org/) - 开发语言
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - UI 框架
- [Material Design 3](https://m3.material.io/) - 设计系统
- [Navigation Compose](https://developer.android.com/jetpack/compose/navigation) - 导航
- [Koin](https://insert-koin.io/) - 依赖注入
- [Ktor](https://ktor.io/) - HTTP 客户端
- [DataStore](https://developer.android.com/topic/libraries/architecture/datastore) - 数据存储

## 🔧 自行编译

### 环境要求

- Android Studio Ladybug (2024.2.1) 或更新版本
- JDK 17 或更高版本
- Android SDK 35

### 编译步骤

```bash
# 1. 克隆仓库
git clone https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize.git
cd MiMo-TTS-Voice-Synthesize

# 2. 切换到 android 分支
git checkout android

# 3. 用 Android Studio 打开项目
# File -> Open -># MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型和音色
5. 输入文本，点击合成

### 3. 使用标签

在文本中插入标签控制语音风格：

```
(开心)你好呀，今天天气真好！
(东北话)哥们儿，整点啥？
(唱歌)小星星，亮晶晶
[笑]哈哈哈
```

## 📋 系统要求

- Android 8.0+ (API 26+)
- 网络连接（用于调用 MiMo API）
- 存储权限（用于保存音频文件）

## 🛠️ 技术栈

- [Kotlin](https://kotlinlang.org/) - 开发语言
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - UI 框架
- [Material Design 3](https://m3.material.io/) - 设计系统
- [Navigation Compose](https://developer.android.com/jetpack/compose/navigation) - 导航
- [Koin](https://insert-koin.io/) - 依赖注入
- [Ktor](https://ktor.io/) - HTTP 客户端
- [DataStore](https://developer.android.com/topic/libraries/architecture/datastore) - 数据存储

## 🔧 自行编译

### 环境要求

- Android Studio Ladybug (2024.2.1) 或更新版本
- JDK 17 或更高版本
- Android SDK 35

### 编译步骤

```bash
# 1. 克隆仓库
git clone https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize.git
cd MiMo-TTS-Voice-Synthesize

# 2. 切换到 android 分支
git checkout android

# 3. 用 Android Studio 打开项目
# File -> Open -> 选择项目文件夹

# 4. 等待 Gradle 同步完成

# 5# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型和音色
5. 输入文本，点击合成

### 3. 使用标签

在文本中插入标签控制语音风格：

```
(开心)你好呀，今天天气真好！
(东北话)哥们儿，整点啥？
(唱歌)小星星，亮晶晶
[笑]哈哈哈
```

## 📋 系统要求

- Android 8.0+ (API 26+)
- 网络连接（用于调用 MiMo API）
- 存储权限（用于保存音频文件）

## 🛠️ 技术栈

- [Kotlin](https://kotlinlang.org/) - 开发语言
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - UI 框架
- [Material Design 3](https://m3.material.io/) - 设计系统
- [Navigation Compose](https://developer.android.com/jetpack/compose/navigation) - 导航
- [Koin](https://insert-koin.io/) - 依赖注入
- [Ktor](https://ktor.io/) - HTTP 客户端
- [DataStore](https://developer.android.com/topic/libraries/architecture/datastore) - 数据存储

## 🔧 自行编译

### 环境要求

- Android Studio Ladybug (2024.2.1) 或更新版本
- JDK 17 或更高版本
- Android SDK 35

### 编译步骤

```bash
# 1. 克隆仓库
git clone https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize.git
cd MiMo-TTS-Voice-Synthesize

# 2. 切换到 android 分支
git checkout android

# 3. 用 Android Studio 打开项目
# File -> Open -> 选择项目文件夹

# 4. 等待 Gradle 同步完成

# 5. 连接手机或启动模拟器

# 6. 点击 Run 按钮 (# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型和音色
5. 输入文本，点击合成

### 3. 使用标签

在文本中插入标签控制语音风格：

```
(开心)你好呀，今天天气真好！
(东北话)哥们儿，整点啥？
(唱歌)小星星，亮晶晶
[笑]哈哈哈
```

## 📋 系统要求

- Android 8.0+ (API 26+)
- 网络连接（用于调用 MiMo API）
- 存储权限（用于保存音频文件）

## 🛠️ 技术栈

- [Kotlin](https://kotlinlang.org/) - 开发语言
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - UI 框架
- [Material Design 3](https://m3.material.io/) - 设计系统
- [Navigation Compose](https://developer.android.com/jetpack/compose/navigation) - 导航
- [Koin](https://insert-koin.io/) - 依赖注入
- [Ktor](https://ktor.io/) - HTTP 客户端
- [DataStore](https://developer.android.com/topic/libraries/architecture/datastore) - 数据存储

## 🔧 自行编译

### 环境要求

- Android Studio Ladybug (2024.2.1) 或更新版本
- JDK 17 或更高版本
- Android SDK 35

### 编译步骤

```bash
# 1. 克隆仓库
git clone https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize.git
cd MiMo-TTS-Voice-Synthesize

# 2. 切换到 android 分支
git checkout android

# 3. 用 Android Studio 打开项目
# File -> Open -> 选择项目文件夹

# 4. 等待 Gradle 同步完成

# 5. 连接手机或启动模拟器

# 6. 点击 Run 按钮 (▶️) 编译并安装
```

### 生成 APK

在 Android# MiMo TTS Android

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Android](https://img.shields.io/badge/Android-8.0%2B-green.svg)](https://www.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-2024.12.01-brightgreen.svg)](https://developer.android.com/jetpack/compose)

> 基于小米 MiMo-V2.5-TTS 的 Android 语音合成应用，支持预置音色、音色设计和声音克隆。

## 📱 下载安装

### 方式一：GitHub Actions 自动构建（推荐）

1. 访问本仓库的 [Actions](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/actions) 页面
2. 选择最新的成功构建
3. 下载 `MiMoTTS-Android-Debug` 工件
4. 解压并安装 APK

### 方式二：Release 页面下载

1. 访问 [Releases](https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize/releases) 页面
2. 找到标记为 `android-v*` 的版本
3. 下载 APK 文件安装

## ✨ 功能特性

- 🎙️ **预置音色** - 8种精品内置音色（冰糖、茉莉、苏打等）
- 🎨 **音色设计** - 通过文本描述定制专属音色
- 🎭 **声音克隆** - 上传音频样本复刻任意音色
- 🏷️ **风格标签** - 支持情感、方言、风格、音效标签
- 🎵 **音频格式** - 支持 WAV 和 MP3 输出
- 💾 **本地存储** - 合成的音频自动保存到本地
- 🎨 **Material You** - 支持动态主题和深色模式
- 📱 **自适应布局** - 完美适配手机和平板

## 🚀 快速开始

### 1. 获取 API 密钥

**方式一：MiMo Plan Token**
- 访问 [MiMo Plan 控制台](https://plan.xiaomimimo.com)
- 创建应用并获取 Token
- 格式：`mimo-plan-...`

**方式二：API Key**
- 访问 [MiMo 开放平台](https://platform.xiaomimimo.com)
- 注册账号并创建应用
- 获取 API Key（格式：`sk-...`）

### 2. 配置应用

1. 打开应用
2. 选择 API 接入方式（MiMo Plan / API Key）
3. 输入对应的 Token 或 API Key
4. 选择模型和音色
5. 输入文本，点击合成

### 3. 使用标签

在文本中插入标签控制语音风格：

```
(开心)你好呀，今天天气真好！
(东北话)哥们儿，整点啥？
(唱歌)小星星，亮晶晶
[笑]哈哈哈
```

## 📋 系统要求

- Android 8.0+ (API 26+)
- 网络连接（用于调用 MiMo API）
- 存储权限（用于保存音频文件）

## 🛠️ 技术栈

- [Kotlin](https://kotlinlang.org/) - 开发语言
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - UI 框架
- [Material Design 3](https://m3.material.io/) - 设计系统
- [Navigation Compose](https://developer.android.com/jetpack/compose/navigation) - 导航
- [Koin](https://insert-koin.io/) - 依赖注入
- [Ktor](https://ktor.io/) - HTTP 客户端
- [DataStore](https://developer.android.com/topic/libraries/architecture/datastore) - 数据存储

## 🔧 自行编译

### 环境要求

- Android Studio Ladybug (2024.2.1) 或更新版本
- JDK 17 或更高版本
- Android SDK 35

### 编译步骤

```bash
# 1. 克隆仓库
git clone https://github.com/xiaozhanqi/MiMo-TTS-Voice-Synthesize.git
cd MiMo-TTS-Voice-Synthesize

# 2. 切换到 android 分支
git checkout android

# 3. 用 Android Studio 打开项目
# File -> Open -> 选择项目文件夹

# 4. 等待 Gradle 同步完成

# 5. 连接手机或启动模拟器

# 6. 点击 Run 按钮 (▶️) 编译并安装
```

### 生成 APK

在 Android Studio 中：
- **Build → Build Bundle(s) / APK(s) → Build