package ua.edu.ucu.function;

public class Consumer implements IntConsumer {
    private Consumer consumer;

    public Consumer(Consumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void accept(int value) {
        consumer.accept(value);
    }
}
