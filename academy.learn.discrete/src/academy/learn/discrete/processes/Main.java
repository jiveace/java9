package academy.learn.discrete.processes;

import java.io.IOException;
import java.util.Optional;

public class Main {

    public static void main(String[] args) throws IOException {
        // Get the info of the current process
        ProcessHandle processHandle = ProcessHandle.current();
        processHandle.pid();
        dumpProcessInfo(processHandle);

        //Create a process
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "process.jar", "Test app");
        // File is checked in, but apparently in wrong directory
        Process p = pb.start();

        // Destroy a process
        Long pidOfExpendableProcess = 15156L;
        Optional<ProcessHandle> optPh = ProcessHandle.of(pidOfExpendableProcess);
        optPh.get().destroy();
    }

    static void dumpProcessInfo(ProcessHandle ph) {
        ProcessHandle.Info info = ph.info();
        var phParent = ph.parent();
        Long parentPID = 0L;

        if(phParent.isPresent())
            parentPID = phParent.get().pid();

        System.out.printf("[%d] [%d] %s : %s\n", ph.pid(),
                parentPID,
                info.user().orElse("Unknown"),
                info.command().orElse("None"));
    }
}
