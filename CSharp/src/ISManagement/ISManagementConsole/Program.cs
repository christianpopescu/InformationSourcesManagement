using ISManagementDomain.FileAndFolder;
namespace ISManagementConsole
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello, World!");
            FileAndFolderManager ffm = new FileAndFolderManager();
            ffm.EnumerateFileApplyAction(@"D:\temp", WriteFileNameOnConsole);

        }

        static void WriteFileNameOnConsole(string fileName)
        {
            Console.WriteLine(Path.GetFileName(fileName));
        }
    }
}