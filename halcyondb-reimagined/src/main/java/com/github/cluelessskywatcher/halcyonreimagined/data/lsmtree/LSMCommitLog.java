package com.github.cluelessskywatcher.halcyonreimagined.data.lsmtree;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import com.github.cluelessskywatcher.halcyonreimagined.HalcyonDBInstance;
import com.github.cluelessskywatcher.halcyonreimagined.data.Tuple;

import lombok.Getter;

public class LSMCommitLog {
    private @Getter File commitLogFile;

    public LSMCommitLog(String tableName) throws Exception {
        commitLogFile = new File(
            String.format(
                "%s/data/commit_log/%s.wal", 
                HalcyonDBInstance.BASE_DIRECTORY,
                tableName
            )
        );

        if (!commitLogFile.exists()){
            commitLogFile.getParentFile().mkdirs();
            commitLogFile.createNewFile();
        }
    }

    public void append(Tuple tuple, LSMOperation op) throws Exception {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(commitLogFile, true));
        tuple.serialize(dos);
        dos.close();
    }
}
