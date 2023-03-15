using ISManagementDomain.FileAndFolder;
namespace ISManagementConsole
{
    internal class Program
    {
        protected static List<string> foldersList= new List<string>();
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");
            FileAndFolderManager ffm = new FileAndFolderManager();
            ffm.EnumerateFileApplyAction(@"D:\Temp\TempToDelete\sandboxkm.wiki", WriteFileNameOnConsole);
            foreach(string folder in foldersList) Console.WriteLine(folder);
        }

        static void WriteFileNameOnConsole(string fileName)
        {
            Console.WriteLine(Path.GetFileName(fileName));
            foldersList.Add(Path.GetDirectoryName(fileName)??"");
        }
    }
}