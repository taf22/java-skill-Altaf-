public class TextProcessor {

    public static int countWord(String sentence) {

        if (sentence == null || sentence.trim().isEmpty()) {
            return 0; //handle empty string
        }
        //split by one or more spaces
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }
    public static String replaceWord(String text, String oldWord, String newWord){
        if(text == null || newWord==null){
            return text;
        }
        //replace all occurrences
        return text.replace(oldWord, newWord);
    }
    public static void main(String[]args){
        String sentence = "Java is fun and Java is powerful";

        //count words
        int wordCount = countWord(sentence);
        System.out.println("word Count: "+ wordCount);


        // Replace "Java" with "Programming"
        String replaced = replaceWord(sentence, "Java", "Programming");
        System.out.println(" After Replacement: " + replaced);

    }


}


