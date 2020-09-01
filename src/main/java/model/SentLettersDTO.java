package model;

import java.util.Objects;

public class SentLettersDTO {

    private int sizeOfLettersList;
    private String exactTimeOfTheLastLetter;

    public int getSizeOfLettersList() { return sizeOfLettersList; }

    public void setSizeOfLettersList(int sizeOfLettersList) {
        this.sizeOfLettersList = sizeOfLettersList;
    }

    public String getExactTimeOfTheLastLetter() {
        return exactTimeOfTheLastLetter;
    }

    public void setExactTimeOfTheLastLetter(String exactTimeOfTheLastLetter) {
        this.exactTimeOfTheLastLetter = exactTimeOfTheLastLetter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SentLettersDTO that = (SentLettersDTO) o;
        return sizeOfLettersList == that.sizeOfLettersList &&
                Objects.equals(exactTimeOfTheLastLetter, that.exactTimeOfTheLastLetter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeOfLettersList, exactTimeOfTheLastLetter);
    }

    @Override
    public String toString() {
        return "SentLettersDTO{" +
                "sizeOfLettersList=" + sizeOfLettersList +
                ", exactTimeOfTheLastLetter='" + exactTimeOfTheLastLetter + '\'' +
                '}';
    }
}
