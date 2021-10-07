public class Main {
    public static void main(String[] args) {
        Metrics.start();
        Worker worker = new Worker("words.txt");
        worker.initFile();
        worker.collectWords();
        worker.findAllConcatenatedWords();
        Metrics.stop();
        Metrics.print();
    }

}
