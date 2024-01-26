package redis.embedded.model;

import lombok.extern.slf4j.Slf4j;

import static redis.embedded.model.Architecture.x86;
import static redis.embedded.model.Architecture.x86_64;
import static redis.embedded.model.Architecture.aarch64;
import static redis.embedded.model.OS.MAC_OS_X;
import static redis.embedded.model.OS.UNIX;
import static redis.embedded.model.OS.WINDOWS;


@Slf4j
public class OsArchitecture {
    
    public static final OsArchitecture
        WINDOWS_x86_64 = new OsArchitecture(WINDOWS, x86_64),
        UNIX_x86 = new OsArchitecture(UNIX, x86),
        UNIX_x86_64 = new OsArchitecture(UNIX, x86_64),
        UNIX_AARCH64 = new OsArchitecture(UNIX, aarch64),
        MAC_OS_X_x86_64 = new OsArchitecture(MAC_OS_X, x86_64),
        MAC_OS_X_ARM64 = new OsArchitecture(MAC_OS_X, aarch64);

    public final OS os;
    public final Architecture arch;
    
    public static OsArchitecture detectOSandArchitecture() {
        final OS os = OS.detectOS();
        final Architecture arch = os.detectArchitecture();
        OsArchitecture retval = new OsArchitecture(os, arch);
        log.info("--- OS & architecture detected: {}", retval);
        return retval;

    }

    public OsArchitecture(final OS os, final Architecture arch) {
        this.os = os;
        this.arch = arch;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final OsArchitecture that = (OsArchitecture) o;
        return arch == that.arch && os == that.os;
    }

    @Override
    public int hashCode() {
        int result = os.hashCode();
        result = 31 * result + arch.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "OsArchitecture{" +
                "os=" + os +
                ", arch=" + arch +
                '}';
    }
}
