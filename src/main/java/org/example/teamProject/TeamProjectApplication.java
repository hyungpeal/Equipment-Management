package org.example.teamProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class TeamProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeamProjectApplication.class, args);
        
        // 서버가 완전히 시작될 때까지 대기 시간을 5초로 늘림
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                openBrowser("http://localhost:80/index");
            }
        }, 5000); // 5초로 증가
        
        System.out.println("애플리케이션이 시작되었습니다. 잠시 후 브라우저가 열립니다...");
    }

    private static void openBrowser(String url) {
        String os = System.getProperty("os.name").toLowerCase();
        try {
            if (os.contains("win")) {
                // Windows
                Runtime.getRuntime().exec("cmd /c start " + url);
            } else if (os.contains("mac")) {
                // macOS
                Runtime.getRuntime().exec("open " + url);
            } else if (os.contains("nix") || os.contains("nux")) {
                // Linux
                Runtime.getRuntime().exec("xdg-open " + url);
            }
            System.out.println("브라우저를 여는 중... URL: " + url);
        } catch (Exception e) {
            System.out.println("브라우저를 여는 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
