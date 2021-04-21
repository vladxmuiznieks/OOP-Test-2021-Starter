package ie.tudublin;

public class Note {
    public char note;  // The variables are public so that drawNote can access them.
    public int duration;

    public Note(char note, int duration) {
        this.note = note;
        this.duration = duration;
    }

    public String toString() {
        String typeOfNote = "";
        if (duration == 1) {
            typeOfNote = "Quaver";
        } else if (duration == 2) {
            typeOfNote = "Crochet";
        }
        return String.format("%c       %d      %s", note, duration, typeOfNote);
    }
}
