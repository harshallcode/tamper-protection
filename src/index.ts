import { registerPlugin } from '@capacitor/core';

import type { tamperProtectionPlugin } from './definitions';

const tamperProtection = registerPlugin<tamperProtectionPlugin>(
  'tamperProtection',
  {
    web: () => import('./web').then(m => new m.tamperProtectionWeb()),
  },
);

export * from './definitions';
export { tamperProtection };
