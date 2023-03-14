using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ISManagementDomain.FileAndFolder
{
    public class FileAndFolderManager
    {

        /// <summary>
        /// 
        /// Recursive enumerates files in directory, filtered with a given model and apply action 
        /// </summary>
        /// <param name="pDirectory"></param>
        /// <param name="pFunctionToApply"></param>
        /// <param name="pFilePattern"></param>
        public void EnumerateFileApplyAction(string pDirectory, Action<string> pFunctionToApply, string pFilePattern = "*.*")
        {
            if (!Directory.Exists(pDirectory)) return;

            RecusiveEnumerateAndApplyAction(pDirectory, pFunctionToApply, pFilePattern);

        }

        private void RecusiveEnumerateAndApplyAction(string pDirectory, Action<string> pFunctionToApply, string pFilePattern)
        {
            // Assumption: directory exists as returned by Enumerate File
            // 1. Process files from directory
            var collectionOfFiles = Directory.EnumerateFiles(pDirectory, pFilePattern, SearchOption.AllDirectories);
            foreach (var file in collectionOfFiles)
            {
                pFunctionToApply(file);
            }

            // 2. For each subdirectory recursive process
            var collectionOfDirectories = Directory.EnumerateDirectories(pDirectory,"*", SearchOption.AllDirectories);
            foreach (var directory in collectionOfDirectories)
            {
                RecusiveEnumerateAndApplyAction(directory, pFunctionToApply, pFilePattern);
            }
        }
    }
}
