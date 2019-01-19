public class KnnTest {
    public static void main(String[] args) {

        SampleRead TrainsvmRead = new SampleRead("D:\\ProgrammeSoftware\\JavaPrac\\IDEAWorkspace\\KNN\\src\\adult_train.txt");
        SampleRead TestsvmRead = new SampleRead("D:\\ProgrammeSoftware\\JavaPrac\\IDEAWorkspace\\KNN\\src\\adult_test.txt");

        new KNN(2).DoKnn(TrainsvmRead.getFetures(), TrainsvmRead.getLables(),
                TestsvmRead.getFetures(), TestsvmRead.getLables());

    }

}