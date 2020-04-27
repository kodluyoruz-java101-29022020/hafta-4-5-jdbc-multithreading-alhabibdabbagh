package questionTwo.multiThread;

import java.util.ArrayList;

public class ThreadHavuz extends Thread { // thread class tan extends ettik

	public ThreadHavuz() {
		arraysCompleted();// constrcutor ile 4 parca dizileri doldurduk
	}

	public static int sayiKontrol(int i) {
		int kontrol = i % 2;// static olarak yaptim
		return kontrol;

	}

	private void arraysCompleted() {// doldurma
		for (int i = 0; i < 2500; i++) {
			firstArray.add("i");
		}
		for (int i = 0; i < 5000; i++) {
			secondArray.add("i");
		}
		for (int i = 0; i < 7500; i++) {
			thridArray.add("i");
		}
		for (int i = 0; i < 10000; i++) {
			fourthArray.add("i");
		}

	}

	ArrayList<String> firstArray = new ArrayList<String>(2500);
	ArrayList<String> secondArray = new ArrayList<String>(5000);
	ArrayList<String> thridArray = new ArrayList<String>(7500);
	ArrayList<String> fourthArray = new ArrayList<String>(10000);
	int count = 0;
	int sayiKontrolu = 0;
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
				for (int i = 0; i < firstArray.size(); i++) {
					sayiKontrolu = sayiKontrol(i);// birinci List dolduruyor
					if (sayiKontrolu == 0) {
						ciftDizi.add(this.getName() + "1 - Thread " + i);

					} else {
						tekDizi.add(this.getName() + "1 - Thread " + i);
					}

				}

				break;
			case 2:// ikinci thread
				for (int i = 2500; i < secondArray.size(); i++) {
					sayiKontrolu = sayiKontrol(i);
					if (sayiKontrolu == 0) {
						ciftDizi.add(this.getName() + this.currentThread() + "2 - Thread " + i);

					} else {
						tekDizi.add(this.getName() + this.currentThread() + "2 - Thread " + i);
					}

				}
				break;
			case 3: // ucuncu thread
				for (int i = 5000; i < thridArray.size(); i++) {
					sayiKontrolu = sayiKontrol(i);
					if (sayiKontrolu == 0) {
						ciftDizi.add(this.getName() + this.currentThread() + "3 - Thread " + i);

					} else {
						tekDizi.add(this.getName() + this.currentThread() + "3 - Thread " + i);
					}
				}
				break;
			case 4:// dortuncu thread
				for (int i = 7500; i < fourthArray.size(); i++) {
					sayiKontrolu = sayiKontrol(i);
					if (sayiKontrolu == 0) {
						ciftDizi.add(this.getName() + this.currentThread() + "4 - Thread " + i);
					} else {
						tekDizi.add(this.getName() + this.currentThread() + "4 - Thread " + i);
					}
				}
				break;
			default:// 5. thread giremeyecegi burda ispatladik
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
