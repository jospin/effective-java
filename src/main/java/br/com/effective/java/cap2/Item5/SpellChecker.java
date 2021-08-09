package br.com.effective.java.cap2.Item5;

public class SpellChecker {

    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = dictionary;
    }

    public void callMethod() {
        dictionary.callMethod();
    }
}
