package questionTwo.starter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import questionTwo.multiThread.ThreadHavuz;

public class Main {
	public static void main(String[] args) throws InterruptedException {// hata firlatabilir o yuzden throw
		ThreadHavuz thread = new ThreadHavuz();// object
		ExecutorService threadPool = Executors.newFixedThreadPool(4);// havuz olusturuldu ve 4 thread var
		for (int i = 0; i < 5; i++) {// bes istedik bir thread beklmeye alanacak herhangi thread e bitene kadar
										// giriri
			threadPool.execute(thread);// islemler baslanir

		}
		threadPool.shutdown();// havuz kapanir
		Thread.sleep(5000);// burda kullanma sepebi multithread calistigi icin bazi donguler daha bitmemis
		// olabilir o yuzden 5 saniye bekleme alalim ki garanti olsun

		ThreadHavuz.ciftSayilariYazdir();// yazdirma
		ThreadHavuz.tekSayilariYazdir();
		// thread.ciftSayilariYazdir();

	}
}
