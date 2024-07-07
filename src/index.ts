import { registerPlugin } from '@capacitor/core';

import type { tamperProtectionPlugin } from './definitions';

const tamperProtection = registerPlugin<tamperProtectionPlugin>(
  'tamperProtection',
  {},
);

export * from './definitions';
export { tamperProtection };
