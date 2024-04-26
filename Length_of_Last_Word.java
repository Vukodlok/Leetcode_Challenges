class Solution {
    public int lengthOfLastWord(String s) {
        //split the string into 'words' and store in an array
        String words[] = s.split("\\s+");
        //grab the last index in the array
        String lastWord = words[words.length-1];
        //find the length and print the results
        return lastWord.length();
    }
}
