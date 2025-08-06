package vitals;
import vitals.Compute;

public abstract class VitalsChecker {
  static boolean vitalsOk(float temperature, float pulseRate, float spo2) 
      throws InterruptedException {
    if (temperature > 102 || temperature < 95) {
      System.out.println("Temperature is critical!");
      for (int i = 0; i < 6; i++) {
        System.out.print("\r* ");
        Thread.sleep(1000);
        System.out.print("\r *");
        Thread.sleep(1000);
      }
      return false;
    } else if (pulseRate < 60 || pulseRate > 100) {
      System.out.println("Pulse Rate is out of range!");
      for (int i = 0; i < 6; i++) {
        System.out.print("\r* ");
        Thread.sleep(1000);
        System.out.print("\r *");
        Thread.sleep(1000);
      }
      return false;
    } else if (spo2 < 90) {
      System.out.println("Oxygen Saturation out of range!");
      for (int i = 0; i < 6; i++) {
        System.out.print("\r* ");
        Thread.sleep(1000);
        System.out.print("\r *");
        Thread.sleep(1000);
      }
      return false;
    }
    return true;
  }
  
private static void alert(String message)throws InterruptedException {
    System.out.println(message)
    for (int i = 0; i < 6; i++) {
            System.out.print("\r* ");
            Thread.sleep(1000);
            System.out.print("\r *");
            Thread.sleep(1000);
        }  
  
}


}
