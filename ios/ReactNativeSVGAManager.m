//
//  ReactNativeSVGAManager.m
//  reactNativeSvga
//
//  Created by 彭 on 4/9/21.
//

#import "ReactNativeSVGAManager.h"

@implementation ReactNativeSVGAManager
RCT_EXPORT_MODULE(ReactNativeSVGA)

- (UIView *)view
{
  return [[ReactNativeSVGA alloc] init];
}
RCT_EXPORT_VIEW_PROPERTY(autoPlay, BOOL)
RCT_EXPORT_VIEW_PROPERTY(url, NSString)
RCT_EXPORT_VIEW_PROPERTY(loops, int)
RCT_EXPORT_VIEW_PROPERTY(clearsAfterStop, BOOL)
RCT_EXPORT_VIEW_PROPERTY(fillMode, NSString)
RCT_EXPORT_VIEW_PROPERTY(onComplete, RCTBubblingEventBlock)
RCT_EXPORT_VIEW_PROPERTY(onerror, RCTBubblingEventBlock)
RCT_EXPORT_VIEW_PROPERTY(onPause, RCTBubblingEventBlock)
RCT_EXPORT_VIEW_PROPERTY(onFinished, RCTBubblingEventBlock)
RCT_EXPORT_VIEW_PROPERTY(onRepeat, RCTBubblingEventBlock)
RCT_EXPORT_VIEW_PROPERTY(onStep, RCTBubblingEventBlock)

RCT_EXPORT_METHOD(start:(nonnull NSNumber *)reactTag) {
  [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
   ReactNativeSVGA * reactNativeSVGA = (ReactNativeSVGA *) viewRegistry[reactTag];
    [reactNativeSVGA startAnimation];
  }];
}
RCT_EXPORT_METHOD(pause:(nonnull NSNumber *)reactTag) {
  [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
   ReactNativeSVGA * reactNativeSVGA = (ReactNativeSVGA *) viewRegistry[reactTag];
    [reactNativeSVGA pauseAnimation];
  }];
}
RCT_EXPORT_METHOD(stepToFrame:(nonnull NSNumber *)reactTag y:(NSInteger)frame x:(BOOL)andPlay) {
  [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
   ReactNativeSVGA * reactNativeSVGA = (ReactNativeSVGA *) viewRegistry[reactTag];
    if(andPlay == NO){
      reactNativeSVGA.onPause(@{});
    }
    [reactNativeSVGA stepToFrame:frame andPlay:andPlay];
  }];
}
RCT_EXPORT_METHOD(stepToPercentage:(nonnull NSNumber *)reactTag y:(CGFloat)frame x:(BOOL)andPlay) {
  [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
   ReactNativeSVGA * reactNativeSVGA = (ReactNativeSVGA *) viewRegistry[reactTag];
    if(andPlay == NO){
      reactNativeSVGA.onPause(@{});
    }
    [reactNativeSVGA stepToPercentage:frame andPlay:andPlay];
  }];
}
@end
