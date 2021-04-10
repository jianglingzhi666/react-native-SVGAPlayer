import React from 'react';
import {ViewStyle} from 'react-native';

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
export default class ReactNativeSVGA extends React.Component<
  Iprops & ViewStyle,
  any
> {
  start(): void;
  pause(): void;
  stepToFrame(frame: number, andPlay: boolean): void;
  stepToPercentage(percentage: number, andPlay: boolean): void;
}
