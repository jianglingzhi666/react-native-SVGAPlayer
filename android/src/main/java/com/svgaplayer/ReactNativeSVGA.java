package com.svgaplayer;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.opensource.svgaplayer.SVGACallback;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;

import org.jetbrains.annotations.NotNull;

import java.net.MalformedURLException;
import java.net.URL;

public class ReactNativeSVGA extends FrameLayout {
    public SVGAImageView svgImageView;
    public SVGAParser svgaParser;
    public boolean autoPaly = true;
    ReactNativeSVGA(ThemedReactContext context) {
        super(context);
        this.svgImageView = new SVGAImageView(context);
        this.svgaParser = new SVGAParser(context);
        svgImageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        this.addView(this.svgImageView);
    }

    public void setUrl(String url) {
        ReactContext reactContext = (ReactContext) getContext();
        try {
            svgaParser.parse(new URL(url), new SVGAParser.ParseCompletion() {
                @Override
                public void onComplete(@NotNull SVGAVideoEntity svgaVideoEntity) {
                    SVGADrawable drawable = new SVGADrawable(svgaVideoEntity);
                    svgImageView.setImageDrawable(drawable);
                    if(autoPaly){
                        svgImageView.startAnimation();
                    }
                    WritableMap event = Arguments.createMap();
                    receiveEvent("onComplete",event);
                }

                @Override
                public void onError() {
                    WritableMap event = Arguments.createMap();
                    receiveEvent("onError",event);
                }
            });
            svgImageView.setCallback(new SVGACallback() {
                @Override
                public void onPause() {
                    WritableMap event = Arguments.createMap();
                    receiveEvent("onPause",event);
                }

                @Override
                public void onFinished() {
                    WritableMap event = Arguments.createMap();
                    receiveEvent("onFinished",event);
                }

                @Override
                public void onRepeat() {
                    WritableMap event = Arguments.createMap();
                    receiveEvent("onRepeat",event);
                }

                @Override
                public void onStep(int i, double v) {
                    WritableMap event = Arguments.createMap();
                    event.putInt("frame",i);
                    event.putDouble("progress",v);
                    receiveEvent("onStep",event);
                }
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
            WritableMap event = Arguments.createMap();
            event.putString("message", e.toString());
            receiveEvent("onError",event);
        }
    }

    public void setLoops(int count) {
        this.svgImageView.setLoops(count);
    }

    public void setClearsAfterStop(boolean bool) {
        this.svgImageView.setClearsAfterStop(bool);
    }

    public void setFillMode(SVGAImageView.FillMode fillMode){
        this.svgImageView.setFillMode(fillMode);
    }
    public void start(){
        this.svgImageView.startAnimation();
    }
    public void pause(){
        this.svgImageView.pauseAnimation();
    }
    public void stepToFrame(int frame, Boolean andPlay){
        this.svgImageView.stepToFrame(frame,andPlay);
    }
    public void stepToPercentage(double percentage,Boolean andPlay){
        this.svgImageView.stepToPercentage(percentage,andPlay);
        this.svgImageView.stopAnimation();
    }
    public void receiveEvent(String eventName,WritableMap map){
        ReactContext reactContext = (ReactContext)getContext();
        reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
                getId(),
                eventName,
                map);
    }
}
