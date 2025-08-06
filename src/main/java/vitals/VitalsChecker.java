package vitals;
import vitals.Compute;

public abstract class VitalsChecker {
  static boolean vitalsOk(float temperature, float pulseRate, float spo2) 
      throws InterruptedException {
      if (Compute.checkTemperature(temperature)) {
            alert("Temperature is critical!");
            return false;
        }

      if (Compute.checkPulseRate(pulseRate)) {
            alert("Pulse Rate is out of range!");
            return false;
        }

      if (Compute.checkSpo2(spo2)) {
            alert("Oxygen Saturation is out of range!");
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
