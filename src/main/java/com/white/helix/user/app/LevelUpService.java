package com.white.helix.user.app;

import static java.lang.Thread.sleep;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

import org.springframework.stereotype.Service;

/**
 * java -jar /Users/baichunqiang/Documents/project/gitee/noia/build/libs/helix-0.0.1-SNAPSHOT.jar
 */
@Service
public class LevelUpService   {

    public String runShell(String shell) {
        StringBuilder sb = new StringBuilder();
        try {
            Runtime runtime = Runtime.getRuntime();
            RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
            String pid = runtimeBean.getName().split("@")[0];
            Process process = runtime.exec(shell);
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            String line;
            while ((line = input.readLine()) != null) {
                System.out.println(line);
                sb.append(line);
                sb.append("\n");
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
