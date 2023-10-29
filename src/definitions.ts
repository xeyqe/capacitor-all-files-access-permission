export interface AllFilesAccessPlugin {
  access(): Promise<void>;
}
