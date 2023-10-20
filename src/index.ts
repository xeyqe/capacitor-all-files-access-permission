import { registerPlugin } from '@capacitor/core';

import type { AllFilesAccessPlugin } from './definitions';

const AllFilesAccess = registerPlugin<AllFilesAccessPlugin>('AllFilesAccess', {
  web: () => import('./web').then(m => new m.AllFilesAccessWeb()),
});

export * from './definitions';
export { AllFilesAccess };
