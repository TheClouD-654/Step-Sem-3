public class ExamHallSeatDuplicationChecker {
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            boolean alreadyPrinted = false;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[i] == seatNumbers[k]) {
                    alreadyPrinted = true;
                    break;
                }
            }

            for (int j = i + 1; j < seatNumbers.length && !alreadyPrinted; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    break;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        int[] seatNumbers = {101, 102, 103, 102, 105};
        checkDuplicateSeats(seatNumbers);
    }
}
