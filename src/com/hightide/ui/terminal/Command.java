package com.hightide.ui.terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by peter on 9/1/15.
 */
public class Command {
    private CommandListener listener;
    private ProcessRunner runner;

    public Command(CommandListener listener) {
        this.listener = listener;
    }

    public boolean isRunning() {

        return runner != null && runner.isAlive();

    }

    public void execute(String cmd) {
        String cmd1 = cmd;

        if (!cmd1.trim().isEmpty()) {

            List<String> values = new ArrayList<String>(25);
            if (cmd1.contains("\"")) {

                while (cmd1.contains("\"")) {

                    String start = cmd1.substring(0, cmd1.indexOf("\""));
                    cmd1 = cmd1.substring(start.length());
                    String quote = cmd1.substring(cmd1.indexOf("\"") + 1);
                    cmd1 = cmd1.substring(cmd1.indexOf("\"") + 1);
                    quote = quote.substring(0, cmd1.indexOf("\""));
                    cmd1 = cmd1.substring(cmd1.indexOf("\"") + 1);

                    if (!start.trim().isEmpty()) {
                        String parts[] = start.trim().split(" ");
                        values.addAll(Arrays.asList(parts));
                    }
                    values.add(quote.trim());

                }

                if (!cmd1.trim().isEmpty()) {
                    String parts[] = cmd1.trim().split(" ");
                    values.addAll(Arrays.asList(parts));
                }

                for (String value : values) {
                    System.out.println("[" + value + "]");
                }

            } else {

                if (!cmd1.trim().isEmpty()) {
                    String parts[] = cmd1.trim().split(" ");
                    values.addAll(Arrays.asList(parts));
                }

            }

            runner = new ProcessRunner(listener, values);

        }

    }

    public void send(String cmd) throws IOException {
        runner.write(cmd);
    }
}
