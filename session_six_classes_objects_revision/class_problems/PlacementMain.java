package session_six_classes_objects_revision.class_problems;

class PlacementRecord {

    String studentName;
    String company;
    double packageLpa;

    // Constructor
    PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }
}

public class PlacementMain {

    public static void main(String[] args) {
        PlacementRecord[] records = {
            new PlacementRecord("Mohith", "TCS", 4.5),
            new PlacementRecord("Ullas", "Zoho", 6.2),
            new PlacementRecord("Karthik", "Infosys", 4.0)
        };

        for (PlacementRecord r : records) {
            r.printRecord();
        }
    }
}