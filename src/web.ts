import { WebPlugin } from '@capacitor/core';

import type { AllFilesAccessPlugin } from './definitions';

export class AllFilesAccessWeb
  extends WebPlugin
  implements AllFilesAccessPlugin
{
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
