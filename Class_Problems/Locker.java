public class Locker {
    private final int lockerNumber;
    private String combinationCode;

    // Constructor: sets the fixed locker number and initial code
    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = initialCode;
    }

    // Method to change combination: requires correct current code first
    public boolean changeCode(String currentCode, String newCode) {
        if (this.combinationCode.equals(currentCode)) {
            this.combinationCode = newCode;
            System.out.println("changeCode(\"" + currentCode + "\", \"" + newCode + "\") -> success");
            return true;
        } else {
            System.out.println("changeCode(\"" + currentCode + "\", \"" + newCode + "\") -> rejected, code remains unchanged");
            return false;
        }
    }

    // Read-only getter for locker number
    public int getLockerNumber() {
        return lockerNumber;
    }

    // Note: No getter exists for combinationCode to preserve privacy

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        l.changeCode("1234", "5678"); // success
        l.changeCode("0000", "9999"); // rejected
    }
}
