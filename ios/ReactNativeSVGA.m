//
//  ReactNativeSVGA.m
//  reactNativeSvga
//
//  Created by 彭 on 4/9/21.
//

#import "ReactNativeSVGA.h"

@implementation ReactNativeSVGA

- (instancetype)initWithFrame:(CGRect)frame
{
  self = [super initWithFrame:frame];
  
  if (self) {
    self.delegate = self;
    _svgaFrame = 0;
    _percentage = 0;
  }
  return self;
}

//是否自动播放
-(void)setAutoPlay:(BOOL)autoPlay{
  _autoPlay = autoPlay;
}
//设置SVGA路径
-(void)setUrl:(NSString * )url{
  _parser = [[SVGAParser alloc]init];
  [_parser parseWithURL:[NSURL URLWithString:url] completionBlock:^(SVGAVideoEntity * _Nullable videoItem) {
    self.videoItem = videoItem;
    if(self.autoPlay){
      [self startAnimation];
    }
//    self.onComplete(@{});
  } failureBlock:^(NSError * _Nullable error) {
    self.onerror(@{});
  }];
}
- (void)svgaPlayerDidFinishedAnimation:(SVGAPlayer *)player{
  self.onFinished(@{});
}
- (void)svgaPlayerDidAnimatedToFrame:(NSInteger)frame{
  if(self.svgaFrame != 0&&self.svgaFrame > frame){
    //重新播放
    self.onRepeat(@{});
  }
_svgaFrame = frame;
 
  self.onStep(@{
     @"progress":[NSString stringWithFormat:@"%f",self.percentage],
    @"frame":[NSString stringWithFormat:@"%ld",self.svgaFrame]
   
              });
}

- (void)svgaPlayerDidAnimatedToPercentage:(CGFloat)percentage{
 
  _percentage = percentage;
  self.onStep(@{@"frame":[NSString stringWithFormat:@"%ld",self.svgaFrame],
    @"progress":[NSString stringWithFormat:@"%f",self.percentage],
              });
}
@end
