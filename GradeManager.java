public class GradeManager {

    // Method to reverse student names in an array
    public static String[] reverseStudentNames(String[] names) {
        String[] reversedNames = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String original = names[i];
            String reversed = "";
            for (int j = original.length() - 1; j >= 0; j--) {
                reversed += original.charAt(j);
            }
            reversedNames[i] = reversed;
        }
        return reversedNames;
    }

// Method to calculate letter grades
public static char getLetterGrade(int score) {

        if (score >= 90) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
    // Method to find students who need to retake exam

    public static String[] findFailingStudents(String[] names, int[] scores) {
        int count = 0;

        // calculate how many people failed
        for (int score : scores) {
            if (score < 60) {
                count++;
            }
        }

        // make a matrix with the same number of failures
        String[] failingStudents = new String[count];
        int index = 0;

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 60) {
                failingStudents[index] = names[i];
                index++;
            }
        }

        return failingStudents;
    }

    //Main Method

    public static void main(String[] args) {
        String[] students = {"Alice", "Bob", "Charlie", "Diana"};
        int[] scores = {95, 67, 45, 78};

        // Test 1: Reversed names
        System.out.println(" Reversed Student Names:");
        String[] reversed = reverseStudentNames(students);
        for (String name : reversed) {
            System.out.println(name);
        }

        // Test 2: calculate letter grades
        System.out.println("\n Letter Grades:");
        for (int i = 0; i < scores.length; i++) {
            char grade = getLetterGrade(scores[i]);
            System.out.println(students[i] + ": " + scores[i] + " -> " + grade);
        }

        // Test 3: Failing Students
        System.out.println("\n Failing Students:");
        String[] failed = findFailingStudents(students, scores);
        for (String name : failed) {
            System.out.println(name);
        }
    }


}
