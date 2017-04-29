package util;

/**
 * Created by Andrew on 4/21/2017.
 */
public enum TutorSubject {
    ENGH("English"),
    HIST("History"),
    PSYCH("Psychology"),
    ECON("Economics"),
    BIO("Biology"),
    CHEM("Chemistry"),
    PHYS("Physics"),
    ASTRO("Astronomy"),
    ENVIR("Environment Science"),
    MATH("Math"),
    STAT("Statistics"),
    IT("IT"),
    COMPSCI("Computer Science"),
    MUSIC("Music");

    private final String description;

    TutorSubject(String description){
        this.description = description;
    }

    public String description(){
        return description;
    }

    public static TutorSubject fromDescription(String subject){
        for (TutorSubject value : values()){
            if (value.description.equals(subject)){
                return value;
            }
        }
        return null;
    }
}
