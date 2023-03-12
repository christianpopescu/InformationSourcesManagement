using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ISManagementDomain.FileAndFolder
{
    internal class FileAndFolderManager
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

            // 1. Process files from directory
            var collectionOfFiles = Directory.EnumerateFiles(pDirectory, pFilePattern, SearchOption.AllDirectories);
            foreach (var file in collectionOfFiles)
            {
                pFunctionToApply(file);
            }
            
            // 2. For each subdirectory recursive process

            // todo enumerate directory
        }

        private void RecusiveEnumerateAndApplyAction(string pDirectory, Action<string> pFunctionToApply, string pFilePattern)
        {
            // todo write recusive function
        }
    }
}
