import { WebPlugin } from '@capacitor/core';

import type { tamperProtectionPlugin } from './definitions';

export class tamperProtectionWeb
  extends WebPlugin
  implements tamperProtectionPlugin
{
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
