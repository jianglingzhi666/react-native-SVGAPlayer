
# react-native-svgaplayer

## 安装

`$ npm install svgaplayer-react-native --save`

### React Naitve <= 5.9

`$ react-native link react-native-svga`

### Manual installation

#### Android

添加混淆规则

-keep class com.squareup.wire.** { *; }
-keep class com.opensource.svgaplayer.proto.** { *; }

#### iOS

在podfile 添加 pod 'SVGAPlayer', '~> 2.3'



## 属性

**url**</br>
***仅支持网络路径***</br>

**loops**</br>
***循环播放次数,0为无限循环***</br>

**autoPlay**</br>
***加载完成后是否自动播放***</br>
* ***true(默认)*** 自动播放</br>
* ***false***

**fillMode**</br>
***播放完成后保留第一帧或最后一帧***</br>
* ***Backward*** 最后一针</br>
* ***Forward(默认)*** 第一帧</br>

**clearsAfterStop**</br>
***播放完成后是否清除画布***</br>
* ***true(默认)*** 清除</br>
* ***false***

**onComplete**</br>
***加载完成时回调***</br>

**onError**</br>
***加载错误时回调***</br>

**onPause**</br>
***暂停时回调***</br>

**onFinished**</br>
***播放完成时回调(无限循环时不会触发)***</br>

**onRepeat**</br>
***重复播放时触发***</br>

**onStep(frame:string,percentage:number)**</br>
***播放进度回调返回当前帧与进度***</br>

## 方法
**start()**</br>
***开始播放***</br>

**pause()**</br>
***暂停播放***</br>

**stepToFrame(frame:number,andPlay:boolean)**</br>
***设置到指定帧数，是否继续播放***</br>

**stepToPercentage(percentage:number,andPlay:boolean)**</br>
***设置到指定进度，是否继续播放***</br>


