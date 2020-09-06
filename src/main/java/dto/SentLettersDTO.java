package dto;

import java.util.Objects;

public class SentLettersDTO {

    private int sizeOfLettersList;
    private String recipientEmailOfTheLastLetter;

    public int getSizeOfLettersList() {
        return sizeOfLettersList;
    }

    public void setSizeOfLettersList(int sizeOfLettersList) {
        this.sizeOfLettersList = sizeOfLettersList;
    }

    public String getRecipientEmailOfTheLastLetter() {
        return recipientEmailOfTheLastLetter;
    }

    public void setRecipientEmailOfTheLastLetter(String recipientEmailOfTheLastLetter) {
        this.recipientEmailOfTheLastLetter = recipientEmailOfTheLastLetter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SentLettersDTO that = (SentLettersDTO) o;
        return sizeOfLettersList == that.sizeOfLettersList &&
                Objects.equals(recipientEmailOfTheLastLetter, that.recipientEmailOfTheLastLetter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeOfLettersList, recipientEmailOfTheLastLetter);
    }

    @Override
    public String toString() {
        return "SentLettersDTO{" +
                "sizeOfLettersList=" + sizeOfLettersList +
                ", recipientEmailOfTheLastLetter='" + recipientEmailOfTheLastLetter + '\'' +
                '}';
    }
}
