package test;
import java.util.Timer;

import com.snp.site.license.Task;
public class TimeTaskTest {
	public static void main(String[] args) throws InterruptedException {
		Timer timer = new Timer();
		timer.schedule(new Task(), 9* 1000);
		for (int i = 0; i < 500; i++) {
			Thread.sleep(1000);
			log.debug("正在运行");
		}
	}
}
