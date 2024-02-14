package methodReplacement;

public class ReplacementTargetMessage implements ReplacementTarget {

    @Override
    public String formatMessage(String message) {
        return "<h1>" + message + "</h1>";
    }

    @Override
    public String formatMessage(Object message) {
        return "<h1>" + message + "</h1>";
    }
}
