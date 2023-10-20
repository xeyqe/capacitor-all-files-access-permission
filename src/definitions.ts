export interface AllFilesAccessPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
