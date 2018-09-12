import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

public class Main {

    private static AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();

    public static void main(String[] args) {
        String bucketName = "justins-bucketv2";
        createBucket(bucketName);
        listBuckets();
        deleteBucket(bucketName);
    }

    public static void createBucket(String bucketName) {
        if(s3Client.doesBucketExistV2(bucketName)){
            System.out.println("That Bucket already exists");
        }
        else {
            s3Client.createBucket(bucketName);
            System.out.println("Bucket created");
        }
    }

    public static void listBuckets(){
        for (Bucket bucket : s3Client.listBuckets()) {
            System.out.println(" - " + bucket.getName());
        }

    }

    public static void deleteBucket(String bucketName) {

        if(s3Client.doesBucketExistV2(bucketName)){
            s3Client.deleteBucket(bucketName);
            System.out.println("Bucket " + " deleted");
        }
        else{
            System.out.println("Bucket does not exist");
        }
    }

}
