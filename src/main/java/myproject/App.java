package myproject;

import com.pulumi.Pulumi;
import com.pulumi.aws.ec2.DefaultVpc;
import com.pulumi.aws.s3.Bucket;

public class App {
    public static void main(String[] args) {
        Pulumi.run(ctx -> {

            // Get the default VPC for the current region.
            var vpc = new DefaultVpc("default-vpc");

            var bucket = new Bucket("my-bucket");
            ctx.export("bucketName", bucket.bucket());
            ctx.export("defaultVpc", vpc.arn());
        });
    }
}
