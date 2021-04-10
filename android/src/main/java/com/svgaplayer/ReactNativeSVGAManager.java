package com.svgaplayer;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.opensource.svgaplayer.SVGAImageView;

import java.util.HashMap;
import java.util.Map;


class ReactNativeSVGAManager extends ViewGroupManager<ReactNativeSVGA> {
    public String REACT_CLASS = "ReactNativeSVGA";

    @NonNull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @NonNull
    @Override
    protected ReactNativeSVGA createViewInstance(@NonNull ThemedReactContext reactContext) {

        return new ReactNativeSVGA(reactContext);
    }

    @ReactProp(name = "url")
    public void setUrl(ReactNativeSVGA reactNativeSVGA, String url) {
            reactNativeSVGA.setUrl(url);
    }

    /**
     * 设置加载完成后是否自动播放
     * @param reactNativeSVGA
     * @param bool
     */
    @ReactProp(name = "autoPlay", defaultBoolean = true)
    public void setAutoPlay(ReactNativeSVGA reactNativeSVGA, boolean bool) {
        reactNativeSVGA.autoPaly = bool;
    }
    /**
     * 设置循环播放多少次
     *
     * @param reactNativeSVGA
     * @param count           0是无限循环
     */
    @ReactProp(name = "loops", defaultInt = 0)
    public void setLoops(ReactNativeSVGA reactNativeSVGA, int count) {
        reactNativeSVGA.setLoops(count);
    }

    /**
     * 动画停止后是否清除最后一针
     *
     * @param reactNativeSVGA
     * @param bool
     */
    @ReactProp(name = "clearsAfterStop", defaultBoolean = true)
    public void setClearsAfterStop(ReactNativeSVGA reactNativeSVGA, boolean bool) {
        reactNativeSVGA.setClearsAfterStop(bool);
    }

    /**
     * 动画播放完后保持在第一针还是最后一针
     * @param reactNativeSVGA
     * @param fillMode
     */
    @ReactProp(name = "fillMode")
    public void setFillMode(ReactNativeSVGA reactNativeSVGA, String fillMode){
        reactNativeSVGA.setFillMode(SVGAImageView.FillMode.valueOf(fillMode));
    }

    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder()
                .put("onComplete", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onComplete")))
                .put("onError", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onError")))
                .put("onPause", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onPause")))
                .put("onFinished", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onFinished")))
                .put("onRepeat", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onRepeat")))
                .put("onStep", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onStep")))
                .build();
    }
    @Override
    public @Nullable
    Map<String, Integer> getCommandsMap() {
        HashMap map = new HashMap();
        map.put("start", 0);
        map.put("pause", 1);
        map.put("stepToFrame", 2);
        map.put("stepToPercentage", 3);
        return map;
    }

    @Override
    public void receiveCommand(ReactNativeSVGA reactNativeSVGA, int commandId, @Nullable ReadableArray args) {

        switch (commandId){
            case 0:reactNativeSVGA.start();break;
            case 1:reactNativeSVGA.pause();break;
            case 2:reactNativeSVGA.stepToFrame(args.getInt(0),args.getBoolean(1));break;
            case 3:reactNativeSVGA.stepToPercentage(args.getDouble(0),args.getBoolean(1));break;
        }
    }
}
