//
//  ReactNativeSVGA.h
//  reactNativeSvga
//
//  Created by 彭 on 4/9/21.
//

#import <UIKit/UIKit.h>
#import "SVGAPlayer.h"
#import "SVGAParser.h"
#import <React/RCTComponent.h>
NS_ASSUME_NONNULL_BEGIN

@interface ReactNativeSVGA : SVGAPlayer <SVGAPlayerDelegate>
//@property (nonatomic, strong)SVGAPlayer * player;
@property (nonatomic, strong)SVGAParser * parser;
@property (nonatomic) BOOL autoPlay;
@property (nonatomic,copy) RCTBubblingEventBlock onComplete;
@property (nonatomic,copy) RCTBubblingEventBlock onerror;
@property (nonatomic,copy) RCTBubblingEventBlock onPause;
@property (nonatomic,copy) RCTBubblingEventBlock onFinished;
@property (nonatomic,copy) RCTBubblingEventBlock onRepeat;
@property (nonatomic,copy) RCTBubblingEventBlock onStep;
@property (nonatomic)NSInteger svgaFrame;
@property (nonatomic)CGFloat percentage;
@end

NS_ASSUME_NONNULL_END
