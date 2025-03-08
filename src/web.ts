import { WebPlugin } from '@capacitor/core';

import type { AllFilesAccessPlugin } from './definitions';

export class AllFilesAccessWeb
  extends WebPlugin
  implements AllFilesAccessPlugin {
  async access(): Promise<void> {
    return Promise.resolve();
  }
  async copyFile(obj: { sourceUri: string, destinationUri: string }): Promise<void> {
    console.log(obj);
    return Promise.resolve();
  }
}
