import java.util.*;
public class Race implements Runnable{
	private static String winner;
	
	public void run(){
		for(int i=0; i <= 100; i++){
			if(Thread.currentThread().getName().equals("兔子") && i% 10 == 0){
				try{
					Thread.sleep(10);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			if(gameOver(i)){
				
				break;
			}
			System.out.println(Thread.currentThread().getName() + "--->跑了" + i + "米");
		}
	}
	
	private Boolean gameOver(int length){
		if(winner != null){
			return true;
		}else {
			if(length >= 100){
				winner = Thread.currentThread().getName();
				System.out.println("winner is : " + winner);
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
		Race race = new Race();
		new Thread(race, "兔子").start();
		new Thread(race, "乌龟").start();
	}
}