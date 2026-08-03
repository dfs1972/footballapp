package org.footballapp.service.snapshot;

import java.io.IOException;

public class SnapshotNotFoundException
        extends IOException {

    public SnapshotNotFoundException(
            String filename
    ) {
        super(
                "Representative snapshot not found: "
                        + filename
        );
    }
}