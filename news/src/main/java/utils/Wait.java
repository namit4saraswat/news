package utils;

public class Wait {
	
	public static void pageWait(int p){
		int q = p * 1000;
		System.out.println("Inside wait");
		try {
			Thread.sleep(q);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
