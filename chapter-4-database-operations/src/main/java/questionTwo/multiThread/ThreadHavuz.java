package questionTwo.multiThread;

import java.util.ArrayList;

public class ThreadHavuz extends Thread { // thread class tan extends ettik
	int count = 0;
	int x = 0;
	Object Lock = new Object();// synchroized icin kullanicaz
	static ArrayList<String> ciftDizi = new ArrayList<String>();// String yaptim hangi thread doldurulmus gostersin diye
	static ArrayList<String> tekDizi = new ArrayList<String>();

	@Override
	public void run() {// threadlar burdan basliyorlar

		synchronized (Lock) {// bir thread girdi ve lock edildi
			this.count = this.count + 1; // bir artirdik
			System.out.println(this.getName() + this.currentThread() + " thread  " + this.count);// hangi thread girecek
																									// isimi alalim

			switch (this.count) {
			case 1:// birinci thread burya giriyor
				for (int i = 0; i < 2500; i++) {
					x = i % 2;// birinci List dolduruyor
					if (x == 0) {
						ciftDizi.add(this.getName() + "1 - Thread " + i);

					} else {
						tekDizi.add(this.getName() + "1 - Thread " + i);
					}

				}

				break;
			case 2:// ikinci thread
				for (int i = 2500; i < 5000; i++) {
					x = i % 2;
					if (x == 0) {
						ciftDizi.add(this.getName() + this.currentThread() + "2 - Thread " + i);

					} else {
						tekDizi.add(this.getName() + this.currentThread() + "2 - Thread " + i);
					}

				}
				break;
			case 3: // ucuncu thread
				for (int i = 5000; i < 7500; i++) {
					x = i % 2;
					if (x == 0) {
						ciftDizi.add(this.getName() + this.currentThread() + "3 - Thread " + i);

					} else {
						tekDizi.add(this.getName() + this.currentThread() + "3 - Thread " + i);
					}
				}
				break;
			case 4:// dortuncu thread
				for (int i = 7500; i < 10000; i++) {
					x = i % 2;
					if (x == 0) {
						ciftDizi.add(this.getName() + this.currentThread() + "4 - Thread " + i);
					} else {
						tekDizi.add(this.getName() + this.currentThread() + "4 - Thread " + i);
					}
				}
				break;
			default:// 5. thread bosuna gidecek
				break;
			}

		}

	}

	public static void ciftSayilariYazdir() {// doldurulmus olan listler yazdirmak icin
		for (int i = 0; i < ciftDizi.size(); i++) {
			System.out.println(ciftDizi.get(i));

		}
	}

	public static void tekSayilariYazdir() { // yazdirma
		for (int i = 0; i < tekDizi.size(); i++) {
			System.out.println(tekDizi.get(i));

		}
	}
}
