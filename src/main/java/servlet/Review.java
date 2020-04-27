package servlet;

import java.util.ArrayList;
import java.util.List;

public class Review {
  String user;
  int lot;
  String lotName;
  int rating;
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
    }};

    if (this.user.isEmpty())
      return false;
    if (lot > 10 || lot < 1 || rating < 1 || rating > 5)
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
