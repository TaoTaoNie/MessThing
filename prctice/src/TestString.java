public class TestString {
    private String data;
    public TestString(String data) {
        this.data = data;
    }

    public String toString() {
        return data;
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(5);
        Sequence.SequenceSelector test = sequence.new SequenceSelector();
    }
}
