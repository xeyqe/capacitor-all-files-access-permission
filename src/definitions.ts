export interface AllFilesAccessPlugin {
  access(): Promise<void>;
  copyFile(obj: {sourceUri: string, destinationUri: string}): Promise<void>;
}
