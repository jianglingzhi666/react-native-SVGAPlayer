
# react-native-svgaplayer

## Getting started

`$ npm install react-native-svga --save`

### Mostly automatic installation

`$ react-native link react-native-svga`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-svgaplayer` and add `RNSvgaplayer.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNSvgaplayer.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.svgaplayer.RNSvgaplayerPackage;` to the imports at the top of the file
  - Add `new RNSvgaplayerPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-svgaplayer'
  	project(':react-native-svgaplayer').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-svgaplayer/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-svgaplayer')
  	```


## Usage
```javascript
import RNSvgaplayer from 'react-native-svgaplayer';

// TODO: What to do with the module?
RNSvgaplayer;
```
  # react-native-SVGAPlayer
