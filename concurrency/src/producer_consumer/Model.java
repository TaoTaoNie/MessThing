package producer_consumer;

public interface Model {
    Runnable newRunnableConsumer();
    Runnable newRunnableProducer();
}
