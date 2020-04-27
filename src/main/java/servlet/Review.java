package servlet;

import java.util.ArrayList;
import java.util.List;

public class Review {
  String user;
  int lot;
  String lotName;
  int rating;
  int vehicleType;
  String vehicleName;
  String morningTraffic;
  String afternoonTraffic;
  String eveningTraffic;
  String parkingSize;
  String arenaConvenience;
  String gymConvenience;
  long date;

  boolean validate() {
    List<String> validationList = new ArrayList<String>() {{
      add("Very");
      add("Kinda");
      add("Not really");
      add("Not sure");
      add("Lot A");
      add("Lot C");
      add("Lot I");
      add("Lot J");
      add("Lot K");
      add("Lot L");
      add("Lot R");
      add("PV Lot");
      add("Shenandoah");
      add("Rappahannock River");
      add("Compact");
      add("Regular");
      add("SUV/Truck");
      add("Motorcycle");
    }};

    if (this.user.isEmpty())
      return false;
    if (this.lot > 10 || this.lot < 1
      || this.rating < 1 || this.rating > 5
      || this.vehicleType < 1 || this.vehicleType > 4)
      return false;
    if (!validationList.contains(this.vehicleName))
      return false;
    if (!validationList.contains(this.lotName))
      return false;
    if (!validationList.contains(this.morningTraffic))
      return false;
    if (!validationList.contains(this.afternoonTraffic))
      return false;
    if (!validationList.contains(this.eveningTraffic))
      return false;
    if (!validationList.contains(this.parkingSize))
      return false;
    if (!validationList.contains(this.arenaConvenience))
      return false;
    if (!validationList.contains(this.gymConvenience))
      return false;

    return true;
  }
}
