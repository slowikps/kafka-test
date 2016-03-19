//import kafka.javaapi.producer.Producer;
//import kafka.producer.KeyedMessage;
//import kafka.producer.ProducerConfig;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by slowikps on 01/03/16.
 */
public class SampleProducer {

    public static void main(String[] args) throws InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "0");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);

        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for(int i = 0; i < 1000; i++) {
            producer.send(new ProducerRecord<>("noReplica2", "Key is: " + Integer.toString(i), "value is: " + Integer.toString(i)));
            System.out.println("Key is: " + Integer.toString(i) +  ", value is: " + Integer.toString(i));
//            TimeUnit.MILLISECONDS.sleep(100);
        }


        producer.close();

        System.out.println("Koniec");
    }


    public void test () {

    }
}
