package org.dimanu.deployservice;

import java.time.LocalDateTime;

public interface Clock {

    public LocalDateTime now();
}
