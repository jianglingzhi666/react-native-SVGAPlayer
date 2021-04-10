
# react-native-svgaplayer

## 安装

`$ npm install svgaplayer-react-native --save`

### React Naitve <= 5.9

`$ react-native link react-native-svga`

### Manual installation


#### iOS

在podfile 添加 pod 'SVGAPlayer', '~> 2.3'


## 属性
url
仅支持网络路径
loops
循环播放次数0为无限循环
autoPlay
加载完成后是否自动播放
>> * true(默认)自动播放
>> * false
fillMode
播放完成后保留第一帧或最后一帧
>> * Backward最后一针
>> *Forward第一帧
clearsAfterStop
播放完成后是否清除画布
>> *true(默认)清除
>> *false
onComplete
加载完成时回调
onError
加载错误时回调
onPause
暂停时回调
onFinished
播放完成时回调(无限循环时不会触发)
onRepeat
重复播放时触发
onStep(frame:string,percentage:number)
播放进度回调返回当前帧与进度


