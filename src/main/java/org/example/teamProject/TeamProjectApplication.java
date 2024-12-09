package org.example.teamProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class TeamProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeamProjectApplication.class, args);
        
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                openBrowser("http://localhost:8090/index");
            }
        }, 5000);
        
        System.out.println("애플리케이션이 시작되었습니다. 잠시 후 브라우저가 열립니다...");
    }

    private static void openBrowser(String url) {
        String os = System.getProperty("os.name").toLowerCase();
        try {
            if (os.contains("win")) {
                Runtime.getRuntime().exec("cmd /c start " + url);
            } else if (os.contains("mac")) {
                Runtime.getRuntime().exec("open " + url);
            } else if (os.contains("nix") || os.contains("nux")) {
                Runtime.getRuntime().exec("xdg-open " + url);
            }
            System.out.println("브라우저를 여는 중... URL: " + url);
        } catch (Exception e) {
            System.out.println("브라우저를 여는 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
