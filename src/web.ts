import { WebPlugin } from '@capacitor/core';

import type { AllFilesAccessPlugin } from './definitions';

export class AllFilesAccessWeb
  extends WebPlugin
  implements AllFilesAccessPlugin
{
  async access(): Promise<void> {
    return Promise.resolve();
  }
}
