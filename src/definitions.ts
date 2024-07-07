export interface tamperProtectionPlugin {
  /**
   * Verify package signatures
   *
   * @since 1.0.0
   */
  verifySignatures(options: {
    playStoreMd5: string;
  }): Promise<{ isSigned: boolean }>;
}
