package academy.learn.discrete.processes;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        // Get the info of the current process
        ProcessHandle processHandle = ProcessHandle.current();
        processHandle.pid();
        dumpProcessInfo(processHandle);

        // Destroy a process
        Long pidOfExpendableProcess = 15156L;
        Optional<ProcessHandle> optPh = ProcessHandle.of(pidOfExpendableProcess);
        //Throw exception of Process doesn't exist
//        optPh.get().destroy();

        // Get all running processes
        Stream<ProcessHandle> allProcs = ProcessHandle.allProcesses();
        allProcs.limit(10).forEach(ph -> dumpProcessInfo(ph));

        System.out.println("******");

        // Get children of a process
        Stream<ProcessHandle> children = processHandle.children();
        children.forEach(ph -> dumpProcessInfo(ph));

        // Running our own process
        // AND
        // Executing code on process termination
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", "process.jar", "XXXXX");
        Process p = processBuilder.start();
        CompletableFuture<Process> future = p.onExit();

        // Synchronous
//        future.thenAccept(process -> System.out.printf("Process [%d] terminated", process.pid()));
//        future.get();

        //Asynchronous
        future.whenCompleteAsync((plop, e) -> System.out.println("Completed XXXXX"));
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
