import React from 'react';
import {UIManager, findNodeHandle} from 'react-native';
import ReactNativeSVGAManager from './ReactNativeSVGAManager';
interface Iprops {
  url: string;
  loops?: number;
  autoPlay?: boolean;
  fillMode: 'Backward' | 'Forward';
  clearsAfterStop?: boolean;
  onComplete?: () => void;
  onError?: () => void;
  onPause?: () => void;
  onFinished?: () => void;
  onRepeat?: () => void;
  onStep?: (frame: number, percentage: number) => void;
}
export default class ReactNativeSVGA extends React.Component<Iprops, any> {
  static defaultProps = {
    onComplete: function () {},
    onError: function () {},
    onPause: function () {},
    onFinished: function () {},
    onRepeat: function () {},
    onStep: function () {},
    loops: 0,
    clearsAfterStop: true,
    autoPlay: true,
    fillMode: 'Backward',
  };
  private ReactNativeSVGA: any;

  start = () => {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this.ReactNativeSVGA),
      UIManager.ReactNativeSVGA.Commands.start,
      [],
    );
  };
  pause = () => {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this.ReactNativeSVGA),
      UIManager.ReactNativeSVGA.Commands.pause,
      [],
    );
  };
  stepToFrame = (frame: number, andPlay: boolean) => {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this.ReactNativeSVGA),
      UIManager.ReactNativeSVGA.Commands.stepToFrame,
      [frame, andPlay],
    );
  };
  stepToPercentage = (percentage: number, andPlay: boolean) => {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this.ReactNativeSVGA),
      UIManager.ReactNativeSVGA.Commands.percentage,
      [percentage, andPlay],
    );
  };
  render() {
    return (
      <ReactNativeSVGAManager
        ref={(ref) => {
          this.ReactNativeSVGA = ref;
        }}
        {...this.props}
        onerror={this.props.onError}
        onStep={(event: any) => {
          this.props.onStep(
            event.nativeEvent.frame,
            event.nativeEvent.progress,
          );
        }}
      />
    );
  }
}
