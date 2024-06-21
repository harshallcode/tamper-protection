export interface tamperProtectionPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
